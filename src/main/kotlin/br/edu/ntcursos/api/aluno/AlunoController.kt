package br.edu.ntcursos.api.aluno

import br.edu.ntcursos.api.montaURI
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/alunos")
@CrossOrigin(origins = ["*"])
class AlunoController(
    val repositorio: AlunoRepository
) {
    @Operation(summary = "Lista todos os alunos cadastrados", description = "Retorna 200 quando bem sucedida")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Sucesso")
        ]
    )
    @GetMapping
    fun listaTodos(): ResponseEntity<List<Aluno>> {
        return ResponseEntity.ok(repositorio.findAll())
    }

    @Operation(summary = "Busca um aluno específico por ID", description = "Retorna 200 quando bem sucedida")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Sucesso"),
            ApiResponse(responseCode = "404", description = "Não encontrado")
        ]
    )
    @GetMapping("/{id}")
    fun busca(@PathVariable id: Long): ResponseEntity<Aluno> {
        val aluno = repositorio.findById(id)
        return if(aluno.isPresent) {
            ResponseEntity.ok(aluno.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @Operation(summary = "Cria um novo aluno", description = "Retorna 201 quando bem sucedida")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "201", description = "Sucesso"),
            ApiResponse(responseCode = "400", description = "Dados inválidos")
        ]
    )
    @PostMapping
    fun cria(@RequestBody aluno: Aluno): ResponseEntity<Aluno> {
        val saved = repositorio.save(aluno)
        val uri = montaURI(saved.id)
        return ResponseEntity.created(uri).build()
    }

    @Operation(summary = "Altera aluno por ID", description = "Retorna 201 quando bem sucedida")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Sucesso"),
            ApiResponse(responseCode = "400", description = "Dados inválidos")
        ]
    )
    @PutMapping
    fun altera(@RequestBody aluno: Aluno): ResponseEntity<Aluno> {
        val saved = repositorio.save(aluno)
        val uri = montaURI(saved.id)
        return ResponseEntity.created(uri).build()
    }

    @Operation(summary = "Busca um aluno específico por ID", description = "Retorna 200 quando bem sucedida")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "204", description = "Sucesso"),
            ApiResponse(responseCode = "404", description = "Não encontrado")
        ]
    )
    @DeleteMapping("/{id}")
    fun deleta(@PathVariable id: Long): ResponseEntity<String> {
        return try{
            repositorio.deleteById(id)
            ResponseEntity.ok("Aluno $id removido com sucesso")
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }
}
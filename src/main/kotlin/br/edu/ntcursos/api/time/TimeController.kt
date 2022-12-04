package br.edu.ntcursos.api.time

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
@RequestMapping("/times")
@CrossOrigin(origins = ["*"])
class TimeController(
    val repositorio: TimeRepository
) {
    @Operation(summary = "Lista todos os clientes cadastrados", description = "Retorna 200 quando bem sucedida")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Sucesso")
        ]
    )
    @GetMapping
    fun listaTodos(): ResponseEntity<List<Time>> {
        return ResponseEntity.ok(repositorio.findAll())
    }

    @Operation(summary = "Busca um cliente específico por ID", description = "Retorna 200 quando bem sucedida")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Sucesso"),
            ApiResponse(responseCode = "404", description = "Não encontrado")
        ]
    )
    @GetMapping("/{id}")
    fun busca(@PathVariable id: Long): ResponseEntity<Time> {
        val cliente = repositorio.findById(id)
        return if(cliente.isPresent) {
            ResponseEntity.ok(cliente.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @Operation(summary = "Cria um novo cliente", description = "Retorna 201 quando bem sucedida")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "201", description = "Sucesso"),
            ApiResponse(responseCode = "400", description = "Dados inválidos")
        ]
    )
    @PostMapping
    fun cria(@RequestBody cliente: Time): ResponseEntity<Time> {
        val saved = repositorio.save(cliente)
        val uri = montaURI(saved.id)
        return ResponseEntity.created(uri).build()
    }

    @Operation(summary = "Altera cliente por ID", description = "Retorna 201 quando bem sucedida")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Sucesso"),
            ApiResponse(responseCode = "400", description = "Dados inválidos")
        ]
    )
    @PutMapping
    fun altera(@RequestBody cliente: Time): ResponseEntity<Time> {
        val saved = repositorio.save(cliente)
        val uri = montaURI(saved.id)
        return ResponseEntity.created(uri).build()
    }

    @Operation(summary = "Busca um cliente específico por ID", description = "Retorna 200 quando bem sucedida")
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
            ResponseEntity.ok("Cliente $id removido com sucesso")
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }
}
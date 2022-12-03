package br.edu.ntcursos.api

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition(
	info = Info(
		title = "API do Curso",
		version = "1.0",
		description = "API para integração do projeto do curso de programação"
	)
)
class NtCursoApiApplication

fun main(args: Array<String>) {
	runApplication<NtCursoApiApplication>(*args)
}

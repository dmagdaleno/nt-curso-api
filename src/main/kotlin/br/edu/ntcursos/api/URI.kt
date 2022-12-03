package br.edu.ntcursos.api

import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

fun montaURI(id: Long?): URI = ServletUriComponentsBuilder
    .fromCurrentRequest()
    .path("/{id}")
    .buildAndExpand(id)
    .toUri()
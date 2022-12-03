package br.edu.ntcursos.api.hotdog

import org.springframework.data.jpa.repository.JpaRepository

interface HotdogClienteRepository: JpaRepository<HotdogCliente, Long>
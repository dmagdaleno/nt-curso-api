package br.edu.ntcursos.api.terapia

import org.springframework.data.jpa.repository.JpaRepository

interface TerapiaClienteRepository: JpaRepository<TerapiaCliente, Long>
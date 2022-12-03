package br.edu.ntcursos.api.time

import org.springframework.data.jpa.repository.JpaRepository

interface TimeRepository: JpaRepository<Time, Long>
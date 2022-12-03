package br.edu.ntcursos.api.aluno

import org.springframework.data.jpa.repository.JpaRepository

interface AlunoRepository: JpaRepository<Aluno, Long>
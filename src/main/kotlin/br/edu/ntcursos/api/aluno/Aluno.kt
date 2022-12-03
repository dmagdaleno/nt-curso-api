package br.edu.ntcursos.api.aluno

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
data class Aluno (
    @Id
    @SequenceGenerator(name = "aluno_seq", sequenceName = "aluno_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno_seq")
    var id: Long?,
    val nome: String,
    val email: String,
    val idade: Int,
    val sexo: String,
    val logicaProgramacao: Boolean,
    val htmlCss: Boolean,
    val javaScript: Boolean
)
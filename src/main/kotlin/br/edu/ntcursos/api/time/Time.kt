package br.edu.ntcursos.api.time

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
data class Time (
    @Id
    @SequenceGenerator(name = "time_seq", sequenceName = "time_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "time_seq")
    var id: Long?,
    val nome: String,
    val escudo: String,
    val contato: String,
    val cor: String,
    val local: String,
    val horario: String
)
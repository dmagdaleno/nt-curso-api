package br.edu.ntcursos.api.terapia

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
data class TerapiaCliente (
    @Id
    @SequenceGenerator(name = "terapia_cliente_seq", sequenceName = "terapia_cliente_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "terapia_cliente_seq")
    var id: Long?,
    val nome: String,
    val email: String,
    val idade: Int,
    val telefone: String,
    val cep: String,
    val numero: String,
    val local: String,
    val depressao: Boolean,
    val autismo: Boolean,
    val cancer: Boolean,
    @JsonProperty("ala_infantil")
    val alaInfantil: Boolean,
    @JsonProperty("ala_adulto")
    val alaAdulto: Boolean,
    @JsonProperty("cao_guia")
    val caoGuia: Boolean,
    val sindromes: Boolean
)
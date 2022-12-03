package br.edu.ntcursos.api.jovem

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
data class JovemAprendiz (
    @Id
    @SequenceGenerator(name = "jovem_aprendiz_seq", sequenceName = "jovem_aprendiz_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jovem_aprendiz_seq")
    var id: Long?,
    val nome: String,
    val email: String,
    val telefone: String,
    val cpf: String,
    val data: String,
    val endereco: String,
    val marca: String,
    val curriculo: String
)
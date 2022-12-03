package br.edu.ntcursos.api.hotdog

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
data class HotdogCliente (
    @Id
    @SequenceGenerator(name = "hotdog_cliente_seq", sequenceName = "hotdog_cliente_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotdog_cliente_seq")
    var id: Long?,
    val nome: String,
    val email: String,
    val telefone: String,
    val cep: String,
    val numero: String,
    @JsonProperty("dog_tradicional")
    val dogTradicional: Boolean,
    @JsonProperty("dog_duplo")
    val dogDuplo: Boolean,
    @JsonProperty("dog_linguica")
    val dogLinguica: Boolean
)
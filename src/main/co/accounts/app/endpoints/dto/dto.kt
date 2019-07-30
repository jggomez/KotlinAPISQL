package co.accounts.app.endpoints.dto

import com.fasterxml.jackson.annotation.JsonProperty


data class AccountDTO(

    @JsonProperty("no_expediente")
    val numDocument: Int,

    @JsonProperty("fecha_ultima_consulta")
    val dateLastQuery: String,

    @JsonProperty("tipo_sangre")
    val bloodType: String,

    @JsonProperty("alergias")
    val allergies: List<AllergieDTO>
)

class AllergieDTO(

    @JsonProperty("id")
    val id: Int,

    @JsonProperty("nombre")
    val name: String,

    @JsonProperty("fecha_alta")
    val date: String,

    @JsonProperty("medicamento")
    val medicine: String
)

data class AccountDTOResponse(

    @JsonProperty("codigo")
    val code: Int,

    @JsonProperty("mensaje")
    val message: String,

    @JsonProperty("payload")
    val payload: List<AccountDTO>? = emptyList()
)
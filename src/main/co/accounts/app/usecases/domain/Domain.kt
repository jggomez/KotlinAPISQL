package co.accounts.app.usecases.domain

data class Account(
    val numDocument: Int,
    val dateLastQuery: String,
    val bloodType: String,
    val allergies: List<Allergie>
)

class Allergie(
    val id : Int,
    val name: String,
    val date: String,
    val medicine: String,
    val account : Account? = null
)
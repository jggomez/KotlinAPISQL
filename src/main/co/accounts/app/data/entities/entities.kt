package co.accounts.app.data.entities

import co.accounts.app.usecases.domain.Account
import co.accounts.app.usecases.domain.Allergie
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
@Table(name = "Account")
class AccountEntity(

    val dateLastQuery: String,
    val bloodType: String,

    @OneToMany(
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        mappedBy = "account"
    )
    val allergies: List<AllergieEntity>?

) : AbstractJpaPersistable<Int>() {
    fun mapToDomain() =
        Account(
            this.getId()!!,
            this.dateLastQuery,
            this.bloodType,
            this.allergies!!.map { it.mapAllergies() }
        )
}

@Entity
@Table(name = "Allergie")
class AllergieEntity(

    val name: String,
    val date: String,
    val medicine: String

) : AbstractJpaPersistable<Int>() {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "accountId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private lateinit var account: AccountEntity


    fun mapAllergies() =
        Allergie(
            this.getId()!!,
            this.name,
            this.date,
            this.medicine
        )
}
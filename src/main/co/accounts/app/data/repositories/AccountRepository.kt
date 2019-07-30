package co.accounts.app.data.repositories

import co.accounts.app.data.dao.AccountDAO
import co.accounts.app.data.entities.AccountEntity
import co.accounts.app.data.entities.AllergieEntity
import co.accounts.app.usecases.domain.Account
import co.accounts.app.usecases.domain.Allergie
import co.accounts.app.usecases.repositories.IAccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class AccountRepository(
    @Autowired private val accountDAO: AccountDAO
) : IAccountRepository {

    override fun insert(account: Account): Int {
        val accountCreated = accountDAO.save(map(account))
        return accountCreated.getId()!!
    }

    override fun getById(id: Int): Account? {
        return accountDAO.findById(id).map {
            it.mapToDomain()
        }.get()
    }

    override fun getAll(): List<Account>? {
        return accountDAO.findAll().map {
            it.mapToDomain()
        }
    }

    private fun map(account: Account) =
        AccountEntity(
            dateLastQuery = account.dateLastQuery,
            bloodType = account.bloodType,
            allergies = account.allergies.map { mapAllergies(it) }
        )

    private fun mapAllergies(allergie: Allergie) =
        AllergieEntity(
            name = allergie.name,
            date = allergie.date,
            medicine = allergie.medicine
        )

}
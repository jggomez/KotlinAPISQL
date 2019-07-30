package co.accounts.app.usecases.repositories

import co.accounts.app.usecases.domain.Account

interface IAccountRepository {

    fun insert(account: Account): Int

    fun getById(id: Int): Account?

    fun getAll(): List<Account>?
}
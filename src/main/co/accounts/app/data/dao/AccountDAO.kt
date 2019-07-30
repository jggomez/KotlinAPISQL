package co.accounts.app.data.dao

import co.accounts.app.data.entities.AccountEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AccountDAO : JpaRepository<AccountEntity, Int> {
}
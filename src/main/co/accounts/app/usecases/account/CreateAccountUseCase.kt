package co.accounts.app.usecases.account

import co.accounts.app.usecases.UseCase
import co.accounts.app.usecases.domain.Account
import co.accounts.app.usecases.repositories.IAccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CreateAccountUseCase(
    @Autowired private val accountRepository: IAccountRepository
) : UseCase<Int, CreateAccountUseCase.Params> {

    override fun execute(params: Params): Int {
        return accountRepository.insert(params.account)
    }


    data class Params(val account: Account)
}
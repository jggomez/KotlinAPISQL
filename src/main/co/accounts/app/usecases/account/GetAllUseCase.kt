package co.accounts.app.usecases.account

import co.accounts.app.usecases.UseCase
import co.accounts.app.usecases.domain.Account
import co.accounts.app.usecases.repositories.IAccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class GetAllUseCase(
    @Autowired private val accountRepository: IAccountRepository
) : UseCase<List<Account>?, GetAllUseCase.None> {

    override fun execute(params: None): List<Account>? {
        return accountRepository.getAll()
    }

    class None
}
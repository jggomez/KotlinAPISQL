package co.accounts.app.usecases.account

import co.accounts.app.usecases.UseCase
import co.accounts.app.usecases.domain.Account
import co.accounts.app.usecases.repositories.IAccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class GetByIdUseCase(
    @Autowired private val accountRepository: IAccountRepository
) : UseCase<Account?, GetByIdUseCase.Params> {

    override fun execute(params: Params): Account? {
        return accountRepository.getById(params.id)
    }


    data class Params(val id: Int)
}
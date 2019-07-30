package co.accounts.app.endpoints.controllers

import co.accounts.app.endpoints.dto.AccountDTO
import co.accounts.app.endpoints.dto.AccountDTOResponse
import co.accounts.app.endpoints.dto.mappers.AccountDTOMapper
import co.accounts.app.usecases.account.CreateAccountUseCase
import co.accounts.app.usecases.account.GetAllUseCase
import co.accounts.app.usecases.account.GetByIdUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/demo/v1")
class AccountApi {

    @Autowired
    private lateinit var createAccountsUseCase: CreateAccountUseCase

    @Autowired
    private lateinit var getByIdUseCase: GetByIdUseCase

    @Autowired
    private lateinit var getAllUseCase: GetAllUseCase

    @Autowired
    private lateinit var accountDTOMapper: AccountDTOMapper

    @GetMapping("/accounts")
    fun getAllAccounts(): AccountDTOResponse {

        try {
            val lstAccountDTO = getAllUseCase
                .execute(GetAllUseCase.None())?.map {
                    accountDTOMapper.map(it)
                }

            return AccountDTOResponse(
                code = 200,
                message = "Petición completada",
                payload = lstAccountDTO
            )
        } catch (e: Exception) {
            return AccountDTOResponse(
                code = 500,
                message = "Petición con Errores = ${e.message}"
            )
        }
    }

    @GetMapping("/accounts/{id}")
    fun getAccountById(@PathVariable("id") id: Int): AccountDTOResponse {
        try {
            val account = getByIdUseCase
                .execute(GetByIdUseCase.Params(id))

            val accountDTO = account?.let {
                accountDTOMapper.map(it)
            }

            val lstAccountDTO = ArrayList<AccountDTO>().apply {
                accountDTO?.let {
                    add(accountDTO)
                }
            }

            return AccountDTOResponse(
                code = 200,
                message = "Petición completada",
                payload = lstAccountDTO
            )
        } catch (e: Exception) {
            return AccountDTOResponse(
                code = 400,
                message = "El id de usuario no existe"
            )
        }
    }

    @PostMapping("/accounts")
    fun createAccount(@RequestBody accountDTO: AccountDTO): AccountDTOResponse {
        return try {
            val account = accountDTOMapper.reverseMap(accountDTO)
            createAccountsUseCase.execute(CreateAccountUseCase.Params(account))

            AccountDTOResponse(
                code = 200,
                message = "Petición completada"
            )

        } catch (e: Exception) {
            AccountDTOResponse(
                code = 500,
                message = "Petición con Errores = ${e.message}"
            )
        }

    }

}
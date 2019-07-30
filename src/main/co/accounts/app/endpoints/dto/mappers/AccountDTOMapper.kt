package co.accounts.app.endpoints.dto.mappers

import co.accounts.app.endpoints.dto.AccountDTO
import co.accounts.app.usecases.domain.Account
import co.accounts.app.util.Mapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class AccountDTOMapper(
    @Autowired private val allergieDTOMapper: AllergieDTOMapper
) : Mapper<Account, AccountDTO>() {

    override fun map(value: Account): AccountDTO {
        return AccountDTO(
            value.numDocument,
            value.dateLastQuery,
            value.bloodType,
            allergieDTOMapper.map(value.allergies)
        )
    }

    override fun reverseMap(value: AccountDTO): Account {
        return Account(
            value.numDocument,
            value.dateLastQuery,
            value.bloodType,
            allergieDTOMapper.reverseMap(value.allergies)
        )
    }
}
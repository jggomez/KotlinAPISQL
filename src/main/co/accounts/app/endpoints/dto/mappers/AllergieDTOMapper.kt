package co.accounts.app.endpoints.dto.mappers

import co.accounts.app.endpoints.dto.AllergieDTO
import co.accounts.app.usecases.domain.Allergie
import co.accounts.app.util.Mapper
import org.springframework.stereotype.Component

@Component
class AllergieDTOMapper : Mapper<Allergie, AllergieDTO>() {
    override fun map(value: Allergie): AllergieDTO {
        return AllergieDTO(
            value.id,
            value.name,
            value.date,
            value.medicine
        )
    }

    override fun reverseMap(value: AllergieDTO): Allergie {
        return Allergie(
            value.id,
            value.name,
            value.date,
            value.medicine
        )
    }
}
package learn.spring.boot.kotlin.restful.api.v2.model

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class UpdateTeamRequest (

    @field:NotBlank
    val name: String?,

    @field:NotBlank
    val firstDriver: String?,

    @field:NotBlank
    val secondDriver: String?,

    @field:NotBlank
    val teamEntry: String?,

    @field:NotNull
    @field:Min(value = 0)
    val champion: Int?
)
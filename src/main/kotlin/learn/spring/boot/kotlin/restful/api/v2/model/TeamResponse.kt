package learn.spring.boot.kotlin.restful.api.v2.model

import java.util.*

data class TeamResponse(

    val id: String,

    val name: String,

    val firstDriver: String,

    val secondDriver: String,

    val teamEntry: String,

    val champion: Int,

    val createdAt: Date,

    val updatedAt: Date?
)

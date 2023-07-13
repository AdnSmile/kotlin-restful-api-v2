package learn.spring.boot.kotlin.restful.api.v2.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "api_keys")
data class ApiKey(

    @Id
    val id: String

)

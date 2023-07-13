package learn.spring.boot.kotlin.restful.api.v2.repository

import learn.spring.boot.kotlin.restful.api.v2.entity.ApiKey
import org.springframework.data.jpa.repository.JpaRepository

interface ApiKeyRepository : JpaRepository<ApiKey, String>
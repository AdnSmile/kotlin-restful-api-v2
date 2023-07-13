package learn.spring.boot.kotlin.restful.api.v2.repository

import learn.spring.boot.kotlin.restful.api.v2.entity.Team
import org.springframework.data.jpa.repository.JpaRepository

interface TeamRepository : JpaRepository<Team, String>
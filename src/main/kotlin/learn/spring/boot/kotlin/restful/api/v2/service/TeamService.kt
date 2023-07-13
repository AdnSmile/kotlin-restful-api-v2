package learn.spring.boot.kotlin.restful.api.v2.service

import learn.spring.boot.kotlin.restful.api.v2.model.CreateTeamRequest
import learn.spring.boot.kotlin.restful.api.v2.model.ListTeamRequest
import learn.spring.boot.kotlin.restful.api.v2.model.TeamResponse
import learn.spring.boot.kotlin.restful.api.v2.model.UpdateTeamRequest

interface TeamService {

    fun create(createTeamRequest: CreateTeamRequest): TeamResponse

    fun get(id: String): TeamResponse

    fun update(id: String, updateTeamRequest: UpdateTeamRequest): TeamResponse

    fun delete(id: String)

    fun list(listTeamRequest: ListTeamRequest): List<TeamResponse>
}
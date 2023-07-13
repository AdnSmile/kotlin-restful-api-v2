package learn.spring.boot.kotlin.restful.api.v2.service.impl

import learn.spring.boot.kotlin.restful.api.v2.entity.Team
import learn.spring.boot.kotlin.restful.api.v2.error.NotFoundException
import learn.spring.boot.kotlin.restful.api.v2.model.CreateTeamRequest
import learn.spring.boot.kotlin.restful.api.v2.model.ListTeamRequest
import learn.spring.boot.kotlin.restful.api.v2.model.TeamResponse
import learn.spring.boot.kotlin.restful.api.v2.model.UpdateTeamRequest
import learn.spring.boot.kotlin.restful.api.v2.repository.TeamRepository
import learn.spring.boot.kotlin.restful.api.v2.service.TeamService
import learn.spring.boot.kotlin.restful.api.v2.validation.ValidationUtil
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collector
import java.util.stream.Collectors

@Service
class TeamServiceImp(
    val teamRepository: TeamRepository,
    val validationUtil: ValidationUtil
) : TeamService {

    override fun create(createTeamRequest: CreateTeamRequest): TeamResponse {
        validationUtil.validate(createTeamRequest)

        val team = Team(
            id = createTeamRequest.id!!,
            name = createTeamRequest.name!!,
            firstDriver = createTeamRequest.firstDriver!!,
            secondDriver = createTeamRequest.secondDriver!!,
            teamEntry = createTeamRequest.teamEntry!!,
            champion = createTeamRequest.champion!!,
            createdAt = Date(),
            updatedAt = null
        )

        teamRepository.save(team)

        return convertTeamToTeamResponse(team)
    }

    override fun get(id: String): TeamResponse {
        val product = findTeamById(id)

        return convertTeamToTeamResponse(product)
    }

    override fun update(id: String, updateTeamRequest: UpdateTeamRequest): TeamResponse {
        val team = findTeamById(id)

        validationUtil.validate(updateTeamRequest)

        team.apply {
            name = updateTeamRequest.name!!
            firstDriver = updateTeamRequest.firstDriver!!
            secondDriver = updateTeamRequest.secondDriver!!
            teamEntry = updateTeamRequest.teamEntry!!
            champion = updateTeamRequest.champion!!
            updatedAt = Date()
        }

        teamRepository.save(team)

        return convertTeamToTeamResponse(team)
    }

    override fun delete(id: String) {
        val team = findTeamById(id)
        teamRepository.delete(team)
    }

    override fun list(listTeamRequest: ListTeamRequest): List<TeamResponse> {
        val page = teamRepository.findAll(PageRequest.of(listTeamRequest.page, listTeamRequest.size))
        val teams: List<Team> = page.get().collect(Collectors.toList())
        return teams.map { convertTeamToTeamResponse(it) }
    }

    private fun findTeamById(id: String): Team {
        return teamRepository.findByIdOrNull(id) ?: throw NotFoundException()
    }

    private fun convertTeamToTeamResponse(team: Team): TeamResponse {
        return TeamResponse(
            id = team.id,
            name = team.name,
            firstDriver = team.firstDriver,
            secondDriver = team.secondDriver,
            teamEntry = team.teamEntry,
            champion = team.champion,
            createdAt = team.createdAt,
            updatedAt = team.updatedAt
        )
    }

}
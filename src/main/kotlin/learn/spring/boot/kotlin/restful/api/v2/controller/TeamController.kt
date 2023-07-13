package learn.spring.boot.kotlin.restful.api.v2.controller

import learn.spring.boot.kotlin.restful.api.v2.model.*
import learn.spring.boot.kotlin.restful.api.v2.service.TeamService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class TeamController(val teamService: TeamService) {

    @PostMapping(
        value = ["/api/teams"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createTeam(@RequestBody body: CreateTeamRequest): WebResponse<TeamResponse> {
        val teamResponse = teamService.create(body)

        return WebResponse(
            code = 200,
            status = "OK",
            data = teamResponse
        )
    }

    @GetMapping(
        value = ["/api/teams/{idTeam}"],
        produces = ["application/json"]
    )
    fun getTeam(@PathVariable("idTeam") id: String) : WebResponse<TeamResponse> {
        val teamResponse = teamService.get(id)

        return WebResponse(
            code = 200,
            status = "OK",
            data = teamResponse
        )
    }

    @PutMapping(
        value = ["/api/teams/{idTeam}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateTeam(@PathVariable("idTeam") id: String,
                   @RequestBody updateTeamRequest: UpdateTeamRequest): WebResponse<TeamResponse> {

        val teamResponse = teamService.update(id, updateTeamRequest)
        return WebResponse(
            code = 200,
            status = "OK",
            data = teamResponse
        )
    }

    @GetMapping(
        value = ["/api/teams"],
        produces = ["application/json"],
    )
    fun listTeams(@RequestParam(value = "page", defaultValue = "0") page: Int,
                  @RequestParam(value = "size", defaultValue = "10") size: Int): WebResponse<List<TeamResponse>> {
        val request = ListTeamRequest(page = page, size = size)
        val response = teamService.list(request)
        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }

    @DeleteMapping(
        value = ["/api/teams/{idTeam}"],
        produces = ["application/json"],
    )
    fun deleteTeam(@PathVariable("idTeam") id: String): WebResponse<String> {
        teamService.delete(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = id
        )
    }

}
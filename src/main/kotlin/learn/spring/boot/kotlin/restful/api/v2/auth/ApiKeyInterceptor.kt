package learn.spring.boot.kotlin.restful.api.v2.auth

import learn.spring.boot.kotlin.restful.api.v2.error.UnauthorizedException
import learn.spring.boot.kotlin.restful.api.v2.repository.ApiKeyRepository
import org.springframework.stereotype.Component
import org.springframework.ui.ModelMap
import org.springframework.web.context.request.WebRequest
import org.springframework.web.context.request.WebRequestInterceptor
import java.lang.Exception

@Component
class ApiKeyInterceptor(val apiKeyRepository: ApiKeyRepository) : WebRequestInterceptor {

    override fun preHandle(request: WebRequest) {
        val apiKey = request.getHeader("X-Api-Key") ?: throw UnauthorizedException() // jika key tidak ada di header

        if (!apiKeyRepository.existsById(apiKey)) {
            throw UnauthorizedException() // api key tidak ada di database
        }
    }

    override fun postHandle(request: WebRequest, model: ModelMap?) { }

    override fun afterCompletion(request: WebRequest, ex: Exception?) { }
}
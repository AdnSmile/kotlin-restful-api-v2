package learn.spring.boot.kotlin.restful.api.v2.model

data class WebResponse<T> (
    val code: Int,
    val status: String,
    val data: T
)


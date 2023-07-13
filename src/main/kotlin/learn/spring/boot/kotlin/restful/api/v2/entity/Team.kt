package learn.spring.boot.kotlin.restful.api.v2.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "teams")
data class Team(

    @Id
    val id: String,

    @Column(name = "name")
    var name: String,

    @Column(name = "firstDriver")
    var firstDriver: String,

    @Column(name = "secondDriver")
    var secondDriver: String,

    @Column(name = "teamEntry")
    var teamEntry: String,

    @Column(name = "champion")
    var champion: Int,

    @Column(name = "createdAt")
    var createdAt: Date,

    @Column(name = "updateAt")
    var updatedAt: Date?
)

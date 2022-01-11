package se.torrentkatten.fourtyk.event

import kotlinx.serialization.Serializable

@Serializable
data class Game(
    val uuid: String,
    val name: String,
    val attacker: Player,
    val defender: Player,
    val result: Result?
)

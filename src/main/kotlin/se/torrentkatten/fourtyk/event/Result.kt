package se.torrentkatten.fourtyk.event

import kotlinx.serialization.Serializable

@Serializable
data class Result(
    val attackerScore: Int,
    val defenderScore: Int
)

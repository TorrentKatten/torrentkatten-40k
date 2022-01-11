package se.torrentkatten.fourtyk.event

import kotlinx.serialization.Serializable

@Serializable
data class Player(
    val faction: String
)
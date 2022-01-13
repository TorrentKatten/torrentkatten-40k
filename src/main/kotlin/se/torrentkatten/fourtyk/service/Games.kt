package se.torrentkatten.fourtyk.service

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import se.torrentkatten.fourtyk.api.GameDTO
import se.torrentkatten.fourtyk.event.Game
import se.torrentkatten.fourtyk.event.Player
import se.torrentkatten.fourtyk.event.Result
import se.torrentkatten.fourtyk.pulsar.Topics
import java.util.UUID

@Service
class Games(@Autowired private val kafkaTemplate: KafkaTemplate<String, String>) {

    fun createGame(game: GameDTO): String {

        val gameId = UUID.randomUUID().toString()

        val gameEvent = Game(
            gameId,
            game.name,
            Player(game.attacker.faction),
            Player(game.defender.faction),
            null
        )

        kafkaTemplate.send(Topics.FOURTYK_GAMES, Json { prettyPrint = true }.encodeToString(gameEvent))

        return gameId
    }

    fun findGame(gameId: UUID): Game {
        return Game(
            uuid = "",
            name = "",
            attacker = Player(faction = "Imperial Guard"),
            defender = Player(faction = "Imperial Guard"),
            result = Result(10, 100),
        )
    }
}
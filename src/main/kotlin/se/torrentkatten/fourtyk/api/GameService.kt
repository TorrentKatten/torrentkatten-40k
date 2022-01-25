package se.torrentkatten.fourtyk.api

import net.devh.boot.grpc.server.service.GrpcService
import org.springframework.beans.factory.annotation.Autowired
import se.torrentkatten.fourtyk.service.Games
import java.util.UUID

@GrpcService
class GameService(@Autowired private val games: Games) :
    FourtyKServiceGrpcKt.FourtyKServiceCoroutineImplBase() {


    override suspend fun createGame(request: GameDTO): GameHandle {
        println("TEST")
        return gameHandle {
            uuid = games.createGame(request)
        }
    }

    override suspend fun findGame(request: GameHandle): GameDTO {
        val game = games.findGame(UUID.fromString(request.uuid))

        return gameDTO {
            name = game.name

        }
    }

    override suspend fun addResult(request: GameResultDTO): GameDTO {
        return super.addResult(request)
    }
}
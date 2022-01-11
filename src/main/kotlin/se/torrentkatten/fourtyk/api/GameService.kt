package se.torrentkatten.fourtyk.api

import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService
import org.springframework.beans.factory.annotation.Autowired
import se.torrentkatten.fourtyk.service.Games
import java.util.*

@GrpcService
class GameService(@Autowired private val games: Games) :
    FourtyKServiceGrpc.FourtyKServiceImplBase() {

    override fun createGame(request: GameDTO, responseObserver: StreamObserver<GameHandle>) {
        responseObserver.onNext(GameHandle.newBuilder().setUuid(games.createGame(request)).build())
        responseObserver.onCompleted()
    }

    override fun findGame(request: GameHandle, responseObserver: StreamObserver<GameDTO>) {
        val game = games.findGame(UUID.fromString(request.uuid))

        responseObserver.onNext(GameDTO.newBuilder().build())
        responseObserver.onCompleted()
    }

    override fun addResult(request: GameResultDTO?, responseObserver: StreamObserver<GameDTO>) {
        super.addResult(request, responseObserver)
    }
}
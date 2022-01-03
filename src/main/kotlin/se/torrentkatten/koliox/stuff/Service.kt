package se.torrentkatten.koliox.stuff

import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.examples.lib.HelloReply
import net.devh.boot.grpc.examples.lib.HelloRequest
import net.devh.boot.grpc.examples.lib.SimpleGrpc.SimpleImplBase
import net.devh.boot.grpc.server.service.GrpcService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate

@GrpcService
class Service(@Autowired private val kafkaTemplate: KafkaTemplate<String, HelloRequest>) : SimpleImplBase() {

    override fun sayHello(req: HelloRequest, responseObserver: StreamObserver<HelloReply>) {
        kafkaTemplate.send(Topics.kolioxTopic, req)
        var reply = HelloReply.newBuilder().setMessage("Hello ==> " + req.name).build()
        responseObserver.onNext(reply)
        reply = HelloReply.newBuilder().setMessage("Hello 2==> " + req.name).build()
        responseObserver.onNext(reply)
        reply = HelloReply.newBuilder().setMessage("Hello 3==> " + req.name).build()
        responseObserver.onNext(reply)

        responseObserver.onCompleted()
    }


}
package se.torrentkatten.koliox.kafka

import io.github.majusko.pulsar.producer.PulsarTemplate
import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.examples.lib.GoodbyeRequest
import net.devh.boot.grpc.examples.lib.GoodbyeResponse
import net.devh.boot.grpc.examples.lib.HelloReply
import net.devh.boot.grpc.examples.lib.HelloRequest
import net.devh.boot.grpc.examples.lib.SimpleGrpc.SimpleImplBase
import net.devh.boot.grpc.server.service.GrpcService
import org.apache.pulsar.client.api.PulsarClientException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate

@GrpcService
class Service(
    @Autowired private val kafkaTemplate: KafkaTemplate<String, String>,
    @Autowired private val producer: PulsarTemplate<String>
) : SimpleImplBase() {

    override fun sayHello(req: HelloRequest, responseObserver: StreamObserver<HelloReply>) {
        kafkaTemplate.send(Topics.kolioxTopic, "req")
        var reply = HelloReply.newBuilder().setMessage("Hello ==> " + req.name).build()
        responseObserver.onNext(reply)
        reply = HelloReply.newBuilder().setMessage("Hello 2==> " + req.name).build()
        responseObserver.onNext(reply)
        reply = HelloReply.newBuilder().setMessage("Hello 3==> " + req.name).build()
        responseObserver.onNext(reply)

        responseObserver.onCompleted()
    }

    @Throws(PulsarClientException::class)
    override fun sayGoodbye(request: GoodbyeRequest, responseObserver: StreamObserver<GoodbyeResponse>) {
        producer.send(se.torrentkatten.koliox.pulsar.Topics.kolioxTopic, "request")
        var reply = GoodbyeResponse.newBuilder().setMessage("Hello ==> " + request.name).build()
        responseObserver.onNext(reply)
        reply = GoodbyeResponse.newBuilder().setMessage("Hello 2==> " + request.name).build()
        responseObserver.onNext(reply)
        reply = GoodbyeResponse.newBuilder().setMessage("Hello 3==> " + request.name).build()
        responseObserver.onNext(reply)

        responseObserver.onCompleted()
    }
}
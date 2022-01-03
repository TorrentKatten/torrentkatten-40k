package se.torrentkatten.koliox.stuff

import net.devh.boot.grpc.examples.lib.HelloRequest
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Service

@Service
class Consumer {
    @KafkaListener(topics = [Topics.kolioxTopic])
    fun listenWithHeaders(@Payload message: HelloRequest) {
        println(message.allFields)
    }
}

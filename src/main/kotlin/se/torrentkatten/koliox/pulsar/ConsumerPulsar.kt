package se.torrentkatten.koliox.pulsar

import io.github.majusko.pulsar.annotation.PulsarConsumer
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Service

@Service
class ConsumerPulsar {
    @PulsarConsumer(consumerName = "meowlolz", topic = Topics.kolioxTopic, clazz = String::class)
    fun listenWithHeaders(@Payload message: String) {
        println("Pulsar $message")
    }
}

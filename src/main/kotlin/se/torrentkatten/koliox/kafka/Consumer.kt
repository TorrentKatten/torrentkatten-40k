package se.torrentkatten.koliox.kafka

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Service

@Service
class Consumer {
    @KafkaListener(topics = [Topics.kolioxTopic])
    fun listenWithHeaders(@Payload message: String) {
        println(message)
    }
}

package se.torrentkatten.fourtyk.pulsar

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Service

@Service
class Consumer {
    @KafkaListener(topics = [Topics.FOURTYK_GAMES])
    fun listenWithHeaders(@Payload message: String) {
        println(message)
    }
}

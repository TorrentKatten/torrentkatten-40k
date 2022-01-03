package se.torrentkatten.koliox

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import se.torrentkatten.koliox.stuff.Topics


@Configuration
open class Configuration {
    @Bean
    open fun kolioxTopic(): NewTopic {
        return NewTopic(Topics.kolioxTopic, 1, 1.toShort())
    }



}
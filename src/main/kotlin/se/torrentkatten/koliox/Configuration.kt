package se.torrentkatten.koliox

import io.github.majusko.pulsar.producer.ProducerFactory
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import se.torrentkatten.koliox.kafka.Topics


@Configuration
open class Configuration {
    @Bean
    open fun kolioxTopic(): NewTopic {
        return NewTopic(Topics.kolioxTopic, 1, 1.toShort())
    }

    @Bean
    open fun producerFactory(): ProducerFactory {
        return ProducerFactory()
            .addProducer(Topics.kolioxTopic, String::class.java)
    }
}
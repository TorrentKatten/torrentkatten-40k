package se.torrentkatten.fourtyk

import org.apache.kafka.clients.admin.NewTopic
import org.apache.kafka.common.config.TopicConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder
import se.torrentkatten.fourtyk.pulsar.Topics


@Configuration
open class Configuration {

    @Bean
    open fun createGamesTopic(): NewTopic {
        return TopicBuilder.name(Topics.FOURTYK_GAMES)
            .partitions(1)
            .replicas(1)
            .config(TopicConfig.RETENTION_MS_CONFIG, (86400 * 1000).toString())
            .compact()
            .build()
    }
}
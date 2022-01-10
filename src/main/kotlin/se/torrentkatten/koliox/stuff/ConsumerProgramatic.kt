package se.torrentkatten.koliox.stuff

import net.devh.boot.grpc.examples.lib.HelloRequest
import org.apache.kafka.common.serialization.Serde
import org.apache.kafka.common.serialization.Serdes
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Service
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.kstream.Consumed

@Service
class ConsumerProgramatic {

    fun listenWithHeaders() {

        val builder = StreamsBuilder()
        val records = builder.stream(Topics.kolioxTopic, Consumed.with(Serdes.String(), dRSerde()))

        val counts = records.map { k, v -> KeyValue(k, v.count) }
        counts.print(Printed.toSysOut<String, Long>().withLabel("Consumed record"))

    }

    private fun dRSerde(): Serde<HelloRequest> {

        val properties = hashMapOf("json.value.type" to HelloRequest::class.java)

        val dRSerializer = KafkaJsonSerializer<HelloRequest>()
        dRSerializer.configure(properties, false)

        val dRDeserializer = KafkaJsonDeserializer<HelloRequest>()
        dRDeserializer.configure(properties, false)

        return serdeFrom(dRSerializer, dRDeserializer)
    }
}

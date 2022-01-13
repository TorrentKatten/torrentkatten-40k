package se.torrentkatten.fourtyk;

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("se.torrentkatten.fourtyk.api")
open class FourtyKApp

fun main(args: Array<String>) {
    runApplication<FourtyKApp>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}
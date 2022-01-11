package se.torrentkatten.fourtyk;

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.runApplication

@SpringBootApplication
open class FourtyKApp

fun main(args: Array<String>) {
    runApplication<FourtyKApp>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}
package org.ldv.myhello

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HelloDemoApplication

fun main(args: Array<String>) {
    runApplication<HelloDemoApplication>(*args)
}

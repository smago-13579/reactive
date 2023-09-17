package com.example.mongoapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MongoAppApplication

fun main(args: Array<String>) {
    runApplication<MongoAppApplication>(*args)
}

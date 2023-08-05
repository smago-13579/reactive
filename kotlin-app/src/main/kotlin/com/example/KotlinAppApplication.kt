package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinAppApplication

fun main(args: Array<String>) {
	println("Hello World")
	runApplication<KotlinAppApplication>(*args)
}

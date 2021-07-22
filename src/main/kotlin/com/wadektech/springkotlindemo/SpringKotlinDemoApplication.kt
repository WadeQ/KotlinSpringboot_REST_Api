package com.wadektech.springkotlindemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class SpringKotlinDemoApplication

fun main(args: Array<String>) {
	runApplication<SpringKotlinDemoApplication>(*args)
}

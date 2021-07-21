package com.wadektech.springkotlindemo

import com.wadektech.springkotlindemo.domain.User
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class SpringKotlinDemoApplication{

	@GetMapping
	fun sayHelloToWorld() : User = User(1,"Wadek","derrickwadek@gmail.com")

}

fun main(args: Array<String>) {
	runApplication<SpringKotlinDemoApplication>(*args)
}

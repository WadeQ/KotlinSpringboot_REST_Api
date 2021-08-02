package com.wadektech.springkotlindemo

import com.wadektech.springkotlindemo.utils.SeleniumApiTest
import com.wadektech.springkotlindemo.utils.TestApiEndpoints
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SpringKotlinDemoApplicationTests : TestApiEndpoints() {
	val testApiEndpoints = TestApiEndpoints()

	@Test
	fun contextLoads() {
		println("Testing our API with selenium!")
		testApiEndpoints.captureHttpRequests()
	}

}

package com

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@MapperScan("com.mapper")
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}

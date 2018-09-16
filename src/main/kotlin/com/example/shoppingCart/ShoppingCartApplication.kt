package com.example.shoppingCart

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan


@SpringBootApplication
@ComponentScan("com.example.shoppingCart")
class TodoBackEndApplication

    fun main(args: Array<String>) {
        runApplication<TodoBackEndApplication>(*args)
}

package com.example.toBackEnd

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan


@SpringBootApplication
@ComponentScan("com.example.toBackEnd")
class TodoBackEndApplication

    fun main(args: Array<String>) {
        runApplication<TodoBackEndApplication>(*args)
    }

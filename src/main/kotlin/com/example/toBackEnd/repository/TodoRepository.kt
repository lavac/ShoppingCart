package com.example.toBackEnd.repository

import com.example.toBackEnd.dto.Item
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

@Document(collection = "todoItems")

interface Repository : ReactiveCrudRepository<Item, Long>

@org.springframework.stereotype.Repository
class TodoRepository(val repository: Repository) {
    fun add(item: Item): Mono<Item> {
        return repository.save(item)
    }

    fun get(id: Long): Mono<Item> {
        return repository.findById(id)
    }
}

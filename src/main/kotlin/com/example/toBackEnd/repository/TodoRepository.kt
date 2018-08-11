package com.example.toBackEnd.repository

import com.example.toBackEnd.dto.Item
import com.example.toBackEnd.error.EmptyException
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono
import java.time.Duration

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

    fun update(id: Long, task1: String): Mono<Item> {
        return get(id).map {
            it.task = task1
            repository.save(it)
            Item(id, task1)
        }

    }

    fun delete(id: Long): Mono<Void> {
        return repository.deleteById(id)
    }

    fun getItems(): Flux<Item> {
        return repository.findAll()
    }
}

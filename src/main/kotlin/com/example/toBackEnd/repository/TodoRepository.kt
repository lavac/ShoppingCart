package com.example.toBackEnd.repository

import com.example.toBackEnd.dto.Item
import com.example.toBackEnd.error.EmptyException
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

    fun update(id: Long, task1: String): Mono<Item>? {
//        val item = get(id).switchIfEmpty(Mono.error
//        (EmptyException())).map { it.task = task1 }
//
//        return item.flatMap { return@flatMap repository.save(it) }



//        return monoItem.map {
//            it.id
//            it.task = task
//        }.flatMap { add(it) }
                //        val item: Item? = monoItem.block()
//        item?.task = task
//        if(item != null)
//            return add(item)
//        }
        return Mono.never()
    }

    fun delete(id: Long): Mono<Void> {
        return repository.deleteById(id)
    }
}

package com.example.toBackEnd.service

import com.example.toBackEnd.dto.Item
import com.example.toBackEnd.repository.TodoRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class TodoService(val todoRepositry: TodoRepository) {
    fun add(item: Item): Mono<Item> {
        return todoRepositry.add(item)
    }

    fun get(id: Long): Mono<Item> {
        return todoRepositry.get(id)
    }

    fun update(id: Long, task: String): Mono<Item> {
        return todoRepositry.update(id, task)
    }

    fun deleteItem(id: Long): Mono<Void> {
        return todoRepositry.delete(id)
    }

    fun getItems(): Flux<Item> {
        return todoRepositry.getItems();
    }

}

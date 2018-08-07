package com.example.toBackEnd.controller

import com.example.toBackEnd.dto.Item
import com.example.toBackEnd.service.TodoService
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono


@ComponentScan("com.example.toBackEnd")
@RequestMapping("/todo")
@RestController
class TodoController(val todoService: TodoService) {
    @PostMapping("/add")
    fun addItem(@RequestBody item: Item): Mono<Item> {
        return todoService.add(item)
    }

    @GetMapping("/get/{id}")
    fun getItem(@PathVariable id: Long): Mono<Item> {
        return todoService.get(id)
    }

    @PatchMapping("/update/{id}/{task}")
    fun updateItem(@PathVariable id: Long, @PathVariable task: String):
            Mono<Item>? {
        return todoService.update(id, task)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteItem(@PathVariable id:Long): Mono<Void> {
        return todoService.deleteItem(id)
    }
}

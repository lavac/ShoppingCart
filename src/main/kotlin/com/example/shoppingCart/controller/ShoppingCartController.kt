package com.example.shoppingCart.controller

import com.example.shoppingCart.dto.Item
import com.example.shoppingCart.service.ShoppingCartService
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@ComponentScan("com.example.shoppingCart")
@RequestMapping("/shoppingCart")
@RestController
class ShoppingCartController(val shoppingCartService: ShoppingCartService) {
    @GetMapping("/get")
    fun getItems() : Flux<Item> {
        return shoppingCartService.getItems();
    }

    @PostMapping("/add")
    fun addItem(@RequestBody id:Long): Mono<Item> {
        return shoppingCartService.add(id)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteItem(@PathVariable id:Long): Mono<Item> {
        return shoppingCartService.remove(id)
    }
}

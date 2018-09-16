package com.example.shoppingCart.client

import com.example.shoppingCart.dto.Item
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class ShoppingCartClient {
    var shoppingCartClient = WebClient.create("http://localhost:8080")

    fun getItems(): Flux<Item> {

        return shoppingCartClient.get()
                .uri("/todo/get")
                .retrieve()
                .bodyToFlux(Item::class.java)
    }

    fun addItem(id: Long): Mono<Item> {
        return shoppingCartClient.delete()
                .uri("/todo/delete/{id}", id)
                .retrieve()
                .bodyToMono(Item::class.java)
    }

    fun removeItem(item: Item): Mono<Item> {
        return shoppingCartClient.post()
                .uri("/todo/add")
                .body(Mono.just(item), Item::class.java)
                .retrieve()
                .bodyToMono(Item::class.java)
    }
}

package com.example.shoppingCart.service

import com.example.shoppingCart.dto.Item
import com.example.shoppingCart.client.ShoppingCartClient
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ShoppingCartService(val shoppingCartClient: ShoppingCartClient) {
    fun getItems(): Flux<Item> {
        return shoppingCartClient.getItems();
    }

    fun add(id: Long): Mono<Item> {
        return shoppingCartClient.addItem(id);
    }

    fun remove(id: Long): Mono<Item> {
        return shoppingCartClient.removeItem(Item(id, "asfwa"));
    }

}

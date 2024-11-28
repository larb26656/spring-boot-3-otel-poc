package com.example.order;

public record Order(
        Long id,
        String name,
        Long productId,
        String productName
) {
}

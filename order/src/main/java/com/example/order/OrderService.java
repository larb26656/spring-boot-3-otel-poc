package com.example.order;

import io.micrometer.tracing.Tracer;
import io.micrometer.tracing.annotation.NewSpan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private final RestTemplate restTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Value("${microservice.product.origin}")
    private String origin;

    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @NewSpan
    public Order getOrder(Long orderId) {
        LOGGER.info("getOrder() invoke {}", orderId);
        String url = origin + "/products/" + orderId;
        Product product =  restTemplate.getForObject(url, Product.class);
        product = new Product(product.id(), product.name());

        return new Order(orderId, "order", product.id(), product.name());
    }
}

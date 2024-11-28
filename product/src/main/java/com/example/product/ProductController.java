package com.example.product;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

@RestController
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{productId}")
    public Product getProduct(@PathVariable Long productId, HttpServletRequest request) {
        // Log header
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            LOGGER.info("Header: {} = {}", headerName, headerValue);
        }

//        Span currentSpan = Span.current();
//        String traceId = currentSpan.getSpanContext().getTraceId();
//        String spanId = currentSpan.getSpanContext().getSpanId();
//        LOGGER.info("Current trace ID: {}", traceId);
//        LOGGER.info("Current span ID: {}", spanId);

        LOGGER.info("Getting product {}", productId);
        return productService.getProduct(productId);
    }
}

package com.example.product;

import io.micrometer.observation.annotation.Observed;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Observed(name = "user.name",
            contextualName = "getting-user-name",
            lowCardinalityKeyValues = {"userType", "userType2"})
    public Product getProduct(Long id) {
        if (id == 1L) {
            return new Product(1L, "Product A");
        } else if (id == 2L) {
            return new Product(2L, "Product B");
        } else if (id == 3L) {
            return new Product(3L, "Product C");
        }

        return new Product(4L, "Product D");
    }
}

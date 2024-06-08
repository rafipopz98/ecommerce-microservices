package dev.rafi.product_service.repository;

import dev.rafi.product_service.models.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductModel, String> {
}

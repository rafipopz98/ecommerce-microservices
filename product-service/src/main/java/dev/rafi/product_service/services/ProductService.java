package dev.rafi.product_service.services;

import dev.rafi.product_service.dto.ProductRequest;
import dev.rafi.product_service.dto.ProductResponse;
import dev.rafi.product_service.models.ProductModel;
import dev.rafi.product_service.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);
    @Autowired
    private ProductRepository productRepository;

    //get all
    public List<ProductResponse> allProducts() {
        List<ProductModel> products = productRepository.findAll();
        return products.stream().map(this::MapToProductResponse).toList();
    }

    private ProductResponse MapToProductResponse(ProductModel productModel) {
        System.out.println("proust");
        return ProductResponse.builder().id(productModel.getId())
                .name(productModel.getName())
                .description(productModel.getDescription())
                .price(productModel.getPrice())
                .build();
    }

    //get one
    public Optional<ProductResponse> singleProduct(String id) {
        Optional<ProductModel> product = productRepository.findById(id);
        if (product.isPresent()) {
            log.info("product found");
            return product.map(this::MapToProductResponse);
        } else {
            log.info("product not found");
            return Optional.empty();
        }
    }

    //add product
    public ProductResponse newProduct(ProductRequest productRequest) {
        ProductModel product = ProductModel.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product {} added Successfully", product.getName());
        return modelToResponse(product);
    }

    //delete
    public String deleteProduct(String id) {
        productRepository.deleteById(id);
        log.info("Deleted Successfully");
        return "Deleted Successfully";
    }

    //update
    public ProductResponse updateProduct(String id, ProductRequest updatedProduct) {
        Optional<ProductModel> product = productRepository.findById(id);
        if (product.isPresent()) {
            ProductModel updatedProductModel = product.get();
            updatedProductModel.setName(updatedProduct.getName() != null ? updatedProduct.getName() : updatedProductModel.getName());
            updatedProductModel.setDescription(updatedProduct.getDescription() != null ? updatedProduct.getDescription() : updatedProductModel.getDescription());
            updatedProductModel.setPrice(updatedProduct.getPrice() != null ? updatedProduct.getPrice() : updatedProductModel.getPrice());
            productRepository.save(updatedProductModel);
            return modelToResponse(updatedProductModel);
        } else {
            log.info("not found");
            return null;
        }
    }

    //function that converts product model to product response
    private ProductResponse modelToResponse(ProductModel productModel) {
        return ProductResponse.builder()
                .id(productModel.getId())
                .name(productModel.getName())
                .description(productModel.getDescription())
                .price(productModel.getPrice()).build();
    }

}

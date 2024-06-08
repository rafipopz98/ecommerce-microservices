package dev.rafi.product_service.controller;

import dev.rafi.product_service.dto.ProductRequest;
import dev.rafi.product_service.dto.ProductResponse;
import dev.rafi.product_service.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    //get all
    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.allProducts();
    }

    //get one
    @GetMapping(value = "/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ProductResponse> getSingleProduct(@PathVariable String id) {
        return productService.singleProduct(id);
    }

    //add product
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse addNewProduct(@RequestBody ProductRequest productRequest) {
        return productService.newProduct(productRequest);
    }


    //delete
    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteAProduct(@PathVariable String id) {
        return productService.deleteProduct(id);
    }

    //update
    @PutMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse updateAProduct(@PathVariable String id, @RequestBody ProductRequest productRequest) {
        return productService.updateProduct(id, productRequest);
    }
}


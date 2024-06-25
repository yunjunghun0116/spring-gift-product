package gift.controller;

import gift.model.Product;
import gift.dto.ProductDto;
import gift.exception.NotFoundProductException;
import gift.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PutMapping("/add")
    public Product addProduct(@RequestBody ProductDto productDto) {
        var product = service.addProduct(productDto);
        return product;
    }

    @PatchMapping("/update/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        var product = service.updateProduct(id, productDto);
        return product;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return service.getProduct(id);
    }

    @GetMapping
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
    }
}
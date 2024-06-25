package gift.controller;

import gift.model.Product;
import gift.dto.ProductDto;
import gift.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PutMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody ProductDto productDto) {
        var product = service.addProduct(productDto);
        return ResponseEntity.ok(product);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        var product = service.updateProduct(id, productDto);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        var product = service.getProduct(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        var products = service.getProducts();
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
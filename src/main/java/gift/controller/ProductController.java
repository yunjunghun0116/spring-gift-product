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

    private final Map<Long, Product> products = new HashMap<>();

    Long count = 1L;

    @PutMapping("/add")
    public Product addProduct(@RequestBody ProductDto productDto) {
        var product = service.addProduct(productDto);
        return product;
    }

    @PatchMapping("/update/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        productIdValidation(id);
        var product = service.updateProduct(id, productDto);
        return product;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        productIdValidation(id);
        return service.getProduct(id);
    }

    @GetMapping
    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productIdValidation(id);
        products.remove(id);
    }

    /**
     * @param id 만약 존재하지 않는 id를 통해 객체에 접근을 시도할 경우 NotFoundProductException 예외를 발생시킨다.
     */
    public void productIdValidation(Long id) {
        if (!products.containsKey(id)) {
            throw new NotFoundProductException(id + "를 가진 상품이 존재하지 않습니다.");
        }
    }
}
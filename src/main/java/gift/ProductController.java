package gift;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController("/api/products")
public class ProductController {

    private final Map<Long, Product> products = new HashMap<>();

    Long count = 1L;

    @PutMapping("/add")
    public Product addProduct(@RequestParam String name, @RequestParam int price, @RequestParam String imageUrl) {
        var product = new Product(count, name, price, imageUrl);
        products.put(count++,product);
        return product;
    }
}
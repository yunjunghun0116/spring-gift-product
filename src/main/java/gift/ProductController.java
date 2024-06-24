package gift;

import gift.exception.NotFoundProductException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("/api/products")
public class ProductController {

    private final Map<Long, Product> products = new HashMap<>();

    Long count = 1L;

    @PutMapping("/add")
    public Product addProduct(@RequestParam String name, @RequestParam int price, @RequestParam String imageUrl) {
        var product = new Product(count, name, price, imageUrl);
        products.put(count++, product);
        return product;
    }

    @PatchMapping("/update/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestParam String name, @RequestParam int price, @RequestParam String imageUrl) {
        if (!products.containsKey(id)) {
            throw new NotFoundProductException(id + "를 가진 상품이 존재하지 않습니다.");
        }
        var product = new Product(id, name, price, imageUrl);

        products.put(id, product);
        return product;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        if (!products.containsKey(id)) {
            throw new NotFoundProductException(id + "를 가진 상품이 존재하지 않습니다.");
        }
        return products.get(id);
    }

    @GetMapping
    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        if (!products.containsKey(id)) {
            throw new NotFoundProductException(id + "를 가진 상품이 존재하지 않습니다.");
        }
        products.remove(id);
    }
}
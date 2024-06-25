package gift.repository;

import gift.model.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepository {

    private final Map<Long, Product> products = new HashMap<>();

    Long sequentialId = 1L;

    public void save(Product product) {
        product.setId(sequentialId);
        products.put(sequentialId++, product);
    }
}

package gift.repository;

import gift.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {

    private final Map<Long, Product> products = new HashMap<>();

    Long sequentialId = 1L;

    public void save(Product product) {
        product.setId(sequentialId);
        products.put(sequentialId++, product);
    }

    public void update(Product product) {
        products.put(product.getId(), product);
    }

    public Product findById(Long id){
        return products.get(id);
    }

    public List<Product> findAll(){
        return new ArrayList<>(products.values());
    }

    public void deleteById(Long id){
        products.remove(id);
    }
}

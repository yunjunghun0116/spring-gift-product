package gift.service;

import gift.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }
}

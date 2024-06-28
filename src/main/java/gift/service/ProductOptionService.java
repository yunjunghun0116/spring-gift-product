package gift.service;

import gift.repository.ProductOptionRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductOptionService {

    private final ProductOptionRepository repository;

    public ProductOptionService(ProductOptionRepository repository) {
        this.repository = repository;
    }
}

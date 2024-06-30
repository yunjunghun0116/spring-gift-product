package gift.service;

import gift.model.Product;
import gift.dto.ProductDto;
import gift.repository.ProductOptionJDBCRepository;
import gift.repository.ProductOptionRepository;
import gift.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductOptionRepository optionRepository;

    public ProductService(ProductRepository repository, ProductOptionRepository optionRepository) {
        this.repository = repository;
        this.optionRepository = optionRepository;
    }

    public Product addProduct(ProductDto productDto) {
        return repository.save(Product.fromDto(productDto));
    }

    public Product updateProduct(Long id, ProductDto productDto) {
        var product = repository.findById(id);
        product.updateFromDto(productDto);
        repository.update(product);
        return product;
    }

    public Product getProduct(Long id) {
        return repository.findById(id);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public void deleteProduct(Long id) {
        optionRepository.deleteByProductId(id);
        repository.deleteById(id);
    }
}

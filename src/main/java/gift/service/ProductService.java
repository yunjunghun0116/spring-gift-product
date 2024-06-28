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
        var product = new Product(productDto.name(), productDto.price(), productDto.imageUrl());
        return repository.insert(product);
    }

    public Product updateProduct(Long id, ProductDto productDto) {
        var product = repository.findById(id);
        product.setName(productDto.name());
        product.setPrice(productDto.price());
        product.setImageUrl(productDto.imageUrl());
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

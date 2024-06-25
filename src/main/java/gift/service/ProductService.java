package gift.service;

import gift.model.Product;
import gift.dto.ProductDto;
import gift.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product addProduct(ProductDto productDto) {
        var product = new Product(productDto.getName(), productDto.getPrice(), productDto.getImageUrl());
        repository.save(product);
        return product;
    }

    public Product updateProduct(Long id, ProductDto productDto) {
        var product = new Product(id, productDto.getName(), productDto.getPrice(), productDto.getImageUrl());
        repository.update(product);
        return product;
    }

    public Product getProduct(Long id) {
        return repository.findById(id);
    }
}

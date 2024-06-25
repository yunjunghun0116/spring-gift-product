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

    public Product addProduct(ProductDto productDto){
        var product = new Product(productDto.getName(),productDto.getPrice(),productDto.getImageUrl());
        repository.save(product);
        return product;
    }
}

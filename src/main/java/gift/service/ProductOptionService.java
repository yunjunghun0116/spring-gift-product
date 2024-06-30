package gift.service;

import gift.dto.ProductOptionDto;
import gift.model.ProductOption;
import gift.repository.ProductOptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOptionService {

    private final ProductOptionRepository repository;

    public ProductOptionService(ProductOptionRepository repository) {
        this.repository = repository;
    }

    public ProductOption addOption(ProductOptionDto productOptionDto) {
        return repository.save(ProductOption.from(productOptionDto));
    }

    public ProductOption updateOption(Long id, ProductOptionDto productOptionDto) {
        var productOption = ProductOption.fromWithId(id,productOptionDto);
        repository.update(productOption);
        return productOption;
    }

    public ProductOption getOption(Long id) {
        return repository.findById(id);
    }

    public List<ProductOption> getOptions(Long productId) {
        return repository.findAll(productId);
    }

    public void deleteOption(Long id) {
        repository.deleteById(id);
    }
}

package gift.repository;

import gift.dto.ProductOptionDto;
import gift.model.Product;
import gift.model.ProductOption;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductOptionRepository {


    ProductOption save(ProductOption productOption);

    void update(ProductOption productOption);

    ProductOption findById(Long id);

    List<ProductOption> findAll(Long productId);

    void deleteById(Long id);

    void deleteByProductId(Long id);
}

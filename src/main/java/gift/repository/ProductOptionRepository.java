package gift.repository;

import gift.model.Product;
import gift.model.ProductOption;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class ProductOptionRepository {
    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert jdbcInsert;

    public ProductOptionRepository(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("product_option")
                .usingGeneratedKeyColumns("id");
    }

    public ProductOption save(ProductOption productOption) {
        var param = new BeanPropertySqlParameterSource(productOption);
        Number key = jdbcInsert.executeAndReturnKey(param);
        productOption.setId(key.longValue());
        return productOption;
    }
}

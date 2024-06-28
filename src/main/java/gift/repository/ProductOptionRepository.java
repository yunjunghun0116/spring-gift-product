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

    public void update(ProductOption productOption) {
        var sql = "update product_option set name=?, additional_price=? where id = ?";
        jdbcTemplate.update(sql, productOption.getName(), productOption.getAdditionalPrice(), productOption.getId());
    }

    public ProductOption findById(Long id) {
        var sql = "select id, product_id, name, additional_price from product_option where id = ?";
        ProductOption productOption = jdbcTemplate.queryForObject(
                sql,
                (resultSet, rowNum) ->
                        new ProductOption(
                                resultSet.getLong("id"),
                                resultSet.getLong("product_id"),
                                resultSet.getString("name"),
                                resultSet.getInt("additional_price")
                        ), id);
        return productOption;
    }
}

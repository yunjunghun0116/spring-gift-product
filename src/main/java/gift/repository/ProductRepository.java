package gift.repository;

import gift.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ProductRepository {

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert jdbcInsert;

    public ProductRepository(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("product")
                .usingGeneratedKeyColumns("id");
    }

    public Product save(Product product) {
        var param = new BeanPropertySqlParameterSource(product);
        Number key = jdbcInsert.executeAndReturnKey(param);
        product.setId(key.longValue());
        return product;
    }

    public void update(Product product) {
        var sql = "update product set name=?, price=?, image_url=? where id = ?";
        jdbcTemplate.update(sql, product.getName(), product.getPrice(), product.getImageUrl(), product.getId());
    }

    public Product findById(Long id) {
        var sql = "select id, name, price, image_url from product where id = ?";
        Product product = jdbcTemplate.queryForObject(
                sql,
                (resultSet, rowNum) ->
                        new Product(
                                resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getInt("price"),
                                resultSet.getString("image_url")
                        ), id);
        return product;
    }

    public List<Product> findAll() {
        var sql = "select id, name, price, image_url from product";
        List<Product> products = jdbcTemplate.query(
                sql,
                (resultSet, rowNum) ->
                        new Product(
                                resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getInt("price"),
                                resultSet.getString("image_url")
                        ));
        return products;
    }

    public void deleteById(Long id) {
        var sql = "delete from product where id = ?";
        jdbcTemplate.update(sql, id);
    }
}

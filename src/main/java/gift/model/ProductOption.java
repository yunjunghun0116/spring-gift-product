package gift.model;

import gift.dto.ProductDto;
import gift.dto.ProductOptionDto;

public class ProductOption {
    private Long id;
    private Long productId;

    private String name;
    private Integer additionalPrice;

    public ProductOption(Long productId, String name, Integer additionalPrice) {
        this.productId = productId;
        this.name = name;
        this.additionalPrice = additionalPrice;
    }

    public ProductOption(Long id, Long productId, String name, Integer additionalPrice) {
        this.id = id;
        this.productId = productId;
        this.name = name;
        this.additionalPrice = additionalPrice;
    }

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public Integer getAdditionalPrice() {
        return additionalPrice;
    }

    public static ProductOption from(ProductOptionDto dto) {
        return new ProductOption(dto.productId(), dto.name(), dto.additionalPrice());
    }

    public static ProductOption copyWithId(Long id, ProductOption productOption) {
        return new ProductOption(id, productOption.getProductId(), productOption.getName(), productOption.getAdditionalPrice());
    }

    public static ProductOption fromWithId(Long id, ProductOptionDto dto) {
        return new ProductOption(id, dto.productId(), dto.name(), dto.additionalPrice());
    }
}

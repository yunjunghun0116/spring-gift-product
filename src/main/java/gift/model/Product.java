package gift.model;

import gift.dto.ProductDto;

public class Product {
    private Long id;
    private String name;
    private Integer price;
    private String imageUrl;

    public Product(String name, Integer price, String imageUrl) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Product(Long id, String name, Integer price, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public static Product from(ProductDto dto) {
        return new Product(dto.name(), dto.price(), dto.imageUrl());
    }

    public static Product copyWithId(Long id,Product product) {
        return new Product(id, product.getName(), product.getPrice(), product.getImageUrl());
    }

    public static Product fromWithId(Long id, ProductDto dto) {
        return new Product(id, dto.name(), dto.price(), dto.imageUrl());
    }
}

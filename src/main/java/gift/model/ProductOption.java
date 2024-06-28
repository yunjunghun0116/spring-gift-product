package gift.model;

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

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAdditionalPrice() {
        return additionalPrice;
    }

    public void setAdditionalPrice(Integer additionalPrice) {
        this.additionalPrice = additionalPrice;
    }
}

package gift.dto;

import gift.exception.PriceLessThanZeroException;
import gift.model.Product;

public record ProductDto(String name, Integer price, String imageUrl) {
    public ProductDto {
        if (price < 0) {
            throw new PriceLessThanZeroException("가격은 0원보다 작을 수 없습니다.");
        }
    }
}

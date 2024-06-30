package gift.dto;

import gift.exception.PriceLessThanZeroException;
import gift.model.ProductOption;

public record ProductOptionDto(Long productId, String name, Integer additionalPrice) {
    public ProductOptionDto {
        if (additionalPrice < 0) {
            throw new PriceLessThanZeroException("가격은 0원보다 작을 수 없습니다.");
        }
    }
}

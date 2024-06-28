package gift.controller;

import gift.service.ProductOptionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products/{productId}/options")
public class ProductOptionController {

    private final ProductOptionService service;

    public ProductOptionController(ProductOptionService service) {
        this.service = service;
    }
}

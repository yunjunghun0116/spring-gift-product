package gift.controller;

import gift.dto.ProductDto;
import gift.dto.ProductOptionDto;
import gift.model.Product;
import gift.model.ProductOption;
import gift.service.ProductOptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/options")
public class ProductOptionController {

    private final ProductOptionService service;

    public ProductOptionController(ProductOptionService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addOption(@RequestBody ProductOptionDto productOptionDto) {
        var productOption = service.addOption(productOptionDto);
        return ResponseEntity.created(URI.create("/api/options/"+productOption.getId())).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductOption> updateOption(@PathVariable Long id, @RequestBody ProductOptionDto productOptionDto) {
        var productOption = service.updateOption(id, productOptionDto);
        return ResponseEntity.ok(productOption);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductOption> getOption(@PathVariable Long id) {
        var productOption = service.getOption(id);
        return ResponseEntity.ok(productOption);
    }

    @GetMapping
    public ResponseEntity<List<ProductOption>> getOptions(@RequestParam Long productId) {
        var options = service.getOptions(productId);
        return ResponseEntity.ok(options);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        service.deleteOption(id);
        return ResponseEntity.noContent().build();
    }
}

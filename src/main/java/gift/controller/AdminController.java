package gift.controller;

import gift.dto.ProductDto;
import gift.model.Product;
import gift.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class AdminController {

    ProductService service;

    public AdminController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public String getProducts(Model model) {
        List<Product> products = service.getProducts();
        model.addAttribute("data", "관리자");
        model.addAttribute("products", products);
        return "views/products";
    }

    @GetMapping("/{id}")
    public String getProduct(@PathVariable Long id, Model model) {
        Product product = service.getProduct(id);
        model.addAttribute("product", product);
        return "views/product";
    }

    @GetMapping("/add")
    public String getAddForm() {
        return "views/addProduct";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable Long id, Model model) {
        Product product = service.getProduct(id);
        model.addAttribute("product", product);
        return "views/editProduct";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute ProductDto productDto, RedirectAttributes redirectAttributes) {
        Product product = service.addProduct(productDto);

        redirectAttributes.addAttribute("productId", product.getId());

        return "redirect:/products/{productId}";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute ProductDto productDto, RedirectAttributes redirectAttributes) {
        Product product = service.updateProduct(id, productDto);

        redirectAttributes.addAttribute("productId", product.getId());

        return "redirect:/products/{productId}";
    }
}
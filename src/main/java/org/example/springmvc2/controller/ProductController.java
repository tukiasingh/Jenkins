package org.example.springmvc2.controller;
import org.example.springmvc2.service.ProductService;
import org.example.springmvc2.model.Product;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController (ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String viewProducts(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);
        return "products.html";


    }

    @PostMapping("/products")
    public String addProduct(Product product, Model model) {
        productService.addProduct(product);

        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);
        return "products.html";
    }




}

package com.example.Books.Controllers;

import com.example.Books.Models.Product;
import com.example.Books.Services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductsController {
    private final ProductService productService;

    public ProductsController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public String showProducts(Model page){
        var products = productService.getProducts();
        page.addAttribute("products",products);

        return "products.html";
    }

    @PostMapping("/products")
    public String addProducts(
            @RequestParam String name,
            @RequestParam double price,
            Model page
    ){
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        productService.addProduct(p);

        var products = productService.getProducts();
        page.addAttribute("products", products);

        return "products.html";
    }
}

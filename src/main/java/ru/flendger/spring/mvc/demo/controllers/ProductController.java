package ru.flendger.spring.mvc.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.flendger.spring.mvc.demo.model.Product;
import ru.flendger.spring.mvc.demo.services.ProductService;

@Controller
@RequestMapping("/prod")
public class ProductController {

    private ProductService service;

    @Autowired
    private void setService(ProductService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public String showProducts(Model model) {
        model.addAttribute("products", service.getProducts());
        return "products";
    }

    @GetMapping("/remove/{id}")
    public String removeProduct(@PathVariable Integer id) {
        service.removeProduct(id);
        return "redirect:/prod/all";
    }

    @GetMapping("/add-form")
    public String openAddForm() {
        return "add-form";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product) {
        service.addProduct(product);
        return "redirect:/prod/all";
    }
}

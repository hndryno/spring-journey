package com.henresearch.controller;

import com.henresearch.entity.Product;
import com.henresearch.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="", method=RequestMethod.GET)
public class HomeController {

    @Autowired
    private ProductService productService; 

    @GetMapping
    public String welcome(Model model) {
        String hello = "Welcome Hendriyono";
        model.addAttribute("hello", hello);
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        //data dari view sana masuk kesini
        model.addAttribute("product", new Product());
        return "add";
    }

    @PostMapping("/save")
    public String save(Product product, Model model){
        productService.addProduct(product);
        String hello = "Welcome Hendriyono";
        model.addAttribute("hello", hello);
        model.addAttribute("products", productService.findAll());
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        //call service utk hapus
        productService.deleteById(id); 
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        //call service utk edit
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("/update/{id}")
    public String update(Product product, Model model){
        //call service utk update
        productService.updateProduct(product);
        return "redirect:/";
    }
    
}

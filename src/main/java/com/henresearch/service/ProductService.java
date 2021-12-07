package com.henresearch.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.henresearch.entity.Product;
import com.henresearch.utils.RandomNumber;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private static List<Product> products = new ArrayList<Product>(){
        {
        add(new Product(RandomNumber.getRandom(1000, 9999), "lemari", "ini adalah lemari", 10000.0));
        add(new Product(RandomNumber.getRandom(1000, 9999), "sepatu", "ini adalah sepatu", 20000.0));
        add(new Product(RandomNumber.getRandom(1000, 9999), "sendal", "ini adalah sendal", 40000.0));
        add(new Product(RandomNumber.getRandom(1000, 9999), "kulkas", "ini adalah kulkas", 120000.0));
        add(new Product(RandomNumber.getRandom(1000, 9999), "tas", "ini adalah tas", 70000.0));
        }
    };
    
    public List<Product> findAll(){
        return products;
    }

    public void addProduct(Product product){
        product.setId(RandomNumber.getRandom(1000, 9999));
        products.add(product);
    }

    public void deleteById(long id){
        products.removeIf(p -> p.getId() == id);
    }

    public Optional<Product> findById(long id){
       return products.stream().filter(p-> p.getId() == id).findFirst();
    }

    public void updateProduct(Product product){
        deleteById(product.getId());
        products.add(product);
    }
}

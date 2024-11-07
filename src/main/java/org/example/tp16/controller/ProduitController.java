package org.example.tp16.controller;


import org.example.tp16.dao.ProduitRepository;
import org.example.tp16.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller

public class ProduitController {


    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping(path="/index")
    public String index() {
        return "index";
    }
    @GetMapping(path = "/products")
    public String products(Model model) {
        List<Produit> produits = produitRepository.findAll();
        System.out.println("Fetched produits: " + produits); // Log fetched data
        model.addAttribute("listProduits", produits);
        return "products";
    }
}

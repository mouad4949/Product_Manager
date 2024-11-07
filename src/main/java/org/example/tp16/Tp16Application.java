package org.example.tp16;

import org.example.tp16.dao.ProduitRepository;
import org.example.tp16.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class Tp16Application implements CommandLineRunner {

    @Autowired
    private ProduitRepository produitRepository;

    public static void main(String[] args) {
        SpringApplication.run(Tp16Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        // TODO Auto-generated method stub
        produitRepository.save(new Produit(null,"Ordianteur HP",6500,54));
        produitRepository.save(new Produit(null,"Imprimante HP Laser",4500,44));
                produitRepository.save(new Produit(null,"Smart Phone",3500,24));
        Page<Produit> produits=
                produitRepository.findByDesignationContains("H", PageRequest.of(0, 2));
        System.out.println(produits.getSize());
        System.out.println(produits.getTotalElements());
        System.out.println(produits.getTotalPages());
        produits.forEach(p->{
            System.out.println(p.toString());
        });
        System.out.println("---------------------------------------");
        Page<Produit> prods= produitRepository.chercher("%H%", 100 ,PageRequest.of(0, 2));
        System.out.println(prods.getSize());
        System.out.println(prods.getTotalElements());
        System.out.println(prods.getTotalPages());
        produits.forEach(p->{
            System.out.println(p.toString());
        });
    }
}

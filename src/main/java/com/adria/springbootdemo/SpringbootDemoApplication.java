package com.adria.springbootdemo;

import com.adria.springbootdemo.entities.Compte;
import com.adria.springbootdemo.entities.TypeCompte;
import com.adria.springbootdemo.repositories.CompteREpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class SpringbootDemoApplication implements CommandLineRunner {

    @Autowired
    private CompteREpository cpRepo;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        Compte cp = new Compte(null, 40000, new Date( ), TypeCompte.COURANT);
        Compte cp1 = new Compte(null, 2000, new Date( ), TypeCompte.COURANT);
        Compte cp2 = new Compte(null, 402580.99, new Date( ), TypeCompte.COURANT);
        Compte cp3 = new Compte(null, 420.65, new Date( ), TypeCompte.EPARGNE);
        Compte cp4 = new Compte(null, 40000, new Date( ), TypeCompte.COURANT);
        Compte cp5 = new Compte(null, 70000, new Date( ), TypeCompte.COURANT);
        Compte cp6 = new Compte(null, 402580.99, new Date( ), TypeCompte.EPARGNE);
        Compte cp7 = new Compte(null, 3450, new Date( ), TypeCompte.COURANT);
        Compte cp8 = new Compte(null, 40000, new Date( ), TypeCompte.EPARGNE);
        Compte cp9 = new Compte(null, 10000, new Date( ), TypeCompte.COURANT);
        Compte cp11 = new Compte(null, 40000, new Date( ), TypeCompte.COURANT);
        Compte cp12 = new Compte(null, 2000, new Date( ), TypeCompte.COURANT);
        Compte cp13 = new Compte(null, 402580.99, new Date( ), TypeCompte.COURANT);
        Compte cp14 = new Compte(null, 420.65, new Date( ), TypeCompte.EPARGNE);
        Compte cp15 = new Compte(null, 40000, new Date( ), TypeCompte.COURANT);
        Compte cp16 = new Compte(null, 70000, new Date( ), TypeCompte.COURANT);
        Compte cp17 = new Compte(null, 402580.99, new Date( ), TypeCompte.EPARGNE);
        Compte cp18 = new Compte(null, 3450, new Date( ), TypeCompte.COURANT);
        Compte cp19 = new Compte(null, 40000, new Date( ), TypeCompte.EPARGNE);
        Compte cp20 = new Compte(null, 10000, new Date( ), TypeCompte.COURANT);

        List<Compte> comptesList = Arrays.asList(cp, cp1, cp2, cp3,cp4, cp5, cp6, cp7, cp8,cp9, cp11, cp12, cp13, cp14, cp15,cp16, cp17, cp18, cp19, cp20);
        Iterator<Compte> it = comptesList.iterator( );
        while (it.hasNext()) {
            cpRepo.save(it.next());
        }

        List<Compte> comptes = cpRepo.findAll();
        comptes.forEach(compte -> System.out.println(compte.toString( ))
        );
        System.out.println("**************************");
        List<Compte> comptesByid = cpRepo.findAllBySoldeIsLessThanEqual(7200);
        comptesByid.forEach(compte -> System.out.println(compte.toString( ))
        );
        System.out.println("**************************");
        Page<Compte> cpPage = cpRepo.findAll(PageRequest.of(1,10, Sort.by("solde").descending()));
        cpPage.forEach(compte -> System.out.println(compte.toString( ))
        );
        System.out.println("**************************");
        Page<Compte> cpq = cpRepo.chercherparsoldeinf(2000,PageRequest.of(1,2));
        cpq.forEach(compte -> System.out.println(compte.toString( ))
        );

    }
}

package com.sidibrahimeljily;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class GestionStock {
    // le nombre maximum des produits accepter dans le system.
    public static int MAX_PRODUCTS_COUNT = 100;
    static Produit[] produits = new Produit[MAX_PRODUCTS_COUNT];

    public static void printMenu() {
        System.out.println("""
                --------------------
                | Gestion de Stock |
                --------------------
                1.Ajouter un produit
                2.Modifier un produit
                3.supprimer un produit
                4.Afficher la liste des produits
                5.Rechercher un produit
                6.calculer la valeur total du stock
                0.Quiter
                                
                Choisissez une option :
                """);
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.println("Code du produit: \n");
            int code = sc.nextInt();
            while (!validerCode(code)) {
                System.out.println("Code deja exist veuillez saisir code valid :\n");
                code = sc.nextInt();
            }
            System.out.println("Nom du produit: \n");
            String nom = sc.next();
            System.out.println("Prix du produit :\n");
            double prix = sc.nextDouble();
            while (!validerPrix(prix)) {
                System.out.println("Prix not valide , Veuillez saisir un prix valid svp : \n");
                prix = sc.nextDouble();
            }
            System.out.println("Quantite du produit : \n");
            int quantite = sc.nextInt();
            while (!validerQuantite(quantite)) {
                System.out.println("Veuiller saisir quantite valid svp : \n");
                quantite = sc.nextInt();
            }
            Produit produit = new Produit(code, nom, prix, quantite);
            System.out.println(ajouterProduit(produit));

            System.out.println("""
                                        
                                        
                    ------------------------------------------------------------------------------------
                    | Cliquer 1 pour retourner au menu ,ou tapez ce que vous voulez pour quitter : | 
                    ------------------------------------------------------------------------------------
                    """);
            choice = sc.nextInt();
            if (choice != 1) {
                return;
            }
            printMenu();
        }
        if (choice == 2){
            System.out.println("Code du produit A modifier: \n");
            int code = sc.nextInt();
            while (validerCode(code)) {
                System.out.println(" Produit n'exist pas avec le code  => "+ code + " veuillez saisir un code valid :\n");
                code = sc.nextInt();
            }
            System.out.println("Nouveau Nom du produit: \n");
            String nom = sc.next();
            System.out.println("Nouveau Prix du produit :\n");
            double prix = sc.nextDouble();
            while (!validerPrix(prix)) {
                System.out.println("Prix not valide , Veuillez saisir un prix valid svp : \n");
                prix = sc.nextDouble();
            }
            System.out.println("Nouveau Quantite du produit : \n");
            int quantite = sc.nextInt();
            while (!validerQuantite(quantite)) {
                System.out.println("Veuiller saisir quantite valid svp : \n");
                quantite = sc.nextInt();
            }
            Produit produit = new Produit(code, nom, prix, quantite);
            System.out.println(modifierProduit(produit));

            System.out.println("""
                                        
                                        
                    ------------------------------------------------------------------------------------
                    | Cliquer 1 pour retourner au menu ,ou tapez ce que vous voulez pour quitter : | 
                    ------------------------------------------------------------------------------------
                    """);
            choice = sc.nextInt();
            if (choice != 1) {
                return;
            }
            printMenu();

    }
        if (choice==3){
            System.out.println("Veuillez saisir le code du produit a supprimer : \n");
            int code =sc.nextInt();
            while (validerCode(code)) {
                System.out.println(" Produit n'exist pas avec le code  => "+ code + " veuillez saisir un code valid :\n");
                code = sc.nextInt();
            }
            System.out.println(supprimerProduit(code));

            System.out.println("""
                                        
                                        
                    ------------------------------------------------------------------------------------
                    | Cliquer 1 pour retourner au menu ,ou tapez ce que vous voulez pour quitter : | 
                    ------------------------------------------------------------------------------------
                    """);
            choice = sc.nextInt();
            if (choice != 1) {
                return;
            }
            printMenu();

        }
        if(choice==4){
            afficherListProduits();
            System.out.println("""
                                        
                                        
                    ------------------------------------------------------------------------------------
                    | Cliquer 1 pour retourner au menu ,ou tapez ce que vous voulez pour quitter : |  
                    ------------------------------------------------------------------------------------
                    """);
            choice = sc.nextInt();
            if (choice != 1) {
                return;
            }
            printMenu();
        }
        if(choice==5){
            System.out.println("Veuillez saisir le nom du produit a chercher : \n");
            String nomProduit =sc.next();
            System.out.println(chercherProduit(nomProduit));

            System.out.println("""
                                        
                                        
                    ------------------------------------------------------------------------------------
                    | Cliquer 1 pour retourner au menu ,ou tapez ce que vous voulez pour quitter : | 
                    ------------------------------------------------------------------------------------
                    """);
            choice = sc.nextInt();
            if (choice != 1) {
                return;
            }
            printMenu();

        }
        if (choice==6){
            System.out.println("La valeur totale du stock est  => "+calculerTotalStock());
            System.out.println("""
                                        
                                        
                    ------------------------------------------------------------------------------------
                    | Cliquer 1 pour retourner au menu ,ou tapez ce que vous voulez pour quitter : | 
                    ------------------------------------------------------------------------------------
                    """);
            choice = sc.nextInt();
            if (choice != 1) {
                return;
            }
            printMenu();
        }

    }

    public static String ajouterProduit(Produit produit) {
        for (int i = 0; i < produits.length; i++) {
            if (produits[i] == null) {
                produits[i] = produit;
                return "produit ajouter avec success";
            }
        }
        return "" + "\n" +
                "Le produit ne peux pas etre ajouter car La capaciter maximum est atteint";
    }

    public static String modifierProduit(Produit produit) {
        for (int i = 0; i < produits.length; i++) {
            if (produits[i] != null && produits[i].getCode() == produit.getCode()) {
                produits[i] = produit;
                return "produit modifier avec succes";
            }
        }
        return "produit n'exist pas avec le code que vous avez inserer";
    }
    public static String supprimerProduit(int code){
        for(int i =0;i< produits.length;i++){
            if (produits[i]!=null){
                if (produits[i].getCode()==code){
                    //pour supprimer un produits
                    produits[i]=null;
                    return "Produit supprimer avec succes !";
                }
            }
        }
        return "Prdocuit n'est pas supprimer";
    }

    public static boolean validerCode(int code) {
        boolean valid = true;
        for (Produit produit : produits) {
            if (produit != null) {
                if (produit.getCode() == code) {
                    valid = false;
                }
            }
        }
        return valid;
    }

    public static boolean validerPrix(double prix) {
        boolean valid = true;
        if (prix <= 0) {
            valid = false;
        }
        return valid;
    }

    public static boolean validerQuantite(int quantite) {
        boolean valid = true;
        if (quantite <= 0) {
            valid = false;
        }
        return valid;
    }

    public static void afficherListProduits(){
        for (int i=0;i<produits.length;i++){
            if (produits[i]!=null){
                System.out.println( "Produit "+(i+1)+" => "+produits[i].toString());
            }
        }
    }

    public static String chercherProduit(String nom){
        for (int i=0;i<produits.length;i++){
            if (produits[i]!=null && Objects.equals(produits[i].getNom(), nom)){
                return produits[i].toString();
            }
        }
        return "Produit n'exist pas avec le nom => "+nom;
    }

    public static double calculerTotalStock(){
        double total = 0;
        for (int i = 0;i<produits.length;i++){
            if (produits[i]!=null){
                total += produits[i].calculerTotalProduit();
            }
        }
        return total;
    }

    public static void main(String[] args) {
        printMenu();
    }
}

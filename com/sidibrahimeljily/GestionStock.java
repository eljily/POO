package com.sidibrahimeljily;

import java.util.Scanner;

public class GestionStock {
    // le nombre maximum des produits accepter dans le system.
    public static int MAX_PRODUCTS_COUNT = 2;
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
                                
                Choisissez un option :
                """);
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.println("Code du produit: \n");
            int code = sc.nextInt();
            while (!validerCode(code)){
                System.out.println("Code deja exist veuillez saisir code valid :\n");
                code = sc.nextInt();
            }
            System.out.println("Nom du produit: \n");
            String nom = sc.next();
            System.out.println("Prix du produit :\n");
            double prix = sc.nextDouble();
            while(!validerPrix(prix)){
                System.out.println("Prix not valide , Veuillez saisir un prix valid svp : \n");
                prix = sc.nextDouble();
            }
System.out.println("Quantite du produit : \n");
            int quantite = sc.nextInt();
            while (!validerQuantite(quantite)){
                System.out.println("Veuiller saisir quantite valid svp : \n");
                quantite = sc.nextInt();
            }
            Produit produit = new Produit(code,nom,prix,quantite);
            System.out.println(ajouterProduit(produit));

            System.out.println("""
                    
                    
                    ------------------------------------------------------------------------------------
                    | Cliquer 1 pour retourner au menu ,ou tapez ce que vous voulez pour quitter : | " +
                    ------------------------------------------------------------------------------------
                    """);
            choice = sc.nextInt();
            if (choice!=1){
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
        return "" +"\n"+
                "Le produit ne peux pas etre ajouter car La capaciter maximum est atteint";
    }

    public static boolean validerCode(int code) {
        boolean valid = true;
        for (Produit produit : produits) {
            if (produit !=null){
                if (produit.getCode() == code) {
                    valid = false;
                }
            }
        }
        return valid;
    }
    public static boolean validerPrix(double prix){
        boolean valid = true;
        if (prix<=0){
            valid = false;
        }
        return valid;
    }
    public static boolean validerQuantite(int quantite){
        boolean valid = true;
        if (quantite<=0){
            valid = false;
        }
        return valid;
    }

    public static void main(String[] args) {
        printMenu();
    }
}
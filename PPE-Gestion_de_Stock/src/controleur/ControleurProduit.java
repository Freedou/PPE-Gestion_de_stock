package controleur;

import java.util.LinkedList;
import java.util.Scanner;
import modele.Modele;
import vue.VueArticle;

public class ControleurProduit 
{
 private LinkedList<Produit> lesProduits;
 
 public ControleurProduit()
 {
     this.lesProduits=null;
 }
 
 public void chargerLesProduits ()
 {
     this.lesProduits = Modele.selectAll();
 }
 

 public String toString()
 {
     String chaine ="";
     for(Produit unProd : this.lesProduits)
     {
         chaine += unProd.toString();
         chaine += "\n\n";
     }
     return chaine;
 }
 public void ajouter(Produit unProd)
 {
     //le controlleur appelle le modele
     Modele.insertProduit(unProd);
 }
 public String afficherLesResultats()
 {
     this.lesProduits = Modele.selectWhere(VueArticle.saisirCle());
     return this.toString();
 }       
 
 public void menu ()
 {
     Scanner sc = new Scanner (System.in);
     int choix = 0;
     do{
         System.out.println("1- Afficher les produits");
         System.out.println("2- Ajouter un produit");
         System.out.println("3- Rechercher par clé");
         System.out.println("0- Quitter");
         choix = sc.nextInt();
         switch (choix)
         {
             case 1 : this.chargerLesProduits();
                      //appel de la vue
                      VueArticle.afficherProduits(this.toString());
                 break;
             case 2 :
                    //le controlleur appelle vue
                      this.ajouter(VueArticle.saisirProduit());
                      System.out.println("Le produit a ete ajouté avec succès !");
                 break;
             case 3 :
                      VueArticle.afficherProduits(this.afficherLesResultats());
                      System.out.println("La recherche est terminée");
                 break; 
         }
     }while (choix !=0);
     sc.close();
 }
         
}

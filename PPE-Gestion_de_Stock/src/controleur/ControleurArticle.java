package controleur;

import java.util.LinkedList;
import java.util.Scanner;
import modele.Modele;
import vue.VueArticle;

public class ControleurArticle 
{
 private LinkedList<Article> lesArticles;
 
 public ControleurArticle()
 {
     this.lesArticles=null;
 }
 
 public void chargerLesArticles ()
 {
     this.lesArticles = Modele.selectAll();
 }
 

 public String toString()
 {
     String chaine ="";
     for(Article unArticle : this.lesArticles)
     {
         chaine += unArticle.toString();
         chaine += "\n\n";
     }
     return chaine;
 }
 public void ajouter(Article unArticle)
 {
     //le controlleur appelle le modele
     Modele.insertArticle(unArticle);
 }
 public String afficherLesResultats()
 {
     this.lesArticles = Modele.selectWhere(VueArticle.saisirCle());
     return this.toString();
 }       
 
 public void menu ()
 {
     Scanner sc = new Scanner (System.in);
     int choix = 0;
     do{
         System.out.println("1- Afficher les Articles");
         System.out.println("2- Ajouter un Article");
         System.out.println("3- Rechercher par clé");
         System.out.println("0- Quitter");
         choix = sc.nextInt();
         switch (choix)
         {
             case 1 : this.chargerLesArticles();
                      //appel de la vue
                      VueArticle.afficherArticle(this.toString());
                 break;
             case 2 :
                    //le controlleur appelle vue
                      this.ajouter(VueArticle.saisirArticle());
                      System.out.println("L'article a ete ajouté avec succès !");
                 break;
             case 3 :
                      VueArticle.afficherArticle(this.afficherLesResultats());
                      System.out.println("La recherche est terminée");
                 break; 
         }
     }while (choix !=0);
     sc.close();
 }
         
}

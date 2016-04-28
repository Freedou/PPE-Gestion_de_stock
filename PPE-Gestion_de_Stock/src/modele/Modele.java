package modele;

import java.util.LinkedList;
import controleur.Article;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Modele {
    
    public static LinkedList<Article> selectAll ()
    {
        LinkedList<Article> uneListe = new LinkedList<Article>();
        BDD uneBDD = new BDD("localhost", "filelec", "root", "");
        uneBDD.chargerPilote();
        uneBDD.seConnecter();
        String requete ="Select * from articles;";
        try {
            Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            while (unRes.next())
            {
                int id = unRes.getInt("id");
                int id_famille = unRes.getInt("id_famille");
                int id_sous_famille = unRes.getInt("id_sous_famille");
                String nom = unRes.getString("nom");
                String code_article = unRes.getString("code_article");
                String designation = unRes.getString("designation");
                float prix_unitaire = unRes.getFloat("prix_unitaire");
                int quantite = unRes.getInt("quantite");
                Article unArticle = new Article (id, id_famille, id_sous_famille, nom, code_article, designation, prix_unitaire, quantite);
                uneListe.add(unArticle);
                
            }
            unStat.close();
            unRes.close();
        }
        catch (SQLException exp)
        {
            System.out.println("Erreur d'execution :"+ requete);
        }
        
        uneBDD.seDeconnecter();
        return uneListe;
    }
    
    public static void insertProduit(Article unArticle)
    {
        //inserer un produit dans la table articles
        String requete ="insert into articles(id, id_famille, id_sous_famille, nom, code_article, designation, prix_unitaire, quantite) values ('"+unArticle.getId()+"','"+unArticle.getId_famille()+"',"+unArticle.getId_sous_famille()+","+unArticle.getNom()+",'"+unArticle.getCode_article()+"','"+unArticle.getDesignation()+"','"+unArticle.getPrix_unitaire()+"','"+unArticle.getQuantite()+"');";
        BDD uneBDD = new BDD ("localhost", "stock", "root", "");
        uneBDD.chargerPilote();
        uneBDD.seConnecter();
        try {
            Statement unStat = uneBDD.getMaconnexion().createStatement();
            unStat.execute(requete);
            unStat.close();
        }
        catch (SQLException exp)
        {
            System.out.println("Erreur de la requete : "+ requete);
        }
        uneBDD.seDeconnecter();
    }
    
    public static LinkedList<Article> selectWhere (String cle)
    {
        //select where designation etc.
        LinkedList<Article> uneListe = new LinkedList<Article>();
        BDD uneBDD = new BDD ("localhost", "stock", "root", "");
        uneBDD.chargerPilote();
        uneBDD.seConnecter();
        String requete ="select * from produit where reference like '%"+cle+"%'"+" or designation like '%"+cle+"%'"+" or categorie like '%"+cle+"%';";  
        try {
            Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            while (unRes.next())
            {
            	int id = unRes.getInt("id");
                int id_famille = unRes.getInt("id_famille");
                int id_sous_famille = unRes.getInt("id_sous_famille");
                String nom = unRes.getString("nom");
                String code_article = unRes.getString("code_article");
                String designation = unRes.getString("designation");
                float prix_unitaire = unRes.getFloat("prix_unitaire");
                int quantite = unRes.getInt("quantite");
                Article unArticle = new Article(id, id_famille, id_sous_famille, nom, code_article, designation, prix_unitaire, quantite);
                uneListe.add(unArticle);
                
            }
            unStat.close();
            unRes.close();
        }
        catch (SQLException exp)
        {
            System.out.println("Erreur d'execution :"+ requete);
        }
        
        uneBDD.seDeconnecter();
        return uneListe;
    }
    
    public static int deleteProduits (String cle)
	{
    	int nb=0;
    	String requete="SELECT count(*) FROM produit WHERE reference LIKE '%"+cle+"%'"+" OR designation LIKE '%"+cle+"%'"+" OR categorie LIKE '%"+cle+"%';";
    	BDD uneBDD = new BDD ("localhost", "stock", "root", "");
        uneBDD.chargerPilote();
        uneBDD.seConnecter();
        try {
            Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            unRes.next();
        	nb = unRes.getInt(1);
            if(nb > 0)
            {
            	requete="DELETE FROM produit WHERE reference LIKE '%"+cle+"%'"+" OR designation LIKE '%"+cle+"%'"+" OR categorie LIKE '%"+cle+"%';";
                unStat.execute(requete);
            }
            unStat.close();
        }
        catch (SQLException exp)
        {
            System.out.println("Erreur de la requete : "+ requete);
        }
        uneBDD.seDeconnecter();
    	return nb;
	}
    
}

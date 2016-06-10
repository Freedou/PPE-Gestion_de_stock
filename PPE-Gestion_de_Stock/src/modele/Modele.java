package modele;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import controleur.Article;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Modele {
    
    public static LinkedList<Article> selectAll()
    {
        LinkedList<Article> uneListe = new LinkedList<Article>();
        BDD uneBDD = new BDD("dyndns.freedou.fr", "filelec", "root", "bagdad");
        uneBDD.chargerPilote();
        uneBDD.seConnecter();
        String requete ="call modeleA_SA();";
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
            System.out.println("Erreur d'execution :"+ exp);
        }
        
        uneBDD.seDeconnecter();
        return uneListe;
    }
    
    public static void insertArticle(Article unArticle)
    {
        //inserer un produit dans la table articles
        String requete ="call modeleA_I('"+unArticle.getId_famille()+"','"+unArticle.getId_sous_famille()+"','"+unArticle.getNom()+"','"+unArticle.getCode_article()+"','"+unArticle.getDesignation()+"','"+unArticle.getPrix_unitaire()+"','"+unArticle.getQuantite()+"','"+unArticle.getId()+"');";
        BDD uneBDD = new BDD("dyndns.freedou.fr", "filelec", "root", "bagdad");
        uneBDD.chargerPilote();
        uneBDD.seConnecter();
        try {
            Statement unStat = uneBDD.getMaconnexion().createStatement();
            unStat.execute(requete);
            unStat.close();
            JOptionPane.showMessageDialog(null, "Insertion réussi !");
        }
        catch (SQLException exp)
        {
            System.out.println("Erreur de la requete : "+ requete+"\nLa requête a retourné : "+exp);
        }
        uneBDD.seDeconnecter();
    }
    
    public static LinkedList<Article> selectWhere(String cle)
    {
        //select where designation etc.
        LinkedList<Article> uneListe = new LinkedList<Article>();
        BDD uneBDD = new BDD("dyndns.freedou.fr", "filelec", "root", "bagdad");
        uneBDD.chargerPilote();
        uneBDD.seConnecter();
        String requete ="call modeleA_SW('"+cle+"');";  
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
            System.out.println("Erreur d'execution :"+ requete+"\nLa requête a retourné : "+exp);
        }
        
        uneBDD.seDeconnecter();
        return uneListe;
    }
    
    public static int deleteArticle(int id)
	{
    	int nb=0;
    	String requete="call modeleA_D1('"+id+"');";
    	BDD uneBDD = new BDD("dyndns.freedou.fr", "filelec", "root", "bagdad");
        uneBDD.chargerPilote();
        uneBDD.seConnecter();
        try {
            Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            unRes.next();
        	nb = unRes.getInt(1);
            if(nb > 0)
            {
            	requete="call modeleA_D2('"+id+"');";
                unStat.execute(requete);
            }
            unStat.close();
        }
        catch (SQLException exp)
        {
            System.out.println("Erreur de la requete : "+ requete+"\nLa requête a retourné : "+exp);
        }
        uneBDD.seDeconnecter();
    	return nb;
	}
    
    public static int updateArticle(Article unArticle)
    {
    	
    	int nb=0;
    	String requete="call modeleA_U1('"+unArticle.getId()+"');";
    	BDD uneBDD = new BDD("dyndns.freedou.fr", "filelec", "root", "bagdad");
        uneBDD.chargerPilote();
        uneBDD.seConnecter();
        try {
            Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            unRes.next();
        	nb = unRes.getInt(1);
            if(nb > 0)
            {
            	requete="call modeleA_U2('"+unArticle.getId_famille()+"', '"+unArticle.getId_sous_famille()+"', '"+unArticle.getNom()+"', '"+unArticle.getCode_article()+"', '"+unArticle.getDesignation()+"', '"+unArticle.getPrix_unitaire()+"', '"+unArticle.getQuantite()+"', '"+unArticle.getId()+"');";
                unStat.execute(requete);
            }
            unStat.close();
            JOptionPane.showMessageDialog(null, "Modification réussi !");
        }
        catch (SQLException exp)
        {
            System.out.println("Erreur de la requete : "+ requete+"\nLa requête a retourné : "+exp);
        }
        uneBDD.seDeconnecter();
    	return nb;
    }
}
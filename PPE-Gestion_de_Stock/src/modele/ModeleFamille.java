package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import controleur.Famille;

public class ModeleFamille
{
	public static LinkedList<Famille> selectAll()
    {
        LinkedList<Famille> uneListe = new LinkedList<Famille>();
        BDD uneBDD = new BDD("dyndns.freedou.fr", "filelec", "root", "bagdad");
        uneBDD.chargerPilote();
        uneBDD.seConnecter();
        String requete ="CALL modeleF_SA();";
        try {
            Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            while (unRes.next())
            {
                int id = unRes.getInt("id");
                String nom = unRes.getString("nom");
                String commentaire = unRes.getString("commentaire");
                Famille unFamille = new Famille (id, nom, commentaire);
                uneListe.add(unFamille);
                
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
    
    public static void insertFamille(Famille uneFamille)
    {
        //inserer un produit dans la table Familles
        String requete ="CALL modeleF_I('"+uneFamille.getId()+"','"+uneFamille.getNom()+"','"+uneFamille.getCommentaire()+"');";
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
    
    public static int deleteFamille(int id)
	{
    	int nb=0;
    	String requete="CALL modeleF_D1('"+id+"');";
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
            	requete="CALL modeleF_D2('"+id+"');";
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
    
    public static int updateFamille(Famille uneFamille)
    {
    	
    	int nb=0;
    	String requete="CALL modeleF_U1('"+uneFamille.getId()+"');";
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
            	requete="CALL modeleF_U2('"+uneFamille.getNom()+"', '"+uneFamille.getCommentaire()+"', '"+uneFamille.getId()+"');";
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
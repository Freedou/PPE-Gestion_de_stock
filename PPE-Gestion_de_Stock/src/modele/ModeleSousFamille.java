package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import controleur.SousFamille;

public class ModeleSousFamille
{
	public static LinkedList<SousFamille> selectAll()
    {
        LinkedList<SousFamille> uneListe = new LinkedList<SousFamille>();
        BDD uneBDD = new BDD("dyndns.freedou.fr", "filelec", "root", "bagdad");
        uneBDD.chargerPilote();
        uneBDD.seConnecter();
        String requete ="call modeleSF_SA()";
        try {
            Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            while (unRes.next())
            {
                int id = unRes.getInt("id");
                int idfamille = unRes.getInt("id_famille");
                String nom = unRes.getString("nom");
                String commentaire = unRes.getString("commentaire");
                SousFamille unSousFamille = new SousFamille (id, idfamille, nom, commentaire);
                uneListe.add(unSousFamille);
                
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
    
    public static void insertSousFamille(SousFamille unSousFamille)
    {
        //inserer un produit dans la table SousFamilles
        String requete ="call modeleSF_I('"+unSousFamille.getId()+"','"+unSousFamille.getIdFamille()+"','"+unSousFamille.getNom()+"','"+unSousFamille.getCommentaire()+"');";
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
    
    public static int deleteSousFamille(int id)
	{
    	int nb=0;
    	String requete="call modeleSF_D1('"+id+"');";
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
            	requete="call modeleSF_D2('"+id+"');";
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
    
    public static int updateSousFamille(SousFamille unSousFamille)
    {
    	
    	int nb=0;
    	String requete="call modeleSF_U1('"+unSousFamille.getId()+"');";
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
            	requete="call modeleSF_U2('"+unSousFamille.getId()+"','"+unSousFamille.getIdFamille()+"','"+unSousFamille.getNom()+"','"+unSousFamille.getCommentaire()+"');";
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
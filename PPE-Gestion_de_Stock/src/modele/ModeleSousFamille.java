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
        BDD uneBDD = new BDD("localhost", "filelec", "root", "");
        uneBDD.chargerPilote();
        uneBDD.seConnecter();
        String requete ="SELECT * FROM sous_familles;";
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
        String requete ="INSERT INTO sous_familles(id, id_famille, nom, commentaire) VALUES ('"+unSousFamille.getId()+"','"+unSousFamille.getIdFamille()+"','"+unSousFamille.getNom()+"','"+unSousFamille.getCommentaire()+"');";
        BDD uneBDD = new BDD ("localhost", "filelec", "root", "");
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
    	String requete="SELECT COUNT(*) FROM sous_familles WHERE id="+id+";";
    	BDD uneBDD = new BDD ("localhost", "filelec", "root", "");
        uneBDD.chargerPilote();
        uneBDD.seConnecter();
        try {
            Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            unRes.next();
        	nb = unRes.getInt(1);
            if(nb > 0)
            {
            	requete="DELETE FROM sous_familles WHERE id="+id+";";
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
    	String requete="SELECT COUNT(*) FROM sous_familles WHERE id="+unSousFamille.getId()+";";
    	BDD uneBDD = new BDD ("localhost", "filelec", "root", "");
        uneBDD.chargerPilote();
        uneBDD.seConnecter();
        try {
            Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            unRes.next();
        	nb = unRes.getInt(1);
            if(nb > 0)
            {
            	requete="UPDATE sous_familles SET nom='"+unSousFamille.getNom()+"', commentaire='"+unSousFamille.getCommentaire()+"' WHERE id='"+unSousFamille.getId()+"';";
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
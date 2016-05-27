package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import controleur.User;

public class ModeleStat {

	public Object ListerNbCommande()
	{
		String requete = "SELECT * FROM Stats_site";
		BDD uneBDD = new BDD("localhost", "filelec", "root", "");
        uneBDD.chargerPilote();
        uneBDD.seConnecter();
		
        try {
            Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            Object stats [][]= new Object[unRes.getFetchSize()][5];
            int i = 0;
            while (unRes.next())
            {
            	stats[i][0]=unRes.getInt("id");
            	stats[i][1]=unRes.getString("nom");
            	stats[i][2]=unRes.getString("prenom");
            	stats[i][3]=unRes.getInt("nb_commande");
            	stats[i][4]=unRes.getInt("nb_articles");
            	i++;
            }
            unStat.close();
            unRes.close();
           
            
        }
        catch (SQLException exp)
        {
            System.out.println("Erreur d'execution :"+ exp);
        }
        uneBDD.seDeconnecter();
        return stats;
	}
	
}

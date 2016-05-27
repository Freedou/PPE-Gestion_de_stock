package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModeleStat {

	public static Object[][] ListerNbCommande()
	{
		Object stats[][] = null;
		String requete = "SELECT * FROM Stats_site";
		BDD uneBDD = new BDD("localhost", "filelec", "root", "");
        uneBDD.chargerPilote();
        try {
        	uneBDD.seConnecter();Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            unRes.last();
            stats = new Object[unRes.getRow()][5];
            unRes.beforeFirst();
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

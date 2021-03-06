package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModeleStat {

	public static Object[][] ListerNbCommande()
	{
		Object stats[][] = null;
		String requete = "call procedureTest1()";
		BDD uneBDD = new BDD("dyndns.freedou.fr", "filelec", "root", "bagdad");
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
	
	public static Object[][] Listerproc1()
	{
		Object stats[][] = null;
		String requete = "call procedure1()";
		BDD uneBDD = new BDD("dyndns.freedou.fr", "filelec", "root", "bagdad");
        uneBDD.chargerPilote();
        try {
        	uneBDD.seConnecter();Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            unRes.last();
            stats = new Object[unRes.getRow()][4];
            unRes.beforeFirst();
            int i = 0;
            while (unRes.next())
            {
            	stats[i][0]=unRes.getInt("id");
            	stats[i][1]=unRes.getString("nom");
            	stats[i][2]=unRes.getString("prenom");
            	stats[i][3]=unRes.getString("mail");
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
	
	public static Object[][] ProcArtPrixASC()
	{
		Object stats[][] = null;
		String requete = "call ProcArtPrixASC()";
		BDD uneBDD = new BDD("dyndns.freedou.fr", "filelec", "root", "bagdad");
        uneBDD.chargerPilote();
        try {
        	uneBDD.seConnecter();Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            unRes.last();
            stats = new Object[unRes.getRow()][4];
            unRes.beforeFirst();
            int i = 0;
            while (unRes.next())
            {
            	stats[i][0]=unRes.getInt("id");
            	stats[i][1]=unRes.getString("nom");
            	stats[i][2]=unRes.getString("code_article");
            	stats[i][3]=unRes.getString("prix_unitaire");
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
	
	public static Object[][] ProcArtPrixDESC()
	{
		Object stats[][] = null;
		String requete = "call ProcArtPrixDESC()";
		BDD uneBDD = new BDD("dyndns.freedou.fr", "filelec", "root", "bagdad");
        uneBDD.chargerPilote();
        try {
        	uneBDD.seConnecter();Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            unRes.last();
            stats = new Object[unRes.getRow()][4];
            unRes.beforeFirst();
            int i = 0;
            while (unRes.next())
            {
            	stats[i][0]=unRes.getInt("id");
            	stats[i][1]=unRes.getString("nom");
            	stats[i][2]=unRes.getString("code_article");
            	stats[i][3]=unRes.getString("prix_unitaire");
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
	
	public static Object[][] ProcUsrNbCommASC()
	{
		Object stats[][] = null;
		String requete = "call ProcUsrNbCommASC()";
		BDD uneBDD = new BDD("dyndns.freedou.fr", "filelec", "root", "bagdad");
        uneBDD.chargerPilote();
        try {
        	uneBDD.seConnecter();Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            unRes.last();
            stats = new Object[unRes.getRow()][4];
            unRes.beforeFirst();
            int i = 0;
            while (unRes.next())
            {
            	stats[i][0]=unRes.getInt("id");
            	stats[i][1]=unRes.getString("nom");
            	stats[i][2]=unRes.getString("prenom");
            	stats[i][3]=unRes.getString("nb_commande");
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
	
	public static Object[][] ProcUsrNbCommDESC()
	{
		Object stats[][] = null;
		String requete = "call ProcUsrNbCommDESC()";
		BDD uneBDD = new BDD("dyndns.freedou.fr", "filelec", "root", "bagdad");
        uneBDD.chargerPilote();
        try {
        	uneBDD.seConnecter();Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            unRes.last();
            stats = new Object[unRes.getRow()][4];
            unRes.beforeFirst();
            int i = 0;
            while (unRes.next())
            {
            	stats[i][0]=unRes.getInt("id");
            	stats[i][1]=unRes.getString("nom");
            	stats[i][2]=unRes.getString("prenom");
            	stats[i][3]=unRes.getString("nb_commande");
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
	
	public static Object[][] ProcUsrNbArtASC()
	{
		Object stats[][] = null;
		String requete = "call ProcUsrNbArtASC()";
		BDD uneBDD = new BDD("dyndns.freedou.fr", "filelec", "root", "bagdad");
        uneBDD.chargerPilote();
        try {
        	uneBDD.seConnecter();Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            unRes.last();
            stats = new Object[unRes.getRow()][4];
            unRes.beforeFirst();
            int i = 0;
            while (unRes.next())
            {
            	stats[i][0]=unRes.getInt("id");
            	stats[i][1]=unRes.getString("nom");
            	stats[i][2]=unRes.getString("prenom");
            	stats[i][3]=unRes.getString("nb_articles");
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
	
	public static Object[][] ProcUsrNbArtDESC()
	{
		Object stats[][] = null;
		String requete = "call ProcUsrNbArtDESC()";
		BDD uneBDD = new BDD("dyndns.freedou.fr", "filelec", "root", "bagdad");
        uneBDD.chargerPilote();
        try {
        	uneBDD.seConnecter();Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            unRes.last();
            stats = new Object[unRes.getRow()][4];
            unRes.beforeFirst();
            int i = 0;
            while (unRes.next())
            {
            	stats[i][0]=unRes.getInt("id");
            	stats[i][1]=unRes.getString("nom");
            	stats[i][2]=unRes.getString("prenom");
            	stats[i][3]=unRes.getString("nb_articles");
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
	
	public static Object[][] ProcArtPlusComm()
	{
		Object stats[][] = null;
		String requete = "call procArtPlusComm()";
		BDD uneBDD = new BDD("dyndns.freedou.fr", "filelec", "root", "bagdad");
        uneBDD.chargerPilote();
        try {
        	uneBDD.seConnecter();Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            unRes.last();
            stats = new Object[unRes.getRow()][3];
            unRes.beforeFirst();
            int i = 0;
            while (unRes.next())
            {
            	stats[i][0]=unRes.getInt("id");
            	stats[i][1]=unRes.getString("nom");
            	stats[i][2]=unRes.getString("totalArticles");
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
	
	public static Object[][] ProcClientOk()
	{
		Object stats[][] = null;
		String requete = "call procClientsOk()";
		BDD uneBDD = new BDD("dyndns.freedou.fr", "filelec", "root", "bagdad");
        uneBDD.chargerPilote();
        try {
        	uneBDD.seConnecter();Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            unRes.last();
            stats = new Object[unRes.getRow()][3];
            unRes.beforeFirst();
            int i = 0;
            while (unRes.next())
            {
            	stats[i][0]=unRes.getInt("id");
            	stats[i][1]=unRes.getString("nom");
            	stats[i][2]=unRes.getString("prenom");
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
	
	public static Object[][] ProcClientNotOk()
	{
		Object stats[][] = null;
		String requete = "call procClientsPasOk()";
		BDD uneBDD = new BDD("dyndns.freedou.fr", "filelec", "root", "bagdad");
        uneBDD.chargerPilote();
        try {
        	uneBDD.seConnecter();Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            unRes.last();
            stats = new Object[unRes.getRow()][3];
            unRes.beforeFirst();
            int i = 0;
            while (unRes.next())
            {
            	stats[i][0]=unRes.getInt("id");
            	stats[i][1]=unRes.getString("nom");
            	stats[i][2]=unRes.getString("prenom");
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
	
	public static Object[][] ProcNbCommJour()
	{
		Object stats[][] = null;
		String requete = "call procNbCommJour()";
		BDD uneBDD = new BDD("dyndns.freedou.fr", "filelec", "root", "bagdad");
        uneBDD.chargerPilote();
        try {
        	uneBDD.seConnecter();Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            unRes.last();
            stats = new Object[unRes.getRow()][2];
            unRes.beforeFirst();
            int i = 0;
            while (unRes.next())
            {
            	stats[i][0]=unRes.getInt("nbComm");
            	stats[i][1]=unRes.getString("dateJour");
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
	
	public static Object[][] ProcNbCommMois()
	{
		Object stats[][] = null;
		String requete = "call procNbCommMois()";
		BDD uneBDD = new BDD("dyndns.freedou.fr", "filelec", "root", "bagdad");
        uneBDD.chargerPilote();
        try {
        	uneBDD.seConnecter();Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            unRes.last();
            stats = new Object[unRes.getRow()][2];
            unRes.beforeFirst();
            int i = 0;
            while (unRes.next())
            {
            	stats[i][0]=unRes.getInt("nbComm");
            	stats[i][1]=unRes.getString("dateMois");
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
	
	public static Object[][] ProcUsrMaxDepense()
	{
		Object stats[][] = null;
		String requete = "call procUsrPlusDepense()";
		BDD uneBDD = new BDD("dyndns.freedou.fr", "filelec", "root", "bagdad");
        uneBDD.chargerPilote();
        try {
        	uneBDD.seConnecter();Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            unRes.last();
            stats = new Object[unRes.getRow()][4];
            unRes.beforeFirst();
            int i = 0;
            while (unRes.next())
            {
            	stats[i][0]=unRes.getInt("id");
            	stats[i][1]=unRes.getString("nom");
            	stats[i][2]=unRes.getString("prenom");
            	stats[i][3]=unRes.getString("panier_prix_total");
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
	
	public static Object[][] ProcStatsVenteNoel()
	{
		Object stats[][] = null;
		String requete = "call procStatsVenteNoel()";
		BDD uneBDD = new BDD("dyndns.freedou.fr", "filelec", "root", "bagdad");
        uneBDD.chargerPilote();
        try {
        	uneBDD.seConnecter();Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            unRes.last();
            stats = new Object[unRes.getRow()][3];
            unRes.beforeFirst();
            int i = 0;
            while (unRes.next())
            {
            	stats[i][0]=unRes.getInt("id");
            	stats[i][1]=unRes.getString("nom");
            	stats[i][2]=unRes.getString("totalArticles");
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

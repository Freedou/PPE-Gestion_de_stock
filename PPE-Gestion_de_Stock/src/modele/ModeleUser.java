package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import controleur.Article;
import controleur.User;

public class ModeleUser {
    
    public static String [] selectWhere (String email, String mdp)
    {
        //select where designation etc.
        String [] tab = new String [2];
        BDD uneBDD = new BDD ("localhost", "filelec", "root", "");
        uneBDD.chargerPilote();
        uneBDD.seConnecter();
        String requete ="select count(mail) as nb, nom, prenom from users where mail ='"+email+"' and mot_de_passe ='"+mdp+"';";  
        try {
            Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            unRes.next();
            int nb = unRes.getInt("nb");
            if (nb>0)
            {
                tab[0] = unRes.getString("nom");
                tab[1] = unRes.getString("prenom");
            }
            else {
                tab[0] = null;
                tab[1] = null;
            }
            unStat.close();
            unRes.close();
        }
        catch (SQLException exp)
        {
            System.out.println("Erreur d'execution :"+ requete);
        }
        
        uneBDD.seDeconnecter();
        return tab;
    }
    
    public static LinkedList<User> SelectAll()
    {
    	LinkedList<User> uneListe = new LinkedList<User>();
        BDD uneBDD = new BDD("localhost", "filelec", "root", "");
        uneBDD.chargerPilote();
        uneBDD.seConnecter();
        String requete ="SELECT * FROM users;";
        try {
            Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            while (unRes.next())
            {
                int id = unRes.getInt("id");
                String raison_sociale = unRes.getString("raison_sociale");
                String nom = unRes.getString("nom");
                String prenom = unRes.getString("prenom");
                String mail = unRes.getString("mail");
                String mot_de_passe = unRes.getString("mot_de_passe");
                String fadresse1 = unRes.getString("fadresse1");
                String fadresse2 = unRes.getString("fadresse2");
                String fcp = unRes.getString("fcp");
                String fville = unRes.getString("fville");
                String ladresse1 = unRes.getString("ladresse1");
                String ladresse2 = unRes.getString("ladresse2");
                String lcp = unRes.getString("lcp");
                String lville = unRes.getString("lville");
                boolean admin = unRes.getBoolean("admin");
                boolean gestionnaire = unRes.getBoolean("gestionnaire");
                float pannier_prix_total = unRes.getFloat("panier_prix_total");
                int nb_commande = unRes.getInt("nb_commande");
                User unArticle = new User (id, raison_sociale, nom, prenom, mail, mot_de_passe, fadresse1, fadresse2, fcp, fville, ladresse1, ladresse2, lcp, lville, admin, gestionnaire, pannier_prix_total, nb_commande);
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
    
    public static int updateUser(User unUser)
    {
    	return 0;
    }
    
    public static void insertUsers(User unUser)
    {
    	String requete ="INSERT INTO User(id, raison_social, nom, prenom, mail, password, fadresse1, fadresse2, fcp, fville, ladresse1, ladresse2, lcp, lville, admin, gestionnaire, nb_commande) VALUES ( '"+unUser.getId()+"', '"+unUser.getRaison_social()+"', '"+unUser.getNom()+"', '"+unUser.getPrenom()+"', '"+unUser.getMail()+"', '"+unUser.getPassword()+"', '"+unUser.getFadresse1()+"', '"+unUser.getFadresse2()+"', '"+unUser.getFcp()+"', '"+unUser.getFville()+"', '"+unUser.getLadresse1()+"', '"+unUser.getLadresse2()+"', '"+unUser.getLcp()+"', '"+unUser.getLville()+"', '"+unUser.isAdmin()+"', '"+unUser.isGestionnaire()+"', '"+unUser.getNb_commande()+"');";
        BDD uneBDD = new BDD ("localhost", "filelec", "root", "");
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
}
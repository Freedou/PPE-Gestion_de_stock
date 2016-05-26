package controleur;

public class User
{
	private String raison_social, nom, prenom, mail, password, fadresse1, fadresse2, fcp, fville, ladresse1, ladresse2, lcp, lville;
	private boolean admin, gestionnaire;
	private int nb_commande, id;
	private float pannier_prix_total;
	
	public User(int id, String raison_social, String nom, String prenom, String mail, String password, String fadresse1, String fadresse2, String fcp, String fville, String ladresse1, String ladresse2, String lcp, String lville, boolean admin, boolean gestionnaire, float pannier_prix_total, int nb_commande)
	{
		this.id = id;
		this.raison_social = raison_social;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.password = password;
		this.fadresse1 = fadresse1;
		this.fadresse2 = fadresse2;
		this.fcp = fcp;
		this.fville = fville;
		this.ladresse1 = ladresse1;
		this.ladresse2 = ladresse2;
		this.lcp = lcp;
		this.lville = lville;
		this.admin = admin;
		this.gestionnaire = gestionnaire;
		this.pannier_prix_total = pannier_prix_total;
		this.nb_commande = nb_commande;
	}

	public float getPannier_prix_total() {
		return pannier_prix_total;
	}

	public void setPannier_prix_total(float pannier_prix_total) {
		this.pannier_prix_total = pannier_prix_total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRaison_social() {
		return raison_social;
	}

	public void setRaison_social(String raison_social) {
		this.raison_social = raison_social;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFadresse1() {
		return fadresse1;
	}

	public void setFadresse1(String fadresse1) {
		this.fadresse1 = fadresse1;
	}

	public String getFadresse2() {
		return fadresse2;
	}

	public void setFadresse2(String fadresse2) {
		this.fadresse2 = fadresse2;
	}

	public String getFcp() {
		return fcp;
	}

	public void setFcp(String fcp) {
		this.fcp = fcp;
	}

	public String getFville() {
		return fville;
	}

	public void setFville(String fville) {
		this.fville = fville;
	}

	public String getLadresse1() {
		return ladresse1;
	}

	public void setLadresse1(String ladresse1) {
		this.ladresse1 = ladresse1;
	}

	public String getLadresse2() {
		return ladresse2;
	}

	public void setLadresse2(String ladresse2) {
		this.ladresse2 = ladresse2;
	}

	public String getLcp() {
		return lcp;
	}

	public void setLcp(String lcp) {
		this.lcp = lcp;
	}

	public String getLville() {
		return lville;
	}

	public void setLville(String lville) {
		this.lville = lville;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isGestionnaire() {
		return gestionnaire;
	}

	public void setGestionnaire(boolean gestionnaire) {
		this.gestionnaire = gestionnaire;
	}

	public int getNb_commande() {
		return nb_commande;
	}

	public void setNb_commande(int nb_commande) {
		this.nb_commande = nb_commande;
	}
}
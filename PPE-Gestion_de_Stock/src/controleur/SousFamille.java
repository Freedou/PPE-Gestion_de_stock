package controleur;

public class SousFamille
{
	private int id, idFamille;
	private String nom, commentaire;
	
	public SousFamille(int id, int idFamille, String nom, String commentaire)
	{
		this.id = id;
		this.idFamille = idFamille;
		this.nom = nom;
		this.commentaire = commentaire;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdFamille() {
		return idFamille;
	}

	public void setIdFfamille(int idFamille) {
		this.idFamille = idFamille;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
}
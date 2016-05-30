package controleur;

public class Famille
{	
	private int id;
	private String nom, commentaire;
	
	public Famille(int id, String nom, String commentaire)
	{
		this.id = id;
		this.nom = nom;
		this.commentaire = commentaire;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
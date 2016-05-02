package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.Article;
import controleur.Produit;

public class FicheProduit extends JFrame implements ActionListener, KeyListener
{
	//construction de la fiche produit
	private JLabel lbNom;
	private JLabel lbDesignation;
	private JLabel lbCodeArticle;
	private JLabel lbPrixUnitaire;
	private JLabel lbId;
	private JLabel lbQuantite;
	private JLabel lbFamille;
	private JLabel lbSousFamille;
	private JTextField tfNom;
	private JTextField tfDesignation;
	private JTextField tfCodeArticle;
	private JTextField tfPrixUnitaire;
	private JTextField tfQuantite;
	private JTextField tfFamille;
	private JTextField tfSousFamille;
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btModifier = new JButton("Modifier");
	private JButton btSupprimer = new JButton("Supprimer");
	
	public FicheProduit(Article monProduit) {
		this.setTitle("Fiche "+ monProduit.getNom());
		this.setBounds(200,200,650,400);
		this.setResizable(false);
		this.setLayout(null);
		

		// on rentre les valeurs des produits
		this.tfNom = new JTextField(monProduit.getNom());
		this.tfDesignation = new JTextField(monProduit.getDesignation());
		this.tfCodeArticle = new JTextField(monProduit.getCode_article());
		this.tfPrixUnitaire = new JTextField(monProduit.getPrix_unitaire()+"");
		this.tfQuantite = new JTextField(monProduit.getQuantite());
		this.tfFamille = new JTextField(monProduit.getId_famille());
		this.tfSousFamille = new JTextField(monProduit.getId_sous_famille());
		
		// on crée les labels des produits
		this.lbNom = new JLabel("Nom : ");
		this.lbDesignation = new JLabel("Designation : ");
		this.lbCodeArticle = new JLabel("Code article : ");
		this.lbPrixUnitaire = new JLabel("Prix unitaire : ");
		this.lbId = new JLabel("Id article : "+monProduit.getId());
		this.lbQuantite = new JLabel("Quantité : ");
		this.lbFamille = new JLabel("Famille : ");
		this.lbSousFamille = new JLabel("Sous Famille : ");
		
		this.lbId.setBounds(x, y, width, height);
		this.lbNom.setBounds(x, y, width, height);
		this.tfNom.setBounds(x, y, width, height);
		this.lbDesignation.setBounds(x, y, width, height);
		this.tfDesignation.setBounds(x, y, width, height);
		this.lbCodeArticle.setBounds(x, y, width, height);
		this.tfCodeArticle.setBounds(x, y, width, height);
		this.lbPrixUnitaire.setBounds(x, y, width, height);
		this.tfPrixUnitaire.setBounds(x, y, width, height);
		this.lbQuantite.setBounds(x, y, width, height);
		this.tfQuantite.setBounds(x, y, width, height);
		
		
	}	
		
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
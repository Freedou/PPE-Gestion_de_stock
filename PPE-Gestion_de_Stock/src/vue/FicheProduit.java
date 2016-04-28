package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import controleur.Produit;

public class FicheProduit extends JFrame implements ActionListener, KeyListener
{
	//construction de la fiche produit
	private JTextField tfReference;
	private JTextField tfDesignation;
	private JTextField tfPrix;
	private JTextField tfQuantite;
	private JTextField tfCategorie;
	private JButton btAnnuler;
	private JButton btEnregistrer;
	private JButton btSupprimer;
		
	public FicheProduit(Produit monProduit) {
		this.setTitle("Fiche "+ monProduit.getNom());
		this.setBounds(200,200,650,400);
		this.setResizable(false);
		this.setLayout(null);
		
		this.tfCategorie = new JTextField(monProduit.getCategorie());
		
		
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
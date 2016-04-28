package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class FicheProduit extends JFrame implements ActionListener, KeyListener
{
	//construction de la fiche produit
	private JTextField tfReference = new JTextField("");
	private JTextField tfDesignation= new JTextField("");
	private JTextField tfPrix = new JTextField("");
	private JTextField tfQuantite = new JTextField("");
	private JTextField tfCategorie = new JTextField("");
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");
	private JButton btSupprimer = new JButton("Supprimer");
		
	public FicheProduit(Produit monProduit) {
		this.setTitle("Fiche '"+ monProduit.get +"'");
		this.setBounds(200,200,650,400);
		this.setResizable(false);
		this.setLayout(null);
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
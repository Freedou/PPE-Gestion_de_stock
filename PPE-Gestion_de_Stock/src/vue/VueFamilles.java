package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controleur.Famille;
import controleur.SousFamille;
import modele.ModeleFamille;
import modele.ModeleSousFamille;

@SuppressWarnings("serial")
public class VueFamilles extends JFrame implements ActionListener, MouseListener
{
	private JPanel panelMenu=new JPanel();
	
	private JPanel panelFamille=new JPanel();
	
	private JPanel panelAjouter=new JPanel();
	private JPanel panelLister=new JPanel();
	
	private JButton btAjouter = new JButton("Ajouter/Modifier");
	private JButton btSupprimer = new JButton("Supprimer");
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btQuitter = new JButton("Quitter");
	
	//construction des objet ajouter
	private JTextField tfId = new JTextField("");
	private JTextField tfNomFamille = new JTextField("");
	private JTextField tfCommentaireFamille = new JTextField("");
	private JTextField tfIdFamille= new JTextField("");
	private JTextField tfIdSousFamille= new JTextField("");
	private JTextField tfNomSousFamille = new JTextField("");
	private JTextField tfCommentaireSousFamille = new JTextField("");
	
	//construction des objet lister
	private JTable tabFamille = new JTable();
	private JTable tabSousFamille = new JTable();
	private JScrollPane scrollFamille = new JScrollPane();
	private JScrollPane scrollSousFamille = new JScrollPane();
	
	public VueFamilles()
	{
		this.setTitle("Gestion des familles et sous familles");
		this.setBounds(250,250,1055,600);
		this.setResizable(false);
		this.setLayout(null);
		
		//construction du panel menu
		this.panelMenu.setBounds( 0, 0, 150, 600);
		this.panelMenu.setBackground(Color.DARK_GRAY);
		this.panelMenu.setLayout(new GridLayout(7, 1));
		this.panelMenu.add(new JLabel(""));
		this.panelMenu.add(this.btAjouter);
		this.panelMenu.add(this.btSupprimer);
		this.panelMenu.add(this.btAnnuler);
		this.panelMenu.add(this.btQuitter);
		this.panelMenu.add(new JLabel(""));
		this.add(this.panelMenu);
		
		
		//construction du panel ajouter
		//form famille
		this.panelAjouter.setBounds(0, 300, 900, 300);
		this.panelAjouter.setBackground(Color.LIGHT_GRAY);
		this.panelAjouter.setLayout(new GridLayout(6,4));
		this.panelAjouter.add(new JLabel(""));
		this.panelAjouter.add(new JLabel("Famille :"));
		this.panelAjouter.add(new JLabel(""));
		this.panelAjouter.add(new JLabel("Sous Famille :"));
		
		this.panelAjouter.add(new JLabel("Id :"));
		this.panelAjouter.add(this.tfId);
		this.tfId.setEditable(false);
		this.tfId.setBackground(Color.gray);
		
		this.panelAjouter.add(new JLabel("Id :"));
		this.panelAjouter.add(this.tfIdSousFamille);
		this.tfIdSousFamille.setEditable(false);
		this.tfIdSousFamille.setBackground(Color.gray);
		
		this.panelAjouter.add(new JLabel("Nom :"));
		this.panelAjouter.add(this.tfNomFamille);
		
		this.panelAjouter.add(new JLabel("Id famille :"));
		this.panelAjouter.add(this.tfIdFamille);
		
		this.panelAjouter.add(new JLabel("Commentaire :"));
		this.panelAjouter.add(this.tfCommentaireFamille);
		
		this.panelAjouter.add(new JLabel("Nom :"));
		this.panelAjouter.add(this.tfNomSousFamille);
		
		this.panelAjouter.add(new JLabel(""));
		this.panelAjouter.add(new JLabel(""));
		
		this.panelAjouter.add(new JLabel("Commentaire :"));
		this.panelAjouter.add(this.tfCommentaireSousFamille);
		
		this.panelAjouter.setVisible(true);

		//construction du panel lister
		this.panelLister.setBounds(0, 0, 900, 300);
		this.panelLister.setBackground(Color.LIGHT_GRAY);
		this.scrollFamille.setBounds(20, 60, 430, 230);
		this.scrollSousFamille.setBounds(450, 60, 430, 230);
		this.panelLister.setLayout(null);
		this.panelLister.setVisible(true);
		this.appelListeFamille();
		this.appelListeSousFamille();
		
		//rendre les bouton clickable
		this.btAjouter.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		this.btQuitter.addActionListener(this);
		this.btAnnuler.addActionListener(this);
		
		//construction du panel gerer article
		this.panelFamille.setBounds(150, 0, 1050, 600);
		this.panelFamille.setLayout(null);
		this.panelFamille.add(this.panelLister);
		this.panelFamille.add(this.panelAjouter);
		this.add(this.panelFamille);
		this.panelFamille.setVisible(true);
		
		this.setVisible(true);
	}
	
	public void appelListeFamille()
	{
		String titres[] = {"Id", "Nom", "Commentaire"};
		LinkedList<Famille> uneListe = ModeleFamille.selectAll();
		Object donnees [][] = new Object[uneListe.size()][3];
		int i = 0;
		for(Famille uneFamille : uneListe)
		{
			donnees[i][0]=uneFamille.getId();
			donnees[i][1]=uneFamille.getNom();
			donnees[i][2]=uneFamille.getCommentaire();
			i++;
		}
		DefaultTableModel model = new DefaultTableModel(donnees, titres);
		this.tabFamille.addMouseListener(this);
		this.tabFamille.setModel(model);
		this.scrollFamille.getViewport().add(this.tabFamille);
		this.scrollFamille.setVisible(true);
		this.panelLister.add(this.scrollFamille);
	}
	
	public void appelListeSousFamille()
	{
		String titres[] = {"Id", "Id Famille", "Nom", "Commentaire"};
		LinkedList<SousFamille> uneListe = ModeleSousFamille.selectAll();
		Object donnees [][] = new Object[uneListe.size()][4];
		int i = 0;
		for(SousFamille uneSousFamille : uneListe)
		{
			donnees[i][0]=uneSousFamille.getId();
			donnees[i][1]=uneSousFamille.getIdFamille();
			donnees[i][2]=uneSousFamille.getNom();
			donnees[i][3]=uneSousFamille.getCommentaire();
			i++;
		}
		DefaultTableModel model = new DefaultTableModel(donnees, titres);
		this.tabSousFamille.addMouseListener(this);
		this.tabSousFamille.setModel(model);
		this.scrollSousFamille.getViewport().add(this.tabSousFamille);
		this.scrollSousFamille.setVisible(true);
		this.panelLister.add(this.scrollSousFamille);
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		if (e.getClickCount() == 1) {
		      JTable target = (JTable)e.getSource();
		      int row = target.getSelectedRow();
		      //int column = target.getSelectedColumn();
		      // do some action if appropriate column
		      //System.out.println("colonne "+column+" ligne "+row);
		      //System.out.println(this.tabArticles.getValueAt(row, column));
		      if(target==this.tabFamille)
		      {
			      this.tfId.setText(this.tabFamille.getValueAt(row, 0)+"");
			      this.tfId.setBackground(Color.gray);
			      this.tfNomFamille.setText(this.tabFamille.getValueAt(row, 1)+"");
			      this.tfNomFamille.setBackground(Color.white);
			      this.tfCommentaireFamille.setText(this.tabFamille.getValueAt(row, 2)+"");
			      this.tfCommentaireFamille.setBackground(Color.white);
		      }
		      if(target==this.tabSousFamille)
		      {
		    	  this.tfIdSousFamille.setText(this.tabSousFamille.getValueAt(row, 0)+"");
			      this.tfIdSousFamille.setBackground(Color.gray);
		    	  this.tfIdFamille.setText(this.tabSousFamille.getValueAt(row, 1)+"");
			      this.tfIdFamille.setBackground(Color.white);
		    	  this.tfNomSousFamille.setText(this.tabSousFamille.getValueAt(row, 2)+"");
			      this.tfNomSousFamille.setBackground(Color.white);
		    	  this.tfCommentaireSousFamille.setText(this.tabSousFamille.getValueAt(row, 3)+"");
			      this.tfCommentaireSousFamille.setBackground(Color.white);
		      }
		      
		      
		}
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==this.btQuitter)
		{
			int r = JOptionPane.showConfirmDialog(this, "Souhaitez vous vraiment quitter?", "Quitter", JOptionPane.OK_CANCEL_OPTION);
			if(r==0)
			{
				this.dispose();
			}
		
		}
		else
		{
			if(e.getSource()==this.btAnnuler)
			{
				this.tfId.setText("");
				this.tfIdFamille.setText("");
				this.tfIdSousFamille.setText("");
				this.tfNomFamille.setText("");
				this.tfNomSousFamille.setText("");
				this.tfCommentaireFamille.setText("");
				this.tfCommentaireSousFamille.setText("");
				this.tfId.setBackground(Color.GRAY);
				this.tfIdFamille.setBackground(Color.WHITE);
				this.tfIdSousFamille.setBackground(Color.GRAY);
				this.tfNomFamille.setBackground(Color.white);
				this.tfNomSousFamille.setBackground(Color.white);
				this.tfCommentaireFamille.setBackground(Color.white);
				this.tfCommentaireSousFamille.setBackground(Color.white);
			}
			else
			{
				if(e.getSource()==this.btSupprimer)
				{
					int idF = 0;
					int idSF = 0;
					try{
						idF=Integer.parseInt(this.tfId.getText());
						this.tfId.setBackground(Color.GRAY);
					}
					catch(Exception exp)
					{
					}
					try{
						idSF=Integer.parseInt(this.tfIdSousFamille.getText());
						this.tfIdSousFamille.setBackground(Color.GRAY);
					}
					catch(Exception exp)
					{
					}
					if(idF!=0)
					{
						ModeleFamille.deleteFamille(idF);
						JOptionPane.showMessageDialog(this, "Suppression réussi !");
					}
					if(idSF!=0)
					{
						ModeleSousFamille.deleteSousFamille(idSF);
						JOptionPane.showMessageDialog(this, "Suppression réussi !");
					}
					if(idSF==0 && idF==0)
					{
						JOptionPane.showMessageDialog(this, "Erreur vous devez selectionner une famille ou une sous famille pour la supprimer.");
					}
					this.appelListeFamille();
					this.appelListeSousFamille();
				}
				else
				{
					if(e.getSource()==this.btAjouter)
					{
						int id = 0;
						int idF = 0;
						int idSF = 0;
						String commF = "";
						String commSF = "";
						String nomF = "";
						String nomSF = "";
						boolean okF=true;
						boolean okSF=true;
						try{
							id=Integer.parseInt(this.tfId.getText());
							this.tfId.setBackground(Color.gray);
						}
						catch(Exception exp)
						{
						}
						try{
							idF=Integer.parseInt(this.tfIdFamille.getText());
							this.tfIdFamille.setBackground(Color.gray);
						}
						catch(Exception exp)
						{
							okSF = false;
							this.tfIdFamille.setBackground(Color.red);
						}
						try{
							idSF=Integer.parseInt(this.tfIdSousFamille.getText());
							this.tfIdSousFamille.setBackground(Color.gray);
						}
						catch(Exception exp)
						{
						}
						try{
							nomF=this.tfNomFamille.getText();
							this.tfNomFamille.setBackground(Color.white);
							if(nomF.length()==0)
							{
								okF = false;
								this.tfNomFamille.setBackground(Color.red);
							}
						}
						catch(Exception exp)
						{
							okF = false;
							this.tfNomFamille.setBackground(Color.red);
						}
						try{
							nomSF=this.tfNomSousFamille.getText();
							this.tfNomSousFamille.setBackground(Color.white);
							if(nomSF.length()==0)
							{
								okSF = false;
								this.tfNomSousFamille.setBackground(Color.red);
							}
						}
						catch(Exception exp)
						{
							okSF = false;
							this.tfNomSousFamille.setBackground(Color.red);
						}
						try{
							commF=this.tfCommentaireFamille.getText();
							this.tfCommentaireFamille.setBackground(Color.white);
							if(commF.length()==0)
							{
								okF = false;
								this.tfCommentaireFamille.setBackground(Color.red);
							}
						}
						catch(Exception exp)
						{
							okF = false;
							this.tfCommentaireFamille.setBackground(Color.red);
						}
						try{
							commSF=this.tfCommentaireSousFamille.getText();
							this.tfCommentaireSousFamille.setBackground(Color.white);
							if(commSF.length()==0)
							{
								okSF = false;
								this.tfCommentaireSousFamille.setBackground(Color.red);
							}
						}
						catch(Exception exp)
						{
							okSF = false;
							this.tfCommentaireSousFamille.setBackground(Color.red);
						}
						if(okF == true)
						{
							Famille uneFamille = new Famille(id, nomF, commF);
							if(id!=0)
							{
								ModeleFamille.updateFamille(uneFamille);
							}
							else
							{
								ModeleFamille.insertFamille(uneFamille);
							}
							this.appelListeFamille();
						}
						if(okSF == true)
						{
							SousFamille uneSousFamille = new SousFamille(idSF, idF, nomSF, commSF);
							if(idSF!=0)
							{
								ModeleSousFamille.updateSousFamille(uneSousFamille);
							}
							else
							{
								ModeleSousFamille.insertSousFamille(uneSousFamille);
							}
							this.appelListeSousFamille();
						}
						if(okF == false && okSF == false)
						{
							JOptionPane.showMessageDialog(this, "Erreur de saisie veuillez remplir correctement les champs colorés en rouge");
						}
					}
				}
			}
		}
	}
}
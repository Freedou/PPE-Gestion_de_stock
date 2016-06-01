package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import modele.ModeleUser;
import controleur.User;



@SuppressWarnings({ "serial" })
public class VueClient extends JFrame implements ActionListener, MouseListener{

	private JPanel panelMenu=new JPanel();
	private JPanel panelClient=new JPanel();
	private JPanel panelAjouter=new JPanel();
	private JPanel panelLister=new JPanel();
	private JPanel panelBouton=new JPanel();
	
	private JButton btArticle = new JButton("Gérer les articles");
	private JButton btClients = new JButton("Gerer clients");
	private JButton btStats = new JButton("Voir statistiques");
	private JButton btQuitter = new JButton("Quitter");
	
	//panel bouton
	private JButton btRechercher = new JButton("Rechercher");
	private JButton btSupprimer = new JButton("Supprimer");
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btAjouter = new JButton("Ajouter/Modifier");
	
	//construction des objet lister
	 private JTable tabClient = new JTable();
	 private JScrollPane scrollClient = new JScrollPane();
	 private JTextField tfRecherche = new JTextField("");
	 private JLabel lbRechercher = new JLabel("Recherche : ");
	
	//construction des objet ajouter
	private JTextField tfId = new JTextField("");
	private JTextField tfRaison_social= new JTextField("");
	private JTextField tfNom = new JTextField("");
	private JTextField tfPrenom = new JTextField("");
	private JTextField tfMail = new JTextField("");
	private JTextField tfMdp = new JTextField("");
	private JTextField tfAdresseF1 = new JTextField("");
	private JTextField tfAdresseF2 = new JTextField("");
	private JTextField tfFcp = new JTextField("");
	private JTextField tfVilleF = new JTextField("");
	private JTextField tfAdresseL1 = new JTextField("");
	private JTextField tfAdresseL2 = new JTextField("");
	private JTextField tfLcp = new JTextField("");
	private JTextField tfVilleL = new JTextField("");
	private JCheckBox Admin = new JCheckBox("");
	private JCheckBox Gest = new JCheckBox("");
	private JTextField tfPprix_total = new JTextField("");
	private JTextField tfNbComm = new JTextField("");
	
	public VueClient()
	{
		this.setTitle("Gestion des clients");
		this.setBounds(200,200,1200,600);
		this.setResizable(false);
		this.setLayout(null);
		
		//construction du panel menu
		this.panelMenu.setBounds( 0, 0, 150, 600);
		this.panelMenu.setBackground(Color.red);
		this.panelMenu.setLayout(new GridLayout(7, 1));
		this.panelMenu.add(new JLabel(""));
		this.panelMenu.add(this.btArticle);
		this.panelMenu.add(this.btClients);
		this.panelMenu.add(this.btStats);
		this.panelMenu.add(this.btQuitter);
		this.panelMenu.add(new JLabel(""));
		this.add(this.panelMenu);
		this.setVisible(true);
		
		//construction du panel bouton
		this.panelBouton.setBounds(900, 0, 150, 600);
		this.panelBouton.setBackground(Color.red);
		this.panelBouton.setLayout(new GridLayout(7, 1));
		this.panelBouton.add(new JLabel(""));
		this.panelBouton.add(this.btAjouter);
		this.panelBouton.add(this.btSupprimer);
		this.panelBouton.add(this.btRechercher);
		this.panelBouton.add(this.btAnnuler);
		this.panelBouton.add(new JLabel(""));
		this.panelBouton.setVisible(true);
		
		//construction du panel ajouter
		this.panelAjouter.setBounds(0, 300, 900, 300);
		this.panelAjouter.setBackground(Color.cyan);
		this.panelAjouter.setLayout(new GridLayout(7,4));
		this.panelAjouter.add(new JLabel("Id :"));
		this.panelAjouter.add(this.tfId);
		this.tfId.setEditable(false);
		this.tfId.setBackground(Color.gray);
		this.panelAjouter.add(new JLabel("Raison social :"));
		this.panelAjouter.add(this.tfRaison_social);
		this.panelAjouter.add(new JLabel("Nom :"));
		this.panelAjouter.add(this.tfNom);
		this.panelAjouter.add(new JLabel("Prenom :"));
		this.panelAjouter.add(this.tfPrenom);
		this.panelAjouter.add(new JLabel("Mail :"));
		this.panelAjouter.add(this.tfMail);
		this.panelAjouter.add(new JLabel("Mdp :"));
		this.panelAjouter.add(this.tfMdp);
		this.panelAjouter.add(new JLabel("Adresse Facturation 1 :"));
		this.panelAjouter.add(this.tfAdresseF1);
		this.panelAjouter.add(new JLabel("Adresse Facturation 2 :"));
		this.panelAjouter.add(this.tfAdresseF2);
		this.panelAjouter.add(new JLabel("CP facturation :"));
		this.panelAjouter.add(this.tfFcp);
		this.panelAjouter.add(new JLabel("Ville Facturation :"));
		this.panelAjouter.add(this.tfVilleF);
		this.panelAjouter.add(new JLabel("Adresse Livraison 1 :"));
		this.panelAjouter.add(this.tfAdresseL1);
		this.panelAjouter.add(new JLabel("Adresse Livraison 2 :"));
		this.panelAjouter.add(this.tfAdresseL2);
		this.panelAjouter.add(new JLabel("CP Livraison :"));
		this.panelAjouter.add(this.tfLcp);
		this.panelAjouter.add(new JLabel("Ville Livraison :"));
		this.panelAjouter.add(this.tfVilleL);
		this.panelAjouter.add(new JLabel("Est Admin ? :"));
		this.panelAjouter.add(this.Admin);
		this.panelAjouter.add(new JLabel("Est Gestionnaire ? :"));
		this.panelAjouter.add(this.Gest);
		this.panelAjouter.add(new JLabel("Prix total panier :"));
		this.panelAjouter.add(this.tfPprix_total);
		this.panelAjouter.add(new JLabel("Nb commandes :"));
		this.panelAjouter.add(this.tfNbComm);
		this.panelAjouter.setVisible(true);
		
		//construction du panel lister
		this.panelLister.setBounds(0, 0, 900, 300);
		this.panelLister.setBackground(Color.GRAY);
		this.lbRechercher.setBounds(20, 20, 80, 20);
		this.tfRecherche.setBounds(100, 20, 640, 20);
		this.btRechercher.setBounds(760, 20, 120, 20);
		this.scrollClient.setBounds(20, 60, 860, 230);
		this.panelLister.add(this.lbRechercher);
		this.panelLister.add(this.tfRecherche);
		this.panelLister.add(this.btRechercher);
		this.panelLister.setLayout(null);
		this.panelLister.setVisible(true);
		
		//construction du panel gerer client
		this.panelClient.setBounds(150, 0, 1050, 600);
		this.panelClient.setLayout(null);
		this.panelClient.add(this.panelLister);
		this.panelClient.add(this.panelAjouter);
		this.panelClient.add(this.panelBouton);
		this.add(this.panelClient);
		this.appelListe();
		this.panelClient.setVisible(true);
			
		//rendre les bouton clickable
		this.btAjouter.addActionListener(this);
		this.btArticle.addActionListener(this);
		this.btRechercher.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		this.btQuitter.addActionListener(this);
		this.btAnnuler.addActionListener(this);
		this.btClients.addActionListener(this);
		this.btStats.addActionListener(this);
		this.setVisible(true);
		}
	
	public void appelListe()
	{
		String cle = this.tfRecherche.getText();
		String titres[] = {"id", "raison_social", "nom", "prenom", "mail", "mdp", "adresse F1", "adresse F2", "cp F", "ville F", "adresse L1", "adresse L2", "cp L", "ville L", "admin", "Gest", "prix_total_panier", "nb commandes"};
		LinkedList<User> uneListe = ModeleUser.selectWhere(cle);
		Object donnees [][] = new Object[uneListe.size()][18];
		int i = 0;
		for(User unUser : uneListe)
		{
			donnees[i][0]=unUser.getId();
			donnees[i][1]=unUser.getRaison_social();
			donnees[i][2]=unUser.getNom();
			donnees[i][3]=unUser.getPrenom();
			donnees[i][4]=unUser.getMail();
			donnees[i][5]=unUser.getPassword();
			donnees[i][6]=unUser.getFadresse1();
			donnees[i][7]=unUser.getFadresse2();
			donnees[i][8]=unUser.getFcp();
			donnees[i][9]=unUser.getFville();
			donnees[i][10]=unUser.getLadresse1();
			donnees[i][11]=unUser.getLadresse2();
			donnees[i][12]=unUser.getLcp();
			donnees[i][13]=unUser.getLville();
			donnees[i][14]=unUser.isAdmin();
			donnees[i][15]=unUser.isGestionnaire();
			donnees[i][16]=unUser.getPrix_total_panier();
			donnees[i][17]=unUser.getNb_commande();
			i++;
		}
		this.tabClient.addMouseListener(this);
		DefaultTableModel dm = new DefaultTableModel(donnees, titres);
		this.tabClient.setModel(dm);
		this.scrollClient.setViewportView(this.tabClient);
		this.scrollClient.setVisible(true);
		this.panelLister.add(scrollClient);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 1) {
		      JTable target = (JTable)e.getSource();
		      int row = target.getSelectedRow();
		      int column = target.getSelectedColumn();
		      // do some action if appropriate column
		      System.out.println("colonne "+column+" ligne "+row);
		      System.out.println(this.tabClient.getValueAt(row, column));
		      this.tfId.setText(this.tabClient.getValueAt(row, 0)+"");
		      this.tfId.setBackground(Color.gray);
		      this.tfRaison_social.setText(this.tabClient.getValueAt(row, 1)+"");
		      this.tfRaison_social.setBackground(Color.white);
		      this.tfNom.setText(this.tabClient.getValueAt(row, 2)+"");
		      this.tfNom.setBackground(Color.white);
		      this.tfPrenom.setText(this.tabClient.getValueAt(row, 3)+"");
		      this.tfPrenom.setBackground(Color.white);
		      this.tfMail.setText(this.tabClient.getValueAt(row, 4)+"");
		      this.tfMail.setBackground(Color.white);
		      this.tfMdp.setText(this.tabClient.getValueAt(row, 5)+"");
		      this.tfMdp.setBackground(Color.white);
		      this.tfAdresseF1.setText(this.tabClient.getValueAt(row, 6)+"");
		      this.tfAdresseF1.setBackground(Color.white);
		      this.tfAdresseF2.setText(this.tabClient.getValueAt(row, 7)+"");
		      this.tfAdresseF2.setBackground(Color.white);
		      this.tfFcp.setText(this.tabClient.getValueAt(row, 8)+"");
		      this.tfFcp.setBackground(Color.white);
		      this.tfVilleF.setText(this.tabClient.getValueAt(row, 9)+"");
		      this.tfVilleF.setBackground(Color.white);
		      this.tfAdresseL1.setText(this.tabClient.getValueAt(row, 10)+"");
		      this.tfAdresseL1.setBackground(Color.white);
		      this.tfAdresseL2.setText(this.tabClient.getValueAt(row, 11)+"");
		      this.tfAdresseL2.setBackground(Color.white);
		      this.tfLcp.setText(this.tabClient.getValueAt(row, 12)+"");
		      this.tfLcp.setBackground(Color.white);
		      this.tfVilleL.setText(this.tabClient.getValueAt(row, 13)+"");
		      this.tfVilleL.setBackground(Color.white);
		      if(this.tabClient.getValueAt(row, 14).equals(true))
		      {
		    	  this.Admin.setSelected(true);
			      this.Admin.setBackground(Color.white);
		      }
		      if(this.tabClient.getValueAt(row, 15).equals(true))
		      {
		    	  this.Gest.setSelected(true);
			      this.Gest.setBackground(Color.white);
		      }
		      this.tfPprix_total.setText(this.tabClient.getValueAt(row, 16)+"");
		      this.tfPprix_total.setBackground(Color.white);
		      this.tfNbComm.setText(this.tabClient.getValueAt(row, 17)+"");
		      this.tfNbComm.setBackground(Color.white);
		    }
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
//////////////////////////////////////////////////////////
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==this.btClients)
		{
			appelListe();
		}
		else
		{
			if(e.getSource()==this.btArticle)
			{
				new VueArticle();
				this.dispose();
			}
			else
			{
				if(e.getSource()==this.btStats)
				{
					new VueStats();
					this.dispose();
				}
				else
				{
					if(e.getSource()==this.btSupprimer)
					{
						int id = 0;
						try{

							System.out.println("l'id est : "+this.tfId.getText());
							id=Integer.parseInt(this.tfId.getText());
							this.tfId.setBackground(Color.white);
						}
						catch(Exception exp)
						{
						}
						if(id!=0)
						{
							ModeleUser.deleteUser(id);
							JOptionPane.showMessageDialog(this, "Suppression réussi !");
						}
						else
						{
							JOptionPane.showMessageDialog(this, "Erreur veuillez selectionner un article pour le supprimer.");
						}
						this.appelListe();
					}
					else
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
								this.tfRaison_social.setText("");
								this.tfNom.setText("");
								this.tfPrenom.setText("");
								this.tfMail.setText("");
								this.tfMdp.setText("");
								this.tfAdresseF1.setText("");
								this.tfAdresseF2.setText("");
								this.tfFcp.setText("");
								this.tfVilleF.setText("");
								this.tfAdresseL1.setText("");
								this.tfAdresseL2.setText("");
								this.tfLcp.setText("");
								this.tfVilleL.setText("");
								this.Admin.setSelected(false);
								this.Gest.setSelected(false);
								this.tfPprix_total.setText("");
								this.tfNbComm.setText("");
							}
							else
							{
								if(e.getSource()==this.btAjouter)
								{
									int id = 0;
									String raison_sociale = "";
									String nom = "";
									String prenom = "";
									String mail = "";
									String mot_de_passe = "";
									String fadresse1 = "";
									String fadresse2 = "";
									String fcp = "";
									String fville = "";
									String ladresse1 = "";
									String ladresse2 = "";
									String lcp = "";
									String lville = "";
									boolean admin = false;
									boolean gest = false;
									float prix_total_panier = 0;
									int nb_commande = 0;
									boolean ok=true;
									try{
										id=Integer.parseInt(this.tfId.getText());
										this.tfId.setBackground(Color.gray);
									}
									catch(Exception exp)
									{
									}
									try{
										raison_sociale = this.tfRaison_social.getText();
										this.tfRaison_social.setBackground(Color.white);
									}
									catch(Exception exp)
									{
										ok = false;
										this.tfRaison_social.setBackground(Color.red);
									}
									try{
										nom=this.tfNom.getText();
										this.tfNom.setBackground(Color.white);
									}
									catch(Exception exp)
									{
										ok = false;
										this.tfNom.setBackground(Color.red);
									}
									try{
										prenom=this.tfPrenom.getText();
										this.tfPrenom.setBackground(Color.white);
									}
									catch(Exception exp)
									{
										ok = false;
										this.tfPrenom.setBackground(Color.red);
									}
									try{
										mail=this.tfMail.getText();
										this.tfMail.setBackground(Color.white);
									}
									catch(Exception exp)
									{
										ok = false;
										this.tfMail.setBackground(Color.red);
									}
									try{
										mot_de_passe=this.tfMdp.getText();
										this.tfMdp.setBackground(Color.white);
									}
									catch(Exception exp)
									{
										ok = false;
										this.tfMdp.setBackground(Color.red);
									}
									try{
										fadresse1=this.tfAdresseF1.getText();
										this.tfAdresseF1.setBackground(Color.white);
									}
									catch(Exception exp)
									{
										ok = false;
										this.tfAdresseF1.setBackground(Color.red);
									}
									try{
										fadresse2=this.tfAdresseF2.getText();
										this.tfAdresseF2.setBackground(Color.white);
									}
									catch(Exception exp)
									{
										ok = false;
										this.tfAdresseF2.setBackground(Color.red);
									}
									try{
										fcp =this.tfFcp.getText();
										this.tfFcp.setBackground(Color.white);
									}
									catch(Exception exp)
									{
										ok = false;
										this.tfFcp.setBackground(Color.red);
									}
									try{
										fville =this.tfVilleF.getText();
										this.tfVilleF.setBackground(Color.white);
									}
									catch(Exception exp)
									{
										ok = false;
										this.tfVilleF.setBackground(Color.red);
									}
									try{
										ladresse1=this.tfAdresseL1.getText();
										this.tfAdresseL1.setBackground(Color.white);
									}
									catch(Exception exp)
									{
										ok = false;
										this.tfAdresseL1.setBackground(Color.red);
									}
									try{
										ladresse2=this.tfAdresseL2.getText();
										this.tfAdresseL2.setBackground(Color.white);
									}
									catch(Exception exp)
									{
										ok = false;
										this.tfAdresseL2.setBackground(Color.red);
									}
									try{
										lcp =this.tfLcp.getText();
										this.tfLcp.setBackground(Color.white);
									}
									catch(Exception exp)
									{
										ok = false;
										this.tfLcp.setBackground(Color.red);
									}
									try{
										lville =this.tfVilleL.getText();
										this.tfVilleL.setBackground(Color.white);
									}
									catch(Exception exp)
									{
										ok = false;
										this.tfVilleL.setBackground(Color.red);
									}
									try{
										admin =this.Admin.isSelected();
										this.Admin.setBackground(Color.white);
									}
									catch(Exception exp)
									{
									}
									try{
										gest =this.Gest.isSelected();
										this.Gest.setBackground(Color.white);
									}
									catch(Exception exp)
									{
									}
									try{
										prix_total_panier = Float.parseFloat(this.tfPprix_total.getText());
										this.tfPprix_total.setBackground(Color.white);
									}
									catch(Exception exp)
									{
									}
									try{
										nb_commande =Integer.parseInt(this.tfNbComm.getText());
										this.tfNbComm.setBackground(Color.white);
									}
									catch(Exception exp)
									{
									}
									try{
										if(ok == true)
										{
											User unUser = new User(id, raison_sociale, nom, prenom, mail, mot_de_passe, fadresse1, fadresse2, fcp, fville, ladresse1, ladresse2, lcp, lville, admin, gest, prix_total_panier, nb_commande);
											if(id!=0)
											{
												ModeleUser.updateUser(unUser);
											}
											else
											{
												ModeleUser.insertUser(unUser);												
											}
											this.appelListe();
										}
										else
										{
											JOptionPane.showMessageDialog(this, "Erreur de saisie veuillez remplir correctement les champs coloré en rouge");
										}
									}
									catch(Exception exp)
									{
										JOptionPane.showMessageDialog(this, "Erreur lors de l'insertion de l'article");
									}
								}
								if(e.getSource()==btRechercher)
								{
									this.appelListe();
						        }
							} 
						}
					}
				}
			}
		}
	}
		
}


package vue;

import controleur.Produit;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import modele.Modele;

@SuppressWarnings({ "serial" })
public class VueProduit extends JFrame implements ActionListener
{
	private JPanel panelMenu=new JPanel();
	private JPanel panelAjouter=new JPanel();
	private JPanel panelLister=new JPanel();
	private JPanel panelRechercher=new JPanel();
	private JPanel panelSupprimer=new JPanel();
	
	private JButton btAjouter = new JButton("Ajouter");
	private JButton btRechercher = new JButton("Rechercher");
	private JButton btLister = new JButton("Lister");
	private JButton btSupprimer = new JButton("Supprimer");
	private JButton btQuitter = new JButton("Quitter");
	
	//construction des objet ajouter
	private JTextField tfReference = new JTextField("");
	private JTextField tfDesignation= new JTextField("");
	private JTextField tfPrix = new JTextField("");
	private JTextField tfQuantite = new JTextField("");
	private JTextField tfCategorie = new JTextField("");
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	//construction des objet lister
	private JLabel lbLister= new JLabel("Liste des produits");
	private JButton btFermer = new JButton("Fermer");
	private JTable tabProduits = null;
	
	//contruction des objet rechercher
	private JLabel lbRechercher = new JLabel("Recherche d'un produit");
	private JButton btOk = new JButton("Ok");
	@SuppressWarnings("rawtypes")
	private JComboBox cbxProduit = new JComboBox();
	private JTextArea taResultat = new JTextArea("Résultat : ");
	
	//construction des objet supprimer
	private JLabel lbSuppr = new JLabel("Supprimer des produits");
	private JTextField tfRecherche = new JTextField();
	private JButton btSuppr = new JButton("Supprimer");
	private JTextArea taNbobj = new JTextArea("Nombre de produits : ");
	
	//ajout d'un background
	private JLabel monBackground = new JLabel(new ImageIcon("C:/Users/Joffray/Desktop/Background.jpg"));
	
	public VueProduit()
	{
		this.setTitle("Gestion de stock");
		this.setBounds(200,200,650,400);
		this.setResizable(false);
		this.setLayout(null);
		
		//construction du panel menu
		this.panelMenu.setBounds(10, 10, 120, 380);
		this.panelMenu.setBackground(Color.red);
		this.panelMenu.setLayout(new GridLayout(7, 1));
		this.panelMenu.add(new JLabel("Menu Principale"));
		this.panelMenu.add(this.btAjouter);
		this.panelMenu.add(this.btLister);
		this.panelMenu.add(this.btRechercher);
		this.panelMenu.add(this.btSupprimer);
		this.panelMenu.add(this.btQuitter);
		this.panelMenu.add(new JLabel(""));
		this.add(this.panelMenu);
		
		//rendre les bouton clickable
		this.btAjouter.addActionListener(this);
		this.btLister.addActionListener(this);
		this.btRechercher.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		this.btQuitter.addActionListener(this);
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		this.btFermer.addActionListener(this);
		this.btOk.addActionListener(this);
		this.btSuppr.addActionListener(this);
		
		//construction du panel ajouter
		this.panelAjouter.setBounds(140, 10, 500, 340);
		this.panelAjouter.setBackground(Color.cyan);
		this.panelAjouter.setLayout(new GridLayout(7,2));
		this.panelAjouter.add(new JLabel("Référence :"));
		this.panelAjouter.add(this.tfReference);
		this.panelAjouter.add(new JLabel("Designation:"));
		this.panelAjouter.add(this.tfDesignation);
		this.panelAjouter.add(new JLabel("Prix :"));
		this.panelAjouter.add(this.tfPrix);
		this.panelAjouter.add(new JLabel("Quantité :"));
		this.panelAjouter.add(this.tfQuantite);
		this.panelAjouter.add(new JLabel("Catégorie :"));
		this.panelAjouter.add(this.tfCategorie);
		this.panelAjouter.add(this.btAnnuler);
		this.panelAjouter.add(this.btEnregistrer);
		this.panelAjouter.setVisible(false);
		this.add(this.panelAjouter);

		//construction du panel lister
		this.panelLister.setBounds(140, 10, 500, 340);
		this.panelLister.setBackground(Color.yellow);
		this.panelLister.setLayout(null);
		this.lbLister.setBounds(100, 20, 200, 20);
		this.panelLister.add(this.lbLister);
		this.btFermer.setBounds(200, 300, 100, 20);
		this.panelLister.add(this.btFermer);
		this.panelLister.setVisible(false);
		this.add(this.panelLister);

		//construction du panel rechercher
		this.panelRechercher.setBounds(140, 10, 500, 340);
		this.panelRechercher.setBackground(Color.green);
		this.panelRechercher.setLayout(null);
		this.lbRechercher.setBounds(100, 20, 200, 20);
		this.panelRechercher.add(this.lbRechercher);
		this.cbxProduit.setBounds(50, 80, 200, 20);
		this.panelRechercher.add(this.cbxProduit);
		this.btOk.setBounds(260, 80, 80, 20);
		this.panelRechercher.add(this.btOk);
		this.taResultat.setBounds(100, 120, 300, 150);
		this.taResultat.setEditable(false);
		this.taResultat.setBackground(Color.green);
		this.taResultat.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		this.panelRechercher.add(this.taResultat);
		this.panelRechercher.setVisible(false);
		this.add(this.panelRechercher);

		//construction du panel suppimer
		this.panelSupprimer.setBounds(140, 10, 500, 340);
		this.panelSupprimer.setBackground(Color.gray);
		this.panelSupprimer.setLayout(null);
		this.lbSuppr.setBounds(100, 20, 200, 20);
		this.panelSupprimer.add(this.lbSuppr);
		this.tfRecherche.setBounds(50, 80, 200, 20);
		this.panelSupprimer.add(this.tfRecherche);
		this.btSuppr.setBounds(260, 80, 100, 20);
		this.panelSupprimer.add(this.btSuppr);
		this.taNbobj.setBounds(100, 120, 300, 150);
		this.taNbobj.setEditable(false);
		this.taNbobj.setBackground(Color.gray);
		this.taNbobj.setBorder(BorderFactory.createLineBorder(Color.white, 1, true));
		this.panelSupprimer.add(this.taNbobj);
		this.panelSupprimer.setVisible(false);
		this.add(this.panelSupprimer);
		
		//mon background
        this.monBackground.setBounds(0, 0, 650, 400);
		this.add(this.monBackground);
		
		this.setVisible(true);
	}
	
	public static void afficherProduits (String chaine)
	{
		System.out.println("Les produitsde la bdd");
		System.out.println(chaine);
	}
	
	public static Produit saisirProduit()
	{
		Produit unProd = new Produit();
		System.out.println("Donner la référence : ");
		unProd.setReference(Console.saisirString());

		System.out.println("Donner la désignation : ");
		unProd.setDesignation(Console.saisirString());

		System.out.println("Donner la catégorie : ");
		unProd.setCategorie(Console.saisirString());
       
		System.out.println("Donner le prix : ");
		unProd.setPrix(Console.saisirFloat());

		System.out.println("Donner la quantité : ");
		unProd.setQte(Console.saisirInt());
		return unProd;
	}
   
	public static String saisirCle()
	{
		String cle;
		System.out.println("Donner la cle : ");
		cle = Console.saisirString();
		return cle;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==this.btAjouter)
		{
			this.panelAjouter.setVisible(true);
			this.panelLister.setVisible(false);
			this.panelRechercher.setVisible(false);
			this.panelSupprimer.setVisible(false);
		}
		else
		{
			if(e.getSource()==this.btLister)
			{
				this.panelAjouter.setVisible(false);
				this.panelLister.setVisible(true);
				this.panelRechercher.setVisible(false);
				this.panelSupprimer.setVisible(false);
				String titres[] = {"Référence", "Désignation", "Prix", "Qantité", "Catégorie"};
				LinkedList<Produit> uneListe = Modele.selectAll();
				Object donnees [][] = new Object[uneListe.size()][5];
				int i = 0;
				for(Produit unProd : uneListe)
				{
					donnees[i][0]=unProd.getReference();
					donnees[i][1]=unProd.getDesignation();
					donnees[i][2]=unProd.getPrix();
					donnees[i][3]=unProd.getQte();
					donnees[i][4]=unProd.getCategorie();
					i++;
				}
				this.tabProduits = new JTable(donnees, titres);
				JScrollPane uneScroll = new JScrollPane(this.tabProduits);
				uneScroll.setBounds(20, 50, 400, 220);
				uneScroll.setVisible(true);
				this.panelLister.add(uneScroll);
			}
			else
			{
				if(e.getSource()==this.btRechercher)
				{
					this.remplixCBX();
					this.panelAjouter.setVisible(false);
					this.panelLister.setVisible(false);
					this.panelRechercher.setVisible(true);
					this.panelSupprimer.setVisible(false);
				}
				else
				{
					if(e.getSource()==this.btSupprimer)
					{
						this.panelAjouter.setVisible(false);
						this.panelLister.setVisible(false);
						this.panelRechercher.setVisible(false);
						this.panelSupprimer.setVisible(true);
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
								this.tfReference.setText("");
								this.tfDesignation.setText("");
								this.tfPrix.setText("");
								this.tfQuantite.setText("");
							}
							else
							{
								if(e.getSource()==this.btEnregistrer)
								{
									String reference = this.tfReference.getText();
									String designation = this.tfDesignation.getText();
									String categorie = this.tfCategorie.getText();
									float prix = 0;
									int quantite = 0;
									boolean ok=true;
									try{
										prix=Float.parseFloat(this.tfPrix.getText());
										this.tfQuantite.setBackground(Color.white);
									}
									catch(Exception exp)
									{
										ok = false;
										JOptionPane.showMessageDialog(this, "Erreur de saisie du prix");
										this.tfQuantite.setBackground(Color.red);
									}
									try{
										quantite = Integer.parseInt(this.tfQuantite.getText());
										this.tfQuantite.setBackground(Color.white);
									}
									catch(Exception exp)
									{
										ok = false;
										JOptionPane.showMessageDialog(this, "Erreur de saisie de la quantité");
										this.tfQuantite.setBackground(Color.red);
									}
									try{
										if(ok == true)
										{
											Produit unProd = new Produit(reference, designation, categorie, prix, quantite);
											Modele.insertProduit(unProd);
											JOptionPane.showMessageDialog(this, "Insertion réussi !");
											this.panelAjouter.setVisible(false);
										}
									}
									catch(Exception exp)
									{
										JOptionPane.showMessageDialog(this, "Erreur lors de l'insertion du produit");
									}
								}
								else
								{
									if(e.getSource()==this.btFermer)
									{
										this.panelLister.setVisible(false);
									}
									else
									{
										if(e.getSource()==this.btOk)
										{
											String chaine = this.cbxProduit.getSelectedItem().toString();
											String tab[] = new String [5];
											tab = chaine.split(" - ");
											chaine = "\n\tRéférence : " +tab[0]+"\n\tDésignation : " +tab[1]+"\n\tPrix : " +tab[2]+"\n\tQuantité : " +tab[3]+"\n\tCatégorie : " +tab[4];
											this.taResultat.setText(chaine);
										}
										else
										{
											if(e.getSource()==this.btSuppr)
											{
												String cle = this.tfRecherche.getText();
												if(!cle.equals(""))
												{
													int nb = Modele.deleteProduits(this.tfRecherche.getText());
													if(nb!=0)
													{
														this.taNbobj.setText("Nombre de produits supprimer : "+nb);
													}
													else
													{
														this.taNbobj.setText("Aucun produit ne correspond à votre recherche.");
													}
												}
												else
												{
													this.taNbobj.setText("Vous devez renseigner un nom de produit.");
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private void remplixCBX()
	{
		this.cbxProduit.removeAllItems();
		LinkedList<Produit> uneListe = Modele.selectAll();
		for(Produit unProd : uneListe)
		{
			this.cbxProduit.addItem(unProd.toString());
		}
	}
}//fin de la classe
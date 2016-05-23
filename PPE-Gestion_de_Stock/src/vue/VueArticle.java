package vue;

import controleur.Article;







import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.table.DefaultTableModel;

import modele.Modele;

@SuppressWarnings({ "serial" })
public class VueArticle extends JFrame implements ActionListener, MouseListener
{
	private JPanel panelMenu=new JPanel();
	private JPanel panelAjouter=new JPanel();
	private JPanel panelLister=new JPanel();
	private JPanel panelRechercher=new JPanel();
	private JPanel panelSupprimer=new JPanel();
	private JPanel panelBouton=new JPanel();
	
	//private JButton btAjouter = new JButton("Ajouter");
	private JButton btRechercher = new JButton("Rechercher");
	private JButton btLister = new JButton("Lister");
	private JButton btSupprimer = new JButton("Supprimer");
	private JButton btQuitter = new JButton("Quitter");
	private JButton btClients = new JButton("Gerer clients");
	private JButton btStats = new JButton("Voir statistiques");
	private JButton btModifier = new JButton("Modifier");
	private JButton btRefresh = new JButton("refresh");
	
	//construction des objet ajouter
	private JTextField tfId = new JTextField("");
	private JTextField tfId_famille= new JTextField("");
	private JTextField tfId_sous_famille= new JTextField("");
	private JTextField tfNom = new JTextField("");
	private JTextField tfCode_article = new JTextField("");
	private JTextField tfDesignation = new JTextField("");
	private JTextField tfPrix_unitaire = new JTextField("");
	private JTextField tfQuantite = new JTextField("");
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btAjouter = new JButton("Ajouter");
	
	//construction des objet lister
	private JLabel lbLister= new JLabel("Liste des articles");
	private JButton btFermer = new JButton("Fermer");
	private JTable tabArticles;
	
	//contruction des objet rechercher
	private JLabel lbRechercher = new JLabel("Recherche d'un article");
	private JButton btOk = new JButton("Ok");
	@SuppressWarnings("rawtypes")
	private JComboBox cbxArticle = new JComboBox();
	private JTextArea taResultat = new JTextArea("Résultat : ");
	
	//construction des objet supprimer
	private JLabel lbSuppr = new JLabel("Supprimer des articles");
	private JTextField tfRecherche = new JTextField();
	private JButton btSuppr = new JButton("Supprimer");
	private JTextArea taNbobj = new JTextArea("Nombre d'articles : ");
	
	//ajout d'un background
	private JLabel monBackground = new JLabel(new ImageIcon("C:/Users/Joffray/Desktop/Background.jpg"));
	
	public VueArticle()
	{
		this.setTitle("Gestion de stocks");
		this.setBounds(200,200,1200,600);
		this.setResizable(false);
		this.setLayout(null);
		
		//construction du panel boutons
		this.panelBouton.setBounds(1050, 0, 150, 600);
		this.panelBouton.setBackground(Color.red);
		this.panelBouton.setLayout(new GridLayout(7, 1));
		this.panelBouton.add(new JLabel(""));
		this.panelBouton.add(this.btAjouter);
		this.panelBouton.add(this.btSupprimer);
		this.panelBouton.add(this.btModifier);
		this.panelBouton.add(this.btRechercher);
		this.panelBouton.add(this.btAnnuler);
		this.panelBouton.add(new JLabel(""));
		this.panelBouton.setVisible(true);
		this.add(this.panelBouton);
		
		//construction du panel menu
		this.panelMenu.setBounds( 0, 0, 150, 600);
		this.panelMenu.setBackground(Color.red);
		this.panelMenu.setLayout(new GridLayout(7, 1));
		this.panelMenu.add(new JLabel("Menu Principale"));
		this.panelMenu.add(this.btLister);
		this.panelMenu.add(this.btClients);
		this.panelMenu.add(this.btStats);
		this.panelMenu.add(this.btQuitter);
		this.panelMenu.add(new JLabel(""));
		this.add(this.panelMenu);
		
		//rendre les bouton clickable
		//this.btAjouter.addActionListener(this);
		this.btLister.addActionListener(this);
		this.btRechercher.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		this.btQuitter.addActionListener(this);
		this.btAnnuler.addActionListener(this);
		this.btAjouter.addActionListener(this);
		this.btFermer.addActionListener(this);
		this.btOk.addActionListener(this);
		this.btSuppr.addActionListener(this);
		this.btRefresh.addActionListener(this);
		
		//construction du panel ajouter
		this.panelAjouter.setBounds(150, 250, 900, 300);
		this.panelAjouter.setBackground(Color.cyan);
		this.panelAjouter.setLayout(new GridLayout(9,2));
		this.panelAjouter.add(new JLabel("id :"));
		this.panelAjouter.add(this.tfId);
		this.panelAjouter.add(new JLabel("id_famille :"));
		this.panelAjouter.add(this.tfId_famille);
		this.panelAjouter.add(new JLabel("id_sous_famille :"));
		this.panelAjouter.add(this.tfId_sous_famille);
		this.panelAjouter.add(new JLabel("nom :"));
		this.panelAjouter.add(this.tfNom);
		this.panelAjouter.add(new JLabel("Code_article :"));
		this.panelAjouter.add(this.tfCode_article);
		this.panelAjouter.add(new JLabel("Designation:"));
		this.panelAjouter.add(this.tfDesignation);
		this.panelAjouter.add(new JLabel("Prix_unitaire :"));
		this.panelAjouter.add(this.tfPrix_unitaire);
		this.panelAjouter.add(new JLabel("Quantité :"));
		this.panelAjouter.add(this.tfQuantite);
		this.panelAjouter.setVisible(false);
		this.add(this.panelAjouter);

		//construction du panel lister
		this.panelLister.setBounds(150, 0, 900, 240);
		this.panelLister.setBackground(Color.GRAY);
		this.panelLister.setLayout(null);
		this.lbLister.setBounds(100, 20, 100, 20);
		this.panelLister.add(this.lbLister);
		this.btFermer.setBounds(300, 10, 100, 20);
		this.btRefresh.setBounds(400, 10, 100, 20);
		this.panelLister.add(this.btRefresh);
		this.panelLister.add(this.btFermer);
		this.panelLister.setVisible(false);
		this.add(this.panelLister);

		//construction du panel rechercher
		this.panelRechercher.setBounds(140, 10, 800, 500);
		this.panelRechercher.setBackground(Color.green);
		this.panelRechercher.setLayout(null);
		this.lbRechercher.setBounds(100, 20, 200, 20);
		this.panelRechercher.add(this.lbRechercher);
		this.cbxArticle.setBounds(50, 80, 200, 20);
		this.panelRechercher.add(this.cbxArticle);
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
		this.panelSupprimer.setBounds(140, 10, 800, 500);
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
	
	public static void afficherArticle (String chaine)
	{
		System.out.println("Les articles de la bdd");
		System.out.println(chaine);
	}
	
	public static Article saisirArticle()
	{
		Article unArticle = new Article();
		System.out.println("Donner l'id : ");
		unArticle.setId(Console.saisirInt());

		System.out.println("Donner l'id de la famille : ");
		unArticle.setId_famille(Console.saisirInt());
		
		System.out.println("Donner l'id de la sous-famille : ");
		unArticle.setId_sous_famille(Console.saisirInt());

		System.out.println("Donner le nom : ");
		unArticle.setNom(Console.saisirString());
       
		System.out.println("Donner le code de l'article : ");
		unArticle.setCode_article(Console.saisirString());

		System.out.println("Donner la désignation : ");
		unArticle.setDesignation(Console.saisirString());
		
		System.out.println("Donner le prix unitaire : ");
		unArticle.setPrix_unitaire(Console.saisirFloat());
		
		System.out.println("Donner la quantité : ");
		unArticle.setQuantite(Console.saisirInt());
		
		return unArticle;
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
		if(e.getSource()==this.btClients)
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
				//this.tabArticles.repaint();
				String titres[] = {"id", "id_famille", "id_sous_famille", "Nom", "code_article", "Désignation", "Prix_unitaire", "Qantité"};
				LinkedList<Article> uneListe = Modele.selectAll();
				Object donnees [][] = new Object[uneListe.size()][8];
				int i = 0;
				for(Article unArticle : uneListe)
				{
					donnees[i][0]=unArticle.getId();
					donnees[i][1]=unArticle.getId_famille();
					donnees[i][2]=unArticle.getId_sous_famille();
					donnees[i][3]=unArticle.getNom();
					donnees[i][4]=unArticle.getCode_article();
					donnees[i][5]=unArticle.getDesignation();
					donnees[i][6]=unArticle.getPrix_unitaire();
					donnees[i][7]=unArticle.getQuantite();
					i++;
				}
				this.tabArticles = new JTable(donnees, titres);
				this.tabArticles.addMouseListener(this);
				JScrollPane uneScroll = new JScrollPane(this.tabArticles);
				uneScroll.setBounds(20, 50, 750, 190);
				uneScroll.setVisible(true);
				this.panelLister.add(uneScroll);
				this.panelAjouter.setVisible(true);

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
								this.tfId.setText("");
								this.tfId_famille.setText("");
								this.tfId_sous_famille.setText("");
								this.tfNom.setText("");
								this.tfCode_article.setText("");
								this.tfDesignation.setText("");
								this.tfPrix_unitaire.setText("");
								this.tfQuantite.setText("");
							}
							else
							{
								if(e.getSource()==this.btAjouter)
								{
									int id = 0;
									int id_famille = 0;
									int id_sous_famille = 0;
									String nom = this.tfNom.getText();
									String code_article = this.tfCode_article.getText();
									String designation = this.tfDesignation.getText();
									float prix_unitaire = 0;
									int quantite = 0;
									boolean ok=true;
									try{
										id=Integer.parseInt(this.tfId.getText());
										this.tfId.setBackground(Color.white);
									}
									catch(Exception exp)
									{
										ok = false;
										JOptionPane.showMessageDialog(this, "Erreur de saisie de l'id");
										this.tfId.setBackground(Color.red);
									}
									try{
										id_famille=Integer.parseInt(this.tfId_famille.getText());
										this.tfId_famille.setBackground(Color.white);
									}
									catch(Exception exp)
									{
										ok = false;
										JOptionPane.showMessageDialog(this, "Erreur de saisie de l'id_famille");
										this.tfId_famille.setBackground(Color.red);
									}
									try{
										id_sous_famille=Integer.parseInt(this.tfId_sous_famille.getText());
										this.tfId_sous_famille.setBackground(Color.white);
									}
									catch(Exception exp)
									{
										ok = false;
										JOptionPane.showMessageDialog(this, "Erreur de saisie de l'id_sous_famille");
										this.tfId_sous_famille.setBackground(Color.red);
									}
									try{
										prix_unitaire=Float.parseFloat(this.tfPrix_unitaire.getText());
										this.tfPrix_unitaire.setBackground(Color.white);
									}
									catch(Exception exp)
									{
										ok = false;
										JOptionPane.showMessageDialog(this, "Erreur de saisie du prix_unitaire");
										this.tfPrix_unitaire.setBackground(Color.red);
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
											Article unArticle = new Article(id, id_famille, id_sous_famille, nom, code_article, designation, prix_unitaire, quantite);
											Modele.insertArticle(unArticle);
											JOptionPane.showMessageDialog(this, "Insertion réussi !");
											this.panelAjouter.setVisible(false);
										}
									}
									catch(Exception exp)
									{
										JOptionPane.showMessageDialog(this, "Erreur lors de l'insertion de l'article");
									}
								}
								else
								{
									if(e.getSource()==this.btFermer)
									{
										this.panelLister.setVisible(false);
									}
									else if(e.getSource()==this.btRefresh)
									{
										
									}
									else
									{
										if(e.getSource()==this.btOk)
										{
											String chaine = this.cbxArticle.getSelectedItem().toString();
											String tab[] = new String [5];
											tab = chaine.split(" - ");
											chaine = "\n\tId : " +tab[0]+"\n\tId_famille : " +tab[1]+"\n\tId_sous_famille : " +tab[2]+"\n\tNom : " +tab[3]+"\n\tCode_article : " +tab[4]+"\n\tDesignation : " +tab[5]+"\n\tPrix_unitaire : " +tab[6]+"\n\tQuantite : " +tab[7];
											this.taResultat.setText(chaine);
										}
										else
										{
											if(e.getSource()==this.btSuppr)
											{
												String cle = this.tfRecherche.getText();
												if(!cle.equals(""))
												{
													int nb = Modele.deleteArticles(this.tfRecherche.getText());
													if(nb!=0)
													{
														this.taNbobj.setText("Nombre d'articles supprimer : "+nb);
													}
													else
													{
														this.taNbobj.setText("Aucun article ne correspond à votre recherche.");
													}
												}
												else
												{
													this.taNbobj.setText("Vous devez renseigner un nom d'article.");
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
		this.cbxArticle.removeAllItems();
		LinkedList<Article> uneListe = Modele.selectAll();
		for(Article unArticle : uneListe)
		{
			this.cbxArticle.addItem(unArticle.toString());
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getClickCount() == 1) {
		      JTable target = (JTable)e.getSource();
		      int row = target.getSelectedRow();
		      int column = target.getSelectedColumn();
		      // do some action if appropriate column
		      System.out.println("colonne "+column+" ligne "+row);
		      System.out.println(this.tabArticles.getValueAt(row, column));
		      this.tfId.setText(this.tabArticles.getValueAt(row, 0)+"");
		      this.tfId_famille.setText(this.tabArticles.getValueAt(row, 1)+"");
		      this.tfId_sous_famille.setText(this.tabArticles.getValueAt(row, 2)+"");
		      this.tfNom.setText(this.tabArticles.getValueAt(row, 3)+"");
		      this.tfCode_article.setText(this.tabArticles.getValueAt(row, 4)+"");
		      this.tfDesignation.setText(this.tabArticles.getValueAt(row, 5)+"");
		      this.tfPrix_unitaire.setText(this.tabArticles.getValueAt(row, 6)+"");
		      this.tfQuantite.setText(this.tabArticles.getValueAt(row, 7)+"");
		    }
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}//fin de la classe
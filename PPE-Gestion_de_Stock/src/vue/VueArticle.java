package vue;

import controleur.Article;
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

import modele.Modele;

@SuppressWarnings({ "serial" })
public class VueArticle extends JFrame implements ActionListener, MouseListener
{
	
	private JPanel panelMenu=new JPanel();
	
	private JPanel panelArticle=new JPanel();
	
	private JPanel panelAjouter=new JPanel();
	private JPanel panelLister=new JPanel();
	private JPanel panelBouton=new JPanel();
	
	private JButton btArticle = new JButton("Gérer les articles");
	private JButton btClients = new JButton("Gerer clients");
	private JButton btStats = new JButton("Voir statistiques");
	private JButton btQuitter = new JButton("Quitter");
	
	private JButton btRechercher = new JButton("Rechercher");
	private JButton btSupprimer = new JButton("Supprimer");
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btAjouter = new JButton("Ajouter/Modifier");
	
	//construction des objet ajouter
	private JTextField tfId = new JTextField("");
	private JTextField tfId_famille= new JTextField("");
	private JTextField tfId_sous_famille= new JTextField("");
	private JTextField tfNom = new JTextField("");
	private JTextField tfCode_article = new JTextField("");
	private JTextField tfDesignation = new JTextField("");
	private JTextField tfPrix_unitaire = new JTextField("");
	private JTextField tfQuantite = new JTextField("");
	
	//construction des objet lister
	private JTable tabArticles = new JTable();
	private JScrollPane scrollArticle = new JScrollPane();
	private JTextField tfRecherche = new JTextField("");
	private JLabel lbRechercher = new JLabel("Recherche : ");
	
	public VueArticle()
	{
		this.setTitle("Gestion de stocks");
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
		
		//construction du panel boutons
		this.panelBouton.setBounds(900, 0, 150, 600);
		this.panelBouton.setBackground(Color.red);
		this.panelBouton.setLayout(new GridLayout(7, 1));
		this.panelBouton.add(new JLabel(""));
		this.panelBouton.add(this.btAjouter);
		this.panelBouton.add(this.btSupprimer);
		this.panelBouton.add(this.btAnnuler);
		this.panelBouton.add(new JLabel(""));
		this.panelBouton.setVisible(true);
		
		
		//construction du panel ajouter
		this.panelAjouter.setBounds(0, 300, 900, 300);
		this.panelAjouter.setBackground(Color.cyan);
		this.panelAjouter.setLayout(new GridLayout(9,2));
		this.panelAjouter.add(new JLabel("Id :"));
		this.panelAjouter.add(this.tfId);
		this.tfId.setEditable(false);
		this.tfId.setBackground(Color.gray);
		this.panelAjouter.add(new JLabel("Id famille :"));
		this.panelAjouter.add(this.tfId_famille);
		this.panelAjouter.add(new JLabel("Id sous famille :"));
		this.panelAjouter.add(this.tfId_sous_famille);
		this.panelAjouter.add(new JLabel("Nom :"));
		this.panelAjouter.add(this.tfNom);
		this.panelAjouter.add(new JLabel("Code article :"));
		this.panelAjouter.add(this.tfCode_article);
		this.panelAjouter.add(new JLabel("Désignation:"));
		this.panelAjouter.add(this.tfDesignation);
		this.panelAjouter.add(new JLabel("Prix unitaire :"));
		this.panelAjouter.add(this.tfPrix_unitaire);
		this.panelAjouter.add(new JLabel("Quantité :"));
		this.panelAjouter.add(this.tfQuantite);
		this.panelAjouter.setVisible(true);

		//construction du panel lister
		this.panelLister.setBounds(0, 0, 900, 300);
		this.panelLister.setBackground(Color.GRAY);
		this.lbRechercher.setBounds(20, 20, 80, 20);
		this.tfRecherche.setBounds(100, 20, 640, 20);
		this.btRechercher.setBounds(760, 20, 120, 20);
		this.scrollArticle.setBounds(20, 60, 860, 230);
		this.panelLister.add(this.lbRechercher);
		this.panelLister.add(this.tfRecherche);
		this.panelLister.add(this.btRechercher);
		this.panelLister.setLayout(null);
		this.panelLister.setVisible(true);

		//construction du panel gerer article
		this.panelArticle.setBounds(150, 0, 1050, 600);
		this.panelArticle.setLayout(null);
		this.panelArticle.add(this.panelLister);
		this.panelArticle.add(this.panelAjouter);
		this.panelArticle.add(this.panelBouton);
		this.add(this.panelArticle);
		this.panelArticle.setVisible(true);
		this.appelListe();
		
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
		String titres[] = {"id", "id_famille", "id_sous_famille", "Nom", "code_article", "Désignation", "Prix_unitaire", "Qantité"};
		String cle = this.tfRecherche.getText();
		LinkedList<Article> uneListe = Modele.selectWhere(cle);
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
		DefaultTableModel model = new DefaultTableModel(donnees, titres);
		this.tabArticles.addMouseListener(this);
		this.tabArticles.setModel(model);
		this.scrollArticle.getViewport().add(this.tabArticles);
		this.scrollArticle.setVisible(true);
		this.panelLister.add(this.scrollArticle);
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
			new VueClient();
			this.dispose();
		}
		else
		{
			if(e.getSource()==this.btArticle)
			{
				appelListe();
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
							Modele.deleteArticle(id);
							JOptionPane.showMessageDialog(this, "Suppression réussi !");
						}
						else
						{
							JOptionPane.showMessageDialog(this, "Erreur vous devez selectionner un article pour le supprimer.");
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
									String nom = "";
									String code_article = "";
									String designation = "";
									float prix_unitaire = 0;
									int quantite = 0;
									boolean ok=true;
									try{
										id=Integer.parseInt(this.tfId.getText());
										this.tfId.setBackground(Color.gray);
									}
									catch(Exception exp)
									{
									}
									try{
										id_famille=Integer.parseInt(this.tfId_famille.getText());
										this.tfId_famille.setBackground(Color.white);
									}
									catch(Exception exp)
									{
										ok = false;
										this.tfId_famille.setBackground(Color.red);
									}
									try{
										id_sous_famille=Integer.parseInt(this.tfId_sous_famille.getText());
										this.tfId_sous_famille.setBackground(Color.white);
									}
									catch(Exception exp)
									{
										ok = false;
										this.tfId_sous_famille.setBackground(Color.red);
									}
									try{
										nom=this.tfNom.getText();
										this.tfNom.setBackground(Color.white);
										if(nom.length()==0)
										{
											ok = false;
											this.tfNom.setBackground(Color.red);
										}
									}
									catch(Exception exp)
									{
										ok = false;
										this.tfNom.setBackground(Color.red);
									}
									try{
										code_article=this.tfCode_article.getText();
										this.tfCode_article.setBackground(Color.white);
										if(code_article.length()==0)
										{
											ok = false;
											this.tfCode_article.setBackground(Color.red);
										}
									}
									catch(Exception exp)
									{
										ok = false;
										this.tfCode_article.setBackground(Color.red);
									}
									try{
										designation=this.tfDesignation.getText();
										this.tfDesignation.setBackground(Color.white);
										if(designation.length()==0)
										{
											ok = false;
											this.tfDesignation.setBackground(Color.red);
										}
									}
									catch(Exception exp)
									{
										ok = false;
										this.tfDesignation.setBackground(Color.red);
									}
									try{
										prix_unitaire=Float.parseFloat(this.tfPrix_unitaire.getText());
										this.tfPrix_unitaire.setBackground(Color.white);
										
									}
									catch(Exception exp)
									{
										ok = false;
										this.tfPrix_unitaire.setBackground(Color.red);
									}
									try{
										quantite = Integer.parseInt(this.tfQuantite.getText());
										this.tfQuantite.setBackground(Color.white);
									}
									catch(Exception exp)
									{
										ok = false;
										this.tfQuantite.setBackground(Color.red);
									}
									try{
										if(ok == true)
										{
											Article unArticle = new Article(id, id_famille, id_sous_famille, nom, code_article, designation, prix_unitaire, quantite);
											if(id!=0)
											{
												Modele.updateArticle(unArticle);
												JOptionPane.showMessageDialog(this, "Modification réussi !");
											}
											else
											{
												Modele.insertArticle(unArticle);
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
								else
								{
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

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 1) {
		      JTable target = (JTable)e.getSource();
		      int row = target.getSelectedRow();
		      int column = target.getSelectedColumn();
		      // do some action if appropriate column
		      System.out.println("colonne "+column+" ligne "+row);
		      System.out.println(this.tabArticles.getValueAt(row, column));
		      this.tfId.setText(this.tabArticles.getValueAt(row, 0)+"");
		      this.tfId.setBackground(Color.gray);
		      this.tfId_famille.setText(this.tabArticles.getValueAt(row, 1)+"");
		      this.tfId_famille.setBackground(Color.white);
		      this.tfId_sous_famille.setText(this.tabArticles.getValueAt(row, 2)+"");
		      this.tfId_sous_famille.setBackground(Color.white);
		      this.tfNom.setText(this.tabArticles.getValueAt(row, 3)+"");
		      this.tfNom.setBackground(Color.white);
		      this.tfCode_article.setText(this.tabArticles.getValueAt(row, 4)+"");
		      this.tfCode_article.setBackground(Color.white);
		      this.tfDesignation.setText(this.tabArticles.getValueAt(row, 5)+"");
		      this.tfDesignation.setBackground(Color.white);
		      this.tfPrix_unitaire.setText(this.tabArticles.getValueAt(row, 6)+"");
		      this.tfPrix_unitaire.setBackground(Color.white);
		      this.tfQuantite.setText(this.tabArticles.getValueAt(row, 7)+"");
		      this.tfQuantite.setBackground(Color.white);
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
}
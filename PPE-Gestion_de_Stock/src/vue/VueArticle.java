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
public class VueArticle extends JFrame implements ActionListener, MouseListener
{
	private JPanel panelMenu=new JPanel();
	private JPanel panelAjouter=new JPanel();
	private JPanel panelLister=new JPanel();
	private JPanel panelRechercher=new JPanel();
	private JPanel panelSupprimer=new JPanel();
	private JPanel panelBouton=new JPanel();
	
	private JPanel panelArticle=new JPanel();
	private JPanel panelClient=new JPanel();
	private JPanel panelStats=new JPanel();
	
	private JButton btArticle = new JButton("G�rer les articles");
	private JButton btClients = new JButton("Gerer clients");
	private JButton btStats = new JButton("Voir statistiques");
	private JButton btQuitter = new JButton("Quitter");
	
	private JButton btRechercher = new JButton("Rechercher");
	private JButton btSupprimer = new JButton("Supprimer");
	private JButton btModifier = new JButton("Modifier");
	private JButton btRefresh = new JButton("Refresh");
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btAjouter = new JButton("Ajouter");
	
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
	private JLabel lbLister= new JLabel("Liste des articles");
	private JButton btFermer = new JButton("Fermer");
	private JTable tabArticles;
	
	//contruction des objet rechercher
	private JLabel lbRechercher = new JLabel("Recherche d'un article");
	private JButton btOk = new JButton("Ok");
	@SuppressWarnings("rawtypes")
	private JComboBox cbxArticle = new JComboBox();
	private JTextArea taResultat = new JTextArea("R�sultat : ");
	
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
		this.panelBouton.add(this.btModifier);
		this.panelBouton.add(this.btRechercher);
		this.panelBouton.add(this.btAnnuler);
		this.panelBouton.add(new JLabel(""));
		this.panelBouton.setVisible(true);
		
		
		//construction du panel ajouter
		this.panelAjouter.setBounds(0, 300, 900, 300);
		this.panelAjouter.setBackground(Color.cyan);
		this.panelAjouter.setLayout(new GridLayout(9,2));
		this.panelAjouter.add(new JLabel("Id :"));
		this.panelAjouter.add(this.tfId);
		this.panelAjouter.add(new JLabel("Id famille :"));
		this.panelAjouter.add(this.tfId_famille);
		this.panelAjouter.add(new JLabel("Id sous famille :"));
		this.panelAjouter.add(this.tfId_sous_famille);
		this.panelAjouter.add(new JLabel("Nom :"));
		this.panelAjouter.add(this.tfNom);
		this.panelAjouter.add(new JLabel("Code article :"));
		this.panelAjouter.add(this.tfCode_article);
		this.panelAjouter.add(new JLabel("D�signation:"));
		this.panelAjouter.add(this.tfDesignation);
		this.panelAjouter.add(new JLabel("Prix unitaire :"));
		this.panelAjouter.add(this.tfPrix_unitaire);
		this.panelAjouter.add(new JLabel("Quantit� :"));
		this.panelAjouter.add(this.tfQuantite);
		this.panelAjouter.setVisible(true);

		//construction du panel lister
		this.panelLister.setBounds(0, 0, 900, 300);
		this.panelLister.setBackground(Color.GRAY);
		this.panelLister.setLayout(null);
		this.lbLister.setBounds(100, 20, 100, 20);
		this.panelLister.add(this.lbLister);
		this.btFermer.setBounds(300, 10, 100, 20);
		this.btRefresh.setBounds(400, 10, 100, 20);
		this.panelLister.add(this.btRefresh);
		this.panelLister.add(this.btFermer);
		this.panelLister.setVisible(true);

		//construction du panel gerer article
		this.panelArticle.setBounds(150, 0, 1050, 600);
		this.panelArticle.setLayout(null);
		this.panelArticle.add(this.panelLister);
		this.panelArticle.add(this.panelAjouter);
		this.panelArticle.add(this.panelBouton);
		this.panelArticle.setVisible(false);
		this.add(this.panelArticle);
		
		//rendre les bouton clickable
		this.btAjouter.addActionListener(this);
		this.btArticle.addActionListener(this);
		this.btRechercher.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		this.btQuitter.addActionListener(this);
		this.btAnnuler.addActionListener(this);
		this.btAjouter.addActionListener(this);
		this.btFermer.addActionListener(this);
		this.btOk.addActionListener(this);
		this.btRefresh.addActionListener(this);
		
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

		System.out.println("Donner la d�signation : ");
		unArticle.setDesignation(Console.saisirString());
		
		System.out.println("Donner le prix unitaire : ");
		unArticle.setPrix_unitaire(Console.saisirFloat());
		
		System.out.println("Donner la quantit� : ");
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
			this.panelClient.setVisible(true);
			this.panelArticle.setVisible(false);
			this.panelStats.setVisible(false);
		}
		else
		{
			if(e.getSource()==this.btArticle)
			{
				this.panelClient.setVisible(false);
				this.panelArticle.setVisible(true);
				this.panelStats.setVisible(false);
				//this.tabArticles.repaint();
				String titres[] = {"id", "id_famille", "id_sous_famille", "Nom", "code_article", "D�signation", "Prix_unitaire", "Qantit�"};
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
			}
			else
			{
				if(e.getSource()==this.btStats)
				{
					this.panelClient.setVisible(false);
					this.panelArticle.setVisible(false);
					this.panelStats.setVisible(true);
				}
				else
				{
					if(e.getSource()==this.btSupprimer)
					{
						
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
										JOptionPane.showMessageDialog(this, "Erreur de saisie de la quantit�");
										this.tfQuantite.setBackground(Color.red);
									}
									try{
										if(ok == true)
										{
											Article unArticle = new Article(id, id_famille, id_sous_famille, nom, code_article, designation, prix_unitaire, quantite);
											Modele.insertArticle(unArticle);
											JOptionPane.showMessageDialog(this, "Insertion r�ussi !");
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
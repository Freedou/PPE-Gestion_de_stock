package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.ModeleStat;

@SuppressWarnings({ "serial" })
public class VueStats extends JFrame implements ActionListener, MouseListener{
	
	
	private JPanel panelMenu=new JPanel();
	private JPanel panelStats=new JPanel();

	
	private JButton btArticle = new JButton("Gérer les articles");
	private JButton btClients = new JButton("Gerer clients");
	private JButton btStats = new JButton("Voir statistiques");
	private JButton btQuitter = new JButton("Quitter");
	//@SuppressWarnings({"rawtypes"})	
	//construction des objet lister
	private JTable tabStats = new JTable();
	private JScrollPane scrollStats = new JScrollPane();
	@SuppressWarnings("rawtypes")
	private JComboBox cbxStats= new JComboBox();
	
	public VueStats()
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
		
		//construction du panel statistique
		this.panelStats.setBounds(150, 0, 1050, 600);
		this.panelStats.setLayout(null);
		this.panelStats.setBackground(Color.GRAY);
		this.scrollStats.setBounds(10, 40, 1000, 500);
		this.cbxStats.setBounds(10, 10, 1000, 20);
		this.remplirCbx();
		this.panelStats.add(this.cbxStats);
		this.panelStats.setVisible(true);		
		this.add(panelStats);

		
		
		//rendre les bouton clickable
		this.btArticle.addActionListener(this);
		this.btQuitter.addActionListener(this);
		this.btClients.addActionListener(this);
		this.btStats.addActionListener(this);
		this.cbxStats.addActionListener(this);
		this.setVisible(true);
	}
	
	@SuppressWarnings("unchecked")
	public void remplirCbx()
	{
		this.cbxStats.removeAllItems();
		this.cbxStats.addItem("");
		this.cbxStats.addItem("Stats nb commande");
		this.cbxStats.addItem("Users par ordre alphabetique");
		this.cbxStats.addItem("Article par prix croissant");
		this.cbxStats.addItem("Article par prix decroissant");
		this.cbxStats.addItem("Client par nombre de commandes croissant");
		this.cbxStats.addItem("Client par nombre de commandes decroissant");
		this.cbxStats.addItem("Client par nombre d'articles croissant");
		this.cbxStats.addItem("Client par nombre d'articles decroissant");
		this.cbxStats.addItem("Article le plus commande");
		this.cbxStats.addItem("Clients ayant deja valide une commande");
		this.cbxStats.addItem("Clients n'ayant pas valide de commande");
		this.cbxStats.addItem("Nombre de commandes ce jour");
		this.cbxStats.addItem("Nombre de commandes ce mois");
		this.cbxStats.addItem("Les clients ayant depense le plus");
	}
	
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==this.btClients)
		{
			new VueClient();
			this.dispose();
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
						if(e.getSource()==this.cbxStats)
						{
							Object donnees[][] = null;
							DefaultTableModel dm = null;
							switch(this.cbxStats.getSelectedItem()+"")
							{
							case "Stats nb commande" :
								donnees = ModeleStat.ListerNbCommande();
								String titres[] = {"Id", "Nom", "Prenom", "Nb commandes", "Nb Articles"};
								this.tabStats.addMouseListener(this);
								dm = new DefaultTableModel(donnees, titres);
								this.tabStats.setModel(dm);
								this.scrollStats.setViewportView(this.tabStats);
								this.scrollStats.setVisible(true);
								this.panelStats.add(scrollStats);
								break;
							case "Users par ordre alphabetique" :
								donnees = ModeleStat.Listerproc1();
								String titres1[] = {"Id", "Nom", "Prenom", "mail"};
								this.tabStats.addMouseListener(this);
								dm = new DefaultTableModel(donnees, titres1);
								this.tabStats.setModel(dm);
								this.scrollStats.setViewportView(this.tabStats);
								this.scrollStats.setVisible(true);
								this.panelStats.add(scrollStats);
								break;
							case "Article par prix croissant" :
								donnees = ModeleStat.ProcArtPrixASC();
								String titres2[] = {"Id", "Nom", "Code article", "Prix"};
								this.tabStats.addMouseListener(this);
								dm = new DefaultTableModel(donnees, titres2);
								this.tabStats.setModel(dm);
								this.scrollStats.setViewportView(this.tabStats);
								this.scrollStats.setVisible(true);
								this.panelStats.add(scrollStats);
								break;
							case "Article par prix decroissant" :
								donnees = ModeleStat.ProcArtPrixDESC();
								String titres3[] = {"Id", "Nom", "Code article", "Prix"};
								this.tabStats.addMouseListener(this);
								dm = new DefaultTableModel(donnees, titres3);
								this.tabStats.setModel(dm);
								this.scrollStats.setViewportView(this.tabStats);
								this.scrollStats.setVisible(true);
								this.panelStats.add(scrollStats);
								break;
							case "Client par nombre de commandes croissant" :
								donnees = ModeleStat.ProcUsrNbCommASC();
								String titres4[] = {"Id", "Nom", "Prenom", "Nb commande"};
								this.tabStats.addMouseListener(this);
								dm = new DefaultTableModel(donnees, titres4);
								this.tabStats.setModel(dm);
								this.scrollStats.setViewportView(this.tabStats);
								this.scrollStats.setVisible(true);
								this.panelStats.add(scrollStats);
								break;
							case "Client par nombre de commandes decroissant" :
								donnees = ModeleStat.ProcUsrNbCommDESC();
								String titres5[] = {"Id", "Nom", "Prenom", "Nb commande"};
								this.tabStats.addMouseListener(this);
								dm = new DefaultTableModel(donnees, titres5);
								this.tabStats.setModel(dm);
								this.scrollStats.setViewportView(this.tabStats);
								this.scrollStats.setVisible(true);
								this.panelStats.add(scrollStats);
								break;
							case "Client par nombre d'articles croissant" :
								donnees = ModeleStat.ProcUsrNbArtASC();
								String titres6[] = {"Id", "Nom", "Prenom", "Nb articles"};
								this.tabStats.addMouseListener(this);
								dm = new DefaultTableModel(donnees, titres6);
								this.tabStats.setModel(dm);
								this.scrollStats.setViewportView(this.tabStats);
								this.scrollStats.setVisible(true);
								this.panelStats.add(scrollStats);
								break;
							case "Client par nombre d'articles decroissant" :
								donnees = ModeleStat.ProcUsrNbArtDESC();
								String titres7[] = {"Id", "Nom", "Prenom", "Nb articles"};
								this.tabStats.addMouseListener(this);
								dm = new DefaultTableModel(donnees, titres7);
								this.tabStats.setModel(dm);
								this.scrollStats.setViewportView(this.tabStats);
								this.scrollStats.setVisible(true);
								this.panelStats.add(scrollStats);
								break;
							case "Article le plus commande":
								donnees = ModeleStat.ProcArtPlusComm();
								String titres8[] = {"Id", "Nom", "Total d'article"};
								this.tabStats.addMouseListener(this);
								dm = new DefaultTableModel(donnees, titres8);
								this.tabStats.setModel(dm);
								this.scrollStats.setViewportView(this.tabStats);
								this.scrollStats.setVisible(true);
								this.panelStats.add(scrollStats);
								break;
							case "Clients ayant deja valide une commande":
								donnees = ModeleStat.ProcClientOk();
								String titres9[] = {"Id", "Nom", "Prenom"};
								this.tabStats.addMouseListener(this);
								dm = new DefaultTableModel(donnees, titres9);
								this.tabStats.setModel(dm);
								this.scrollStats.setViewportView(this.tabStats);
								this.scrollStats.setVisible(true);
								this.panelStats.add(scrollStats);
								break;
							case "Clients n'ayant pas valide de commande":
								donnees = ModeleStat.ProcClientNotOk();
								String titres10[] = {"Id", "Nom", "Prenom"};
								this.tabStats.addMouseListener(this);
								dm = new DefaultTableModel(donnees, titres10);
								this.tabStats.setModel(dm);
								this.scrollStats.setViewportView(this.tabStats);
								this.scrollStats.setVisible(true);
								this.panelStats.add(scrollStats);
								break;
							case "Nombre de commandes ce jour":
								donnees = ModeleStat.ProcNbCommJour();
								String titres11[] = {"Nombre de commande", "Date du jour"};
								this.tabStats.addMouseListener(this);
								dm = new DefaultTableModel(donnees, titres11);
								this.tabStats.setModel(dm);
								this.scrollStats.setViewportView(this.tabStats);
								this.scrollStats.setVisible(true);
								this.panelStats.add(scrollStats);
								break;
							case "Nombre de commandes ce mois":
								donnees = ModeleStat.ProcNbCommMois();
								String titres12[] = {"Nombre de commande", "Mois en cours"};
								this.tabStats.addMouseListener(this);
								dm = new DefaultTableModel(donnees, titres12);
								this.tabStats.setModel(dm);
								this.scrollStats.setViewportView(this.tabStats);
								this.scrollStats.setVisible(true);
								this.panelStats.add(scrollStats);
								break;
							case "Les clients ayant depense le plus":
								donnees = ModeleStat.ProcUsrMaxDepense();
								String titres13[] = {"Id", "Nom", "Prenom", "Dépense totale"};
								this.tabStats.addMouseListener(this);
								dm = new DefaultTableModel(donnees, titres13);
								this.tabStats.setModel(dm);
								this.scrollStats.setViewportView(this.tabStats);
								this.scrollStats.setVisible(true);
								this.panelStats.add(scrollStats);
								break;
							default :
								break;
							}
							
							
							
						}
					}
				}
			}
		}
	}
}

package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings({ "serial" })
public class VueStats extends JFrame implements ActionListener, MouseListener{
	
	
	private JPanel panelMenu=new JPanel();
	private JPanel panelStats=new JPanel();

	
	private JButton btArticle = new JButton("Gérer les articles");
	private JButton btClients = new JButton("Gerer clients");
	private JButton btStats = new JButton("Voir statistiques");
	private JButton btQuitter = new JButton("Quitter");
		
	//construction des objet lister
	private JTable tabStats = new JTable();
	private JScrollPane ScrollStats = new JScrollPane();
	
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
		this.panelStats.setBounds(0, 0, 900, 300);
		this.panelStats.setBackground(Color.GRAY);
		this.ScrollStats.setBounds(20, 60, 860, 230);
		this.panelStats.setLayout(null);
		this.panelStats.setVisible(true);		
		
		//rendre les bouton clickable
		this.btArticle.addActionListener(this);
		this.btQuitter.addActionListener(this);
		this.btClients.addActionListener(this);
		this.btStats.addActionListener(this);
		this.setVisible(true);
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
				}
			}
		}
	}
}

package projetLabyrinthe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame
{
	JPanel menu = new JPanel();
	JButton bMenu = new JButton("Menu");
	Panneau pan = new Panneau();

	public Fenetre(String map)
	{
		this.init();
		this.pan.setMap(map);
		this.setContentPane(pan);

	}

	public Fenetre()
	{
		this.init();
		this.pan.setMap("niv0.txt");
		this.pan.add(bMenu);
		this.setContentPane(pan);

	}

	public void init()
	{
		LabyFichier lf = new LabyFichier();
		this.setTitle("The Labyrinthe of the Death");
		this.setSize(lf.LARGEUR * 64, lf.HAUTEUR * 64 + 28);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.bMenu.addActionListener(new EcouteurBoutonChanger());
		setVisible(true);
	}

	// Méthode qui change le panel de ta fenêtre
	public void changerMenu(String map)
	{
		Panneau pan = new Panneau();
		pan.setMap(map);
		pan.add(bMenu);
		this.setContentPane(pan);
		this.revalidate();
	}

	public void changerMap()
	{
		char numNextMap = this.pan.getMap().charAt(3);
		numNextMap++;
		
		System.out.println("numNextMap : " + numNextMap);
		if (numNextMap < '3' && numNextMap != '/' ) //incrémentation du niveau
		{
			this.pan.setMap("niv" + numNextMap + ".txt");
		} else //affichage map de la victoire
		{
			this.pan.setMap("win.txt");
		}
		this.setContentPane(pan);
		this.revalidate();
	}

	// Ecouteur de ton bouton
	public class EcouteurBoutonChanger implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent clic)
		{
			// TODO Auto-generated method stub
			// Fenetre.this.changerMenu("laby_special.txt");
			System.out.println("Bouton menu cliqué");
			Fenetre.this.changerMap();

		}
	}

}

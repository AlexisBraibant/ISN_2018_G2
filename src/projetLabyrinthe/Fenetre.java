package projetLabyrinthe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import utilensemjava.Lecture;

public class Fenetre extends JFrame
{

	JPanel menu = new JPanel();
	JButton button = new JButton("Start");
	LabyFichier pan;
	Heros H;
	Fantome F;
	boolean jouer;
	ArrayList<Personnage> listePersonnages = new ArrayList<Personnage>();
	ArrayList<Zombie> listeZombie = new ArrayList<Zombie>();
	ArrayList<Fantome> listeFantome = new ArrayList<Fantome>();

	public Fenetre() throws IOException
	{

		// **********
		this.pan = new LabyFichier("niv0.txt");
		this.init();
		this.pan.add(button);

		// ecouter clavier
		this.pan.setFocusable(true);
		this.pan.addKeyListener(new EcouteurClavier());
		// -----------
		this.setContentPane(pan);

	}

	// initialisation de la fenetre
	public void init()
	{
		LabyFichier lf = new LabyFichier();
		this.setTitle("The Labyrinthe of the Death");
		this.setSize(lf.LARGEUR * 64, lf.HAUTEUR * 64 + 28);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.button.addActionListener(new EcouteurBoutonChanger());
		setVisible(true);
	}
	
	

	public int getVieHero()
	{
		return H.hp;
	}

	public void genererPersos()
	{
		listePersonnages.add(H);
		Zombie Z1 = new Zombie(3, 3, 1, 1, this.pan);
		Zombie Z2 = new Zombie(5, 5, 1, 1, this.pan);
		listeZombie.add(Z1);
		listeZombie.add(Z2);
		listePersonnages.add(Z1);
		listePersonnages.add(Z2);
	}

	// TODO g�rer le key listener
	public void lancerPartie() throws IOException
	{
		// gestion du hero
		jouer = true;
		this.pan.setMapName("niv1.txt");
		this.pan.setMap(this.pan.getMapName());
		this.pan.add(button);

		button.setText("Menu");
		// ecouter le clavier
		this.addKeyListener(new EcouteurClavier());
		this.setFocusable(true);
		this.setContentPane(pan);
		this.revalidate();
		// ----------------------------
		// generation des personnages
		H = new Heros(this.pan);
		//genererPersos();
		this.pan.setVieHero(H.hp);
		System.out.println("**************************");

		// --------------------------------------

	}

	// incrementation de la map
	public void changerMap() throws IOException
	{

		// changement de map en lui meme
		char numNextMap = this.pan.getMapName().charAt(3);
		numNextMap++;

		System.out.println("numNextMap : " + numNextMap);
		if (numNextMap < '6' && numNextMap != '/') // incr�mentation du niveau, il faut dire le nb de map
		{
			this.pan.setMapName("niv" + numNextMap + ".txt");
		} else // affichage map de la victoire
		{
			this.pan.setMapName("win.txt");
		}
		this.pan.setMap(this.pan.getMapName());
		this.setContentPane(pan);
		this.revalidate();

		// reaparition du hero:
		H = new Heros(this.pan, H.hp, H.vie);
	}

	private void deplacementHero(KeyEvent e)
	{
		
		// TODO Auto-generated method stub
		char key = e.getKeyChar();
		System.out.println("key : " + key);
		// Fenetre.this.pan.afficheLaby();
		System.out.println("");
		char direction = key;
		// gestion vie
		this.pan.setVieHero(H.getHp());
		H.deplacementCollision(direction, this.pan, jouer, 'H', listePersonnages);
		// ariver sur le passage
		if (H.getTile() == 'O')
		{
			try
			{
				Fenetre.this.changerMap();
			} catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}
	}


	// ecouteur clavier
	public class EcouteurClavier implements KeyListener
	{

		@Override
		public void keyPressed(KeyEvent e)
		{
			Fenetre.this.deplacementHero(e);
			// TODO d�placement monstres
			Monstre.deplacementDesMonstre(Fenetre.this.pan, jouer, listeZombie, listeFantome, listePersonnages);
			// rafraichissement
			Fenetre.this.setContentPane(pan);
			Fenetre.this.revalidate();
		}

		@Override
		public void keyReleased(KeyEvent e)
		{
			// TODO Auto-generated method stub
			// char key = e.getKeyChar();
			// System.out.println("key : "+key);

		}

		@Override
		public void keyTyped(KeyEvent e)
		{
			// TODO Auto-generated method stub

		}

	}
	

	// Ecouteur du bouton
	public class EcouteurBoutonChanger implements ActionListener
	{
		// TODO lancer la partie la premi�re fois puis apr�s on verra
		@Override
		public void actionPerformed(ActionEvent clic)
		{
			System.out.println("Bouton menu cliqu�");
			if (Fenetre.this.pan.getMapName() == "niv0.txt")
			{
				try
				{
					lancerPartie();
				} catch (IOException e)
				{
					e.printStackTrace();
				}

			} else
			{

				try
				{
					Fenetre.this.changerMap();
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}

		}
	}
}

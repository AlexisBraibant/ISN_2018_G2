package projetLabyrinthe;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.text.html.StyleSheet.ListPainter;

import org.omg.Messaging.SyncScopeHelper;

import utilensemjava.Lecture;

public class Fenetre extends JFrame
{

	JPanel menu = new JPanel();
	JButton button = new JButton("Start");
	String[] maps =
	{ "niv0.txt", "niv1.txt", "niv2.txt", "niv3.txt", "niv4.txt", "niv5.txt", "win.txt" };
	Integer[] listeNumMaps =
	{ 1, 2, 3, 4, 5 };
	public int numMap = 0;
	JComboBox<Integer> comboBox = new JComboBox<Integer>(listeNumMaps);
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
		this.pan.add(comboBox);
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
		
		listePersonnages = new ArrayList<Personnage>();
		listeZombie = new ArrayList<Zombie>();
		listeFantome = new ArrayList<Fantome>();
		listePersonnages.add(H);
		Zombie Z1 = new Zombie(1, 1, this.pan, listeZombie, listePersonnages);
		Zombie Z2 = new Zombie(1, 1, this.pan, listeZombie, listePersonnages);
		Fantome F = new Fantome(1, 1, this.pan, listeFantome, listePersonnages);
		// System.out.println(listePersonnages);
		
	}


	// TODO gérer le key listener
	public void lancerPartie() throws IOException
	{
		// gestion du hero
		jouer = true;
		this.pan.setMapName("niv1.txt");
		numMap = 1;
		this.pan.setMap(this.pan.getMapName());
		this.pan.add(button);

		button.setText("Select level");
		// ecouter le clavier
		this.addKeyListener(new EcouteurClavier());
		this.setFocusable(true);
		this.setContentPane(pan);
		this.revalidate();
		// ----------------------------
		// generation des personnages
		H = new Heros(this.pan);
		genererPersos();
		this.pan.setVieHero(H.hp);
		System.out.println("**************************");

		// --------------------------------------

	}

	// incrementation de la map
	public void changerMap() throws IOException
	{

		// changement de map en lui meme
		/*
		 * char numNextMap = this.pan.getMapName().charAt(3); numNextMap++;
		 * 
		 * System.out.println("numNextMap : " + numNextMap); if (numNextMap < '6' &&
		 * numNextMap != '/') // incrémentation du niveau, il faut dire le nb de map {
		 * this.pan.setMapName("niv" + numNextMap + ".txt"); } else // affichage map de
		 * la victoire { this.pan.setMapName("win.txt"); }
		 * this.pan.setMap(this.pan.getMapName()); this.setContentPane(pan);
		 * this.revalidate();
		 * 
		 * // reaparition du hero: H = new Heros(this.pan, H.hp, H.vie);
		 */

		this.pan.setMap(maps[++numMap]);
		this.setContentPane(pan);
		this.revalidate();

		// reaparition du hero:
		H = new Heros(this.pan, H.getHp(), H.getVie(), H.getBourse());
		genererPersos();
		if (numMap > 5)
		{
			this.pan.setDrawPerso(false);
		}

	}

	public void changerMap(int numeroMap) throws IOException
	{

		// changement de map en lui meme
		numMap = numeroMap + 1;
		System.out.println("--> " + numMap);
		this.pan.setMap(maps[numMap]);
		this.setContentPane(pan);
		this.revalidate();

		// reaparition du hero:
		H = new Heros(this.pan);
		genererPersos();
	}

	
	public int getNumMap()
	{
		return numMap;
	}

	public void setNumMap(int numMap)
	{
		this.numMap = numMap;
	}

	private void deplacementHero(KeyEvent e)
	{

		char key = e.getKeyChar();
		System.out.println("key : " + key);
		// Fenetre.this.pan.afficheLaby();
		System.out.println("");
		char direction = key;
		// gestion vie
		H.deplacementCollision(direction, this.pan, jouer, 'H', listePersonnages);
		this.pan.setVieHero(H.getHp());
		// System.out.println("BOURSE: "+H.getBourse());
		this.pan.setBourse(H.getBourse());
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
			Monstre.deplacementDesMonstre(Fenetre.this.pan, jouer, listeZombie, listeFantome, listePersonnages);
			if (H.isDead())
			{
				Fenetre.this.pan.setDrawPerso(false);
				Fenetre.this.pan.setGameOver(true);
			}
			// rafraichissement
			Fenetre.this.setContentPane(pan);
			Fenetre.this.revalidate();
		}

		@Override
		public void keyReleased(KeyEvent e)
		{
		}

		@Override
		public void keyTyped(KeyEvent e)
		{
		}

	}

	// Ecouteur du bouton
	public class EcouteurBoutonChanger implements ActionListener
	{
		// TODO lancer la partie la première fois puis après on verra
		@Override
		public void actionPerformed(ActionEvent clic)
		{
			System.out.println("Bouton menu cliqué");
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
					Fenetre.this.changerMap(comboBox.getSelectedIndex());
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}

		}
	}
}

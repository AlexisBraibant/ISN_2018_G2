package projetLabyrinthe;

import javax.swing.JFrame;

public class Fenetre extends JFrame
{
	/**
	 * Afficeh le labyrinthe dans une fenêtre
	 * @param map  
	 *		Choisie la map afficher à l'écran
	 */
	public Fenetre(String map) {
		this.setTitle("The Labyrinthe of the Death");
		this.setSize(640, 7*64+28);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		Panneau pan = new Panneau();
		pan.setMap(map);
		this.setContentPane(pan);
		
		this.setVisible(true);		
	}
	
}

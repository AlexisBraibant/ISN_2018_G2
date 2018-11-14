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
	
	
	public Fenetre(String map) {
		this.init();
		Panneau pan = new Panneau();
		pan.setMap(map);
		this.setContentPane(pan);
		
			
	}
	
	public Fenetre() {
		this.init();
		this.bMenu.addActionListener(new EcouteurBoutonChanger());
		this.menu.add(bMenu);
		this.setContentPane(this.menu);
		
	}
	
	public void init() {
		this.setTitle("The Labyrinthe of the Death");
		this.setSize(640, 7*64+28);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		setVisible(true);
	}
	 //Méthode qui change le panel de ta fenêtre
    public void changerMenu(String map){
    	Panneau pan = new Panneau();
		pan.setMap(map);
		pan.add(bMenu);
        this.setContentPane(pan);
        this.revalidate();
    }
     
    //Ecouteur de ton bouton
    public class EcouteurBoutonChanger implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent clic)
		{
			// TODO Auto-generated method stub
			Fenetre.this.changerMenu("laby_special.txt");
			System.out.println("Bouton menu cliqué");
			
		}
    }
	
}

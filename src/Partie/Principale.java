package Partie;

import java.io.IOException;
import java.util.ArrayList;

import projetLabyrinthe.Fantome;
import projetLabyrinthe.Fenetre;
import projetLabyrinthe.Heros;
import projetLabyrinthe.LabyFichier;
import projetLabyrinthe.Personnage;
import projetLabyrinthe.Zombie;
import utilensemjava.Lecture;

public class Principale
{
	public static void main(String[] args) throws IOException
	{
		// testSprint3_Zombie();
		// testSprint3_Fantome();
		testSprint4_2Zombie();
		// testSprint2_AffichageLaby();
	}

	/*private static void testSprint1() throws IOException
	{
		System.out.println("--- testSprint1: affichage console du laby + déplacement héros ---");
		boolean jouer = true;
	
		LabyFichier Labyrinthe = new LabyFichier("laby_special.txt");
		Heros H = new Heros(Labyrinthe);
	
		while (!H.isDead())
		{
			Labyrinthe.afficheLaby();
			System.out.println("");
			char direction = Lecture.lireCaractere("Dans quel direction aller?(zqsd) : ");
			H.deplacement(direction, Labyrinthe, jouer, 'H');
		}
	}*/

	private static void testSprint2_AffichageLaby() throws IOException
	{
		System.out.println("--- testSprint2_AffichageLaby ---");
		Fenetre fen = new Fenetre();
	}

	/*private static void testSprint2_Monstre() throws IOException
	{
		System.out.println("--- testSprint1: affichage console du laby + déplacement héros ---");
		boolean jouer = true;
	
		LabyFichier Labyrinthe = new LabyFichier("laby_special.txt");
		Heros H = new Heros(Labyrinthe);
	
		Monstre M = new Monstre(5, 5, 4, 4, Labyrinthe);
	
		System.out.println(H.isDead());
		while (!H.isDead())
		{
			Labyrinthe.afficheLaby();
			System.out.println("");
			String dir = Lecture.lireChaine("Dans quel direction aller?(zqsd) : ");
			char direction = dir.charAt(0);
			H.deplacement(direction, Labyrinthe, jouer, 'H');
			//M.deplacement(M.deplacementAleatoirePo(Labyrinthe), Labyrinthe, jouer, 'M');
		}
	}*/

	/*private static void testSprint3_Zombie() throws IOException
	{
		System.out.println(
				"--- testSprint3: affichage console du laby + déplacement héros + deplacement zombie (sans gestion de collision)");
		boolean jouer = true;
	
		LabyFichier Labyrinthe = new LabyFichier("niv1.txt");
	
		Heros H = new Heros(Labyrinthe);
		Zombie Z = new Zombie(5, 5, 4, 4, Labyrinthe);
	
		while (!H.isDead())
		{
			Labyrinthe.afficheLaby();
			System.out.println("");
			String dir = Lecture.lireChaine("Dans quel direction aller?(zqsd) : ");
			char direction = dir.charAt(0);
			H.deplacement(direction, Labyrinthe, jouer, 'H');
			Z.deplacement(Z.deplacementAleatoire(Labyrinthe), Labyrinthe, jouer, Z.getTilePerso());
		}
	}*/

	private static void testSprint3_Fantome() throws IOException
	{
		System.out.println(
				"--- testSprint3: affichage console du laby + déplacement héros + deplacement fantome (sans gestion de collision)");
		boolean jouer = true;
		LabyFichier Labyrinthe = new LabyFichier("niv1.txt");

		Heros H = new Heros(Labyrinthe);
		Fantome F = new Fantome(5, 5, 4, 4, Labyrinthe);

		while (!H.isDead())
		{
			Labyrinthe.afficheLaby();
			System.out.println("");
			String dir = Lecture.lireChaine("Dans quel direction aller?(zqsd) : ");
			char direction = dir.charAt(0);
			ArrayList<Personnage> ListPersonnage = new ArrayList<Personnage>();
			ArrayList<Personnage> ListFantome = new ArrayList<Personnage>();
			H.deplacement(direction, Labyrinthe, jouer, 'H',ListPersonnage);
			F.deplacement(F.deplacementAleatoire(Labyrinthe), Labyrinthe, jouer, F.getTilePerso(),ListFantome);
		}
	}

	private static void testSprint4_2Zombie() throws IOException
	{
		// Créer une liste de monstres et tester qu'on les tue et qu'ils disparaissent.
		ArrayList<Personnage> ListPersonnage = new ArrayList<Personnage>();
		ArrayList<Fantome> ListFantome = new ArrayList<Fantome>();
		ArrayList<Zombie> ListZombie = new ArrayList<Zombie>();
		boolean jouer = true;

		LabyFichier Labyrinthe = new LabyFichier("niv1.txt");

		Heros H = new Heros(Labyrinthe);
		Zombie Z1 = new Zombie(5, 5, 1, 1, Labyrinthe);
		Zombie Z2 = new Zombie(3, 3, 1, 1, Labyrinthe);

		ListZombie.add(Z1);
		ListZombie.add(Z2);

		ListPersonnage.add(H);
		ListPersonnage.add(Z1);
		ListPersonnage.add(Z2);

		while (!H.isDead())
		{
			Labyrinthe.afficheLaby();
			System.out.println("");
			String dir = Lecture.lireChaine("Dans quel direction aller?(zqsd) : ");
			char direction = dir.charAt(0);
			H.deplacementCollision(direction, Labyrinthe, jouer, 'H', ListPersonnage);
			for (int i = 0; i < ListZombie.size(); i++)
			{
				Zombie nom = ListZombie.get(i);
				nom.deplacementCollision(nom.deplacementAleatoire(Labyrinthe), Labyrinthe, jouer, nom.getTilePerso(),
						ListPersonnage);
			}
		}
	}
}
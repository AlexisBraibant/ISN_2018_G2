package projetLabyrinthe;

public abstract class Monstre extends Personnage
{

	public Monstre(int xx, int yy, int h, int v, LabyFichier Lab)
	{
		this.coorX = xx;
		this.coorY = yy;
		this.hp = h;
		this.vie = v;
		this.tile = Lab.getMap()[coorX][coorY];
		this.enVie = true;
		this.degat = 1;
	}

	public char directionAleatoire()
	{
		char[] liste_dir =
			{ 'z', 'q', 's', 'd' };
		int aleat = (int) (Math.random() * 4);
		return liste_dir[aleat];
	}

}

package projetLabyrinthe;

public abstract class Personnage
{
	protected int hp;
	protected int vie;
	protected int coorX;
	protected int coorY;
	protected int degat;
	protected boolean enVie;
	protected char tile; // enregistre la case dans laquelle le personnage se trouve
	protected char tilePerso; // valeur à afficher qui est l'image du personnage

	public Personnage()
	{
		setHp(0);
		setVie(0);
		this.enVie = true;
	}

	public Personnage(int xx, int yy, int h, int v)
	{
		coorX = xx;
		coorY = xx;
		hp = h;
		vie = v;
		this.enVie = true;
	}

	public void setHp(int hp)
	{
		this.hp = hp;
	}

	public void setVie(int vie)
	{
		this.vie = vie;
	}

	public int getHp()
	{
		return hp;
	}

	public int getVie()
	{
		return vie;
	}

	public int getCoorX()
	{
		return coorX;
	}

	public int getCoorY()
	{
		return coorY;
	}

	public int getDegat()
	{
		return degat;
	}

	public boolean isDead()
	{
		return !this.enVie;
	}

	public char getTile()
	{
		return tile;
	}

	public char getTilePerso()
	{
		return tilePerso;
	}

	protected boolean deplacementPossible(char direction, LabyFichier Labyrinthe)
	{
		int xApres = this.coorX;
		int yApres = this.coorY;

		if (direction == 'z')
			xApres -= 1;
		if (direction == 's')
			xApres += 1;
		if (direction == 'q')
			yApres -= 1;
		if (direction == 'd')
			yApres += 1;

		if (xApres < 0 || xApres >= Labyrinthe.HAUTEUR || yApres < 0 || yApres >= Labyrinthe.LARGEUR)
		{
			return false;
		}
		System.out.println();
		if (Labyrinthe.getMap()[xApres][yApres] == '#')
		{
			return false;
		}
		return true;
	}

	public void deplacement(char direction, LabyFichier Labyrinthe, boolean jouer, char lettre_perso)
	{
		char[][] map = Labyrinthe.getMap();

		if (deplacementPossible(direction, Labyrinthe))
		{
			switch (direction)
			{
				case 'z':
					map[this.coorX][this.coorY] = tile;
					coorX += -1;
					tile = map[this.coorX][this.coorY];
					map[this.coorX][this.coorY] = lettre_perso;
					break;
				case 's':
					map[this.coorX][this.coorY] = tile;
					coorX += 1;
					tile = map[this.coorX][this.coorY];
					map[this.coorX][this.coorY] = lettre_perso;
					break;
				case 'q':
					map[this.coorX][this.coorY] = tile;
					coorY += -1;
					tile = map[this.coorX][this.coorY];
					map[this.coorX][this.coorY] = lettre_perso;
					break;
				case 'd':
					map[this.coorX][this.coorY] = tile;
					coorY += +1;
					tile = map[this.coorX][this.coorY];
					map[this.coorX][this.coorY] = lettre_perso;
					break;
				case 'm':
					this.enVie = false;
					System.out.println("\n\nLa partie est terminée");
					break;
				default:
					System.out.println("~~~ Mauvais input ~~~\n");
					Labyrinthe.setMap(map);
			}
		}
	}

	public void attaquer(Personnage autre)
	{
		autre.recevoirDegat(this.getDegat());
	}

	public void recevoirDegat(int MontantDeDegat)
	{
		this.hp -= MontantDeDegat;
		if (hp <= 0)
			this.enVie = false;
	}
}

package projetLabyrinthe;

import java.util.ArrayList;

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
	protected int bourse;

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

	public void deplacementCollision(char direction, LabyFichier Labyrinthe, boolean jouer, char lettre_perso,
			ArrayList<Personnage> ListPersonnage)
	{
		char[][] map = Labyrinthe.getMap();

		if (!this.isDead() && deplacementPossible(direction, Labyrinthe))
		{
			boolean laCaseEstVide = true;
			switch (direction)
			{
				case 'z':
					for (int i = 0; i < ListPersonnage.size(); i++)
					{
						if (this.getNom() == "Heros")
						{
							if (ListPersonnage.get(i).coorX == this.coorX - 1
									&& ListPersonnage.get(i).coorY == this.coorY)
							{
								this.attaquer(ListPersonnage.get(i), map, Labyrinthe);
								if (ListPersonnage.get(i).isDead())
								{
									laCaseEstVide = true;
								} else
									laCaseEstVide = false;
							}
						}
						if (this.getNom() == "Monstre")
						{
							if (ListPersonnage.get(0).coorX == this.coorX - 1
									&& ListPersonnage.get(0).coorY == this.coorY)
							{
								this.attaquer(ListPersonnage.get(0), map, Labyrinthe);
								if (ListPersonnage.get(0).isDead())
								{
									laCaseEstVide = true;
								} else
									laCaseEstVide = false;
							}
							if (map[this.coorX - 1][this.coorY] == 'F' || map[this.coorX - 1][this.coorY] == 'Z')
							{
								laCaseEstVide = false;
							}
						}
					}
					if (laCaseEstVide)
					{
						map[this.coorX][this.coorY] = tile;
						coorX += -1;
						tile = map[this.coorX][this.coorY];
						map[this.coorX][this.coorY] = lettre_perso;
					}
					break;
				case 's':
					for (int i = 0; i < ListPersonnage.size(); i++)
					{
						if (this.getNom() == "Heros")
						{
							if (ListPersonnage.get(i).coorX == this.coorX + 1
									&& ListPersonnage.get(i).coorY == this.coorY)
							{
								this.attaquer(ListPersonnage.get(i), map, Labyrinthe);
								if (ListPersonnage.get(i).isDead())
								{
									laCaseEstVide = true;
								} else
									laCaseEstVide = false;
							}
						}
						if (this.getNom() == "Monstre")
						{
							if (ListPersonnage.get(0).coorX == this.coorX + 1
									&& ListPersonnage.get(0).coorY == this.coorY)
							{
								this.attaquer(ListPersonnage.get(0), map, Labyrinthe);
								if (ListPersonnage.get(0).isDead())
								{
									laCaseEstVide = true;
								} else
									laCaseEstVide = false;
							}
							if (map[this.coorX + 1][this.coorY] == 'F' || map[this.coorX + 1][this.coorY] == 'Z')
							{
								laCaseEstVide = false;
							}
						}
					}
					if (laCaseEstVide)
					{
						map[this.coorX][this.coorY] = tile;
						coorX += 1;
						tile = map[this.coorX][this.coorY];
						map[this.coorX][this.coorY] = lettre_perso;

					}
					break;
				case 'q':
					for (int i = 0; i < ListPersonnage.size(); i++)
					{
						if (this.getNom() == "Heros")
						{
							if (ListPersonnage.get(i).coorX == this.coorX
									&& ListPersonnage.get(i).coorY == this.coorY - 1)
							{
								this.attaquer(ListPersonnage.get(i), map, Labyrinthe);
								if (ListPersonnage.get(i).isDead())
								{
									laCaseEstVide = true;
								} else
									laCaseEstVide = false;
							}
						}
						if (this.getNom() == "Monstre")
						{
							if (ListPersonnage.get(0).coorX == this.coorX
									&& ListPersonnage.get(0).coorY == this.coorY - 1)
							{
								this.attaquer(ListPersonnage.get(0), map, Labyrinthe);
								if (ListPersonnage.get(0).isDead())
								{
									laCaseEstVide = true;
								} else
									laCaseEstVide = false;
							}
							if (map[this.coorX][this.coorY - 1] == 'F' || map[this.coorX][this.coorY - 1] == 'Z')
							{
								laCaseEstVide = false;
							}
						}
					}
					if (laCaseEstVide)
					{
						map[this.coorX][this.coorY] = tile;
						coorY += -1;
						tile = map[this.coorX][this.coorY];
						map[this.coorX][this.coorY] = lettre_perso;

					}
					break;
				case 'd':
					for (int i = 0; i < ListPersonnage.size(); i++)
					{
						if (this.getNom() == "Heros")
						{
							if (ListPersonnage.get(i).coorX == this.coorX
									&& ListPersonnage.get(i).coorY == this.coorY + 1)
							{
								this.attaquer(ListPersonnage.get(i), map, Labyrinthe);
								if (ListPersonnage.get(i).isDead())
								{
									laCaseEstVide = true;
								} else
									laCaseEstVide = false;
							}
						}
						if (this.getNom() == "Monstre")
						{
							if (ListPersonnage.get(0).coorX == this.coorX
									&& ListPersonnage.get(0).coorY == this.coorY + 1)
							{
								this.attaquer(ListPersonnage.get(0), map, Labyrinthe);
								if (ListPersonnage.get(0).isDead())
								{
									laCaseEstVide = true;
								} else
									laCaseEstVide = false;
							}
							if (map[this.coorX][this.coorY + 1] == 'F' || map[this.coorX][this.coorY + 1] == 'Z')
							{
								laCaseEstVide = false;
							}
						}
					}
					if (laCaseEstVide)
					{
						map[this.coorX][this.coorY] = tile;
						coorY += +1;
						tile = map[this.coorX][this.coorY];
						map[this.coorX][this.coorY] = lettre_perso;

					}
					break;
				case 'm':
					this.enVie = false;
					System.out.println("\n\nLa partie est terminée");
					break;
				default:
					System.out.println("~~~ Mauvais input ~~~\n");
					Labyrinthe.setMap(map);
			}
			if (this.getNom() == "Heros")
			{
				caseSpe(map);
			}
		}
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

	public void attaquer(Personnage autre, char[][] map, LabyFichier Lab)
	{
		autre.recevoirDegat(this.getDegat(), map, Lab);
	}

	public void recevoirDegat(int MontantDeDegat, char[][] map, LabyFichier Lab)
	{
		this.hp -= MontantDeDegat;
		if (hp <= 0)
		{
			this.enVie = false;
			map[this.coorX][this.coorY] = this.tile;
			Lab.setMap(map);
		}
	}

	public String getNom()
	{
		return null;
	}

	private void caseSpe(char[][] map)
	{
		char currentTile = this.tile;
		if (currentTile == '*' || currentTile == 'X' || currentTile == '$')
		{
			System.out.println("on est sur une case spécial");
			if (currentTile == 'X')
			{
				System.out.println("un piege aïe");
				this.setHp(this.getHp() - 1);
			} else if (currentTile == '*')
			{
				System.out.println("une case magique oui !");
				if (this.getHp() < this.getVie())
				{
					this.setHp(this.getHp() + 1);
				}
				this.tile = ' ';
			} else if (currentTile == '$')
			{
				System.out.println("$.$ de l'argent");
				this.bourse++;
				this.tile = ' ';
			}
		}
	}
}

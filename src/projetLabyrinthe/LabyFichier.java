package projetLabyrinthe;

import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class LabyFichier extends JPanel
{
	public final int LARGEUR = 10;
	public final int HAUTEUR = 7;
	private char[][] map;
	private String mapName;
	private int imgSize = 64;
	private int vieHero;
	private int bourse;
	private boolean drawPerso=true;
	private boolean gameOver=false;
	private boolean victory=false;
	private boolean monstreAttaque=false;
	private boolean heroAttaque=false;
	

	public LabyFichier(String nomFichier) throws IOException
	{
		map = fileToArray("./Map/" + nomFichier);
		mapName = nomFichier;
	}

	public String getMapName()
	{
		return mapName;
	}
	
	
	

	public boolean isMonstreAttaque()
	{
		return monstreAttaque;
	}

	public void setMonstreAttaque(boolean monstreAttaque)
	{
		this.monstreAttaque = monstreAttaque;
	}

	public boolean isHeroAttaque()
	{
		return heroAttaque;
	}

	public void setHeroAttaque(boolean heroAttaque)
	{
		this.heroAttaque = heroAttaque;
	}

	public boolean isVictory()
	{
		return victory;
	}

	public void setVictory(boolean victory)
	{
		this.victory = victory;
	}

	public boolean isGameOver()
	{
		return gameOver;
	}

	public void setGameOver(boolean gameOver)
	{
		this.gameOver = gameOver;
	}

	public boolean isDrawPerso()
	{
		return drawPerso;
	}

	public void setDrawPerso(boolean drawPerso)
	{
		this.drawPerso = drawPerso;
	}

	public void setMapName(String mapName)
	{
		this.mapName = mapName;
	}

	public LabyFichier()
	{
		// juste utile pour récupérer largeur et hauteur
	}

	public char[][] getMap()
	{
		return map;
	}

	public void setMap(char[][] map)
	{
		this.map = map;
	}

	public void setMap(String nomFichier) throws IOException
	{
		this.map = fileToArray("./Map/" + nomFichier);
	}

	public void afficheLaby()
	{
		for (int i = 0; i < this.map.length; i++)
		{
			for (int j = 0; j < this.map[0].length; j++)
			{
				System.out.print(this.map[i][j]);
			}
			System.out.println();
		}
	}

	public void paintComponent(Graphics g)
	{
		try
		{

			char[][] map = this.getMap();
			System.out.println("Labyrinthe affiché:");
			this.afficheLaby();
			Image mur = ImageIO.read(new File("./Textures/mur.png"));
			Image vide = ImageIO.read(new File("./Textures/vide.png"));
			Image entree = ImageIO.read(new File("./Textures/entree.png"));
			Image tresor = ImageIO.read(new File("./Textures/tresor.png"));
			Image passage = ImageIO.read(new File("./Textures/passage.png"));
			Image piege = ImageIO.read(new File("./Textures/piege.png"));
			Image magique = ImageIO.read(new File("./Textures/magique.png"));
			Image hero = ImageIO.read(new File("./Textures/hero.png"));
			Image fantome = ImageIO.read(new File("./Textures/fantome.png"));
			Image zombie = ImageIO.read(new File("./Textures/zombie.png"));
			Image coeur = ImageIO.read(new File("./Textures/coeur.png"));
			Image go = ImageIO.read(new File("./Textures/gameover.png"));
			Image win = ImageIO.read(new File("./Textures/youWin.png"));
			Image hAtk = ImageIO.read(new File("./Textures/heroAttaque.png"));
			Image mAtk = ImageIO.read(new File("./Textures/monstreAttaque.png"));

			// dessin de la map
			for (int i = 0; i < map.length; i++)
			{
				for (int j = 0; j < map[i].length; j++)
				{
					g.drawImage(vide, j * imgSize, i * imgSize, imgSize, imgSize, this);
					switch (map[i][j])
					{
					case '#':
						g.drawImage(mur, j * imgSize, i * imgSize, imgSize, imgSize, this);
						break;
					case 'E':
						g.drawImage(entree, j * imgSize, i * imgSize, imgSize, imgSize, this);
						break;
					case '$':
						g.drawImage(tresor, j * imgSize, i * imgSize, imgSize, imgSize, this);
						break;
					case 'X':
						g.drawImage(piege, j * imgSize, i * imgSize, imgSize, imgSize, this);
						break;
					case '*':
						g.drawImage(magique, j * imgSize, i * imgSize, imgSize, imgSize, this);
						break;
					case 'O':
						g.drawImage(passage, j * imgSize, i * imgSize, imgSize, imgSize, this);
						break;
					default:
						//g.drawImage(vide, j * imgSize, i * imgSize, imgSize, imgSize, this);
						break;
					}
				}
			}
			if (drawPerso)
			{

				// dessin des persos
				for (int i = 0; i < map.length; i++)
				{
					for (int j = 0; j < map[i].length; j++)
					{
						switch (map[i][j])
						{
						case 'H':
							g.drawImage(hero, j * imgSize, i * imgSize, imgSize, imgSize, this);
							break;
						case 'F':
							g.drawImage(fantome, j * imgSize, i * imgSize, imgSize, imgSize, this);
							break;
						case 'Z':
							g.drawImage(zombie, j * imgSize, i * imgSize, imgSize, imgSize, this);
						default:
							break;
						}

					}
				}
				// affichage de l'attatque
				if (heroAttaque)
				{
					g.drawImage(hAtk,9*64, 0, imgSize, imgSize, this);
				}
				if (monstreAttaque)
				{
					g.drawImage(mAtk,8*64, 0, imgSize, imgSize, this);
				}
				// affichage de la vie du heros:
				for (int i = 0; i < vieHero; i++)
				{
					g.drawImage(coeur, 10, i * imgSize / 4, imgSize / 4, imgSize / 4, this);
				}
				// affichage bourse heros
				for (int i = 0; i < bourse; i++)
				{
					g.drawImage(tresor, i * imgSize / 4, 64 * 6, imgSize / 2, imgSize / 2, this);
				}
				
			
			}
			// gestion fin du jeu
			if (gameOver)
			{
				g.drawImage(go,64, 64, imgSize*8, imgSize*5, this);
			}
			
			if (victory)
			{
				g.drawImage(win,64, 64, imgSize*8, imgSize*5, this);
			}
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private static char[][] fileToArray(String nomFichier) throws IOException
	{
		String[] raw = lireFichier(nomFichier).split("\n");
		char[][] res = new char[raw.length][raw[0].split("").length];
		// System.out.println(Arrays.toString(raw));
		// System.out.println("raw.length: " + raw.length);
		for (int i = 0; i < raw.length; i++)
		{
			String[] ligne = raw[i].split("");
			// System.out.println(raw[i]);
			// System.out.println("ligne[i].length: "+ligne.length);
			for (int j = 0; j < ligne.length; j++)
			{
				// System.out.println(ligne);
				// res[i][j] = '1'; //test
				// ************************
				switch (ligne[j])
				{
				// mur
				case "1":
					res[i][j] = '#';
					break;
				// emplacement vide
				case "0":
					res[i][j] = ' ';
					break;
				// entree du laby
				case "2":
					res[i][j] = 'E';
					break;
				// case piege
				case "3":
					res[i][j] = 'X';
					break;
				// case passage
				case "4":
					res[i][j] = 'O';
					break;
				// case magique
				case "5":
					res[i][j] = '*';
					break;
				// case trésor
				case "6":
					res[i][j] = '$';
					break;

				default:
					break;
				}

				// ***********************
			}
		}
		return res;
	}

	public static String lireFichier(String nomFichier) throws IOException
	{
		File f = new File(nomFichier);
		BufferedReader fR = new BufferedReader(new FileReader(f));
		String chaine = "";
		String chaine_totale = "";
		do
		{
			chaine = fR.readLine();
			if (chaine != null)
			{
				chaine_totale += chaine + "\n";
			}
		} while (chaine != null);
		fR.close();
		return (chaine_totale);
	}

	public void setMap(int abscisse, int ordonnee, char carac) // change un caractï¿½re de la map
	{
		// le caractere en haut a gauche est le [0][0]
		if (abscisse >= 0 && ordonnee >= 0 && abscisse < this.HAUTEUR && ordonnee < this.LARGEUR)
		{
			this.map[abscisse][ordonnee] = carac;
		} else
			System.out.println("setMap: Veuillez entrer une abscisse et une ordonnï¿½e valide !");
	}

	public int getVieHero()
	{
		return vieHero;
	}

	public void setVieHero(int vieHero)
	{
		this.vieHero = vieHero;
	}

	public int getBourse()
	{
		return bourse;
	}

	public void setBourse(int bourse)
	{
		this.bourse = bourse;
	}

}

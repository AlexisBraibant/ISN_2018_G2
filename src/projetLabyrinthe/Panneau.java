package projetLabyrinthe;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.omg.Messaging.SyncScopeHelper;

public class Panneau extends JPanel
{
	private int imgSize = 64;
	private String map = "laby1.txt";
	
	public void paintComponent(Graphics g)
	{
		try
		{
			LabyFichier laby = new LabyFichier(map);
			char[][] map = laby.getMap();
			System.out.println("Labyrinthe affiché:");
			laby.afficheLaby();
			Image mur = ImageIO.read(new File("./Textures/mur.png"));
			Image vide = ImageIO.read(new File("./Textures/vide.png"));
			Image entree = ImageIO.read(new File("./Textures/entree.png"));
			Image tresor = ImageIO.read(new File("./Textures/tresor.png"));
			Image passage = ImageIO.read(new File("./Textures/passage.png"));
			Image piege = ImageIO.read(new File("./Textures/piege.png"));
			Image magique = ImageIO.read(new File("./Textures/magique.png"));
			// g.drawImage(mur, 0, 0, imgSize, imgSize, this);

			for (int i = 0; i < map.length; i++)
			{
				// System.out.println(raw[i]);
				// System.out.println("ligne[i].length: "+ligne.length);
				for (int j = 0; j < map[i].length; j++)
				{
					switch (map[i][j])
					{
					// mur
					case '#':
						g.drawImage(mur, j * imgSize, i * imgSize, imgSize, imgSize, this);
						break;
					case 'E':
						g.drawImage(entree, j * imgSize, i * imgSize, imgSize, imgSize, this);
						break;
					case ' ':
						g.drawImage(vide, j * imgSize, i * imgSize, imgSize, imgSize, this);
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
						break;
					}

					// ***********************
				}
			}

		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public String getMap()
	{
		return map;
	}

	public void setMap(String map)
	{
		this.map = map;
	}
}

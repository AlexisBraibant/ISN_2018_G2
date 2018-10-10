package projetLabyrinthe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class LabyFichier
{
	public static int compteur = 0;
	public static final int LARGEUR = 10;
	public static final int HAUTEUR = 7;
	public char[][] map;

	public LabyFichier(String nomFichier) throws IOException {
		map=fileToArray("laby1.txt"); 
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
	
	
	public static char[][] fileToArray(String nomFichier) throws IOException
	{
		String[] raw = lireFichier(nomFichier).split("\n");
		char[][] res = new char[raw.length][raw[0].split("").length];
		// System.out.println(Arrays.toString(raw));
		//System.out.println("raw.length: " + raw.length);
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
				case "1":
					res[i][j] = '#';
					break;
				case "0":
					res[i][j] = ' ';
					break;
				case "2":
					res[i][j] = 'E';
					break;
//				case "\n":
//					// j++
//					break;
				default:
					break;
				}

				// ***********************
			}
		}
		return res;
	}




	private static String lireFichier(String nomFichier) throws IOException
	{
		File f = new File(nomFichier);
		BufferedReader fR = new BufferedReader(new FileReader(f));
		String chaine = "";
		String chaine_totale = "";
		do
		{
			compteur++;
			chaine = fR.readLine();
			if (chaine != null)
			{
				chaine_totale += chaine + "\n";
			}
		} while (chaine != null);
		fR.close();
		compteur--;
		return (chaine_totale);
	}
}

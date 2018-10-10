package projetLabyrinthe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class LabyFichier
{
	public static int compteur = 0;
	
	public static String[] affichageFichier(String nomFichier) throws IOException {
		
		String[] raw = lireFichier(nomFichier).split("");
		String[] res = {};
		for (int i = 0; i < raw.length; i++)
		{
			System.out.println(i);
			System.out.println(raw[i]);
			if (raw[i].equals("1"))
			{
				res[i]="#";
			} else if (raw[i].equals("0")) {
				res[i]=" ";
			} else if (raw[i].equals("2")) {
				res[i]="E";
			}
		}
		System.out.println(Arrays.toString(res));
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
			compteur++;
			chaine = fR.readLine();
			if (chaine != null)
			{
				chaine_totale += chaine + "\n";
			}
		}
		while (chaine != null);
		fR.close();
		compteur--;
		return (chaine_totale);
	}
}

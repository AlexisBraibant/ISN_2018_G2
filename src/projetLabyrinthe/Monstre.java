package projetLabyrinthe;

public class Monstre extends Personnage{

	
	public Monstre() {
		super(0,0,0,0);
	}
	
	public Monstre(int h,int v, LabyFichier Lab ){
		super(0,0,h,v);
		this.tile = Lab.getMap()[coorX][coorY];
	}
	
	public Monstre (int xx, int yy, int h, int v, LabyFichier Lab){
		this.coorX=xx;
		this.coorY=yy;
		this.hp=h;
		this.vie=v;
		this.tile = Lab.getMap()[coorX][coorY];
	}
	
	
	public char directionAleatoire() {
		char[] liste_dir= { 'z','q','s','d'};
		int aleat = (int) (Math.random()*4); 
		return liste_dir[aleat];
	}
	
	//permet de changer de direction si le deplacement n'est pas possible
	public char deplacementAleatoirePo( LabyFichier Labyrinthe) {
		char dir_al;
		boolean deplPoss;
		do {
			dir_al=this.directionAleatoire();
			deplPoss=this.deplacementPossible(dir_al,Labyrinthe);
		}while (!deplPoss);
		return dir_al;
	}
	

}

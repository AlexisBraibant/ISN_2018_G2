package projetLabyrinthe;

public class Monstre extends Personnage{

	private boolean fantome;
	
	public Monstre() {
		super(0,0,0,0);
		setFantome(false);
	}
	
	public Monstre(int h,int v, boolean f){
		super(0,0,h,v);
		fantome=f;
	}
	
	public Monstre (int xx, int yy, int h, int v, boolean f){
		this.coorX=xx;
		this.coorY=yy;
		this.hp=h;
		this.vie=v;
		fantome=f;

	}
	
	public void setFantome(boolean fantome) {
		this.fantome = fantome;
	}
	
	public void directionAlea(boolean init,LabyFichier Labyrinthe){
		int voiesLibre=0;
		int haut=0;
		int bas=0;
		int droite=0;
		int gauche=0;
		char [][] carte = Labyrinthe.getMap();
		int n=carte.length;
		int a =(this.coorX)/n;
		int b =(this.coorY)/n;
		int c =(this.coorX+28)/n;
		int d =(this.coorY+28)/n;
		if(carte[b-1][a]!='1'){					// voie du haut libre ou non
			voiesLibre++;
			haut=1;
		}
		if(carte[b+1][a]!='1'){					// voie du bas libre ou non
			voiesLibre++;
			bas=1;
		}
		if(carte[b][a-1]!='1'){					// voie de gauche libre ou non
			voiesLibre++;
			gauche=1;
		}
		if(carte[b][a+1]!='1'){					// voie de droite libre ou non
			voiesLibre++;
			droite=1;
		}
	}
	

}

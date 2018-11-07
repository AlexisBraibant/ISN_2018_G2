package projetLabyrinthe;

public class Personnage {
	protected int hp;
	protected int vie;
	protected int coorX;
	protected int coorY;
	private int degat;
	private boolean enVie;

	public Personnage() {
		setHp(0);
		setVie(0);
	}
	
	public Personnage(int xx,int yy, int h,int v){
		coorX=xx;
		coorY=xx;
		hp=h;
		vie=v;
	}
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}


}

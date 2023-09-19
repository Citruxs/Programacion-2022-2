public abstract class Pieza {
	protected int x;
	protected int y;
	protected boolean color;

	public Pieza(int x, int y, boolean c){
		this.x = x;
		this.y = y;
		this.color = c;
	}

	public abstract boolean mover(int x,int y, Pieza[][] tablero);
}
public class Peon extends Pieza{

	public Peon(int x, int y, boolean color){
		super(x, y, color);
	}

	@Override
	public boolean mover(int x,int y, Pieza[][] tablero){
		int movx = Math.abs(this.x - x);
		int movy = Math.abs(this.y -y);

		if(movy == 1 && (tablero[x][y] != null && tablero[x][y].color != this.color) && movx != 0){
			return super.diagonalDelantera(x, y, tablero);
		}
		else if(movy != 0){
			return false;
		}
		else if(movx != 1 && movx !=2){
			return false;
		}
		else if((movx == 1)&& tablero[x][y] == null){
			return super.delantera(x, y, tablero);
		}

		else if(movx == 2 && ((x == 4 && this.color == false) || (x == 3 && this.color == true) ) && tablero[x][y] == null){
			return super.delantera(x, y, tablero);
		}
		
		return false;
	}
	public String toString(){
		String s = super.toString();
		s = "Peon: " + s;
		return s;
	}
}
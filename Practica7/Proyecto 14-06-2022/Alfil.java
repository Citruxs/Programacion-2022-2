public class Alfil extends Pieza{
	public Alfil(int x, int y, boolean color){
		super(x, y, color);
	} 

	@Override
	public boolean mover(int x,int y, Pieza[][] tablero){
		int xn = Math.abs(this.x-x);
		int yn = Math.abs(this.y-y);
		if (xn == yn) {
			if(this.y < y){
				return super.diagonalDelantera(x, y, tablero);
			}else{
				return super.diagonalTrasera(x, y, tablero);
			}
			
		}else{
			return false;
		}
	}
	public String toString(){
		String s = super.toString();
		s = "Reina: " + s;
		return s;
	}
}
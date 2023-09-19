public class Rey extends Pieza{
	public Rey(int x, int y, boolean color){
		super(x, y, color);
	} 

	public boolean enJaque(Pieza p, int x, int y, Pieza[][] tablero){
		return false;
	}


	@Override
	public boolean mover(int x,int y, Pieza[][] tablero){
		int xn = Math.abs(this.x-x);
		int yn = Math.abs(this.y-y);
		if (xn > 1 || yn > 1) {
			return false;
		}
		if (xn == yn) {
			if(this.y < y){
				return super.diagonalDelantera(x, y, tablero);
			}else{
				return super.diagonalTrasera(x, y, tablero);
			}
			
		}else{
			//Los casos en para avanzar de forma recta
			if (this.x == x) {
				if (this.y < y) {
					return super.delantera(x, y, tablero);					
				}else{
					return super.trasera(x, y, tablero);
				}				
			}
			if (this.y == y) {
				if (this.x < x) {
					return super.derecha(x, y, tablero);					
				}else{
					return super.izquierda(x, y, tablero);
				}
			}else{
				return false;
			}
		}

	}
	public String toString(){
		String s = super.toString();
		s = "Rey: " + s;
		return s;
	}
}
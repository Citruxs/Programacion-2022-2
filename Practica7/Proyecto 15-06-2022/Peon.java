public class Peon extends Pieza{

	private boolean inicial;

	public Peon(int x, int y, boolean color){
		super(x, y, color);
	}

	@Override
	public boolean mover(int x,int y, Pieza[][] tablero){
		int yn = Math.abs(this.y-y);
		boolean resultado = moverAux(x, y, tablero, yn);

		if (resultado) {
			tablero[this.x][this.y] = null;
			tablero[x][y] = this;
			this.x = x;
			this.y = y;
			inicial = true;
		}
		return resultado;
	}

	private boolean moverAux(int x,int y, Pieza[][] tablero, int distancia){
		if (distancia == 1 || (distancia == 2 && !inicial)) {
			//En esta parte se verifica el movimiento hacia adelante.
			if (this.x == x && this.y < y) {
				return tablero[x][y] == null;
			}
			//En esta parte se verifica el movimiento para comer pieza.
			if (this.y + 1 == y) {
				return tablero[x][y] != null && tablero[x][y].color != this.color;  
			}else{
				return false;
			}
		}else{
			return false;
		}
		
	}
}
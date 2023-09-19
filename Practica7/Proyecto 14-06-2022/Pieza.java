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

	//Aqui suponemos que this.y < y
	protected boolean diagonalDelantera(int x, int y, Pieza[][] tablero){
		
		int aux = this.y+1;
		//Caso cuando se mueve a la derecha
		if (this.x < x) {
			for (int i = this.x + 1; i < x; i++) {
				System.out.println("(" + i + "," +aux+")");
				if (tablero[i][aux] != null) {
					return false;
				}
				aux ++;
			}
			//Si el lugar a donde vamos a mover:
			//No hay pieza o tiene un color diferente, la movida es válida.
			if (tablero[x][y] == null || tablero[x][y].color != this.color) {
				tablero[x][y] = tablero[this.x][this.y];
				tablero[this.x][this.y] = null;
				this.x = x;
				this.y = y;
				return true;
			}else{
				//Este caso es cuando en el lugar en donde se va a
				//mover la pieza, hay una pieza del mismo color. 
				return false;
			}
		}else{
			for (int i = this.x-1; i > x; i--) {
				if (tablero[i][aux] != null) {
					return false;
				}
				aux ++;
			}
			//Si el lugar a donde vamos a mover:
			//No hay pieza o tiene un color diferente, la movida es válida.
			if (tablero[x][y] == null || tablero[x][y].color != this.color) {
				tablero[x][y] = tablero[this.x][this.y];
				tablero[this.x][this.y] = null;
				this.x = x;
				this.y = y;
				return true;
			}else{
				//Este caso es cuando en el lugar en donde se va a
				//mover la pieza, hay una pieza del mismo color. 
				return false;
			}
		}

	}

	//Aqui suponemos que this.y < y
	protected boolean diagonalTrasera(int x, int y, Pieza[][] tablero){
		
		int aux = this.y-1;
		//Caso cuando se mueve a la derecha
		if (this.x < x) {
			for (int i = this.x + 1; i < x; i++) {
				System.out.println("(" + i + "," +aux+")");
				if (tablero[i][aux] != null) {
					return false;
				}
				aux --;
			}
			//Si el lugar a donde vamos a mover:
			//No hay pieza o tiene un color diferente, la movida es válida.
			if (tablero[x][y] == null || tablero[x][y].color != this.color) {
				tablero[x][y] = tablero[this.x][this.y];
				tablero[this.x][this.y] = null;
				this.x = x;
				this.y = y;
				return true;
			}else{
				//Este caso es cuando en el lugar en donde se va a
				//mover la pieza, hay una pieza del mismo color. 
				return false;
			}
		}else{
			for (int i = this.x-1; i > x; i--) {
				if (tablero[i][aux] != null) {
					return false;
				}
				aux --;
			}
			//Si el lugar a donde vamos a mover:
			//No hay pieza o tiene un color diferente, la movida es válida.
			if (tablero[x][y] == null || tablero[x][y].color != this.color) {
				tablero[x][y] = tablero[this.x][this.y];
				tablero[this.x][this.y] = null;
				this.x = x;
				this.y = y;
				return true;
			}else{
				//Este caso es cuando en el lugar en donde se va a
				//mover la pieza, hay una pieza del mismo color. 
				return false;
			}
		}

	}

	public String toString(){
		String s = "(" + this.x +"," + this.y +")";
		if (color) {
			s += " blanca";
		}else{
			s+= " negra";
		}
		return s;
	}

}
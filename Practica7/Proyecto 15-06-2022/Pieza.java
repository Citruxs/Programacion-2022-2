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
			return asignarLugar(x, y, tablero);
		}else{
			for (int i = this.x-1; i > x; i--) {
				if (tablero[i][aux] != null) {
					return false;
				}
				aux ++;
			}
			//Si el lugar a donde vamos a mover:
			//No hay pieza o tiene un color diferente, la movida es válida.
			return asignarLugar(x, y, tablero);
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
			return asignarLugar(x, y, tablero);
		}else{
			for (int i = this.x-1; i > x; i--) {
				if (tablero[i][aux] != null) {
					return false;
				}
				aux --;
			}
			//Si el lugar a donde vamos a mover:
			//No hay pieza o tiene un color diferente, la movida es válida.
			return asignarLugar(x, y, tablero);
		}

	}
	//Movimiento recto hacia adelante
	public boolean delantera(int x, int y, Pieza[][] tablero){
		for (int i = this.y + 1; i < y; i++) {
			if (tablero[x][i] != null) {
				return false;
			}
		}
		//Si el lugar a donde vamos a mover:
		//No hay pieza o tiene un color diferente, la movida es válida.
		return asignarLugar(x, y, tablero);

	}

	//Movimiento recto hacia atras
	public boolean trasera(int x, int y, Pieza[][] tablero){
		for (int i = this.y - 1; i > y; i--) {
			if (tablero[x][i] != null) {
				return false;
			}
		}
		//Si el lugar a donde vamos a mover:
		//No hay pieza o tiene un color diferente, la movida es válida.
		return asignarLugar(x, y, tablero);
	}

	//Movimiento rect hacia la derecha
	public boolean derecha(int x, int y, Pieza[][] tablero){
		for (int i = this.x + 1; i < x; i++) {
			if (tablero[i][y] != null) {
				return false;
			}
		}
		//Si el lugar a donde vamos a mover:
		//No hay pieza o tiene un color diferente, la movida es válida.
		return asignarLugar(x, y, tablero);

	}

	//Movimiento recto hacia la izquierda
	public boolean izquierda(int x, int y, Pieza[][] tablero){
		for (int i = this.x - 1; i > x; i--) {
			if (tablero[i][y] != null) {
				return false;
			}
		}
		//Si el lugar a donde vamos a mover:
		//No hay pieza o tiene un color diferente, la movida es válida.
		return asignarLugar(x, y, tablero);
	}



	private boolean asignarLugar(int x, int y, Pieza[][] tablero){
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
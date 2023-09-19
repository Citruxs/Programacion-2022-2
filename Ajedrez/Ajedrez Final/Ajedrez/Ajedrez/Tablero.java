import java.io.Serializable;
public class Tablero implements Serializable{
	private String nombrePartida;
	private String nombreJugador1;
	private String nombreJugador2;
	private boolean turno;
	private boolean jaque;
	private boolean mate;
	private Pieza[][] posiciones;


	public Tablero(String nombrePartida, String nombreJugador1, String nombreJugador2){
		this.turno = true;
		this.nombrePartida = nombrePartida;
		this.nombreJugador1 = nombreJugador1;
		this.nombreJugador2 = nombreJugador2;
		this.posiciones = new Pieza[8][8];
		this.iniciarJuego();
	}

	//Inicializar las piezas.
	public void iniciarJuego(){
		posiciones[0][0] = new Torre(0, 0, true);
		posiciones[0][1] = new Caballo(0, 1, true);
		posiciones[0][2] = new Alfil(0, 2, true);
		posiciones[0][3] = new Reina(0, 3, true);
		posiciones[0][4] = new Rey(0, 4, true);
		posiciones[0][5] = new Alfil(0, 5, true);
		posiciones[0][6] = new Caballo(0, 6, true);
		posiciones[0][7] = new Torre(0, 7, true);
		posiciones[1][0] = new Peon(1, 0, true);
		posiciones[1][1] = new Peon(1, 1, true);
		posiciones[1][2] = new Peon(1, 2, true);
		posiciones[1][3] = new Peon(1, 3, true);
		posiciones[1][4] = new Peon(1, 4, true);
		posiciones[1][5] = new Peon(1, 5, true);
		posiciones[1][6] = new Peon(1, 6, true);
		posiciones[1][7] = new Peon(1, 7, true);
		//
		//...
		//
		posiciones[7][0] = new Torre(7, 0, false);
		posiciones[7][1] = new Caballo(7, 1, false);
		posiciones[7][2] = new Alfil(7, 2, false);
		posiciones[7][3] = new Rey(7, 3, false);
		posiciones[7][4] = new Reina(7, 4, false);
		posiciones[7][5] = new Alfil(7, 5, false);
		posiciones[7][6] = new Caballo(7, 6, false);
		posiciones[7][7] = new Torre(7, 7, false);
		posiciones[6][0] = new Peon(6, 0, false);
		posiciones[6][1] = new Peon(6, 1, false);
		posiciones[6][2] = new Peon(6, 2, false);
		posiciones[6][3] = new Peon(6, 3, false);
		posiciones[6][4] = new Peon(6, 4, false);
		posiciones[6][5] = new Peon(6, 5, false);
		posiciones[6][6] = new Peon(6, 6, false);
		posiciones[6][7] = new Peon(6, 7, false);
	}

	public boolean mover(int x1, int y1, int x2, int y2){
		if (mate) {
			return false;
		}
		if (jaque) {
			//Aqui va codigo
			Pieza p = this.posiciones[x1][y1];

		}
		Pieza p = posiciones[x1][y1];
		if (p!= null) {

			System.out.println("Se esta moviendo la pieza");
			System.out.println(p);
			boolean respuesta = p.mover(x2, y2, this.posiciones);
			System.out.println("Se movió la pieza.");
			System.out.println(p);
			if(respuesta){
				//Hay que revisar si la jugada generó un jaque o un mate
				turno = !turno;
			}

			return respuesta;
		}
		return false;
	}

	public boolean movp(int x1, int y1){
		boolean p = posiciones[x1][y1].color;
		return p;
	}

	//Metodo para saber si la partida sigue siendo activa.
	public boolean partidaActiva(){
		return !mate;
	}

	public boolean getTurno(){
		return turno;
	}
	public String getJugador1(){
		return nombreJugador1;
	}
	public String getJugador2(){
		return nombreJugador2;
	}
	public String getNombrePartida(){
		return nombrePartida;
	}
	public String toString(){

		String s = "";
		for (int i = 0; i < 8 ;i++) {
			for (int j = 0;j < 8 ;j++ ) {
				if (this.posiciones[i][j] != null) {
					Pieza p = this.posiciones[i][j];
					if (p instanceof Reina) {
						s += "Q ";
					}
					if (p instanceof Peon) {
						s += "P ";
					}
					if (p instanceof Torre){
						s += "T ";
					}
					if (p instanceof Rey) {
						s += "K ";
					}
					if (p instanceof Alfil) {
						s += "A ";
					}
					if (p instanceof Caballo){
						s += "C ";
					}
				}else{
					if (i % 2 == 0) {
						if (j % 2 == 0) {
							s += "0 ";
						}else{
							s += "X ";
						}
					}else{
						if (j % 2 != 0) {
							s += "0 ";
						}else{
							s += "X ";
						}
					}
				}
				
			}
			s += "\n";
		}
		return s;
	}
	//Metodo para busacar un rey del color especificado
	//Devuelve true si encuentra al Rey, false en otro caso
	public boolean buscarRey(boolean color){
		for (int i = 0; i < 8 ;i++ ) {
			for (int j = 0; j < 8; j++ ) {
				//En este caso revisamos si existe el Rey del color indicado
				if (posiciones[i][j] != null 
					&& posiciones[i][j] instanceof Rey
					&& posiciones[i][j].color == color) {
					return true;
				}
			}
		}
		return false;
	}
}
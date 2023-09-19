import java.io.Serializable;
public class Tablero implements Serializable{
	private Pieza[][] posiciones;

	public Tablero(){
		this.posiciones = new Pieza[8][8];
	}

	public String toString(){
		String s = "";
		for (int i = 0; i < 8 ;i++) {
			for (int j = 0;j < 8 ;j++ ) {
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
			s += "\n";
		}
		return s;
	}
}
public class Matriz{
	private boolean[][] valores;

	public Matriz(boolean[][] v){
		this.valores = v;
	}
	public String toString(){
		String s = "";
		for (int i = 0; i < this.valores.length; i++) {
			s += "|";
			for (int j = 0;j < this.valores[i].length -1 ;j++ ) {
				s += this.valores[i][j] + " ";
			}
			s += this.valores[i][this.valores[i].length -1];
			s += "|\n";
		}
		return s;
	}
}
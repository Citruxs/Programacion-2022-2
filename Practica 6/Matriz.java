public class Matriz {
    private double[][] m;
    public Matriz(double[][] m){
        this.m = m;
    }

	public static String imprimirFila(double[] arreglo){
		String s = "|";
		for(int i = 0; i < arreglo.length;i++){
			s += arreglo[i] + " ";
		}
		s += "|";

		return s;
	}

	public Matriz suma(Matriz k){
		double[][] valoresSuma = new double[this.m.length][this.m[0].length];
		for (int i = 0;i < this.m.length ; i++ ) {
			for (int j = 0; j < m[i].length; j++){
				valoresSuma[i][j] = this.m[i][j] + k.m[i][j];
			}
		}
		return new Matriz(valoresSuma);
	}


	public String toString(){
		String s = "";
		for(int i = 0; i < m.length; i++){
			s += imprimirFila(m[i]) + "\n";
		}
		return s;
	}


}

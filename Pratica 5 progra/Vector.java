public class Vector{
	
	private double[] v;

	public Vector(double[] v){
		this.v = v;
	}

	public Vector suma(Vector k){
		double[] valoresSuma = new double[this.v.length];
		for (int i = 0;i < this.v.length ; i++ ) {
			valoresSuma[i] = this.v[i] + k.v[i];
		}
		return new Vector(valoresSuma);
	}

	public double producto(Vector l){
		double[] valoresProducto = new double[this.v.length];
		for (int i = 0;i < this.v.length ; i++ ) {
			valoresProducto[i] = this.v[i] * l.v[i];
		}
		double valoresProducto2 = 0;
		for (int i =0; i < this.v.length; i++){
			valoresProducto2 += valoresProducto[i];
		}
		return valoresProducto2;
	}

	public String toString(){
		String s = "(";
		for (int i = 0; i < this.v.length-1; i++ ) {
			s += v[i] + ", ";
		}
		s += v[this.v.length-1];
		s += ")";
		return s;
	}
}
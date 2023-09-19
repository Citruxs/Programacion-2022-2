public class Punto{
	private double coordenadaX;
	private double coordenadaY;

	public Punto(double x, double y){
		this.coordenadaX = x;
		this.coordenadaY = y;
	}

	public double getX(){
		return this.coordenadaX;
	}

	public double getY(){
		return this.coordenadaY;
	}

	public double distancia(Punto p){
		double dx = Math.pow(this.coordenadaX - p.coordenadaX,2);
		double dy = Math.pow(this.coordenadaY - p.coordenadaY,2);
		double r = Math.sqrt(dx + dy);
		//double r = Math.sqrt(
		//                      Math.pow(this.coordenadaX - p.coordenadaX,2) + 
		//                      Math.pow(this.coordenadaY - p.coordenadaY,2)
		//                    );
		return r;
	}

	public Punto puntoMedio(Punto p){
		double xm = (this.coordenadaX + p.coordenadaX)/2;
		double ym = (this.coordenadaY + p.coordenadaY)/2;
		//Punto m = new Punto(xm,ym);
		//return m;
		return new Punto(xm,ym);
	}

	public String toString(){

		String s = "(" + this.coordenadaX + "," + this.coordenadaY + ")";
		return s;
	}

}
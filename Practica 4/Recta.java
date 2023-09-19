public class Recta{

	private double pendiente;
	private double constante;

	public Recta(double m, double c){
		this.pendiente = m;
		this.constante = c;
	}

	public Recta(Punto p, Punto q){
		double my = p.getY() - q.getY();
		double mx = p.getX() - q.getX();
		this.pendiente = my/mx;
		this.constante = -1*this.pendiente*p.getX() + p.getY();
	}

	public String toString(){
		String s = "y = " + this.pendiente +"x" + " + " +this.constante;
		return s;
	}

    public Punto interseccion(Recta r){
        double x = (constante - r.constante)/(r.pendiente-pendiente);
        double y = pendiente*x+constante;
        return new Punto(x,y);
    }
}
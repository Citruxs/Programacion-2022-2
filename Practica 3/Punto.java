public class Punto {
public double x;
public double y;

    public Punto(double x, double y){
        this.x=x;
        this.y=y;
    }

    public String toString(){
        String s = "(" + this.x + "," + this.y + ")";
        return s; 
    }

    public double distancia(Punto p){
        double r = ((p.x-x)*(p.x-x)) + ((p.y-y)*(p.y-y));
        return Math.sqrt(r);
    }
    
    public Punto puntoMedio(Punto p){
        double x1 = (x+p.x)/2;
        double y1 = (y+p.y)/2;
        return new Punto(x1,y1);
    }
}

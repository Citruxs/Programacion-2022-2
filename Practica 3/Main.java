public class Main {
    public static void main(String [] args){
        Punto punto1 = new Punto(5,6);
        Punto punto2 = new Punto(2,8);
	  System.out.println("Tu punto 1 es: " + punto1);
	  System.out.println("Tu punto 2 es: " + punto2);
	  System.out.println("El punto medio entre ambos puntos es: " + punto1.puntoMedio(punto2));
        System.out.println("La distancia entre ambos puntos es: " + punto1.distancia(punto2));
    }
}
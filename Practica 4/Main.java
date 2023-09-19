public class Main{
	public static void main(String[] args) {
        Punto punto1 = new Punto(0,3);
        Punto punto2 = new Punto(1,3.5);
		Recta recta1 = new Recta(2,6);
        Recta recta2 = new Recta(punto1,punto2);

        System.out.println("La recta creada con la pendiente y una constantes es: " + "\n" + recta1);
        System.out.println("La recta creada con 2 puntos es: " + "\n" + recta2);
		System.out.println("El punto de interseccion de ambas rectas es: " + "\n" + recta1.interseccion(recta2));
	}
}
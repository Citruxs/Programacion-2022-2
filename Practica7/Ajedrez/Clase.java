import java.util.Random ;
import java.util.Scanner ;
import java.util.InputMismatchException ;

public class Clase{
    public static void main(String[] args) {
	a() ;
    } // Fin de main

    private static void a() {
	Random r = new Random() ;
	Scanner sc = new Scanner(System.in) ;
	int a = r.nextInt(1000000) ;
	int n = -1 ;
	do {
	    try {
		System.out.println("Adivina mi número") ;
		n = sc.nextInt() ;
		if ( n == a ) {
		    System.out.println("Exito") ;
		    break ;
		} // Fin de if
	    } // Fin de try
	    catch (InputMismatchException e) {
		System.out.println("Lo que escribiste no es un número entero") ;
		sc.next() ;
	    } // Fin de catch
	} while ( n != a ) ;
    } // Fin de a()

} // Fin de la clase Clase


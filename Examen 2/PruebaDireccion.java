/**
 * Clase PruebaDireccion - Contiene un programa para probar el 
 * funcionamiento de los objetos de la clase Direccion.
 *
 */

public class PruebaDireccion {

    public static void main(String [] param) {

	// Declaracion de objetos de la clase Direccion
	Direccion miCasa ;
	Direccion otraCasa ;

	miCasa = new Direccion("Independencia 85", "Contreras", "CDMX",
			       03245, "Mexico") ;
	otraCasa = new Direccion("Independencia 85", "Contreras", "CDMX", 03245, "Mexico") ;

	if (miCasa.equals(otraCasa)) {
	    System.out.println("Las dos direcciones son iguales") ;
	} else {
	    System.out.println("La direccion " + miCasa + " y " +
			       otraCasa + " son distintas") ;
	}

	otraCasa = new Direccion("Independencia 85", "Contreras", 03245) ;
	    
	if (miCasa.equals(otraCasa)) {
	    System.out.println("La direcciones " + miCasa + " y " +
			       " la direccion " + otraCasa + " son iguales") ;
	} else {
	    System.out.println("La direccion " + miCasa + " y " +
			       otraCasa + " son distintas") ;
	}

	miCasa = new Direccion("Alamos 25", "Necaxa", "Puebla",
			       76543, "Mexico") ;

	otraCasa = new Direccion("Guerreros 14", "Popayan", "Tachira",
				 77665, "Colombia") ;

	System.out.println("La direccion " + miCasa + " se encuentra en "
			   + miCasa.obtenerEstado() ) ;
	System.out.println("La direccion " + otraCasa + " se encuentra en "
			   + otraCasa.obtenerEstado() ) ;
	

    }  // Fin de main

}  // Fin de la clase PruebaDireccion
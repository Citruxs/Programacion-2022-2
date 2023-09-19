/**
 * Clase Presidente. Describe a los Presidentes de México
 *
 * @author Andrés Limón Cruz
 *
 */
import java.io.Serializable;
public class Presidente implements Serializable {


    // Atributos
    private String nombre ;
    private String partido ;
    private int a_inicio ;
    private int a_final ;

    // Metodos

    // Constructores
    public Presidente() {
	nombre = "Desconocido" ;
	partido = "Sin partido" ;
	a_inicio = 2020 ;
	a_final = 2024 ;
    }

    public Presidente(String nom, String part, int inicio, int fin) {
	nombre = nom ;
	partido = part ;
	a_inicio = inicio ;
	a_final = fin ;
    }

    // Observadores
    public String obtenerNombre() {
	return nombre ;
    }

    public String obtenerPartido() {
	return partido ;
    }

    public int obtenerInicio() {
	return a_inicio ;
    }

    public int obtenerFinal() {
	return a_final ;
    }

    // Modificadores
    public void asignarNombre(String nom) {
	nombre = nom ;
    }

    public void asignarPartido(String part) {
	partido = part ;
    }

    public void asignarInicio(int inicio) {
	a_inicio = inicio ;
    }

    public void asignarFinal(int fin) {
	a_final = fin ;
    }

    // Especiales
    public String toString() {
	return nombre + " del partido " + partido +
	    " fue presidente de " + a_inicio +
	    " a " + a_final ;
    }

}
/**
 * Clase Direccion. Permite definir y manipular la información 
 * relativa a direcciones.
 *
 */

public class Direccion{
    // Atributos
     private String calleNum;
     private String municipio;
     private String estado;
     private int codigoPostal;
     private String pais;
     //Metodos
    public Direccion(String calleNum, String municipio, String estado, int codigoPostal, String pais){
        this.calleNum = calleNum;
        this.municipio = municipio;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
    }

    public Direccion(String calleNum, String municipio, int codigoPostal){
        this.calleNum = calleNum;
        this.municipio = municipio;
        this.codigoPostal = codigoPostal;
    }

    public Direccion(String calleNum, String municipio, String estado, String pais){
        this.calleNum = calleNum;
        this.municipio = municipio;
        this.estado = estado;
        this.pais = pais;
        if (pais == "Mexico")
        {
        pais = "Mexico";
        }
    }

    public Direccion(String municipio, String estado, String pais){
        this.municipio = municipio;
        if (estado == "CDMX")
        {
        this.estado = "CDMX";
        }

        if (pais == "Mexico")
        {
        this.pais = "Mexico";
        }
    }

    public String toString(){
        String s = "Tu direccion es: "+ calleNum + " " + municipio + " "  + estado +  " " + codigoPostal + " " + pais;
        return s;
    }

    public String obtenerEstado(){
        if(estado == "CDMX")
        {
            estado = "CDMX";
        }
        else if (estado != "CDMX")
        {
            estado = "Provincia";
        }
        else
        {
            estado = "Extranjero";
        }
        return estado;
    }
}




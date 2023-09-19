    import java.util.Scanner ;

    /**
     * Clase Multiplica. Programa que multiplica valores enteros usando
     *                   un método recursivo.
     *
     */
    
    public class Multiplica {
    
        /*
         * Lugar para el método producto
         *
         */
        public static int producto(int a , int b){
            int d = 0;
            if(b == 0){
                d = 0;
            }
            else if(b< 0){
                d = -(a*-b);
            }
            else{
                d = a+(a*(b-1));
            }
            return d;
        }
    
        public static void main(String [] parametros) {
    
        Scanner datos = new Scanner(System.in) ;
    
        int a ;
        int b ;
        int respuesta = 0 ;
    
        System.out.println("Escribe el valor del primer número entero") ;
        a = datos.nextInt() ;
        System.out.println("Escribe el valor del segundo número entero") ;
        b = datos.nextInt() ;
    
        respuesta = producto(a, b) ;
        System.out.println("La multiplicación de " + a + " con " + b +
                  " es: " + respuesta) ;
    
        } // Fin de main
    
    } // Fin de clase Sumar
    

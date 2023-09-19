public class Duda{
   private static void cambia(int x, int y) {
      int tmp = 1 ;

     System.out.println("El metodo recibe como parametros los valores:") ;

     System.out.println("x = " + x + " y = " + y) ;

      tmp = x ;
      x = y ;
      y = x ;

     System.out.println("Antes de terminar el  metodo los valores son:") ;

     System.out.println("x = " + x + " y = " + y) ;

   }
   public static void main(String [] args) {
      int a = 8, b = 4 ;
      System.out.println(" a = " + a + " b = " + b) ;
      cambia(a, b) ;
      System.out.println(" a = " + a + " b = " + b) ;
   }
}
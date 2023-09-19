//Andres Limon Cruz, Facultad de ciencias
public class Main {
    public static void main(String[] args) {
    Pieza[][] tablero = new Pieza[8][8];
    Torre t1 = new Torre(0,0,false);
    Caballo c1 = new Caballo(0, 1, false);
    Alfil a1 = new Alfil(0, 2, false);
    Reina r1 = new Reina(0, 3, false);
    Rey R1 = new Rey(0,4,false);
    Peon p1 = new Peon(0, 5, false);

    Torre t2 = new Torre(0,7,true);
    Caballo c2 = new Caballo(2, 2, true);
    Alfil a2 = new Alfil(5, 7, true);
    Reina r2 = new Reina(4, 7, true);
    Rey R2 = new Rey(1,4,true);
    Peon p2 = new Peon(1, 5, true);



    Matriz tab = new Matriz(tablero);
    System.out.println("El tablero es una matriz de (0,0) a (7,7)");
    System.out.println(tab);

    System.out.println(t2);
    System.out.println(t1);
    System.out.println("Se ha movido a (0,7)");
    System.out.println(t1.mover(0, 7, tablero));

    System.out.println(c2);
    System.out.println(c1);
    System.out.println("Se ha movido a (2,2)");
    System.out.println(c1.mover(2, 2, tablero));

    System.out.println(a2);
    System.out.println(a1);
    System.out.println("Se ha movido a (5,7)");
    System.out.println(a1.mover(5, 7, tablero));

    System.out.println(r2);
    System.out.println(r1);
    System.out.println("Se ha movido a (4,7)");
    System.out.println(r1.mover(4, 7, tablero));

    System.out.println(R2);
    System.out.println(R1);
    System.out.println("Se ha movido a (1,4)");
    System.out.println(R1.mover(1, 4, tablero));

    System.out.println(p2);
    System.out.println(p1);
    System.out.println("Se ha movido a (1,5)");
    System.out.println(p1.mover(1, 5, tablero));


}    
}

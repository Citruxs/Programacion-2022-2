public class Main {
    public static void main(String[] args) {
        Caballo caballob = new Caballo();
        Tablero tableroa = new Tablero();
        Posicion posicion1 = new Posicion();
        boolean[][] a = caballob.posicionesPosibles();
        caballob.setPosicion(posicion1);
        Matriz a1 = new Matriz(a);
        System.out.println(a1);

    }
}

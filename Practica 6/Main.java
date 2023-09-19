public class Main {
    public static void main(String[] args){
        double[][] m1 = {{2,3,2},{3,6,2}};
        double[][] m2 = {{3,4,2},{2,3,2}};
        Matriz matriz1 = new Matriz(m1);
        Matriz matriz2 = new Matriz(m2);
        System.out.println("Tu matriz 1 es: " + "\n" + matriz1);
        System.out.println("Tu matriz 2 es: " + "\n" + matriz2);
        System.out.println("La suma de tus matrices es: " + "\n" +matriz1.suma(matriz2));
    }
}

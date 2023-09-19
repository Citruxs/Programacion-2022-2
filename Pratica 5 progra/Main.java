public class Main {
    public static void main(String [] args){
        double v[] = {-3,5,6,5,7};
        double v2[] = {2,-4,4,5,3};
        Vector vector1 = new Vector(v);
        Vector vector2 = new Vector(v2);
        System.out.println("Tu vector 1 es: " + "\n" + vector1);
        System.out.println("Tu vector 2 es: " + "\n"+ vector2);
        System.out.println("La suma de ambos vectores es: " + "\n" + vector1.suma(vector2));
        System.out.println("El producto punto de ambos vectores es: " + "\n" + vector1.producto(vector2));
    }
}

import java.util.Scanner;
public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame tu numero de cuenta: ");
        String numC = sc.nextLine();
        System.out.println("Dame tu nombre: ");
        String nomb = sc.nextLine();
        System.out.println("Dame tu dia de nacimiento: ");
        int dia = sc.nextInt();
        System.out.println("Dame tu mes de nacimiento: ");
        int mes = sc.nextInt();
        System.out.println("Dame tu año de nacimiento: ");
        int an = sc.nextInt();
        Cuenta cuenta1 = new Cuenta(numC);
        Nombre nombre1 = new Nombre(nomb);
        Fecha fecha1 = new Fecha(dia, mes, an);
        System.out.println("Fecha: " + fecha1);
        System.out.println("Nombre: " + nombre1);
        System.out.println("Numero de cuenta: " + cuenta1);
    }
}
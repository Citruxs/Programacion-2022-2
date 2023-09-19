import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLInvalidAuthorizationSpecException;
public class Main {
    private Scanner lector;

    public Main(){
        lector = new Scanner(System.in);
    }

	public void escribirObjeto(String archivo,Object obj){
		FileOutputStream fos = null;
        ObjectOutputStream salida = null;
        try {
            //Se crea el fichero
            fos = new FileOutputStream(archivo);                                                 
            salida = new ObjectOutputStream(fos);
            //Se escribe el objeto en el fichero
            salida.writeObject(obj);
           
        } catch (Exception e) {
                 System.out.println("1"+e.getMessage());                                                          
        } finally {
            try {
                if(fos!=null){
                   fos.close();
                }
                if(salida!=null){
                   salida.close();
                }
            } catch (Exception e) {
                     System.out.println("3"+e.getMessage());
            }
        }
	}

	public String[] leerTexto(String archivo){
		String texto = "";
		FileReader f = null;
		BufferedReader b = null;
		try{
			f = new FileReader(archivo);
			b = new BufferedReader(f);
			String aux = null;
			do{
				aux = b.readLine();
				if (aux != null) {
					texto += aux + "-";
				}
			}while(aux != null);
			b.close(); 
			String[] lineas = texto.split("-");
			return lineas;
		}catch (Exception e) {
			System.out.println(e);
			System.out.println("Ocurrio un error al leer el archivo " + archivo);
			return null;
		}

	}

    public void presidentes(){
		while(true){

			String[] presidentes = this.leerTexto("Presidentes.txt");
			if (presidentes != null) {
				for (int i = 0; i < presidentes.length; i++) {
					System.out.println((i+1)+". " + presidentes[i]);
				}
			}else{
				System.out.println("Por el momento no hay presidentes en el archivo");
			}

			lector = new Scanner(System.in);
			System.out.println();
			System.out.println("1. Regresar");
			System.out.println("Escribe la opcion:");
			try{
				int opcion = lector.nextInt();
				switch (opcion) {
					case 1:
						return;
					default:
						System.out.println(
							"Escribe una de las opciones disponibles"
						);
						break;
				}
			}catch(Exception e){
				System.out.println(
					"Escribe un numero dentro de la opciones"
				);
			}
		}
	}


    public void menuPrincipal(){
		while(true){
			lector = new Scanner(System.in);
			System.out.println("1. Escribir presidente");
			System.out.println("2. Leer presidentes");
            System.out.println("3. Salir");
			System.out.println("Escribe la opcion");
			try{
				int opcion = lector.nextInt();
				switch (opcion) {
					case 1:
						escribirObjeto("Presidentes.txt", Presidente.class);
						break;
					case 2:
						this.presidentes();
						break;
					case 3:
						return;
					default:
						System.out.println(
							"Escribe una de las opciones disponibles"
						);
						break;
				}
			}catch(Exception e){
				System.out.println(
					"Escribe un numero dentro de la opciones"
				);
			}
		}
	}

	public static void main(String[] args) {
		Main menu = new Main();
		menu.menuPrincipal();
 	}


}

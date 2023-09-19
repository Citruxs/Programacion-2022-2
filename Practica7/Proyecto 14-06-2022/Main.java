import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
public class Main{
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

	public static Object leerObjeto(String archivo){
		FileInputStream fis = null;
        ObjectInputStream entrada = null;
        Object p = null;

        try {

            fis = new FileInputStream(archivo);
            entrada = new ObjectInputStream(fis);
            p = entrada.readObject();                         
   
        } catch (Exception e) {
                 System.out.println(e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (Exception e) {
                     System.out.println(e.getMessage());
            }
        }
        return p;
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

	public void puntaje(){
		while(true){

			String[] puntajes = this.leerTexto("Puntaje.txt");
			if (puntajes != null) {
				for (int i = 0; i < puntajes.length; i++) {
					System.out.println((i+1)+". " + puntajes[i]);
				}
			}else{
				System.out.println("Por el momento no hay puntajes");
			}
			
			//Aqui va la parte donde muestras el puntaje.
			//....
			//Aqui va la parte donde muestras el puntaje.
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
					"Escribe un numero dentro de la opcionessss"
				);
			}
		}
	}

	public void nuevaPartida(){
		//Aqui va la parte de la nueva partida.
	}

	public void buscarPartida(){
		String partida = null;
		while(partida == null || partida.equals("")){
			lector = new Scanner(System.in);
			System.out.println("Escribe el nombre de la partida");
			try{
				partida = lector.nextLine();
			}catch(Exception e){
				System.out.println(
					"Escribe el nombre de la partida que quieres cargar"
				);
			}
		}
		//Aqui va la parte de la carga de partida.
		//Se debe usar la variable partida
		//para cargar el archivo partida, donde
		//debe estar una partida anterior.
	}
	public void cargarPartida(){

		while(true){
			lector = new Scanner(System.in);
			System.out.println("1. Buscar partida");
			System.out.println("2. Regresar");
			System.out.println("Escribe la opcion");
			try{
				int opcion = lector.nextInt();
				switch (opcion) {
					case 1:
						this.buscarPartida();
						break;
					case 2:
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
			System.out.println("1. Puntaje");
			System.out.println("2. Nueva partida");
			System.out.println("3. Cargar partida");
			System.out.println("4. Salir");
			System.out.println("Escribe la opcion");
			try{
				int opcion = lector.nextInt();
				switch (opcion) {
					case 1:
						this.puntaje();
						break;
					case 2:
						this.nuevaPartida();
						break;
					case 3:
						this.cargarPartida();
						break;
					case 4:
						//Aqui va tu codigo.
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
		//Main menu = new Main();
		//menu.menuPrincipal();
		//Tablero t = new Tablero();
		//menu.escribirObjeto("prueba.dat",t);
		//Tablero t = (Tablero) (menu.leerObjeto("prueba.dat"));
		//System.out.println(t);
		Reina r1 = new Reina(2,1, true);
		Reina r2 = new Reina(5,4, false);
		Reina r3 = new Reina(4,3, false);

		Pieza[][] tablero = new Pieza[8][8];
		tablero[2][1] = r1;
		tablero[5][4] = r2;
		//tablero[4][3] = r3;

		System.out.println(r2);
		boolean respuesta = r2.mover(2,1, tablero);
		System.out.println(respuesta);
		System.out.println(r2);
		System.out.println(tablero);
 	}
}

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

	public static boolean randomBoolean(String s){
		return Math.random() < 0.5;
	}

	public void nuevaPartida(){
		//Aqui va la parte de la nueva partida.
		try{
			lector = new Scanner(System.in);
			System.out.println("Escribe el nombre de la partida");
			String nombrePartida = lector.nextLine();
			
			System.out.println("Escribe el nombre del jugador 1");
			String nombreJugador1 = lector.nextLine();
			boolean T1 = randomBoolean(nombreJugador1);
			System.out.println("Escribe el nombre del jugador 2");
			String nombreJugador2 = lector.nextLine();
			//Aqui hay que que elegir de forma aleatoria el nombre
			//que sera el primer jugador entre nombreJugador1 y nombreJugador2
			Tablero nuevaPartida = new Tablero(nombrePartida, nombreJugador1, nombreJugador2);
			while(nuevaPartida.partidaActiva()){
				System.out.println(nuevaPartida);
				if (nuevaPartida.getTurno()) {
					System.out.println("Que pieza quieres mover " + nuevaPartida.getJugador1() + ", puedes mover las piezas de color " + T1);
				}else{
					System.out.println("Que pieza quieres mover " + nuevaPartida.getJugador2() + ", puedes mover las piezas de color " + !T1);
				}
				System.out.println("(Si quieres guardar partida presiona cualquier letra)");
				try{
					lector = new Scanner(System.in);
					System.out.println("Posicion x");
					int posX = lector.nextInt();
					System.out.println("Posicion y");
					int posY = lector.nextInt();
					System.out.println("A donde quieres mover la pieza");
					System.out.println("Posicion x");
					int movX = lector.nextInt();
					System.out.println("Posicion y");
					int movY = lector.nextInt();

					boolean respuesta = nuevaPartida.mover(posX,posY,movX, movY);
					if (!respuesta) {
						System.out.println("Tu movimiento es inválido.");
					}
				}catch (Exception e) {
					System.out.println("Estas seguro que quieres guardar partida?");
					//Aqui falta la opcion de empate.
					//Aqui falta la opcion de retirarse.
					System.out.println("1. Si");
					System.out.println("2. No.");
					System.out.println("3. Salir.");
					lector = new Scanner(System.in);
					int opcion = lector.nextInt();
					switch (opcion) {
						case 1:
							this.escribirObjeto(nuevaPartida.getNombrePartida(),nuevaPartida);
							break;
						case 2:
							break;
						case 3:
							return;
					}

				}
				//Ya hay un jugador que es ganador:
				//Aqui hay que guardar el nombre en el archivo de puntaje

			}


		}catch(Exception e){
			System.out.println("Ocurrio un error inesperado");
		}
		
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



		try{
			Tablero nuevaPartida = (Tablero)(this.leerObjeto(partida));
			
			while(nuevaPartida.partidaActiva()){
				System.out.println(nuevaPartida);
				if (nuevaPartida.getTurno()) {
					System.out.println("Que pieza quieres mover " + nuevaPartida.getJugador1());
				}else{
					System.out.println("Que pieza quieres mover " + nuevaPartida.getJugador2());
				}
				System.out.println("(Si quieres guardar partida presiona cualquir letra)");
				try{
					lector = new Scanner(System.in);
					System.out.println("Posicion x");
					int posX = lector.nextInt();
					System.out.println("Posicion y");
					int posY = lector.nextInt();
					System.out.println("A donde quieres mover la pieza");
					System.out.println("Posicion x");
					int movX = lector.nextInt();
					System.out.println("Posicion y");
					int movY = lector.nextInt();

					boolean respuesta = nuevaPartida.mover(posX,posY,movX, movY);
					if (!respuesta) {
						System.out.println("Tu movimiento es inválido.");
					}
				}catch (Exception e) {
					System.out.println("Estas seguro que quieres guardar partida?");
					System.out.println("1. Si");
					System.out.println("2. No.");
					System.out.println("3. Salir.");
					lector = new Scanner(System.in);
					int opcion = lector.nextInt();
					switch (opcion) {
						case 1:
							this.escribirObjeto(nuevaPartida.getNombrePartida(),nuevaPartida);
							break;
						case 2:
							break;
						case 3:
							return;
					}

				}
				//Ya hay un jugador que es ganador:
				//Aqui hay que guardar el nombre en el archivo de puntaje

			}
		}catch(Exception e){
			System.out.println("No existe la partida.");
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
		Main menu = new Main();
		menu.menuPrincipal();
 	}
}
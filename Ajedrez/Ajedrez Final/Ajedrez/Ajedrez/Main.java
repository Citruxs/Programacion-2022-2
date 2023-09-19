//Facultad de ciencias
//Proyecto Final: Ajedrez
//Integrantes
//-Andres Limon Cruz
//-Aylin Yerami Cobos Luna
//-Sebastian Cruz Castro
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.time.LocalDate;

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

	public void EscribirTexto(String archivo, String jugador, int puntaje){
		FileWriter f = null;
		BufferedWriter b = null;
		PrintWriter p = null;
		try{
			f = new FileWriter(archivo, true);
			p = new PrintWriter(f);
			p.println("El jugador: " + jugador + ", ha ganado un juego, el dia: " + LocalDate.now() + ", Puntos: " + puntaje);

			p.close();
			f.close();

		}catch (Exception e) {
			System.out.println(e);
			System.out.println("Ocurrio un error al ecribir el archivo " + archivo);
			return;
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

	//Metodo para asignar un color aleatorio a los jugadores
	public static boolean randomBoolean(){
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
			System.out.println("Escribe el nombre del jugador 2");
			String nombreJugador2 = lector.nextLine();
			//Aqui hay que que elegir de forma aleatoria el nombre
			//que sera el primer jugador entre nombreJugador1 y nombreJugador2
			boolean T1 = randomBoolean();
			Tablero nuevaPartida = new Tablero(nombrePartida, nombreJugador1, nombreJugador2);
			while(nuevaPartida.partidaActiva()){
				System.out.println(nuevaPartida);
				boolean Turno = T1;
				
				if (nuevaPartida.getTurno()) {
					Turno = T1;
					System.out.println("Que pieza quieres mover " + nuevaPartida.getJugador1() + ", puedes mover las piezas de color " + Turno );
				}else{
					Turno = !T1;
					System.out.println("Que pieza quieres mover " + nuevaPartida.getJugador2() + ", puedes mover las piezas de color " + Turno);
				}
				System.out.println("(Si quieres guardar partida presiona cualquier letra)");
				try{
					System.out.println("Las piezas superiores son true, las inferiores son false");
					lector = new Scanner(System.in);
					System.out.println("Posicion x (Renglones)");
					int posX = lector.nextInt();
					System.out.println("Posicion y (Columnas)");
					int posY = lector.nextInt();
					System.out.println("A donde quieres mover la pieza");
					System.out.println("Posicion x (Renglones)");
					int movX = lector.nextInt();
					System.out.println("Posicion y (Columnas)");
					int movY = lector.nextInt();

					if(nuevaPartida.movp(posX, posY) == Turno){
						boolean respuesta = nuevaPartida.mover(posX,posY,movX, movY);
					}

					else{
						System.out.println("Tu movimiento es inválido.");
					}


				}catch (Exception e) {
					System.out.println("Estas seguro que quieres guardar partida?");

					System.out.println("1. Si");
					System.out.println("2. No.");
					System.out.println("3. Retirarse");
					System.out.println("4. Empate");
					System.out.println("5. Salir.");
					lector = new Scanner(System.in);
					int opcion = lector.nextInt();
					switch (opcion) {
						case 1:
							this.escribirObjeto(nuevaPartida.getNombrePartida(),nuevaPartida);
							break;
						case 2:
							break;
						case 3:
						if (nuevaPartida.getTurno()) {
							System.out.println("Te has retirado del juego " + nuevaPartida.getJugador1());
							System.out.println("El ganador es: " + nuevaPartida.getJugador2());
							EscribirTexto("Puntaje.txt", nuevaPartida.getJugador2(), 1);
						}
						else{
							System.out.println("Te has retirado del juego " + nuevaPartida.getJugador2());
							System.out.println("El ganador es: " + nuevaPartida.getJugador1());
							EscribirTexto("Puntaje.txt", nuevaPartida.getJugador1(), 1);
						}


							return;
						case 4:
						System.out.println("La partida ha sido declarada empate, ningun jugador ha ganado");
							return;
						case 5:
							return;
					}

				}

				if(!nuevaPartida.buscarRey(T1)){
					System.out.println("El juego ha terminado, el ganador es el jugador: " + nuevaPartida.getJugador2());
					EscribirTexto("Puntaje.txt", nuevaPartida.getJugador2(), 1);
					return;
				}

				if(!nuevaPartida.buscarRey(!T1)){
					System.out.println("El juego ha terminado, el ganador es el jugador: " + nuevaPartida.getJugador1());
					EscribirTexto("Puntaje.txt", nuevaPartida.getJugador1(), 1);
					return;
				}
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
						if (nuevaPartida.getTurno()) {
							System.out.println("Te has retirado del juego " + nuevaPartida.getJugador1());
							System.out.println("El ganador es: " + nuevaPartida.getJugador2());
							EscribirTexto("Puntaje.txt", nuevaPartida.getJugador2(), 1);
						}
						else{
							System.out.println("Te has retirado del juego " + nuevaPartida.getJugador2());
							System.out.println("El ganador es: " + nuevaPartida.getJugador1());
							EscribirTexto("Puntaje.txt", nuevaPartida.getJugador1(), 1);
						}


							return;
						case 4:
						System.out.println("La partida ha sido declarada empate, ningun jugador ha ganado");
							return;
						case 5:
							return;
					}

				}
				if(!nuevaPartida.buscarRey(true)){
					System.out.println("El juego ha terminado, el ganador es el jugador: " + nuevaPartida.getJugador2());
					EscribirTexto("Puntaje.txt", nuevaPartida.getJugador2(), 1);
					return;
				}

				if(!nuevaPartida.buscarRey(false)){
					System.out.println("El juego ha terminado, el ganador es el jugador: " + nuevaPartida.getJugador1());
					EscribirTexto("Puntaje.txt", nuevaPartida.getJugador1(), 1);
					return;
				}
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
						System.out.println("Muchas gracias por jugar");
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
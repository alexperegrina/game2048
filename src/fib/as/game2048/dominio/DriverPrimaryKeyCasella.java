package fib.as.game2048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DriverPrimaryKeyCasella {
	private static String NOMBRE_CLASE = "PrimaryKeyCasella";
	
	
	public static void main(String[] args) throws IOException {
		
		String linea;
        String palabras[];
        String opcion;
        Partida partida = new Partida(55);
        String numero;
        
        System.out.println("Driver " + NOMBRE_CLASE );
        
		PrimaryKeyCasella key = new PrimaryKeyCasella();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean salir = false;
//        boolean lista = true;
        
    	mostrarMenu();
    	
    	while (!salir) {
            linea = br.readLine();
            palabras = linea.split(" ");
            opcion = palabras[0];
            
//            System.out.println("Opción " + opcion + " seleccionada.");
            switch (opcion) {
                case "1":
                	key = new PrimaryKeyCasella();
                    break;
                case "2":
                	key = new PrimaryKeyCasella(1, 1);
                    break;
                case "3":
                	key = new PrimaryKeyCasella(2, 2, partida);
                    break;
                case "4":
                	System.out.println("NumeroFila: " + Integer.toString(key.getNumeroFila()));
                    break;
                case "5":
                	numero = br.readLine().split(" ")[0];
                	key.setNumeroFila(Integer.valueOf(numero));
                    break;
                case "6":
                	System.out.println("NumeroColumna: " + Integer.toString(key.getNumeroColumna()));
                    break;
                case "7":
                	numero = br.readLine().split(" ")[0];
                	key.getNumeroColumna(Integer.valueOf(numero));
                    break;
                case "8":
                	System.out.println("Numero: " + key.getPartida());
                    break;
                case "9":
                	key.setPartida(partida);
                    break;
                case "-2":
                	salir = true;
                    break;
            	default:
            		mostrarMenu();
            }
        }
        System.out.println("Fin del driver");
	}
	
	public static void mostrarMenu() {
		System.out.println("Escoge una opción:");
		System.out.println("\t 1) PrimaryKeyCasella()");
		System.out.println("\t 2) PrimaryKeyCasella(Integer numeroFila, Integer numeroColumna) (1,1)");
		System.out.println("\t 3) PrimaryKeyCasella(Integer numeroFila, Integer numeroColumna, Partida partida) (2,2)");
		System.out.println("\t 4) getNumeroFila()");
		System.out.println("\t 5) setNumeroFila(Integer numeroFila)");
		System.out.println("\t 6) getNumeroColumna()");
		System.out.println("\t 7) setNumeroColumna(Integer numeroColumna)");
		System.out.println("\t 8) getPartida()");
		System.out.println("\t 9) setPartida(Partida partida)");
        
        System.out.println("\t -1) Mostrar Menu");
        System.out.println("\t -2) Salir");
        System.out.println(" ");
	}
}

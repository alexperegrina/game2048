package fib.as.game2048.dominio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DriverCasella {
	private static String NOMBRE_CLASE = "Casella";
	Casella c1,c2;
	
	
	public static void main(String[] args) throws IOException {
		System.out.println("Driver " + NOMBRE_CLASE );
		
		Partida partida = new Partida(55);
		Casella casella1 = new Casella();
		Casella casella2 = new Casella();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean salir = false;
//        boolean lista = true;
        while (!salir) {
        	System.out.println("Escoge una opción:");
            
        	System.out.println("\t 1) C1 -- Casella()");
            System.out.println("\t 2) C1 -- Casella(PrimaryKeyCasella key, Integer numero) -- PrimaryKeyCasella(1, 1, partida)");
            System.out.println("\t 3) C1 -- Casella(Integer numeroFila, Integer numeroColumna, Integer numero) -- Casella(1, 1, 1)");
            System.out.println("\t 4) C1 -- Casella(Integer numeroFila, Integer numeroColumna, Integer numero, Partida partida) -- Casella(1, 1, 1, partida)");
            System.out.println("\t 5) C2 -- Casella()");
            System.out.println("\t 6) C2 -- Casella(PrimaryKeyCasella key, Integer numero) -- PrimaryKeyCasella(2, 2, partida)");
            System.out.println("\t 7) C2 -- Casella(Integer numeroFila, Integer numeroColumna, Integer numero) -- Casella(2, 2, 2)");
            System.out.println("\t 8) C2 -- Casella(Integer numeroFila, Integer numeroColumna, Integer numero, Partida partida) -- Casella(2, 2, 2, partida)");

        	
//        	System.out.println("\t 1) Casella()");
//            System.out.println("\t 2) Casella(PrimaryKeyCasella key, Integer numero)");
//            System.out.println("\t 3) Casella(Integer numeroFila, Integer numeroColumna, Integer numero)");
//            System.out.println("\t 4) Casella(Integer numeroFila, Integer numeroColumna, Integer numero, Partida partida) -- partida predefinida");
            
            System.out.println("\t 9) (casella1) - getNumero()");
            System.out.println("\t 10) (casella1) - setNumero(Integer numero)");
            System.out.println("\t 11) (casella1) - assignarPartida(Partida partida)");
            System.out.println("\t 12) (casella1) - fusio(Casella casella) (casella2)");
            System.out.println("\t 13) (casella1) - getNumeroFila()");
            System.out.println("\t 14) (casella1) - getNumeroColumna()");
            System.out.println("\t 15) (casella1) - esBuida()");
            System.out.println("\t 16) (casella1) - copia(Casella casella) (casella2)");
            System.out.println("\t 17) (casella1) - duplica()");
            System.out.println("\t 18) (casella1) - buida()");
            
            System.out.println("\t 19) (casella1) - getNumero()");
            
            System.out.println("\t -1) Salir");
            System.out.println("\n");
            
            String linea;
            String palabras[];
            String opcion;

            linea = br.readLine();
            palabras = linea.split(" ");
            opcion = palabras[0];
            
            System.out.println("Opción " + opcion + " seleccionada.");
            switch (opcion) {
                case "1":
                	casella1 = new Casella();
                    break;
                case "2":
                	PrimaryKeyCasella key1 = new PrimaryKeyCasella(1, 1, partida);
                	casella1 = new Casella(key1, 1);
                    break;
                case "3":
                	casella1 = new Casella(1, 1, 1);
                    break;
                case "4":
                	casella1 = new Casella(1, 1, 1, partida);
                    break;
                case "5":
                	casella2 = new Casella();
                    break;
                case "6":
                	PrimaryKeyCasella key2 = new PrimaryKeyCasella(2, 2, partida);
                	casella2 = new Casella(key2, 2);
                    break;
                case "7":
                	casella2 = new Casella(2, 2, 2);
                    break;
                case "8":
                	casella2 = new Casella(2, 2, 2, partida);
                    break;
                case "9":
                	System.out.println("Numero: " + Integer.toString(casella1.getNumero()));
                    break;
                case "10":
                	String numero = br.readLine().split(" ")[0];
                	casella1.setNumero(Integer.valueOf(numero));
                    break;
                case "11":
                	casella1.assignarPartida(partida);
                    break;
                case "12":
                	casella1.fusio(casella2);
                    break;
                case "13":
                	System.out.println("NumeroFila: " + Integer.toString(casella1.getNumeroFila()));
                    break;
                case "14":
                	System.out.println("NumeroColumna: " + Integer.toString(casella1.getNumeroColumna()));
                    break;
                case "15":
                	System.out.println("esBuida: " + Boolean.toString(casella1.esBuida()));
                    break;
                case "16":
                	casella1.copia(casella2);
                    break;
                case "17":
                	System.out.println("NumeroColumna: " + Integer.toString(casella1.duplica()));
                    break;
                case "18":
                	casella1.buida();
                    break;
                case "19":
                	System.out.println("Numero: " + Integer.toString(casella2.getNumero()));
                    break;
                
                case "-1":
                	salir = true;
                    break;
            }
        }
        System.out.println("Fin del driver");
	}
}

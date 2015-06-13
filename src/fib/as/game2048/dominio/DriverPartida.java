package fib.as.game2048.dominio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder.Case;

public class DriverPartida {
	private static String NOMBRE_CLASE = "Partida";
	
	public static void main(String[] args) throws IOException {
		String linea;
        String palabras[];
        String opcion;
        
        Partida partida = new Partida();
        Jugador jugador = new Jugador();
        String numero;
        ArrayList<Casella> caselles;
        Boolean ordre;
        Integer fila;
        String param;
        
        System.out.println("Driver " + NOMBRE_CLASE );
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
	            	partida = new Partida();
	                break;
	            case "2":
	            	partida = new Partida(35);
	                break;
	            case "3":
	            	partida = new Partida(jugador, 35);
	                break;
	            case "4":
	            	System.out.println("IdPartida: " + Integer.toString(partida.getIdPartida()));
	                break;
	            case "5":
	            	numero = br.readLine().split(" ")[0];
	            	partida.setIdPartida(Integer.valueOf(numero));
	                break;
	            case "6":
	            	System.out.println("EstaAcabada: " + Boolean.toString(partida.getEstaAcabada()));
	                break;
	            case "7":
	            	numero = br.readLine().split(" ")[0];
	            	partida.setEstaAcabada(Boolean.valueOf(numero));
	                break;
	            case "8":
	            	System.out.println("EstaGuanyada: " + Boolean.toString(partida.getEstaGuanyada()));
	                break;
	            case "9":
	            	numero = br.readLine().split(" ")[0];
	            	partida.setEstaGuanyada(Boolean.valueOf(numero));
	                break;
	            case "10":
	            	System.out.println("Puntuacio: " + Integer.toString(partida.getPuntuacio()));
	                break;
	            case "11":
	            	numero = br.readLine().split(" ")[0];
	            	partida.setPuntuacio(Integer.valueOf(numero));
	                break;
	            case "12":
	            	caselles = partida.getCaselles();
	            	for (Casella casella : caselles) {
	            		System.out.println(casella);
					}
	            	Util.printCasellesToVector(caselles);
	                break;
	            case "13":
	            	caselles = generateCasellas(partida);
	            	Util.printCasellesToVector(caselles);
	            	partida.setCaselles(caselles);
	                break;
	            case "14":
	            	caselles = partida.crearTaulell();
	            	for (Casella casella : caselles) {
	            		System.out.println(casella);
					}
	            	Util.printCasellesToVector(caselles);
	                break;
	            case "15":
	            	partida.sumaPuntuacio(555);
	                break;
	            case "16":
	            	System.out.println("partidaPerduda: " + Boolean.toString(partida.comprovarPartidaPerduda()));
	                break;
	            case "17":
	            	System.out.println("partidaGuanyada: " + Boolean.toString(partida.comprovarPartidaGuanyada()));
	                break;
	            case "18":
	            	partida.preparaSeguentMoviment();
	                break;
	            case "19":
	            	caselles = partida.getCasellesLliures();
	            	for (Casella casella : caselles) {
	            		System.out.println(casella);
					}
	                break;
	            case "20":
	            	caselles = partida.getCasellesValor();
	            	for (Casella casella : caselles) {
	            		System.out.println(casella);
					}
	                break;
	            case "21":
	            	System.out.println("\t ordre:");
	            	numero = br.readLine().split(" ")[0];
	            	ordre = Boolean.valueOf(numero);
	            	System.out.println("\t fila:");
	            	numero = br.readLine().split(" ")[0];
	            	fila = Integer.valueOf(numero);
	            	caselles = partida.obteFila(ordre, fila);
	            	for (Casella casella : caselles) {
	            		System.out.println(casella);
					}
	            	Util.printLineaCaselles(caselles);
	                break;
	            case "22":
	            	System.out.println("\t ordre:");
	            	numero = br.readLine().split(" ")[0];
	            	ordre = Boolean.valueOf(numero);
	            	System.out.println("\t Columna:");
	            	numero = br.readLine().split(" ")[0];
	            	fila = Integer.valueOf(numero);
	            	caselles = partida.obteColumna(ordre, fila);
	            	for (Casella casella : caselles) {
	            		System.out.println(casella);
					}
	            	Util.printLineaCaselles(caselles);
	                break;
	            case "23":
	            	numero = br.readLine().split(" ")[0];
	            	param = partida.MOVIMENT_AMUNT;
	            	switch(numero) {
	            	case "amunt":
	            		param = partida.MOVIMENT_AMUNT;
	            		break;
	            	case "avall":
	            		param = partida.MOVIMENT_AVALL;
	            		break;
	            	case "dreta":
	            		param = partida.MOVIMENT_DRETA;
	            		break;
	            	case "esquerra":
	            		param = partida.MOVIMENT_ESQUERRA;
	            		break;
	            	}
	            	Boolean result = partida.potMoure(param);
	            	System.out.println("PotMoure: " + Boolean.toString(result));
	                break;
	            case "24":
	            	numero = br.readLine().split(" ")[0];
	            	param = partida.MOVIMENT_AMUNT;
	            	switch(numero) {
	            	case "amunt":
	            		param = partida.MOVIMENT_AMUNT;
	            		break;
	            	case "avall":
	            		param = partida.MOVIMENT_AVALL;
	            		break;
	            	case "dreta":
	            		param = partida.MOVIMENT_DRETA;
	            		break;
	            	case "esquerra":
	            		param = partida.MOVIMENT_ESQUERRA;
	            		break;
	            	}
	            	ArrayList<ArrayList<Casella>> c = partida.obteLinies(param);
	            	Util.printCasellesToMatriz(c);
	                break;
//	            case "25":
//	                break; 
	                
	            case "-2":
                	salir = true;
                    break;
            	default:
            		mostrarMenu();
	                
            }
    	}
	}
	
	public static void mostrarMenu() {
		System.out.println("Escoge una opción:");
		
		System.out.println("\t 1) Partida()");
		System.out.println("\t 2) Partida(Integer idPartida), idPartida = 35");
		System.out.println("\t 3) Partida(Jugador jugador, Integer idPartida)");
		System.out.println("\t 4) getIdPartida()");
		System.out.println("\t 5) setIdPartida(Integer idPartida)");
		System.out.println("\t 6) getEstaAcabada()");
		System.out.println("\t 7) setEstaAcabada(Boolean estaAcabada)");
		System.out.println("\t 8) getEstaGuanyada()");
		System.out.println("\t 9) setEstaGuanyada(Boolean estaGuanyada)");
		
		System.out.println("\t 10) getPuntuacio()");
		System.out.println("\t 11) setPuntuacio(Integer puntuacio)");
		System.out.println("\t 12) getCaselles()");
		System.out.println("\t 13) setCaselles(ArrayList<Casella> caselles)");
		System.out.println("\t 14) crearTaulell()");
		System.out.println("\t 15) sumaPuntuacio(Integer punts) (555) ");
		System.out.println("\t 16) comprovarPartidaPerduda()");
		System.out.println("\t 17) comprovarPartidaGuanyada()");
		System.out.println("\t 18) preparaSeguentMoviment()");
		System.out.println("\t 19) getCasellesLliures()");
		
		System.out.println("\t 20) getCasellesValor()");
		System.out.println("\t 21) obteFila(Boolean ordre, Integer fila)");
		System.out.println("\t 22) obteColumna(Boolean ordre, Integer col)");
		System.out.println("\t 23) potMoure(String mov) (amunt,avall,dreta,esquerra)");
		System.out.println("\t 24) obteLinies(String mov) (amunt,avall,dreta,esquerra)");
//		System.out.println("\t 25) ");
//		System.out.println("\t 26) ");
//		System.out.println("\t 27) ");
//		System.out.println("\t 28) ");
//		System.out.println("\t 29) ");
        
        System.out.println("\t -1) Mostrar Menu");
        System.out.println("\t -2) Salir");
        System.out.println(" ");
	}
	
	public static ArrayList<Casella> generateCasellas(Partida partida) {
		ArrayList<Integer> randCaselles = Util.generateRandomsCaselles(4, 2);
		ArrayList<Casella> caselles = new ArrayList<Casella>();
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				int valor = 0;
				int numCasilla = ((j*4)+i)-1;
				if(randCaselles.contains(numCasilla)) {
					valor = Util.randomInterval(1, 2)*2;
				}
				Casella c = new Casella(new PrimaryKeyCasella(i, j, partida), valor);
				caselles.add(c);
			}
		}
		return caselles;
	} 
}

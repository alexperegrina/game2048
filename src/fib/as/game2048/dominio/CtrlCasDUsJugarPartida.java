package fib.as.game2048.dominio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CtrlCasDUsJugarPartida {
	static Jugador jugador;
	static Partida partida;
	
	public static void ferAutentificacio(String userN, String passwd) {
		// lo tiene que implementar Eric
		
		/*
		 * Codigo provisional para poder hacer puebas
		 */
		jugador = new Jugador();
	}
	
	public static void crearPartida() {
		// lo tiene que implementar Eric
		
		/*
		 * Codigo provisional para poder hacer puebas
		 */
		partida = new Partida(jugador, 35);
	}
	
	/**
	 * Metodo para hacer un nuevo movimiento en la partida actual.
	 * @param tipusMov
	 * @return ArrayList<Object> ==> 
	 * [0] => guanyada: Boolean, 
	 * [1] => acabada: Boolean, 
	 * [2] => puntuació: Integer, 
	 * V1_ [3] => casellesAmbNúmero: Set(TupleType(i:Integer, j:Integer, número: Integer)),
	 * V2_ [3] => casellesAmbNúmero: ArrayList<ArrayList<Integer>> ==> [0] => i:Integer, [0] => j:Integer, [0] => número: Integer 
	 * V3_ [3] => casellesAmbNúmero: ArrayList<Caselles> 
	 */
	public static ArrayList<Object> ferMoviment(String tipusMov) {
		Boolean b;
		Integer punts = 0;
		Boolean acabada,guanyada;
		Integer id,mPuntacio;
		String mail;
		
		
		
		if(partida.potMoure(tipusMov)) {
			ArrayList<ArrayList<Casella>> linies = partida.obteLinies(tipusMov);
			
			//Triple bucle infernal para hacer el movimiento.
//			for(int i = 0; i < 4; i++) {
//				b = true;
//				for(int j = 3; j >= 0; j--) {
//					for(int k = j-1; k >= 0; k--) {
//						Casella casellaOrigen = linies.get(i).get(k);
//						Casella casellaDesti = linies.get(i).get(j);
//						if(!casellaOrigen.esBuida()) {
//							punts += casellaOrigen.fusio(casellaDesti);
//							k = -1;
//						}
//	 				}
//				}
//			}
			
			for(Integer i = 0; i < 4; i++) {
				b = true;
				Integer j = 3;
				while(j >= 0) {
//					System.out.println("j: " + Integer.toString(j));
					for(Integer k = j-1; k >= 0; k--) {
//						System.out.println("k: " + Integer.toString(k));
						Casella casellaOrigen = linies.get(i).get(k);
						Casella casellaDesti = linies.get(i).get(j);
						if(!casellaOrigen.esBuida()) {
							
							if(!casellaDesti.esBuida()) j--;
							punts += casellaOrigen.fusio(casellaDesti);
							k = -1;
							
						}
						if(k == 0) {
							j = -1;
						}
	 				}
					if(j == 0) {
						j--;
					}
				}
				
			}
			
			
			partida.sumaPuntuacio(punts);
			acabada = partida.comprovarPartidaPerduda();
			partida.setEstaAcabada(acabada);
			guanyada = partida.comprovarPartidaGuanyada();
			partida.setEstaGuanyada(guanyada);
			if(guanyada) {
				acabada = guanyada;
				partida.setEstaAcabada(acabada);
				punts = partida.getPuntuacio();
				id = partida.getIdPartida();
//				mail = jugador.getMail();
				// AQUI VA EL CODIGO PARA LLAVAR AL FACTORYADAPTER Y ENVIAR EL MENSAJE
				/*
				 
				 AdapMissatgeria am = FactoryAdapter.getAdapMissatgeria();
				 am.enviarMissarge(id,punts,mail);
				 */
			}
			
			if(acabada) {
//				jugador.eliminarPartidaActual(this);
//				jugador.assignarPartidaJugada(this);
//				mpuntuacio = jugador.getMillorPuntuacio();
//				if(punts > mPuntacio) {
//					jugador.setMillorPuntuacio(punts);
//				}
			}
			else {
				partida.preparaSeguentMoviment();
			}
			
//			ArrayList<Casella> caselles = partida.getCasellesValor();
//			ArrayList<Object> ret = new ArrayList<Object>();
//			ret.add(acabada);
//			ret.add(guanyada);
//			ret.add(punts);
//			ret.add(caselles);
//			
//			return ret;
		}
		else {
//			ArrayList<Casella> caselles = partida.getCasellesValor();
//			ArrayList<Object> ret = new ArrayList<Object>();
//			ret.add(acabada);
//			ret.add(guanyada);
//			ret.add(punts);
//			ret.add(caselles);
//			
//			return ret;
			acabada = partida.comprovarPartidaPerduda();
			partida.setEstaAcabada(acabada);
			
		}
//		ArrayList<Casella> caselles = partida.getCasellesValor();
		ArrayList<Object> ret = new ArrayList<Object>();
		ret.add(partida.getEstaAcabada());
		ret.add(partida.getEstaGuanyada());
		ret.add(partida.getPuntuacio());
		ret.add(partida.getCasellesValor());
		
		return ret;
		
	}
	
	public static void main(String[] args) throws IOException {
		
		ferAutentificacio("alex", "123");
		crearPartida();
		
		String linea;
        String palabras[];
        String opcion;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("\t w) amunt");
    	System.out.println("\t d) dreta");
    	System.out.println("\t s) avall)");
    	System.out.println("\t a) esquerra");
    	
        while(!partida.getEstaAcabada()) {
        	Util.printCasellesToVector(partida.getCaselles());
        	
        	linea = br.readLine();
            palabras = linea.split(" ");
            opcion = palabras[0];
        	
        	switch (opcion) {
			case "w":
				ferMoviment(partida.MOVIMENT_AMUNT);
				break;
			case "d":
				ferMoviment(partida.MOVIMENT_DRETA);
				break;
			case "s":
				ferMoviment(partida.MOVIMENT_AVALL);
				break;
			case "a":
				ferMoviment(partida.MOVIMENT_ESQUERRA);
				break;
			}
        	
        }
		
	}
}

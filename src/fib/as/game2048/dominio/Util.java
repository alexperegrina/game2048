package fib.as.game2048.dominio;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder.In;

public abstract class Util {
	public static String CARACTER_NULO = "X";
	/**
	 * Metodo que genera un numero random indicando un rango
	 * @param min
	 * @param max
	 * @return
	 */
	public static Integer randomInterval(Integer min, Integer max) {
		return (min + (int)(Math.random()*max));
	}
	
	/**
	 * Metodo que genera para una matriz cuadra casillas aleatorias diferentes entre ellas y con 
	 * una cierta cantidad.
	 * pre: cantidad < size*2
	 * @param sizeMat
	 * @param cuantitat cantidad de casillas a crear
	 * @return {@link ArrayList}
	 */
	public static ArrayList<Integer> generateRandomsCaselles(Integer sizeMat, Integer cuantitat) {
		Integer maxim = (sizeMat*2)-1;
		Integer minim = 0;
		ArrayList<Integer> caselles = new ArrayList<Integer>();
		
		int i = 0;
		while(i < cuantitat) {
			Integer randomNum = randomInterval(minim,maxim); 
			if(!caselles.contains(randomNum)) {
				caselles.add(randomNum);
				i++;
			}
		}
		
		return caselles;
	}
	
	
	public static void printCasellesToVector(ArrayList<Casella> caselles) {
		
		
		
		//Inicializamos el la matriz con los valores nulos
		ArrayList<ArrayList<String>> tablero = new ArrayList<ArrayList<String>>();
		for(int i = 0; i < 4; i++) {
			ArrayList<String> fila = new ArrayList<String>();
			for(int j = 0; j < 4; j++) {
				fila.add(CARACTER_NULO);
			}
			tablero.add(fila);
		}
		
		for (Casella casella : caselles) {
			if(!casella.esBuida()) {				
				tablero.get(casella.getNumeroFila()).set(casella.getNumeroColumna(), Integer.toString(casella.getNumero()));
			}
		}
		System.out.println("\n -----Tablero-----\n");
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.print(tablero.get(i).get(j));
				System.out.print("\t");
			}
			System.out.println("");
		}
		System.out.println("\n ----------");
	}
	
	
	public static void printLineaCaselles(ArrayList<Casella> linia) {
		System.out.println("\n -----Linia-----\n");
		for (Casella casella : linia) {
			if(casella.esBuida()) {
				System.out.print(CARACTER_NULO);
			}
			else {				
				System.out.print(Integer.toString(casella.getNumero()));
			}
		}
		System.out.println("\n ----------");
	}
	
	public static void printCasellesToMatriz(ArrayList<ArrayList<Casella>> caselles) {
		
		System.out.println("\n -----Tablero-----\n");
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(caselles.get(i).get(j).esBuida()) {
					System.out.print(CARACTER_NULO);
				}
				else {
					System.out.print(Integer.toString(caselles.get(i).get(j).getNumero()));
				}
				
			}
			System.out.println("");
		}
		System.out.println("\n ----------");
	}
}

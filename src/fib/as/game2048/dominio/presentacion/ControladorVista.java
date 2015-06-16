package fib.as.game2048.presentacion;

import java.util.ArrayList;

import fib.as.game2048.CtrlCasDUsJugarPartida;
import fib.as.game2048.CtrlCasUsLogin;
import fib.as.game2048.CtrlCasUsRanking;
import fib.as.game2048.CtrlDataFactory;
import fib.as.game2048.ExcepcioNoHiHaPartida;
import fib.as.game2048.TuplePersPunt;
/*
 * La classe controlador vista conté les diferents vistes del programa
 * i fa les comunicacions pertinents entre elles a més de proporcionar-lis
 * els controladors de la capa de domini que necessiten
 * 
 */
public class ControladorVista {
	
	private VistaLogin vistalogin;
	private VistaMenu vistamenu;
	private VistaPartida vistapartida;
	private VistaRanking vistaranking;
	private VistaResumen vistaresumen;
	
	
	  private CtrlCasUsLogin login;
	  private CtrlCasDUsJugarPartida partida;
	  private CtrlCasUsRanking ranking;
	 
	
	public ControladorVista(){
		/*
		 * En la creació inicialitzem els controladors de la cama de domini
		 * 
		 */
		login = CtrlDataFactory.getCtrlCasUsLogin();
		partida = CtrlDataFactory.getCtrlCasDUsJugarPartida();
		ranking = CtrlDataFactory.getCtrlCasUsRanking(); 
	}
	/*
	 * Funció que es crida un cop creada la classe si es vol començar l'aplicació
	 * Mostrarà la vista del login, que és la finestra inicial
	 */
	public void inicialitzar(){
		vistalogin = new VistaLogin(this);
		vistalogin.show();
	}
	/*
	 * Quan en la finestra de login s'ha fet una autentificació correcta
	 * es crida a aquesta funció per tancar-la i obrir la nova finestra Menu
	 */
	public void okPressed(){	
			vistalogin.tancar();
			iniciarMenu();
	}
	/*
	 * Quan en la finestra de Menu es clica sobre New Game, es tanca la finestra Menu
	 * i s'obre una nova del tipus partida.
	 */
	public void newPressed(){
		
		vistamenu.tancar();
		iniciarPartida();
	}
	//DEPRECATED
	public void keyPressed(String dir){
		/*set = controladorCasDUS.ferMoviment(dir);
		vistapartida.actualitza(set);*/
	}
	/*
	 * Quan es vol accedir al rank, primer comprovem que hi ha partides
	 * guardade en el ranking
	 */
	public void rankPressed() throws ExcepcioNoHiHaPartida{
		ArrayList<TuplePersPunt> r = ranking.consultarRanking();
		ArrayList<String> rannks = new ArrayList<String>();
		for(TuplePersPunt t : r){
			rannks.add(t.getNom()+": "+t.getPunt());
		}
		iniciarRanking(rannks);
		
		
	}
	
	public void exit(){
		
	}
	/*
	 * funció que encapsula les ordres per iniciar la finestra de menu
	 */
	public void iniciarMenu(){
		vistamenu = new VistaMenu(this);
		vistamenu.show();
	}
	/*
	 * funció que encapsula les ordres per iniciar la finestra partida
	 */
	public void iniciarPartida(){
		vistapartida = new VistaPartida(this);
		vistapartida.setCU(partida);
		vistapartida.show();
	}
	/*
	 * funcio que encapsula les ordres per iniciar la finestra resumen
	 */
	public void iniciarResumen(Integer score, String msg){
		vistapartida.tancar();
		vistaresumen = new VistaResumen(this, score, msg);
		vistaresumen.show();
	}
	/*
	 * funcio que encapsula les ordres per iniciar la finestra ranking
	 * per testeig
	 */
	public void iniciarRanking(){
		vistaresumen.tancar();
		vistaranking = new VistaRanking();
		vistaranking.show();
		vistapartida.setCU(partida);
	}
	/*
	 * funcio que encapsula les ordres per iniciar la finestra de ranking
	 */
	public void iniciarRanking(ArrayList<String> r){
		vistaresumen.tancar();
		vistaranking = new VistaRanking();
		vistaranking.omple(r);
		vistaranking.show();
	}
}
package fib.as.game2048.presentacion;

import java.util.ArrayList;

public class ControladorVista {
	
	private VistaLogin vistalogin;
	private VistaMenu vistamenu;
	private VistaPartida vistapartida;
	private VistaRanking vistaranking;
	private VistaResumen vistaresumen;
	
	/*
	 * private CtrlCasUsLogin login
	 * private CtrlCasUsJugarPartida partida
	 * private CtrlCasUsRanking ranking
	 * 
	 */
	
	public ControladorVista(){
		/*
		login = CtrlDataFactory.getCtrlCasUsLogin();
		partida = CtrlDataFactory.getCtrlPartida();
		ranking = CtrlDataFactory.getCtrlCasUsRanking(); */
	}

	public void inicialitzar(){
		vistalogin = new VistaLogin(this);
		vistalogin.show();
	}
	
	public void okPressed(){
		
			vistalogin.tancar();
			iniciarMenu();
			 
	}
	
	public void newPressed(){
		
		vistamenu.tancar();
		iniciarPartida();
	}
	
	public void keyPressed(String dir){
		//set = controladorCasDUS.ferMoviment(dir);
		//vistapartida.actualitza(set);
	}
	
	public void rankPressed(){
		//ArrayList<TuplesPersPunt> r = ranking.consultarRanking();
		//ArrayList<String> rannks = new ArrayList<String>();
		/*for(TuplesPersPunt t : r){
			rannks.add(r.getNom()+": "+r.getPunt());
		}*/
		//iniciarRanking(rannks);
		iniciarRanking();//borrar al descomentar las otras
		
	}
	
	public void exit(){
		
	}
	
	public void iniciarMenu(){
		vistamenu = new VistaMenu(this);
		vistamenu.show();
	}
	
	public void iniciarPartida(){
		vistapartida = new VistaPartida(this);
		vistapartida.show();
	}
	
	public void iniciarResumen(Integer score, String msg){
		vistapartida.tancar();
		vistaresumen = new VistaResumen(this, score, msg);
		vistaresumen.show();
	}
	public void iniciarRanking(){
		vistaresumen.tancar();
		vistaranking = new VistaRanking();
		vistaranking.show();
	}
	public void iniciarRanking(ArrayList<String> r){
		vistaresumen.tancar();
		vistaranking = new VistaRanking();
		vistaranking.omple(r);
		vistaranking.show();
	}
}

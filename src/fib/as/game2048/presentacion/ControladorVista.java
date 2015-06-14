package fib.as.game2048.presentacion;

public class ControladorVista {
	
	private VistaLogin vistalogin;
	private VistaMenu vistamenu;
	private VistaPartida vistapartida;
	private VistaRanking vistaranking;
	private VistaResumen vistaresumen;
	
	public ControladorVista(){
		vistalogin = new VistaLogin();
		vistalogin.addOKListener(this);
		vistalogin.show();/*
		vistamenu = new VistaMenu();
		vistamenu.show();
		vistapartida = new VistaPartida();
		vistapartida.show();
		vistaresumen = new VistaResumen();
		vistaresumen.show();
		vistaranking = new VistaRanking();
		vistaranking.show();*/
	}

	public void inicialitzar(){
		
	}
	
	public void okPressed(String usr, String pwd){
		try{
			System.out.println("usr: "+usr+" pwd: "+pwd);
			//System.exit(0);
			vistalogin.tancar();
			iniciarMenu();
		}
		catch(Exception ex){
			vistalogin.errorNoJugador(ex.getMessage());
		}
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
		inciiarRanking();
	}
	
	public void exit(){
		
	}
	
	public void iniciarMenu(){
		vistamenu = new VistaMenu();
		vistamenu.addOKListener(this);
		vistamenu.show();
	}
	
	public void iniciarPartida(){
		vistapartida = new VistaPartida();
		vistapartida.show();
	}
	
	public void iniciarResumen(int score, int maxscore){
		vistaresumen = new VistaResumen();
		vistaresumen.show();
	}
	public void inciiarRanking(){
		vistaranking = new VistaRanking();
		vistaranking.show();
	}
}

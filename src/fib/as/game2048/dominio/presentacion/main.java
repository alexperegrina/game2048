package fib.as.game2048.presentacion;

public class main {
	
	public static void main(String [ ] args)
	{
		ControladorVista cv = new ControladorVista();
		cv.inicialitzar();
		String stri = "c";
		
		while(stri.equalsIgnoreCase("q")){
			stri = System.console().readLine();
		}
		
	}
	
	
	
	
}	

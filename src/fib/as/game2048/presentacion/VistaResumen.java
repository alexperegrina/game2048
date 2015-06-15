package fib.as.game2048.presentacion;

import java.util.ArrayList;

public class VistaResumen extends Vista{
	private WindowJ win;
	private ArrayList<ComponentJ> comps;
	private ControladorVista cv;
	
	public VistaResumen(ControladorVista ctrlv, Integer score, String mes){
		win = new WindowJ(800,600);
		win.setLayout();
		cv = ctrlv;
		comps = new ArrayList<ComponentJ>();
		LabelJ titol = new LabelJ("Joc 2048");
		LabelJ msg = new LabelJ(mes);
		Area arsc = new Area("Score: " + score);
		Area arbe = new Area("Best: " + score);
		ButtonJ okb = new ButtonJ("Ok");
		ButtonJ rankingb = new ButtonJ("Ranking");
		
		comps.add(titol);
		comps.add(msg);
		comps.add(arsc);
		comps.add(arbe);
		comps.add(okb);
		comps.add(rankingb);
		
		win.addComponent(titol, 3, 0, false);
		win.addComponent(msg, 1, 1, false);
		win.addComponent(arsc, 2, 2, false);
		win.addComponent(arbe, 4, 2, false);
		win.addComponent(okb, 3, 3, false);
		win.addComponent(rankingb, 5, 3, false);
	}
	
	public void show(){
		win.show();
	}
	public void rankPressed(){
		
	}
	public void okPressed(){
		
	}
	
	public void tancar(){
		this.win.tancar();
	}
	
	public void errorNoPartides(String msg){
		
	}
	public void error(String msg){
		
	}
}

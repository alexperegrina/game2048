package fib.as.game2048.presentacion;

import java.util.ArrayList;

public class VistaRanking extends Vista{
	private WindowJ win;
	private ArrayList<ComponentJ> comps;
	ListNonEditable rank;
	public VistaRanking(){
		win = new WindowJ(800,600);
		win.setLayout();
		
		comps = new ArrayList<ComponentJ>();
		
		LabelJ titol = new LabelJ("Joc 2048");
		
		win.addComponent(titol,0,0,false);
		rank = new ListNonEditable();
		rank.add("master 200");
		rank.add("segon 150");
		win.addComponent(rank,5, 0, false);
		comps.add(titol);
		comps.add(rank);
		
		
	}
	public void show(){
		win.show();
		
	}
	public void omple(ArrayList<String> ar){
		for(String s : ar){
			rank.add(s);
		}
	}
	public void okPressed(){
		System.exit(0);
	}
}

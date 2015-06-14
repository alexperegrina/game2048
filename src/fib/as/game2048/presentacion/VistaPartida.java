package fib.as.game2048.presentacion;

import java.util.ArrayList;

public class VistaPartida extends Vista{
	private WindowJ win;
	private ArrayList<ComponentJ> comps;
	private ButtonJ bUp;
	private ButtonJ bDown;
	private ButtonJ bLeft;
	private ButtonJ bRight;
	ArrayList<Area> caselles;
	public VistaPartida(){
		win = new WindowJ(800,600);
		win.setLayout();
		comps = new ArrayList<ComponentJ>();
		Area score= new Area("Score: 0");
		score.setBgColor(0.8f, 0.6f, 0.2f);
		Area best = new Area("Best: ");
		best.setBgColor(0.8f, 0.6f, 0.2f);
		
		caselles = new ArrayList<Area>(16);
		
		win.addComponent(score, 0,0,true);
		win.addComponent(best, 1,0,true);
		
		comps.add(score);
		comps.add(best);
		for(int i = 0; i<16; ++i){
			Area a = new Area("");
			caselles.add(a);
			comps.add(a);
			win.addComponent(a, i%4,(i/4)+1,true);
		}
		bUp = new ButtonJ("^");
		comps.add(bUp);
		win.addComponent(bUp, 2, 5, true);
		bDown = new ButtonJ("v");
		comps.add(bDown);
		win.addComponent(bDown, 2, 7, true);
		bLeft = new ButtonJ("<");
		comps.add(bLeft);
		win.addComponent(bLeft, 1, 6, true);
		bRight = new ButtonJ(">");
		comps.add(bRight);
		win.addComponent(bRight, 3, 6, true);
	}
	
	public void show(){
		win.show();
	}
	public void keyPressed(String key){
		
	}
	
	public void actualitza(ArrayList<Integer> caselles){
		for(Integer i = 0; i < caselles.size();++i){
			this.caselles.get(i).setText(caselles.get(i).toString());
		}
	}
	
}

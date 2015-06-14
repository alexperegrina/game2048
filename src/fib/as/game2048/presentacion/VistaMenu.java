package fib.as.game2048.presentacion;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VistaMenu extends Vista{
	private WindowJ win;
	private ArrayList<ComponentJ> comps;
	private ButtonJ newb;
	private ButtonJ exitb;
	
	public VistaMenu(){
		win = new WindowJ(800,600);
		win.setLayout();
		comps = new ArrayList<ComponentJ>();
		LabelJ titol = new LabelJ("Joc 2048");
		newb = new ButtonJ("New Game");
		exitb = new ButtonJ("Exit");
		
		win.addComponent(titol, 1,0,true);
		win.addComponent(newb, 1,1,true);
		win.addComponent(exitb, 1,2,true);
		comps.add(titol);
		comps.add(newb);
		comps.add(exitb);
		this.addCancelListener();
	}
	
	public void addOKListener(ControladorVista v){
		Button b = (Button) newb.getC();
		b.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				v.newPressed();
				
			};
		});
		
	}
	
	public void addCancelListener(){
		Button b = (Button) exitb.getC();
		b.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			};
		});
		
	}
	public void show(){
		win.show();
	}
	
	public void newPressed(){
		
	}
	
	public void tancar(){
		this.win.tancar();
	}
}

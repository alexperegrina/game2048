package fib.as.game2048.presentacion;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import fib.as.game2048.CtrlCasDUsJugarPartida;

public class VistaPartida extends Vista{
	private WindowJ win;
	private ArrayList<ComponentJ> comps;
	private ButtonJ bUp;
	private ButtonJ bDown;
	private ButtonJ bLeft;
	private ButtonJ bRight;
	ArrayList<Area> caselles;
	private ControladorVista cv;
	private CtrlCasDUsJugarPartida cp;
	private Area score;
	public VistaPartida(ControladorVista ctrlv){
		win = new WindowJ(800,600);
		win.setLayout();
		comps = new ArrayList<ComponentJ>();
		 score= new Area("Score: 0");
		score.setBgColor(0.8f, 0.6f, 0.2f);
		Area best = new Area("Best: ");
		best.setBgColor(0.8f, 0.6f, 0.2f);
		cv = ctrlv;
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
		addKeyListener(this);
		addUpListener(this);
		addDownListener(this);
		addLeftListener(this);
		addRightListener(this);
	}
	
	public void tancar(){
		this.win.tancar();
	}
	
	public void show(){
		win.show();
	}
	public void keyPressed(String key){
		ArrayList<Object> res = cp.ferMoviment(key);
			if((Boolean) res.get(0)){
				if((Boolean) res.get(1)){
					//estaguanyada
					cv.iniciarResumen((Integer) res.get(2), "Has guanyat!");
				}
				else{
					//estaperduda
					 cv.iniciarResumen((Integer) res.get(2), "Has perdut!");
				}
			}
			else{
			//actualitza
			  for(Area a : caselles){
			  	a.setText("");
			  }
			  score.setText(res.get(2).toString());
			  ArrayList<ArrayList<Integer> > casis = (ArrayList<ArrayList<Integer>>) res.get(3);
			  for(ArrayList<Integer> ar : casis){
				  Integer fila = (Integer) ar.get(1);
				  Integer columna = (Integer) ar.get(0);
			  	caselles.get(fila *4 + columna).setText(ar.get(2).toString());
			  }
			}
		 
	}
	
	public void actualitza(ArrayList<Integer> caselles){
		for(Integer i = 0; i < caselles.size();++i){
			this.caselles.get(i).setText(caselles.get(i).toString());
		}
	}
	
	public void addKeyListener(final VistaPartida v){
		JFrame f = (JFrame) win.getC();
		f.setFocusable(true);
		f.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getExtendedKeyCode());
				if(e.getKeyCode()==KeyEvent.VK_LEFT){
					v.keyPressed("esquerra");
					System.out.println("esquerra");
				}
				if(e.getKeyCode()==KeyEvent.VK_RIGHT){
					v.keyPressed("dreta");
				}
				if(e.getKeyCode()==KeyEvent.VK_UP){
					v.keyPressed("amunt");
				}
				if(e.getKeyCode()==KeyEvent.VK_DOWN){
					v.keyPressed("avall");
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public void addUpListener(final VistaPartida v){
		Button b = (Button) bUp.getC();
		b.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				v.keyPressed("amunt");
			};
		});
	}
	public void addDownListener(final VistaPartida v){
		Button b = (Button) bDown.getC();
		b.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				v.keyPressed("avall");
			};
		});
	}
	public void addLeftListener(final VistaPartida v){
		Button b = (Button) bLeft.getC();
		b.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				v.keyPressed("esquerra");
			};
		});
	}
	public void addRightListener(final VistaPartida v){
		Button b = (Button) bRight.getC();
		b.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				v.keyPressed("dreta");
			};
		});
	}
	
	public void setCU(CtrlCasDUsJugarPartida con){
		cp = con;
		ArrayList<Object> ini = cp.crearPartida();
		for(Area a : caselles){
		  	a.setText("");
		  }
		ArrayList<ArrayList<Integer> > cas = (ArrayList<ArrayList<Integer>>) ini.get(2);
		for(ArrayList<Integer> ar : cas){
			  Integer fila = (Integer) ar.get(1);
			  Integer columna = (Integer) ar.get(0);
		  	caselles.get(fila *4 + columna).setText(ar.get(2).toString());
		  }
		score.setText(ini.get(1).toString());
	}
	
}

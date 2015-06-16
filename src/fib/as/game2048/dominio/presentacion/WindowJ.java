package fib.as.game2048.presentacion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;

public class WindowJ extends GraphicElement{
	private JFrame f;
	private GridBagConstraints c;//GridBagConstraints es el layout mes flexible
	public WindowJ(){
		f = new JFrame();
		this.setC(f);
		f.setVisible(false);
	}
	
	//amplada, altura
	public WindowJ(int x, int y){
		f = new JFrame();
		this.setC(f);
		f.setVisible(false);
		f.setSize(x, y);
	}
	//inicialitza el layout
	public void setLayout(){
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout layout = new GridBagLayout();
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 5;
		c.ipady = 5;
		Insets i = new Insets(0,5,5,0);
		c.insets = i;
		f.setLayout(layout);
	}
	
	
	//affegeix un component -DEPRECATED-
	public void addComponent(ComponentJ c){
		f.add(c.getC());
	}
	
	//afegeix un component en la posicio row col
	public void addComponent(ComponentJ comp, Integer row, Integer col, Boolean fil){
		c.gridx = row;
		c.gridy = col;
		f.add(comp.getC(), c);
	}
	//afegeix un component en la posicio row col i aplica anchor i fill
	public void addComponentTop(ComponentJ comp, Integer row, Integer col, Boolean fil){
		c.gridx = row;
		c.gridy = col;
		c.anchor = GridBagConstraints.PAGE_START;
		c.fill = GridBagConstraints.BOTH;
		
		f.add(comp.getC(), c);
	}
	
	public void tancar(){
		this.f.dispose();
	}
	
}

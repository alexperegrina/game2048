package fib.as.game2048.presentacion;

import javax.swing.JCheckBox;

public class CheckJ extends Active{
	private JCheckBox check;
	public CheckJ(){
		check = new JCheckBox();
		check.setEnabled(false);
		this.setC(check);
	}
	
	public void check(){
		this.check.setSelected(true);
	}
	
	public void uncheck(){
		this.check.setSelected(false);
	}
	
}

package fib.as.game2048.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class TextField extends Editable{
	private String text;
	private Integer nbChars;
	protected JTextField j;
	
	public TextField(){
		j = new JTextField();
		this.setC(j);
	}
	public String getText(){
		return this.j.getText();
	}
	
	public Integer getNBChars(){
		return this.nbChars;
	}
}

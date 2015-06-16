package fib.as.game2048.presentacion;

import java.awt.Button;

public class ButtonJ extends Active{
	private String text;
	private Button button;
	
	public ButtonJ(String text){
		this.text = text;
		this.button = new Button(text);
		this.setC(button);
	}
	
	public String getText(){
		return this.text;
	}
	
	public void setText(String text){
		this.text = text;
		
	}
	
	public Boolean pressed(){
		return false;
	}
}

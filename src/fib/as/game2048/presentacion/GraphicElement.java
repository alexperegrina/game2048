package fib.as.game2048.presentacion;

import java.awt.Component;

public class GraphicElement {
	private Integer cx, cy;
	private String name;
	private Component c;

	public Component getC() {
		return c;
	}

	public void setC(Component c) {
		this.c = c;
	}
	
	public void show(){
		c.setVisible(true);
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	
	public void setCX(Integer cx){
		this.cx = cx;
	}
	
	public void setCY(Integer cy){
		this.cy = cy;
	}
	
	public Integer getCX(){
		return this.cx;
	}
	
	public Integer getCY(){
		return this.cy;
	}
}

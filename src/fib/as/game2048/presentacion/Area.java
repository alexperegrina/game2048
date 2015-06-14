package fib.as.game2048.presentacion;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Area extends NonEditable{
	private String text;
	private Color bgColor;
	
	private JLabel lab;
	
	public Area(String text){
		lab = new JLabel(text);
		lab.setBorder(BorderFactory.createLineBorder(Color.black));
		lab.setPreferredSize(new Dimension(75,75));
		lab.setOpaque(true);
		lab.setHorizontalAlignment(JLabel.CENTER);
		this.setC(lab);
	}
	
	
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Color getBgColor() {
		return bgColor;
	}
	public void setBgColor(Integer red, Integer green, Integer blue) {
		this.bgColor = new Color(red,green,blue);
		lab.setBackground(bgColor);
	}
	
	public void setBgColor(float red, float green, float blue) {
		this.bgColor = new Color(red,green,blue);
		lab.setBackground(bgColor);
	}
	
}

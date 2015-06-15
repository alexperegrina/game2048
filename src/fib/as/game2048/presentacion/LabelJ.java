package fib.as.game2048.presentacion;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

public class LabelJ extends NonEditable{
	private String text;
	private JLabel l;
	
	public LabelJ(){
		l = new JLabel();
		this.setC(l);
	}
	
	LabelJ(String t){
		l = new JLabel(t);
		text = t;
		this.setC(l);
	}
	
	public void updateFontSize(){
		Font labelFont = l.getFont();
		String labelText = l.getText();

		int stringWidth = l.getFontMetrics(labelFont).stringWidth(labelText);
		int componentWidth = l.getWidth();

		// Find out how much the font can grow in width.
		double widthRatio = (double)componentWidth / (double)stringWidth;

		int newFontSize = (int)(labelFont.getSize() * widthRatio);
		int componentHeight = l.getHeight();

		// Pick a new font size so it will not be larger than the height of label.
		int fontSizeToUse = Math.min(newFontSize, componentHeight);

		// Set the label's font size to the newly determined size.
		l.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
	}
	
	public void setDimension(Integer x, Integer y){
		l.setPreferredSize(new Dimension(x,y));
		updateFontSize();
	}
	
	public String getText() {
		text = l.getText();
		return text;
	}

	public void setText(String text) {
		this.text = text;
		l.setText(text);
		updateFontSize();
	}
	

}

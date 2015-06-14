package fib.as.game2048.presentacion;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JScrollPane;

public class ListNonEditable extends NonEditable{
	private ArrayList<String> elems;
	private JList<String> l;
	private JScrollPane jsc;
	
	public ListNonEditable(){
		elems = new ArrayList<String>();
		l = new JList<String>();
		jsc = new JScrollPane(l);
		setC(jsc);
	}
	
	public ListNonEditable(String[] data){
		elems = new ArrayList<String>();
		l = new JList<String>(data);
		jsc = new JScrollPane(l);
		setC(jsc);	
	}
	
	public void add(String s){
		elems.add(s);
		LabelJ lab = new LabelJ(s);
		l.add(lab.getC());
	}
	public void clean(){
		elems.clear();
		l.removeAll();
	}
	
}

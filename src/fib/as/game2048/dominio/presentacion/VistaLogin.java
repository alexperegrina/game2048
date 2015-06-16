package fib.as.game2048.presentacion;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import fib.as.game2048.CtrlCasUsLogin;
import fib.as.game2048.ExcepcioLoginIncorrecte;
import fib.as.game2048.ExcepcioNoJugador;
import fib.as.game2048.ExcepcioPwdIncorrecte;

public class VistaLogin extends Vista{
	private WindowJ win;
	private ArrayList<ComponentJ> comps;
	private ButtonJ okb;
	private ButtonJ cancelb;
	private TextField textf;
	private Password p;
	private CheckJ checkUser;
	private CheckJ checkPwd;
	private ControladorVista cv;
	private CtrlCasUsLogin login;
	
	  public void setCtrlCasUsLogin(CtrlCasUsLogin cu){
	  	login = cu;
	  }
	 
	public VistaLogin(ControladorVista ctrlv){
		win = new WindowJ(800,600);
		win.setLayout();
		cv = ctrlv;
		//LabelJ buit = new LabelJ("");
		LabelJ titol = new LabelJ("Joc 2048");
		LabelJ login = new LabelJ("Login:");
		LabelJ pass = new LabelJ("Password:");
		okb = new ButtonJ("Ok");
		cancelb = new ButtonJ("Cancel");
		textf = new TextField();
		p = new Password();
		checkUser = new CheckJ();
		checkPwd = new CheckJ();
		checkUser.check();
		checkPwd.check();
		comps = new ArrayList<ComponentJ>();
		comps.add(titol);
		comps.add(login);
		comps.add(pass);
		comps.add(textf);
		comps.add(p);
		comps.add(okb);
		comps.add(cancelb);
		comps.add(checkUser);
		comps.add(checkPwd);
		win.addComponent(titol, 1, 0, false);
		win.addComponent(login,0,1,false);
		win.addComponent(textf, 1, 1, false);
		win.addComponent(checkUser, 2, 1, false);
		win.addComponent(pass,0,2,false);
		win.addComponent(p, 1, 2, false);
		win.addComponent(checkPwd, 2, 2, false);
		win.addComponent(okb, 2, 3, false);
		win.addComponent(cancelb, 3, 3, false);
		addOKListener(this);
		this.addCancelListener();
		//win.show();
	}
	public void show()	{
		win.show();
	}
	public void okPressed(){
	/*	try{
			login.login(textf.getText(), p.getText());
			  cv.okPressed();
		}
		catch(ExcepcioLoginIncorrecte ex){
			errorUserName(ex.getMessage());
		}
		
		 catch(ExcepcioPwdIncorrecte ex){
		 		errorPassword(ex.getMessage());
		 }
		 catch(ExcepcioNoJugador ex){
		 		errorNoJugador(ex.getMessage());
		 }
		 catch(Exception ex){
		 		error(ex.getMessage());
		 }
		*/
		cv.okPressed();
		 
	}
	
	public void addOKListener(final VistaLogin v){
		Button b = (Button) okb.getC();
		b.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				v.okPressed();
			};
		});
		
	}
	
	public void addCancelListener(){
		Button b = (Button) cancelb.getC();
		b.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			};
		});
		
	}
	
	public void errorUserName(String msg){
		this.checkUser.uncheck();
		this.checkPwd.uncheck();
	}
	public void errorPassword(String msg){
		this.checkUser.check();
		this.checkPwd.uncheck();
	}
	
	public void errorNoJugador(String msg){
		this.checkUser.uncheck();
		this.checkPwd.uncheck();
	}
	
	public void error(String msg){
		
	}
	
	public void tancar(){
		this.win.tancar();
	}
}

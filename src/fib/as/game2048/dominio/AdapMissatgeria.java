package fib.as.game2048.dominio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class AdapMissatgeria {
	
	public void enviarMissatge(Integer id, Integer punt, String mail)
	{
		
		String server = "localhost";
		try {
		URL u = new URL(server);
		URLConnection uc = u.openConnection();
		HttpURLConnection connection = (HttpURLConnection) uc;
		 
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setRequestMethod("POST");
		//connection.setRequestProperty("SOAPAction", SOAP_ACTION);
		 
		OutputStream out = connection.getOutputStream();
		Writer wout = new OutputStreamWriter(out);
		 
		wout.write(
		
				"<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:src=\"http://src\">"+
				   "<soap:Header/>"+
				   "<soap:Body>"+
				      "<src:enviarMissatge>"+
				         "<!--Optional:-->"+
				         "<src:id>"+id+"</src:id>"+
				         "<!--Optional:-->"+
				         "<src:punt>"+punt+"</src:punt>"+
				         "<!--Optional:-->"+
				         "<src:mail>"+mail+"</src:mail>"+
				      "</src:enviarMissatge>"+
				   "</soap:Body>"+
				"</soap:Envelope>"
				
		);
		wout.flush();
		 
		wout.close();
		 
		InputStream in = connection.getInputStream();
		int c;
		System.err.println( "\n\nCONTESTACION\n\n");
		while ((c = in.read()) != -1) System.out.write(c);
		in.close();
		 
		}
		catch (IOException e) {
		System.err.println("HA DADO UNA EXCEPCION");
		System.err.println(e);
		}
		
		
		
	}
}

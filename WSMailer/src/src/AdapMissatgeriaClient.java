package src;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import src.AdapMissatgeriaStub.EnviarMissatge;


public class AdapMissatgeriaClient {
	
	public static void main(String[] args)
	{
		try
		{
			AdapMissatgeriaStub AMS = new AdapMissatgeriaStub();
			EnviarMissatge m = new EnviarMissatge();
			m.setId(Integer.parseInt(args[0]));
			m.setMail(args[1]);
			m.setPunt(Integer.parseInt(args[2]));
			AMS.enviarMissatge(m);
			System.out.println("id: "+m.getId());
			System.out.println("mail: "+m.getMail());
			System.out.println("punt: "+m.getPunt());
		}
		catch (AxisFault e)
		{
			e.printStackTrace();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
	}
}

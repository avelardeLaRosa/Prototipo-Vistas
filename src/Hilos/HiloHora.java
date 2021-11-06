package Hilos;

import java.text.SimpleDateFormat;
import java.util.Date;

import vistas.*;

public class HiloHora extends Thread{
	@Override
	public void run() {
		while(true){
		// TODO Auto-generated method stub
		super.run();
		
		//1. obtener la hora del sistema
				Date fecha = new Date();
				//2. formatear la fehca segun el requeimiento 
				SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
				frmPrincipalEmp.lbl_Hora.setText(sdf.format(fecha));
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}

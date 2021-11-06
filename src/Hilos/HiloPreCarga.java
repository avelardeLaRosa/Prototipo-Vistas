package Hilos;

import vistas.frmPreCarga;

public class HiloPreCarga extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=0; i<=100; i++){
		frmPreCarga.pbCarga.setValue(i);
		try {
			Thread.sleep(20); //DURACION DE CARGA
		} catch (InterruptedException ie) {
			// TODO: handle exception
			ie.printStackTrace();
		}
		}
	}
	
	
}

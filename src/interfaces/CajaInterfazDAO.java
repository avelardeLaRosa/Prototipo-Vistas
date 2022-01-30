package interfaces;

import java.util.ArrayList;

import entidad.CabeceraVenta;
import entidad.Caja;
import entidad.CajaCierre;
import entidad.CajaEstado;
import entidad.CajaApertura;
import entidad.DetalleVenta;

public interface CajaInterfazDAO {
	
	public int actualizarEstado(Caja c);
	public ArrayList<Caja>listar();
	public int aperturaCaja(Caja c,CajaApertura cm);
	public int cierreCaja(Caja c,CajaCierre cc);
}

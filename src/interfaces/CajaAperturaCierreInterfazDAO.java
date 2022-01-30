package interfaces;

import java.util.ArrayList;

import entidad.CajaApertura;
import entidad.CajaCierre;
import entidad.CajaEstado;

public interface CajaAperturaCierreInterfazDAO {
	public int registarMontoApertura(CajaApertura ca);
	public int registrarMontoCierre(CajaCierre cc);
	public int ValidarCaja();
	public ArrayList<CajaApertura>listarRegistrosApertura();
	public ArrayList<CajaCierre>listarRegistrosCierre();
	
}

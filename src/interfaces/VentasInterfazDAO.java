package interfaces;

import java.util.ArrayList;

import entidad.CabeceraVenta;
import entidad.DetalleVenta;

public interface VentasInterfazDAO {
	
	public String generarNroBoleta();
	
	public int realizarVenta(CabeceraVenta cVent,ArrayList<DetalleVenta>detVent);
	public ArrayList<DetalleVenta>listar();
	public ArrayList<DetalleVenta>listarDetalles(String numbol);

}

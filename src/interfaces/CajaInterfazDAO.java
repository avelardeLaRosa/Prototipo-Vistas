package interfaces;

import java.util.ArrayList;

import entidad.Caja;

public interface CajaInterfazDAO {
	
	public int registrarMonto(Caja c);
	public int actualizarMonto(Caja c);
	public Caja listarMonto();
}

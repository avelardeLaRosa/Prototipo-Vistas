package interfaces;

import java.util.ArrayList;

import entidad.Proveedor;

public interface ProveedorInterfazDAO {
	public int registrar(Proveedor p);
	public int actualizar(Proveedor p);
	public int eliminar(int codigo);
	public ArrayList<Proveedor> listarProveedorXRuc(String nro);
	public ArrayList<Proveedor>listarProveedor();
}

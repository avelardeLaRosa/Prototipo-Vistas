package interfaces;

import java.util.ArrayList;

import entidad.Cliente;


public interface ClienteInterfazDAO {
	public int registrar(Cliente c);
	public int actualizar(Cliente c);
	public int eliminar(int codigo);
	public ArrayList <Cliente> listar();
	public ArrayList<Cliente> listarClientexDNI(String nro);
	
}

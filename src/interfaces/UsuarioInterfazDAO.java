package interfaces;

import java.util.ArrayList;

import entidad.Usuario;
import entidad.UsuarioXTipo;

public interface UsuarioInterfazDAO {
	
	public int registrar(Usuario u);
	public int modificar(Usuario u);
	public int eliminar(int id);
	public Usuario login(String user, String clave);
	public ArrayList<UsuarioXTipo>listarUsuario();
	public ArrayList<Usuario>listarXId(int id);
	public ArrayList<UsuarioXTipo>ListarXDesTipo(int id);
	
}

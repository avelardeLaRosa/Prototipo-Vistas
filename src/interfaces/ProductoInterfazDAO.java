package interfaces;

import java.util.ArrayList;

import entidad.Producto;

public interface ProductoInterfazDAO {
	
	public int registar(Producto p);
	public int actualizar(Producto p);
	public int eliminar(int id);
	public ArrayList<Producto>listarXCat(int idCat);
	public ArrayList<Producto>listarXIdPro(int idPro);
	public ArrayList<Producto>listarXNombrePro(String nomPro);
	public ArrayList<Producto>listarProductos();
	

}

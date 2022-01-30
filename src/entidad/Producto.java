package entidad;

public class Producto {
	
	private int idProducto,cantidad, idCategoria, idProveedor;
	private double precio;
	private String nombre, des_categoria, des_proveedor,eliminado;

	public Producto(){};
	
	public int getIdProducto() {return idProducto;}

	public void setIdProducto(int idProducto) {this.idProducto = idProducto;}

	public int getCantidad() {return cantidad;}

	public void setCantidad(int cantidad) {this.cantidad = cantidad;}

	public int getIdCategoria() {return idCategoria;}

	public void setIdCategoria(int idCategoria) {this.idCategoria = idCategoria;}

	public int getIdProveedor() {return idProveedor;}

	public void setIdProveedor(int idProveedor) {this.idProveedor = idProveedor;}

	public double getPrecio() {return precio;}

	public void setPrecio(double precio) {this.precio = precio;}

	public String getNombre() {return nombre;}

	public void setNombre(String nombre) {this.nombre = nombre;}
	
	public String getDes_categoria() {return des_categoria;}

	public void setDes_categoria(String des_categoria) {this.des_categoria = des_categoria;}

	public String getDes_proveedor() {
		return des_proveedor;
	}

	public void setDes_proveedor(String des_proveedor) {
		this.des_proveedor = des_proveedor;
	}
	public String getEliminado() {
		return eliminado;
	}

	public void setEliminado(String eliminado) {
		this.eliminado = eliminado;
	}
	
	
	
		

}

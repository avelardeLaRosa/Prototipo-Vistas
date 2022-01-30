package entidad;

public class DetalleVenta {
	
	private int cantidad,idProducto;
	private double precio;
	private String num_bol;
	
	public DetalleVenta(int cantidad, int idProducto, double precio, String num_bol) {
		super();
		this.cantidad = cantidad;
		this.idProducto = idProducto;
		this.precio = precio;
		this.num_bol = num_bol;
	}
	
	public DetalleVenta(){};
	
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNum_bol() {
		return num_bol;
	}

	public void setNum_bol(String num_bol) {
		this.num_bol = num_bol;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	

}

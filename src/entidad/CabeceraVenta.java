package entidad;

public class CabeceraVenta {
	
	private int idCliente,idCaja,idUsuario;
	private double total_bol;
	private String fecha_bol,num_bol;
	
	public CabeceraVenta(String num_bol, int idCliente, int idCaja, int idUsuario, double total_bol, String fecha_bol) {
		super();
		this.num_bol = num_bol;
		this.idCliente = idCliente;
		this.idCaja = idCaja;
		this.idUsuario = idUsuario;
		this.total_bol = total_bol;
		this.fecha_bol = fecha_bol;
	}
	
	public CabeceraVenta(){};
	
	public String getNum_bol() {
		return num_bol;
	}

	public void setNum_bol(String num_bol) {
		this.num_bol = num_bol;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdCaja() {
		return idCaja;
	}

	public void setIdCaja(int idCaja) {
		this.idCaja = idCaja;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public double getTotal_bol() {
		return total_bol;
	}

	public void setTotal_bol(double total_bol) {
		this.total_bol = total_bol;
	}

	public String getFecha_bol() {
		return fecha_bol;
	}

	public void setFecha_bol(String fecha_bol) {
		this.fecha_bol = fecha_bol;
	}
	
	

}

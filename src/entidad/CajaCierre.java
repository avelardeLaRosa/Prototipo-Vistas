package entidad;

public class CajaCierre {
	private double monto;
	private int idCaja,idUsuario,cod_estado;
	private String fecha,comentario;
	
	public CajaCierre(){};
	
	public CajaCierre(double monto, int idCaja, int idUsuario, int cod_estado, String fecha, String comentario) {
		super();
		this.monto = monto;
		this.idCaja = idCaja;
		this.idUsuario = idUsuario;
		this.cod_estado = cod_estado;
		this.fecha = fecha;
		this.comentario = comentario;
	}
	
	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public int getCod_estado() {
		return cod_estado;
	}

	public void setCod_estado(int cod_estado) {
		this.cod_estado = cod_estado;
	}
}

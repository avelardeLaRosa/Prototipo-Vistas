package entidad;

public class Caja {
	
	private int idCaja,idUsuario;
	private double monto;
	private String comentario,fecha;
	
	public Caja(){};
	
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

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	

}

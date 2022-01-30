package entidad;

public class Caja {
	
	private int idCaja,cod_estado;
	private String des_caja;
	
	public Caja(){};
	
	public Caja(int idCaja, int cod_estado, String des_caja) {
		super();
		this.idCaja = idCaja;
		this.cod_estado = cod_estado;
		this.des_caja = des_caja;
	}
	public int getIdCaja() {
		return idCaja;
	}

	public void setIdCaja(int idCaja) {
		this.idCaja = idCaja;
	}

	public int getCod_estado() {
		return cod_estado;
	}

	public void setCod_estado(int cod_estado) {
		this.cod_estado = cod_estado;
	}

	public String getDes_caja() {
		return des_caja;
	}

	public void setDes_caja(String des_caja) {
		this.des_caja = des_caja;
	}
	
	
	

}

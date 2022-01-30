package entidad;

public class Usuario {
	private int idUsuario,idtipo;
	private String nombre,apellido,usuario,clave,fecha_registro,fecha_eliminacion,eliminado;

	

	public Usuario(){}
	
	public int getIdUsuario() {return idUsuario;}

	public void setIdUsuario(int idUsuario) {this.idUsuario = idUsuario;}

	public String getNombre() {return nombre;}

	public void setNombre(String nombre) {this.nombre = nombre;}

	public String getApellido() {return apellido;}

	public void setApellido(String apellido) {this.apellido = apellido;}

	public String getUsuario() {return usuario;}

	public void setUsuario(String usuario) {this.usuario = usuario;}

	public String getClave() {return clave;}

	public void setClave(String clave) {this.clave = clave;}

	public String getFecha_registro() {return fecha_registro;}

	public void setFecha_registro(String fecha_registro) {this.fecha_registro = fecha_registro;}

	public String getFecha_eliminacion() {return fecha_eliminacion;}

	public void setFecha_eliminacion(String fecha_eliminacion) {this.fecha_eliminacion = fecha_eliminacion;}
	
	public int getIdtipo() {return idtipo;}

	public void setIdtipo(int idtipo) {this.idtipo = idtipo;}

	public String getEliminado() {
		return eliminado;
	}

	public void setEliminado(String eliminado) {
		this.eliminado = eliminado;
	}
	
	

}

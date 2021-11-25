package utils;

public class Validacion {
	
	public static final String nomApell = "[a-zA-Z\\s]{3,25}";
	public static final String psw = "[a-zA-Z\\s]{1}[0-9]{5}";
	//
	public static final String NOMBREYAPELLIDO = "(?=.{3,45}$)[a-zA-ZáéíóúÁÉÍÓÚñÑ]+(?: [a-zA-ZáéíóúÁÉÍÓÚñÑ]+)*";
	public static final String DNI = "[0-9]{8}";
	public static final String TELEFONO = "[0-9]{7,9}";
	public static final String CORREO = "^[A-Za-z0-9+_.-]+@(.+)$";
	public static final String RUC = "[0-9]{11}";
	public static final String DIRECCION = "(?=.{3,45}$)[a-zA-ZáéíóúÁÉÍÓÚñÑ.#]+(?: [a-zA-ZáéíóúÁÉÍÓÚñÑ.#]+)*";
	
	
}

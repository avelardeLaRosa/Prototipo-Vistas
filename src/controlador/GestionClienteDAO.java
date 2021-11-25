package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Cliente;
import interfaces.ClienteInterfazDAO;
import utils.MySQLConexion8;

public class GestionClienteDAO implements ClienteInterfazDAO{

	@Override
	public int registrar(Cliente c) {
				int estado = 0;
				Connection con = null;
				PreparedStatement pstm = null; //
				
				try {
					con = MySQLConexion8.getConexion();
					String sql = "insert into cliente values(null ,? ,? , ?, ?, ?)";
					pstm = con.prepareStatement(sql);
					pstm.setString(1, c.getNombre());
					pstm.setString(2, c.getApellido());
					pstm.setString(3, c.getDni());
					pstm.setString(4, c.getTelefono());
					pstm.setString(5, c.getCorreo());

					estado = pstm.executeUpdate();
				} catch (Exception e) {
					System.out.println(" Error << en la instrucción de registro. " + e.getMessage());
				}
				  finally {
						try {
							if(pstm != null)
								pstm.close();
							if (con != null)
								con.close();
							
						} catch (SQLException e2) {
							System.out.println("Error al cerrar base de Datos" + e2.getMessage());
						}
					}
				
				return estado;
	}
	

	@Override
	public ArrayList<Cliente> listar() {
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM cliente";
			pstm = con.prepareStatement(sql);
			res = pstm.executeQuery();
			Cliente c;
			while(res.next()){
				c = new Cliente();
				c.setIdCliente(res.getInt(1));
				c.setNombre(res.getString(2));
				c.setApellido(res.getString(3));
				c.setDni(res.getString(4));
				c.setTelefono(res.getString(5));
				c.setCorreo(res.getString(6));
				lista.add(c);
			}
				
		} catch (Exception e) {
			System.out.println("Error en la sentencia listar usuario: " + e.getMessage());
		}
		finally {
			try {
				if(res != null)
					res.close();
				if(pstm != null)
					pstm.close();
				if(con != null)
					con.close();
				
			} catch (SQLException e2) {
				System.out.println(">>>> Error al cerrar la base de datos <<<<" + e2.getMessage());
			}
		}		
		return lista;
	}


	@Override
	public int actualizar(Cliente c) {

		int estado = 0;
		Connection con = null;
		PreparedStatement pstm = null;		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "update cliente set nombre = ?, apellido = ?, dni= ? , telefono = ?, correo = ? where idCliente = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, c.getNombre());
			pstm.setString(2, c.getApellido());
			pstm.setString(3, c.getDni());
			pstm.setString(4, c.getTelefono());
			pstm.setString(5, c.getCorreo());
			pstm.setInt(6, c.getIdCliente());
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println(" Error << en la instrucción al actualizar. " + e.getMessage());
		}
		  finally {
				try {
					if(pstm != null)
						pstm.close();
					if (con != null)
						con.close();
					
				} catch (SQLException e2) {
					System.out.println("Error al cerrar base de Datos" + e2.getMessage());
				}
			}
		
		return estado;
	}


	@Override
	public ArrayList<Cliente> listarClientexDNI(String nro) {
		ArrayList<Cliente> listar = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from cliente where dni = ?";
			pstm = con.prepareStatement(sql);
            pstm.setString(1, nro);
			 res = pstm.executeQuery();
			 Cliente c;
			 while(res.next()) {
				 c = new Cliente();
				 c.setIdCliente(res.getInt(1));
				 c.setNombre(res.getString(2));
				 c.setApellido(res.getString(3));
				 c.setDni(res.getString(4));
				 c.setTelefono(res.getString(5));
				 c.setCorreo(res.getString(6));
				 listar.add(c);
			 }
			 			
		} catch (Exception e) {
			System.out.println("Error en la sentencia listar usuario" + e.getMessage());
		}finally {
			try {
				if(res != null) res.close();
				if(pstm != null) pstm.close();
				if(con != null) con.close();
				
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}	
		return listar ;
		
	}


	@Override
	public int eliminar(int codigo) {
				int estado = 0;
				Connection con = null;
				PreparedStatement pstm = null;
				try {
					con = MySQLConexion8.getConexion();
					String sql = "delete from cliente where idCliente = ?";
					pstm = con.prepareStatement(sql);
					pstm.setInt(1, codigo);
					estado = pstm.executeUpdate();
					
				} catch (Exception e) {
					System.out.println("Error en la sentencia al eliminar " + e.getMessage());
				}
				
				finally {
					try {
						if(pstm != null)
							pstm.close();
						if(con != null)
							con.close();
						
					} catch (SQLException e2) {
						System.out.println(">>>> Error al cerrar la base de datos <<<<");
					}
				}
				return estado;			
	}
	
	

}//

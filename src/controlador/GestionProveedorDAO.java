package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Proveedor;
import entidad.UsuarioXTipo;
import interfaces.ProveedorInterfazDAO;
import utils.MySQLConexion8;

public class GestionProveedorDAO implements ProveedorInterfazDAO{

	@Override
	public int registrar(Proveedor p) {
		int estado = 0;
		Connection con = null;
		PreparedStatement pstm = null; //
		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "insert into proveedor values(null , ?, ?, ?, ?, ?,?,'No')";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, p.getRuc());
			pstm.setString(2, p.getNombre());
			pstm.setString(3, p.getDireccion());
			pstm.setString(4, p.getTelefono());
			pstm.setString(5, p.getInformacion());
			pstm.setString(6, p.getContacto());
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
	public int actualizar(Proveedor p) {
		int estado = 0;
		Connection con = null;
		PreparedStatement pstm = null;		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "update proveedor set ruc = ?, nombre = ?, direccion = ? , telefono = ?, informacion = ?, Contacto = ? where idProveedor = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, p.getRuc());
			pstm.setString(2, p.getNombre());
			pstm.setString(3, p.getDireccion());
			pstm.setString(4, p.getTelefono());
			pstm.setString(5, p.getInformacion());
			pstm.setString(6, p.getContacto());
			pstm.setInt(7, p.getIdProveedor());
			
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
	public int eliminar(int codigo) {
		int estado = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "update proveedor set eliminado = 'Si' where idProveedor = ? and eliminado = 'No'";
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

	@Override
	public ArrayList<Proveedor> listarProveedorXRuc(String nro) {
		ArrayList<Proveedor> listar = new ArrayList<Proveedor>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from proveedor where ruc = ? and eliminado = 'No'";
			pstm = con.prepareStatement(sql);
            pstm.setString(1, nro);
			 res = pstm.executeQuery();
			 Proveedor p;
			 while(res.next()) {
				 p = new Proveedor();
				 p.setIdProveedor(res.getInt(1));
				 p.setRuc(res.getString(2));
				 p.setNombre(res.getString(3));
				 p.setDireccion(res.getString(4));
				 p.setTelefono(res.getString(5));
				 p.setInformacion(res.getString(6));
				 p.setContacto(res.getString(7));
				 p.setEliminado(res.getString(8));
				 listar.add(p);
			 }
			 			
		} catch (Exception e) {
			System.out.println("Error en la sentencia listar proveedor x ruc" + e.getMessage());
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
	public ArrayList<Proveedor> listarProveedor() {
		ArrayList<Proveedor>listar=new ArrayList<Proveedor>();
		Connection con=null;
		PreparedStatement pstm=null;
		ResultSet res=null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM proveedor where eliminado = 'No'";
			pstm = con.prepareStatement(sql);
			res = pstm.executeQuery();
			Proveedor p;
			while(res.next()){
				p = new Proveedor();
				p.setIdProveedor(res.getInt(1));
				p.setRuc(res.getString(2));
				p.setNombre(res.getString(3));
				p.setDireccion(res.getString(4));
				p.setTelefono(res.getString(5));
				p.setInformacion(res.getString(6));
				p.setContacto(res.getString(7));
				
				listar.add(p);
			}
		} catch (Exception e) {
			System.out.println("Error <<< en la instruccion de listado " + e.getMessage());
		}finally {
			try {
				if(con!=null){con.close();}
				if(pstm!=null){con.close();}
				if(res!=null){res.close();}
			} catch (SQLException e2) {
				System.out.println("Error <<< en la base de datos " + e2.getMessage());
			}
		}
		return listar;
	}
	
	
}

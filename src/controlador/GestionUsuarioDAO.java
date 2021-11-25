package controlador;

import java.beans.ParameterDescriptor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Usuario;
import entidad.UsuarioXTipo;
import interfaces.UsuarioInterfazDAO;
import utils.MySQLConexion8;

public class GestionUsuarioDAO implements UsuarioInterfazDAO{

	@Override
	public int registrar(Usuario u) {
		
		int estado = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		String sql;
		
		try {
			con = MySQLConexion8.getConexion();
			sql = "insert into usuario values (null,?,?,?,?,curdate(),null,?)";
			pstm = con.prepareStatement(sql);
			pstm.setString(1,u.getNombre());
			pstm.setString(2, u.getApellido());
			pstm.setString(3, u.getUsuario());
			pstm.setString(4, u.getClave());
			pstm.setInt(5, u.getIdtipo());
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error <<< en la instruccion de registro " + e.getMessage());
		}finally{
			try{
			if(con!=null){con.close();}
			if(pstm!=null){pstm.close();}
			}catch(SQLException e){
			System.out.println("Error <<< en la base de datos " + e.getMessage());
		}
		}
		return estado;
	}
	@Override
	public int modificar(Usuario u) {
		int estado = 0;
		Connection con=null;
		PreparedStatement pstm=null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "update usuario set nombre=?,apellido=?,usuario=?,clave=?,fecha_registro=?,idtipo = ? where idUsuario = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1,u.getNombre());
			pstm.setString(2, u.getApellido());
			pstm.setString(3, u.getUsuario());
			pstm.setString(4, u.getClave());
			pstm.setString(5, u.getFecha_registro());
			pstm.setInt(6, u.getIdtipo());
			pstm.setInt(7, u.getIdUsuario());
			
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error <<< en la instruccion de actualizacion " + e.getMessage());
		}finally {
			try {
				if(con!=null)con.close();
				if(pstm!=null)pstm.close();
			} catch (SQLException e2) {
				System.out.println("Error <<< en la base de datos " + e2.getMessage());
			}
		}
		
		return estado;
	}

	@Override
	public int eliminar(int id) {
		int estado=0;
		Connection con=null;
		PreparedStatement pstm=null;
		try{
		con = MySQLConexion8.getConexion();
		String sql = "delete from usuario where idusuario=?";
		pstm = con.prepareStatement(sql);
		pstm.setInt(1,id);
		estado = pstm.executeUpdate();
		}catch(Exception e){
			System.out.println("Error <<< en la instruccion de eliminar " + e.getMessage());
		}finally {
			try {
				if(con!=null)con.close();
				if(pstm!=null)pstm.close();
			} catch (SQLException e2) {
				System.out.println("Error <<< en la base de datos " + e2.getMessage());
			}
		}
		return estado;
	}

	@Override
	public ArrayList<UsuarioXTipo> listarUsuario() {
		ArrayList<UsuarioXTipo> user=new ArrayList<UsuarioXTipo>();
		
		Connection con=null;
		PreparedStatement pstm=null;
		String sql = null;
		ResultSet res=null;
		
		try {
			con = MySQLConexion8.getConexion();
			sql = "call sp_listarTipo()";
			pstm = con.prepareStatement(sql);
			res = pstm.executeQuery();
			UsuarioXTipo ut;
			while(res.next()){
				ut = new UsuarioXTipo();
				ut.setIdUsuario(res.getInt(1));
				ut.setNombre(res.getString(2));
				ut.setApellido(res.getString(3));
				ut.setUsuario(res.getString(4));
				ut.setClave(res.getString(5));
				ut.setFecha_registro(res.getString(6));
				ut.setFecha_eliminacion(res.getString(7));
				ut.setIdtipo(res.getInt(8));
				ut.setDes_tipo(res.getString(9));
				user.add(ut);
			}
		} catch (Exception e) {
			System.out.println("Error <<< en la instruccion de registro " + e.getMessage());
		}finally {
			try {
				if(con!=null){con.close();}
				if(pstm!=null){con.close();}
				if(res!=null){res.close();}
			} catch (SQLException e2) {
				System.out.println("Error <<< en la base de datos " + e2.getMessage());
			}
		}
		return user;
	}
	@Override
	public ArrayList<Usuario> listarXId(int id) {
		
		ArrayList<Usuario>listarId=new ArrayList<Usuario>();
		
		Connection con=null;
		PreparedStatement pstm=null;
		ResultSet res=null;
		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "call consultarId(?)";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			res = pstm.executeQuery();
			Usuario u;
			while(res.next()){
				u = new Usuario();
				u.setIdUsuario(res.getInt(1));
				u.setNombre(res.getString(2));
				u.setApellido(res.getString(3));
				u.setUsuario(res.getString(4));
				u.setClave(res.getString(5));
				u.setFecha_registro(res.getString(6));
				u.setIdtipo(res.getInt(7));
				listarId.add(u);
			}
		} catch (Exception e) {
			System.out.println("Error <<< en la instruccion de registro " + e.getMessage());
		}finally{
			try {
				if(con!=null)con.close();
				if(pstm!=null)pstm.close();
				if(res!=null)res.close();
			} catch (SQLException e2) {
				System.out.println("Error <<< en la base de datos " + e2.getMessage());
			}
		}
		
		
		return listarId;
	}
	@Override
	public Usuario login(String user, String psw) {
		Usuario u= null;
		Connection con=null;
		PreparedStatement pstm=null;
		ResultSet res = null;
		try {
			//paso 1: Establecer la conexion
			con = MySQLConexion8.getConexion();
			//paso 2: Determinar sentencia sql
			String sql = "call sp_validar(?,?)";
			//paso 3: Crear objeto pstm y enviar setencia sql
			pstm = con.prepareStatement(sql);
			//paso 4: parametros 
			pstm.setString(1, user);
			pstm.setString(2, psw);
			//paso 5: Ejecutar la instruccion
			res = pstm.executeQuery();
			//Paso 6: si hay data-...
			if(res.next()){
				//Paso 8: Crear el objeto usuario
				u = new Usuario();
				//Paso 9: setear los atributos de la clase usuario
				u.setIdUsuario(res.getInt(1));
				u.setNombre(res.getString(2));
				u.setApellido(res.getString(3));
				u.setUsuario(res.getString(4));
				u.setClave(res.getString(5));
				u.setFecha_registro(res.getString(6));
				u.setFecha_eliminacion(res.getString(7));
				u.setIdtipo(res.getInt(8));
			}
		} catch (Exception e) {
			System.out.println("Eror en validar acceso" + e.getMessage());
		}finally {
			try {
				if(res !=null)
					res.close();
				if(pstm!=null)
					pstm.close();
				if(con!=null)
					con.close();
			} catch (SQLException se) {
				System.out.println("Error en la base de datos" + se.getMessage());
			}
		return u;
	}
	}
	@Override
	public ArrayList<UsuarioXTipo> ListarXDesTipo(int id) {
		ArrayList<UsuarioXTipo>listarTipo=new ArrayList<UsuarioXTipo>();
		
		Connection con=null;
		PreparedStatement pstm=null;
		ResultSet res=null;
		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "call sp_des_tipo(?)";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			res = pstm.executeQuery();
			UsuarioXTipo ut;
			while(res.next()){
				ut = new UsuarioXTipo();
				ut.setIdUsuario(res.getInt(1));
				ut.setNombre(res.getString(2));
				ut.setApellido(res.getString(3));
				ut.setUsuario(res.getString(4));
				ut.setClave(res.getString(5));
				ut.setFecha_registro(res.getString(6));
				ut.setFecha_eliminacion(res.getString(7));
				ut.setIdtipo(res.getInt(8));
				ut.setDes_tipo(res.getString(9));
				listarTipo.add(ut);
			}
		} catch (Exception e) {
			System.out.println("Error <<< en la instruccion de registro " + e.getMessage());
		}finally{
			try {
				if(con!=null)con.close();
				if(pstm!=null)pstm.close();
				if(res!=null)res.close();
			} catch (SQLException e2) {
				System.out.println("Error <<< en la base de datos " + e2.getMessage());
			}
		}
		
		
		return listarTipo;
	}

	
	

}

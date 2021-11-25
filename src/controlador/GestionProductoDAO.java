package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Producto;
import entidad.Usuario;
import interfaces.ProductoInterfazDAO;
import utils.MySQLConexion8;

public class GestionProductoDAO implements ProductoInterfazDAO{

	@Override
	public int registar(Producto p) {
		int estado=0;
		Connection con=null;
		PreparedStatement pstm=null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "insert into producto values (null,?,?,?,?,?)";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, p.getNombre());
			pstm.setInt(2, p.getCantidad());
			pstm.setDouble(3, p.getPrecio());
			pstm.setInt(4, p.getIdCategoria());
			pstm.setInt(5, p.getIdProveedor());
			estado = pstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error <<< en la instruccion de registro " + e.getMessage());
		}finally {
			try {
				if(con!=null)con.close();
				if(pstm!=null)con.close();
			} catch (SQLException e2) {
				System.out.println("Error <<< en la base de datos " + e2.getMessage());
			}
		}
		return estado;
	}

	@Override
	public int actualizar(Producto p) {
		int estado=0;
		Connection con=null;
		PreparedStatement pstm=null;
		String sql=null;
		try {
			con = MySQLConexion8.getConexion();
			sql = "UPDATE producto SET nombre = ?, cantidad = ?, precio = ?, idCategoria = ?, idProveedor = ? WHERE idProducto = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, p.getNombre());
			pstm.setInt(2, p.getCantidad());
			pstm.setDouble(3, p.getPrecio());
			pstm.setInt(4, p.getIdCategoria());
			pstm.setInt(5, p.getIdProveedor());
			pstm.setInt(6, p.getIdProducto());
			estado = pstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error <<< en la instruccion de Actualizacion " + e.getMessage());
		}finally {
			try {
				if(con!=null)con.close();
				if(pstm!=null)con.close();
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
		String sql = "delete from producto where idProducto = ?";
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
	public ArrayList<Producto> listarXCat(int idCat) {
		ArrayList<Producto>listarId=new ArrayList<Producto>();
		
		Connection con=null;
		PreparedStatement pstm=null;
		ResultSet res=null;
		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "call bdtienda.sp_listar_proCat(?)";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, idCat);
			res = pstm.executeQuery();
			Producto p;
			while(res.next()){
				p = new Producto();
				p.setIdProducto(res.getInt(1));
				p.setNombre(res.getString(2));
				p.setCantidad(res.getInt(3));
				p.setPrecio(res.getDouble(4));
				p.setDes_categoria(res.getString(5));
				listarId.add(p);
			}
		} catch (Exception e) {
			System.out.println("Error <<< en la instruccion de Listado x Categoria " + e.getMessage());
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
	public ArrayList<Producto> listarXIdPro(int idPro) {
		ArrayList<Producto>listar=new ArrayList<Producto>();
		Connection con =null;
		PreparedStatement pstm=null;
		ResultSet res=null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "call sp_listar_Producto(?)";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, idPro);
			res = pstm.executeQuery();
			Producto p;
			while(res.next()){
				p = new Producto();
				p.setIdProducto(res.getInt(1));
				p.setNombre(res.getString(2));
				p.setCantidad(res.getInt(3));
				p.setPrecio(res.getDouble(4));
				p.setDes_categoria(res.getString(5));
				p.setDes_proveedor(res.getString(6));
				listar.add(p);
			}
		} catch (Exception e) {
			System.out.println("Error <<< en la instruccion de listado de producto " + e.getMessage());
		}finally {
			try {
				if(con!=null)con.close();
				if(pstm!=null)pstm.close();
			} catch (Exception e2) {
				System.out.println("Error <<< en la base de datos " + e2.getMessage());
			}
		}
		
		return listar;
	}

	@Override
	public ArrayList<Producto> listarProductos() {
		
		ArrayList<Producto>listar=new ArrayList<Producto>();
		Connection con =null;
		PreparedStatement pstm=null;
		ResultSet res=null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "call sp_listarpro()";
			pstm = con.prepareStatement(sql);
			res = pstm.executeQuery();
			Producto p;
			while(res.next()){
				p = new Producto();
				p.setIdProducto(res.getInt(1));
				p.setNombre(res.getString(2));
				p.setCantidad(res.getInt(3));
				p.setPrecio(res.getDouble(4));
				p.setDes_categoria(res.getString(5));
				p.setDes_proveedor(res.getString(6));
				listar.add(p);
			}
		} catch (Exception e) {
			System.out.println("Error <<< en la instruccion de listado de producto " + e.getMessage());
		}finally {
			try {
				if(con!=null)con.close();
				if(pstm!=null)pstm.close();
			} catch (Exception e2) {
				System.out.println("Error <<< en la base de datos " + e2.getMessage());
			}
		}
		
		return listar;
	}

	@Override
	public ArrayList<Producto> listarXNombrePro(String nomPro) {
		
		ArrayList<Producto>listar=new ArrayList<Producto>();
		Connection con =null;
		PreparedStatement pstm=null;
		ResultSet res=null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from bdtienda.producto where nombre = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1,nomPro);
			res = pstm.executeQuery();
			Producto p;
			while(res.next()){
				p = new Producto();
				p.setIdProducto(res.getInt(1));
				p.setNombre(res.getString(2));
				p.setCantidad(res.getInt(3));
				p.setPrecio(res.getDouble(4));
				p.setDes_categoria(res.getString(5));
				p.setDes_proveedor(res.getString(6));
				listar.add(p);
			}
		} catch (Exception e) {
			System.out.println("Error <<< en la instruccion de listado de producto " + e.getMessage());
		}finally {
			try {
				if(con!=null)con.close();
				if(pstm!=null)pstm.close();
			} catch (Exception e2) {
				System.out.println("Error <<< en la base de datos " + e2.getMessage());
			}
		}
		
		return listar;
	}
	

}

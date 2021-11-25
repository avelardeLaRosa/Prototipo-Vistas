package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Caja;
import entidad.Categoria;
import interfaces.CajaInterfazDAO;
import utils.MySQLConexion8;

public class GestionCajaDAO implements CajaInterfazDAO {

	@Override
	public int registrarMonto(Caja c) {
		int estado=0;
		Connection con=null;
		PreparedStatement pstm=null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "INSERT INTO caja VALUES (null,?,?,?,CURRENT_TIMESTAMP());";
			pstm = con.prepareStatement(sql);
			pstm.setDouble(1, c.getMonto());
			pstm.setString(2, c.getComentario());
			pstm.setInt(3, c.getIdUsuario());
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
	public int actualizarMonto(Caja c) {
		int estado = 0;
		Connection con=null;
		PreparedStatement pstm=null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "UPDATE bdtienda.caja SET monto = ?, comentario = ?,fecha = CURRENT_TIMESTAMP() WHERE idCaja = 1";
			pstm = con.prepareStatement(sql);
			pstm.setDouble(1, c.getMonto());
			pstm.setString(2, c.getComentario());
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
	public Caja listarMonto() {
		Caja c=null;
		Connection con=null;
		PreparedStatement pstm=null;
		String sql = null;
		ResultSet res=null;
		
		try {
			con = MySQLConexion8.getConexion();
			sql = "SELECT * FROM bdtienda.caja";
			pstm = con.prepareStatement(sql);
			res = pstm.executeQuery();
			if(res.next()){
				c = new Caja();
				c.setIdCaja(res.getInt(1));
				c.setMonto(res.getDouble(2));
				c.setComentario(res.getString(3));
				c.setIdUsuario(res.getInt(4));
				c.setFecha(res.getString(5));
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
		return c;
	}
	

}

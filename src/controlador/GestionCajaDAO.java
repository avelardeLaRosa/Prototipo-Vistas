package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Caja;
import entidad.CajaApertura;
import entidad.CajaCierre;
import entidad.CajaEstado;
import entidad.Categoria;
import interfaces.CajaAperturaCierreInterfazDAO;
import interfaces.CajaInterfazDAO;
import utils.MySQLConexion8;

public class GestionCajaDAO implements CajaAperturaCierreInterfazDAO {

	@Override
	public int registarMontoApertura(CajaApertura ca) {
		int estado=0;
		Connection con=null;
		PreparedStatement pstm=null;
		String sql=null;
		try {
			con = MySQLConexion8.getConexion();
			sql = "insert into caja_apertura values(?,CURRENT_TIMESTAMP(),?,?,?,?)";
			pstm = con.prepareStatement(sql);
			pstm.setDouble(1,ca.getMonto());
			pstm.setString(2, ca.getComentario());
			pstm.setInt(3, ca.getIdCaja());
			pstm.setInt(4, ca.getIdUsuario());
			pstm.setInt(5, ca.getCod_estado());
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error <<< en la instruccion de registro de monto apertura " + e.getMessage());
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
	public int registrarMontoCierre(CajaCierre cc) {
		int estado=0;
		Connection con=null;
		PreparedStatement pstm=null;
		String sql=null;
		try {
			con = MySQLConexion8.getConexion();
			sql = "insert into caja_cierre values(?,CURRENT_TIMESTAMP(),?,?,?,?)";
			pstm = con.prepareStatement(sql);
			pstm.setDouble(1,cc.getMonto());
			pstm.setString(2, cc.getComentario());
			pstm.setInt(3, cc.getIdCaja());
			pstm.setInt(4, cc.getIdUsuario());
			pstm.setInt(5, cc.getCod_estado());
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error <<< en la instruccion de registro de monto de cierre" + e.getMessage());
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
	public ArrayList<CajaApertura> listarRegistrosApertura() {
		ArrayList<CajaApertura>listar=new ArrayList<CajaApertura>();
		Connection con=null;
		PreparedStatement pstm=null;
		ResultSet res = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from caja_apertura";
			pstm = con.prepareStatement(sql);
			res = pstm.executeQuery();
			CajaApertura ca;
			while(res.next()){
				ca=new CajaApertura();
				ca.setMonto(res.getDouble(1));
				ca.setFecha(res.getString(2));
				ca.setComentario(res.getString(3));
				ca.setIdCaja(res.getInt(4));
				ca.setIdUsuario(res.getInt(5));
				ca.setCod_estado(res.getInt(6));
				listar.add(ca);
			}
		} catch (Exception e) {
			System.out.println("Error <<< en la instruccion de listado de montos apertura " + e.getMessage());
		}finally {
			try {
				if(con!=null)con.close();
				if(pstm!=null)pstm.close();
				if(res!=null)res.close();
			} catch (SQLException e2) {
				System.out.println("Error <<< en la base de datos " + e2.getMessage());
			}
		}
		return listar;
	}

	@Override
	public ArrayList<CajaCierre> listarRegistrosCierre() {
		ArrayList<CajaCierre>listar=new ArrayList<CajaCierre>();
		Connection con=null;
		PreparedStatement pstm=null;
		ResultSet res = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from caja_cierre";
			pstm = con.prepareStatement(sql);
			res = pstm.executeQuery();
			CajaCierre cc;
			while(res.next()){
				cc=new CajaCierre();
				cc.setMonto(res.getDouble(1));
				cc.setFecha(res.getString(2));
				cc.setComentario(res.getString(3));
				cc.setIdCaja(res.getInt(4));
				cc.setIdUsuario(res.getInt(5));
				cc.setCod_estado(res.getInt(6));
				listar.add(cc);
			}
		} catch (Exception e) {
			System.out.println("Error <<< en la instruccion de listado de montos  cierre " + e.getMessage());
		}finally {
			try {
				if(con!=null)con.close();
				if(pstm!=null)pstm.close();
				if(res!=null)res.close();
			} catch (SQLException e2) {
				System.out.println("Error <<< en la base de datos " + e2.getMessage());
			}
		}
		return listar;
	}

	@Override
	public int ValidarCaja() {
		int codigo= 0;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "select cod_estado FROM caja";
			pstm = con.prepareStatement(sql);
			res = pstm.executeQuery();
			if(res.next()) {
				codigo = Integer.parseInt(res.getString(1));
			}
		} catch (Exception e) {
			System.out.println("Error al Traer el Estado de Caja: " + e.getMessage());
		}	finally {
			try {
				con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar: " + e2.getMessage());
			}
		}	
		return codigo;
	}

	
	

	
}

package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.*;
import interfaces.CajaInterfazDAO;
import utils.MySQLConexion8;

public class GestionCajaPruebaDAO implements CajaInterfazDAO{

	@Override
	public int actualizarEstado(Caja c) {
		int estado = 0;
		Connection con = null;
		PreparedStatement pstm = null;		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "UPDATE caja SET cod_estado = ? WHERE idCaja = ? ";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, c.getCod_estado());
			pstm.setInt(2, c.getIdCaja());
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println(" Error << en la instrucción al modificar estado. " + e.getMessage());
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
	public ArrayList<Caja> listar() {
		ArrayList<Caja> lista = new ArrayList<Caja>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM caja";
			pstm = con.prepareStatement(sql);
			res = pstm.executeQuery();
			Caja c;
			while(res.next()){
				c = new Caja();
				c.setIdCaja(res.getInt(1));
				c.setDes_caja(res.getString(2));
				c.setCod_estado(res.getInt(3));
				lista.add(c);
			}
				
		} catch (Exception e) {
			System.out.println("Error en la sentencia listar caja " + e.getMessage());
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
	public int aperturaCaja(Caja c, CajaApertura cm) {
		int estado = 0;
		
		Connection con=null;
		PreparedStatement pstm1=null,
						  pstm2=null;
		try {
			//INSTRUCCION MODIFICAR ESTADO
			con = MySQLConexion8.getConexion(); 
			con.setAutoCommit(false);
			String sql = "UPDATE bdtienda.caja SET cod_estado = ? WHERE idCaja = ? ";
			pstm1 = con.prepareStatement(sql);
			pstm1.setInt(1, c.getCod_estado());
			pstm1.setInt(2, c.getIdCaja());
			estado = pstm1.executeUpdate();
			
			//INSTRUCCION REGISTRO MONTO
			String sql1 = "insert into caja_apertura values(?,CURRENT_TIMESTAMP(),?,?,?,?)";
			pstm2 = con.prepareStatement(sql1);
			pstm2.setDouble(1,cm.getMonto());
			pstm2.setString(2, cm.getComentario());
			pstm2.setInt(3, cm.getIdCaja());
			pstm2.setInt(4, cm.getIdUsuario());
			pstm2.setInt(5, cm.getCod_estado());
			estado = pstm2.executeUpdate();
			con.commit();
		} catch (Exception e) {
			System.out.println("Error <<<< al realizar la apertura de caja  >>" + e.getMessage());
			estado = 0;// control de validacion
			try {
				con.rollback();
			} catch (Exception e2) {
				System.out.println("Error <<<< al restaurar >>" + e.getMessage());
			}
		}finally {
			try{
			if(con!=null)
				con.close();
		}catch(SQLException e2){
			System.out.println("Error al cerrar base de datos >>> " + e2.getMessage());
		}
		
		}
		
		
		return estado;
	}

	@Override
	public int cierreCaja(Caja c, CajaCierre cc) {
		int estado = 0;
		
		Connection con=null;
		PreparedStatement pstm1=null,
						  pstm2=null;
		try {
			//INSTRUCCION MODIFICAR ESTADO
			con = MySQLConexion8.getConexion(); 
			con.setAutoCommit(false);
			String sql = "UPDATE bdtienda.caja SET cod_estado = ? WHERE idCaja = ? ";
			pstm1 = con.prepareStatement(sql);
			pstm1.setInt(1, c.getCod_estado());
			pstm1.setInt(2, c.getIdCaja());
			estado = pstm1.executeUpdate();
			
			//INSTRUCCION REGISTRO MONTO
			String sql1 = "insert into caja_cierre values(?,CURRENT_TIMESTAMP(),?,?,?,?)";
			pstm2 = con.prepareStatement(sql1);
			pstm2.setDouble(1,cc.getMonto());
			pstm2.setString(2, cc.getComentario());
			pstm2.setInt(3, cc.getIdCaja());
			pstm2.setInt(4, cc.getIdUsuario());
			pstm2.setInt(5, cc.getCod_estado());
			estado = pstm2.executeUpdate();
			con.commit();
		} catch (Exception e) {
			System.out.println("Error <<<< al realizar el cierre de caja >>  " + e.getMessage());
			estado = 0;// control de validacion
			try {
				con.rollback();
			} catch (Exception e2) {
				System.out.println("Error <<<< al restaurar >>  " + e.getMessage());
			}
		}finally {
			try{
			if(con!=null)
				con.close();
		}catch(SQLException e2){
			System.out.println("Error al cerrar base de datos " + e2.getMessage());
		}
		
		}
		
		
		return estado;
	}

	


}

package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.CajaCierre;
import entidad.CajaEstado;
import interfaces.CajaEstadoInterfazDAO;
import utils.MySQLConexion8;

public class GestionCajaEstadoDAO implements CajaEstadoInterfazDAO{

	@Override
	public ArrayList<CajaEstado> listarEstado() {
		ArrayList<CajaEstado>listar=new ArrayList<CajaEstado>();
		Connection con=null;
		PreparedStatement pstm=null;
		String sql = null;
		ResultSet res=null;
		
	
		try {
			con = MySQLConexion8.getConexion();
			sql = "SELECT * FROM bdtienda.caja_estado";
			pstm = con.prepareStatement(sql);
			res = pstm.executeQuery();
			CajaEstado ce;
			while(res.next()){
				ce = new CajaEstado();
				ce.setCod_estado(res.getInt(1));
				ce.setDes_estado(res.getString(2));
				listar.add(ce);
			}
		} catch (Exception e) {
			System.out.println(/*"Error <<< en la instruccion de listado de estado de caja  " +*/ e.getMessage());
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
	

}

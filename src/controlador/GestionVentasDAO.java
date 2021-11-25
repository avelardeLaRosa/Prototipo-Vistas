package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import entidad.CabeceraVenta;
import entidad.DetalleVenta;
import interfaces.VentasInterfazDAO;
import utils.MySQLConexion8;

public class GestionVentasDAO implements VentasInterfazDAO {

	@Override
	public String generarNroBoleta() {
		String codigo = "B0001";
		Connection con=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			con = MySQLConexion8.getConexion();
			//select al mayor valor de la parte numerica ejemplo: B002 = 2
			String sql="select substring(max(num_bol),2) from cab_venta";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			if(rs.next()){
				DecimalFormat df = new DecimalFormat("0000");

				codigo = "B" + df.format(Integer.parseInt(rs.getString(1)) + 1);

				// ejemplo 003 + 1 = 004
			}
		} catch (Exception e) {
			System.out.println("Error en generaNumBoleta" + e.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar: " + e2.getMessage());
			}
		}
		
		return codigo;
	}

	@Override
	public int realizarVenta(CabeceraVenta cVent, ArrayList<DetalleVenta> detVent) {
		int estado = 0;
		
		Connection con=null;
		PreparedStatement pstm1=null,//registrar datos en la tabla cab_bol
						  pstm2=null,//registrar datos en la tb det_bol
						  pstm3=null;//actualizar la tabla -->stock
		try {
			//PASO 1: ESTABLECER CONEXION CON BASE DE DATOS
			con = MySQLConexion8.getConexion(); //establecemos conexion
			//PASO 2: desactivar la confirmacion automatica
			con.setAutoCommit(false);
			//paso 3: instruccion 1 - registro de la tb_cabeceraBoleta
			String sql1 = "insert into cab_venta values(?,?,?,?,?,?)";
			//PASEO 3: CREAR EL OBJETO PST 1 Y ENVIAR INSTRUCCION SQL 1
			pstm1 = con.prepareStatement(sql1);
			//PASO 4: PARAMETROS 1
			//codigo -- null porque esta autoincremento en la base de datos
			pstm1.setString(1, cVent.getNum_bol());
			pstm1.setString(2, cVent.getFecha_bol());
			pstm1.setInt(3, cVent.getIdCliente());
			pstm1.setInt(4, cVent.getIdCaja());
			pstm1.setDouble(5, cVent.getTotal_bol());
			pstm1.setInt(6, cVent.getIdUsuario());
			//PASO 5: EJECUTAR INSTRUCCION 1
			estado = pstm1.executeUpdate();
			
			//INSTRUCCION 2 
			String sql2 = "insert into detalle_venta values(?,?,?,?)";
			for(DetalleVenta dv: detVent){
			//PASEO 3: CREAR EL OBJETO PST 1 Y ENVIAR INSTRUCCION SQL 1
			pstm2 = con.prepareStatement(sql2);
			//PASO 4: PARAMETROS 1
			//codigo -- null porque esta autoincremento en la base de datos
			pstm2.setDouble(1, dv.getPrecio());
			pstm2.setInt(2, dv.getCantidad());
			pstm2.setInt(3, dv.getIdProducto());
			pstm2.setString(4, cVent.getNum_bol());
			//PASO 5: EJECUTAR INSTRUCCION 1
			estado = pstm2.executeUpdate();
			}
			
			//INSTRUCCION 3: ACTUALIZAR LOS PRODUCTOS
			String sql3="update producto set cantidad = cantidad - ? where idProducto = ?";
			for (DetalleVenta dv : detVent) {
				//preparar la instruccion sql 3
				pstm3 = con.prepareStatement(sql3);
				pstm3.setInt(1,dv.getCantidad());
				pstm3.setInt(2, dv.getIdProducto());
				//EJECUTAR
				estado = pstm3.executeUpdate();
			}
			
			//confirmar las transacciones , si no hay problemas
			con.commit();
		} catch (Exception e) {
			System.out.println("Error <<<< al realizar la venta" + e.getMessage());
			estado = 0;// control de validacion
			try {
				con.rollback();
			} catch (Exception e2) {
				System.out.println("Error <<<< al restaurar" + e.getMessage());
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



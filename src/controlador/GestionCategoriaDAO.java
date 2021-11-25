package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Categoria;
import entidad.UsuarioXTipo;
import interfaces.CategoriaInterfazDAO;
import utils.MySQLConexion8;

public class GestionCategoriaDAO implements CategoriaInterfazDAO {

	@Override
	public ArrayList<Categoria> listar() {
		
		ArrayList<Categoria> listarCat=new ArrayList<Categoria>();
		
		Connection con=null;
		PreparedStatement pstm=null;
		String sql = null;
		ResultSet res=null;
		
		try {
			con = MySQLConexion8.getConexion();
			sql = "SELECT * FROM categoria";
			pstm = con.prepareStatement(sql);
			res = pstm.executeQuery();
			Categoria c;
			while(res.next()){
				c = new Categoria();
				c.setIdCategoria(res.getInt(1));
				c.setDes_categoria(res.getString(2));
				listarCat.add(c);
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
		return listarCat;
	}

}

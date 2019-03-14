import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.*;
//aqui esta el codigo para grabar y consultar
public class JDBCCompra implements DAOCompra{
	
	private Connection conectar() {//se hace un metodo para la conexión, para asi no tener que copiar el codigo siempre
		String url = "jdbc:sqlite:compra.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public void grabar(Compra c) {//codigo para grabar
		String sql = "INSERT INTO compra (Cliente,Producto,Cantidad,Precio,ID) VALUES(?,?,?,?,?)";
		try (Connection conn = this.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, c.getPer().getName());
			pstmt.setString(2, c.getArt().getNombre());
			pstmt.setInt(3, c.getCant());
			pstmt.setInt(4, c.getArt().getPrecio());
			pstmt.setInt(5, c.getId());
			pstmt.executeUpdate();
		} catch (SQLException o) {
			System.out.println(o.getMessage());
		}
	}
	//a partir de aqui, el codigo es para consultar.
	public void consultart(){//aqui te muestra todo lo que hay almacenado en la base de datos
		try  {
			String sql1 = "SELECT * FROM compra";
			Connection conn = this.conectar();
			PreparedStatement pstmt = conn.prepareStatement(sql1);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("CLIENTE|PRODUCTO|CANTIDAD|PRECIO|ID");
			while (rs.next()) {	
				 System.out.println(rs.getString("Cliente")+ " | " +rs.getString("Producto")+" | "+rs.getInt("Cantidad")+" | "+rs.getInt("Precio") + " | " + rs.getInt("ID"));

			 }	
			
		} catch (SQLException o) {
			System.out.println(o.getMessage());
		}
	}

	public void consultarn(String nombre){//aqui te muestra solo aquellos con el nombre introducido
		try{
			String sql2 = "SELECT * FROM compra WHERE CLIENTE ='"+nombre+"'";
			Connection conn = this.conectar();
			PreparedStatement pstmt = conn.prepareStatement(sql2);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("CLIENTE|PRODUCTO|CANTIDAD|PRECIO|ID");
			while (rs.next()) {	
				 System.out.println(rs.getString("Cliente")+ " | " +rs.getString("Producto")+" | "+rs.getInt("Cantidad")+" | "+rs.getInt("Precio") + " | " + rs.getInt("ID"));

			 }	
		}
		catch (SQLException o) {
			System.out.println(o.getMessage());
		}
	}

	public void consultarp(String producto){//aqui te muestra solo aquellos con el producto introducido
		try{
			String sql2 = "SELECT * FROM compra WHERE PRODUCTO ='"+producto+"'";
			Connection conn = this.conectar();
			PreparedStatement pstmt = conn.prepareStatement(sql2);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("CLIENTE|PRODUCTO|CANTIDAD|PRECIO|ID");
			while (rs.next()) {	
				 System.out.println(rs.getString("Cliente")+ " | " +rs.getString("Producto")+" | "+rs.getInt("Cantidad")+" | "+rs.getInt("Precio") + " | " + rs.getInt("ID"));

			 }	
		}
		catch (SQLException o) {
			System.out.println(o.getMessage());
		}
	}

	public void consultari(int id){//aqui te muestra solo aquellos con la ID introducida.
		try{
			String sql2 = "SELECT * FROM compra WHERE ID ="+id;
			Connection conn = this.conectar();
			PreparedStatement pstmt = conn.prepareStatement(sql2);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("CLIENTE|PRODUCTO|CANTIDAD|PRECIO|ID");
			while (rs.next()) {	
				 System.out.println(rs.getString("Cliente")+ " | " +rs.getString("Producto")+" | "+rs.getInt("Cantidad")+" | "+rs.getInt("Precio") + " | " + rs.getInt("ID"));

			 }	
		}
		catch (SQLException o) {
			System.out.println(o.getMessage());
		}
	}
}

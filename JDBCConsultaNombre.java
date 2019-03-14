public void consultar1(String nombre) {
		String sql = "SELECT * FROM compra WHERE CLIENTE ="+nombre;
		try  {
			Connection conn = this.conectar();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException o) {
			System.out.println(o.getMessage());
		}
	}
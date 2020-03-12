package ads.pipoca.model.entity;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ads.pipoca.model.dao.ConnectionFactory;
import ads.pipoca.model.dao.GeneroDAO;

public class Genero {
	private int id;
	private String nome;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "Genero [id=" + id + ", nome=" + nome + "]";
	}
	
	public Genero buscarGenero(int id) throws IOException {
		Genero genero = null;
		String sql = "select id, nome from genero where id=?";

		try (Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery();) {

				if (rs.next()) {
					genero = new Genero();
					genero.setId(id);
					genero.setNome(rs.getString("nome"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return genero;
	}
	
}

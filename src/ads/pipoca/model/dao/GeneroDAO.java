package ads.pipoca.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ads.pipoca.model.entity.Genero;

public class GeneroDAO {
	public ArrayList<Genero> listarGeneros() throws IOException {
		ArrayList<Genero> generos = new ArrayList<>();
		String sql = "select id, nome from genero order by nome";

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {
				Genero genero = new Genero();
				genero.setId(rs.getInt("id"));
				genero.setNome(rs.getString("nome"));
				generos.add(genero);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return generos;
	}
}

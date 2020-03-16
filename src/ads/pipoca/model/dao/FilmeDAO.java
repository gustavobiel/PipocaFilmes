package ads.pipoca.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ads.pipoca.model.entity.Filme;
import ads.pipoca.model.entity.Genero;

public class FilmeDAO {

	public FilmeDAO() {
		// TODO Auto-generated constructor stub
	}

	public Filme atualizarFilme(Filme filme) throws Exception {

		if (filme.getId() < 0) {
			throw new Exception("Deve ser informado um id de Filme valido");
		}

		String sql = "UPDATE pipocadb.filme" + " SET" + " titulo = ?," + " descricao = ?," + " diretor = ?,"
				+ " posterpath = ?," + " popularidade = ?," + " data_lancamento = ?," + " id_genero = ?"
				+ " WHERE id = ?;";

		try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setString(1, filme.getTitulo());
			pst.setString(2, filme.getDescricao());
			pst.setString(3, filme.getDiretor());
			pst.setString(4, filme.getPosterPath());
			pst.setDouble(5, filme.getPopularidade());
			pst.setDate(6, new java.sql.Date(filme.getDataLancamento().getTime()));
			pst.setInt(7, filme.getGenero().getId());
			pst.setInt(8, filme.getId());

			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return filme;
	}

	public Filme buscarFilme(int id) throws IOException {
		Filme filme = null;
		String sql = "select f.id, titulo, descricao, diretor, posterpath, "
				+ "popularidade, data_lancamento, id_genero, nome " + "from filme f, genero g "
				+ "where f.id_genero = g.id and f.id = ?";

		try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery();) {

				while (rs.next()) {
					filme = new Filme();
					filme.setId(id);
					filme.setTitulo(rs.getString("titulo"));
					filme.setDescricao(rs.getString("descricao"));
					filme.setDiretor(rs.getString("diretor"));
					filme.setPosterPath(rs.getString("posterpath"));
					filme.setPopularidade(rs.getDouble("popularidade"));
					filme.setDataLancamento(rs.getDate("data_lancamento"));
					Genero genero = new Genero();
					genero.setId(rs.getInt("id_genero"));
					genero.setNome(rs.getString("nome"));
					filme.setGenero(genero);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return filme;
	}

}

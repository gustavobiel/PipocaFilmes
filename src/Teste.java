import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import ads.pipoca.controller.ManterFilmes;
import ads.pipoca.model.entity.Filme;
import ads.pipoca.model.entity.Genero;

public class Teste {

	public static void main(String[] args) {
		ManterFilmes manter = new ManterFilmes();
		try {
			manter.listarGeneros();
			int id = manter.inserirFilme();
			Filme filme = manter.listarFilme(id);
			
			//atualizar
			filme.setTitulo("O Naufrago2");
			filme.setDescricao("Chuck Noland  (Tom Hanks) um inspetor da Federal Express (FedEx), "
					+ "multinacional encarregada de enviar cargas e correspondências, que tem por "
					+ "função checar vários escritórios da empresa pelo planeta. Porém, em uma de "
					+ "suas ....");
			filme.setDiretor("Eloiza Yoshida");

			Genero genero = new Genero();
			genero.setId(16);
			filme.setGenero(genero);

			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			try {
				filme.setDataLancamento(formatter.parse("15/03/2020"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				filme.setDataLancamento(null);
			}

			filme.setPopularidade(50.25);
			filme.setPosterPath("img/naufrago2.jpg");
			manter.atualizarFilme(filme);
			System.out.println("=============   APOS ATUALIZACAO  =================================");
			System.out.println(filme);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

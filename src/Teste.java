import java.io.IOException;

import ads.pipoca.controller.ManterFilmes;

public class Teste {

	public static void main(String[] args) {
		ManterFilmes manter = new ManterFilmes();
		try {
			manter.listarGeneros();
			int id = manter.inserirFilme();
			manter.listarFilme(id);
			System.out.println("=======================");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

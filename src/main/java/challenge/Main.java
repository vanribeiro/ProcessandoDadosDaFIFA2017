package challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Generated;

public class Main {
	static Main objetoMain = new Main();
	
	public List<Jogadores> executarMetodos() {
		String arquivo = "C:\\Users\\vanes\\codenation\\java-3\\src\\main\\resources\\data.csv";
		ExtraindoDadosDoCSV extrair = new ExtraindoDadosDoCSV(arquivo);
		List<Jogadores> dadosDosJogadores = extrair.lerDados();
		return dadosDosJogadores;
	}
	

	// Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
	public int q1() {
	    List<Jogadores> dados = objetoMain.executarMetodos();
		Set<String> paises = new HashSet<String>();
		
		for(int i = 1; i < dados.size(); i++) {
			paises.add(dados.get(i).getNacionalidade());
		} 
		
		return paises.size();
	}

	// Quantos clubes (coluna `club`) diferentes existem no arquivo?
	// Obs: Existem jogadores sem clube.
	public int q2() {
		 List<Jogadores> dados = objetoMain.executarMetodos();
		
		Set<String> clubes = new HashSet<String>();
		for(int i = 0; i < dados.size(); i++) {
			clubes.add(dados.get(i).getNomeDosClubes());
		}

		return clubes.size();
	}

	// Liste o primeiro nome (coluna `full_name`) dos 20 primeiros jogadores.
	public List<String> q3() {
		List<Jogadores> dados = objetoMain.executarMetodos();
		List<String> nomeCompleto = new ArrayList<String>();
		
		for(int i = 0; i < 20; i++) {
			nomeCompleto.add(dados.get(i).getNomeCompleto());
		}

		return nomeCompleto;
	}

	// Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
	// (utilize as colunas `full_name` e `eur_release_clause`)
	public List<String> q4() {
		List<Jogadores> dados = objetoMain.executarMetodos();
		List<String> clausulas = new ArrayList<String>();
		
		Collections.sort(dados, new OrdenarClausulas().reversed());
		
		for(int i = 0; i < 10; i++) {
			clausulas.add(dados.get(i).getNomeCompleto());
		}
		
		return clausulas;
	}

	// Quem são os 10 jogadores mais velhos (use como critério de desempate o campo `eur_wage`)?
	// (utilize as colunas `full_name` e `birth_date`)
	public List<String> q5() {
		List<Jogadores> dados = objetoMain.executarMetodos();
		List<String> osMaisVelhos = new ArrayList<String>();

		Collections.sort(dados, new OrdenarDataDeNascimento());
		
		for(int i = 0; i < 10; i++) {
			osMaisVelhos.add(dados.get(i).getNomeCompleto());
		}
		
		for(int i = 0; i < 10; i++) {
			System.out.println(osMaisVelhos.get(i));
		}
		
		return osMaisVelhos;
	}

	// Conte quantos jogadores existem por idade. Para isso, construa um mapa 
	// onde as chaves são as idades e os valores a contagem.
	// (utilize a coluna `age`)
	public Map<Integer, Integer> q6() {
		Map<Integer, Integer> idadeDosJogadores = new HashMap<Integer, Integer>();
		List<Jogadores> dados = objetoMain.executarMetodos();
		List<Integer> colunaIdade = new ArrayList<Integer>();
		
		for(int i = 0; i < dados.size(); i++) {
			colunaIdade.add(dados.get(i).getIdade());
		}
		
		colunaIdade.forEach(id 
				-> idadeDosJogadores.compute(id, (Integer idade, Integer frequencia)  
					-> (frequencia == null) ? 1 : ++frequencia));
		
		return idadeDosJogadores;
	}
	

	public static void main(String[] args) {
		
		/* Respostas */
		objetoMain.q1();
		objetoMain.q2();
		objetoMain.q3();
		objetoMain.q4();
		objetoMain.q5();
		objetoMain.q6();
		
	}

}

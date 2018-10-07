package challenge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExtraindoDadosDoCSV {
	private String arquivo;
	private String[] jogadores;
	private List<Jogadores> dadosDosJogadores = new ArrayList<Jogadores>();
	
	public List<Jogadores> getDadosDosJogadores() {
		return this.dadosDosJogadores;
	}

	public ExtraindoDadosDoCSV(String arquivo) {
		this.arquivo = arquivo;
	}
	

	public List<Jogadores> lerDados() {
		
		BufferedReader conteudoArquivo = null;
		
		String separador = ",";
		String linha = "";
		boolean cabecalhoLido = false;
		
		try{
			conteudoArquivo = new BufferedReader(new FileReader(arquivo));
			while((linha = conteudoArquivo.readLine()) != null) {
				if(!cabecalhoLido) {
					cabecalhoLido = true;
					continue;
				} int i = 0;
				
				jogadores = linha.split(separador);
				String nomeCompleto = jogadores[2];
				String nacionalidade = jogadores[14];
				int idade = Integer.parseInt(jogadores[6]);
				Double euroWage = Double.parseDouble(jogadores[17]);
				String nomeDosClubes = jogadores[3];
				
				String[] aux = new String[17994];
				aux[i] = jogadores[18];
				
				if(aux[i].isEmpty()) {
					aux[i] = "0.0";
				}
				
				Double rescisao = Double.parseDouble(aux[i]);
				String birthDay = jogadores[8].replace("-", "/");
				SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
				Date aniversario = null;
				try {
					aniversario = formatarData.parse(birthDay);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				dadosDosJogadores.add(new Jogadores(nomeCompleto, idade, nacionalidade, 
						nomeDosClubes, rescisao, euroWage, aniversario));
			}
		} catch(FileNotFoundException e) {
			System.out.println("Arquivo não encontrado: \n" + e.getMessage());
		} catch(ArrayIndexOutOfBoundsException e ) {
			System.out.println("Indice fora dos limites: \n" + e.getMessage());
		} catch(IOException e) {
			System.out.println("Erro de entrada de dados: \n" + e.getMessage());
		} finally {
			if(conteudoArquivo != null) {
				try {
					conteudoArquivo.close();
				} catch(IOException e) {
					System.out.println("Erro de entrada de dados: \n" + e.getMessage());
				}
			}
		}
		return dadosDosJogadores;
	}
}

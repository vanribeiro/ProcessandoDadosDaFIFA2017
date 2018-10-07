package challenge;

import java.util.Comparator;

public class OrdenarListas{
	
}

class OrdenarClausulas implements Comparator<Jogadores>{
	 @Override
	 public int compare(Jogadores x, Jogadores y) {
			return x.getRescisao().compareTo(y.getRescisao());
	 }
}

class OrdenarDataDeNascimento implements Comparator<Jogadores>{
	@Override
	public int compare(Jogadores x, Jogadores y) {
		if(x.getDataDeNascimento().equals(y.getDataDeNascimento())){
			if(x.getEuroWage() < y.getEuroWage())
				return x.getDataDeNascimento().compareTo(y.getDataDeNascimento());
		}
		return x.getDataDeNascimento().compareTo(y.getDataDeNascimento());
	}
}
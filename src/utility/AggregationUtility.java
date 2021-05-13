package utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import entity.dylandog.Artista;

public class AggregationUtility {
	
	public final static String PATTERN_SPLIT = ",|&| e ";
	
	public static HashMap<String, String> getHashArtistaFromListString(List<String> input){
		HashMap<String, String> output = new HashMap<String, String>();
		input.forEach(stringaInput->{
			String[] stringaInputSplit = stringaInput.split(PATTERN_SPLIT);
			for(String artistaString : stringaInputSplit) {
				output.put(artistaString.trim(), artistaString.trim());
			}
		});
		return output;
	}
	
	public static List<Artista> getArtistaFromString(String input){
		List<Artista> output = new ArrayList<Artista>();
		String[] stringaInputSplit = input.split(PATTERN_SPLIT);
		for(String artistaString : stringaInputSplit) {
			Artista artista = new Artista();
			artista.setNomeCognome(artistaString.trim());
			output.add(artista);
		}
		return output;
	}
	
	

}

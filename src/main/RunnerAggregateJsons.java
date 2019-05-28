package main;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import utility.JsonUtility;
import utility.PropertiesUtility;

public class RunnerAggregateJsons {

	private static Properties props;

	static {
		try{
			props = PropertiesUtility.getPropValues();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	};

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException, GeneralSecurityException, ParseException {
		String folder = args[0];
        
		//items
		String itemsName = "items.json";
		JSONObject garage = JsonUtility.getGarage(folder, itemsName);
        JSONObject balcone = JsonUtility.getBalcone(folder, itemsName);
        //ABC
		String abcName = "ABC.json";
		JSONObject abc = JsonUtility.getABC(folder, abcName);
        //ENI
		String eniName = "ENI.json";
		JSONObject eni = JsonUtility.getENI(folder, eniName);
        //SEN
		String senName = "SEN.json";
		JSONObject sen = JsonUtility.getSEN(folder, senName);
        //spese
		String speseName = "spese.json";
		JSONObject spese = JsonUtility.getSpese(folder, speseName);
        //medicines
		String medicinesName = "medicines.json";
		JSONObject medicines = JsonUtility.getMedicines(folder, medicinesName);
        //medicines
		String wineName = "wine.json";
		JSONObject wine = JsonUtility.getWine(folder, wineName);
        
		JSONArray fulljson = new JSONArray();
		fulljson.add(garage);
		fulljson.add(balcone);
		fulljson.add(abc);
		fulljson.add(eni);
		fulljson.add(sen);
		fulljson.add(spese);
		fulljson.add(medicines);
		fulljson.add(wine);
		
		JsonUtility.writeFileFromJSONArray(fulljson, "fulljson", folder);
		System.out.println("Finito!");
	}
}

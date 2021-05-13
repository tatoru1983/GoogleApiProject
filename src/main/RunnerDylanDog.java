package main;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Properties;

import org.json.simple.JSONArray;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import entity.dylandog.Albo;
import utility.GoogleUtility;
import utility.JsonUtility;
import utility.PropertiesUtility;

public class RunnerDylanDog {

	private static Properties props;

	static {
		try{
			props = PropertiesUtility.getPropValues();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	};

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException, GeneralSecurityException {
		String folder = args[0];
		// Build a new authorized API client service.
		final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		String range = "";
		//Garage
		final String spreadsheetIdGarage = props.getProperty("spreadsheetIdDylanDog");
		final String albi = props.getProperty("sheetNameDylanDogAlbi");
		range = albi.concat("!A2:I600");
		
		List<Albo> listDylanDog = GoogleUtility.getDylanDogByRange(spreadsheetIdGarage, range, HTTP_TRANSPORT);
		
		JSONArray items = JsonUtility.getJSONDylanDog(listDylanDog);
		
		JsonUtility.writeFileFromJSONArray(items, "dylandog", folder);
		System.out.println("Finito!");
	}
}

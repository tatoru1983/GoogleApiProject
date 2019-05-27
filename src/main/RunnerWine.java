package main;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.json.simple.JSONArray;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import entity.ElementoLista;
import entity.Vino;
import utility.GoogleUtility;
import utility.JsonUtility;
import utility.PropertiesUtility;

public class RunnerWine {

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
		final String spreadsheetIdGarage = props.getProperty("spreadsheetIdGarage");
		final String vino = props.getProperty("sheetNameGarageVino");
		range = vino.concat("!A2:J200");
		List<Vino> listVino = GoogleUtility.getWineByRange(spreadsheetIdGarage, range, HTTP_TRANSPORT);
		
		JSONArray items = JsonUtility.getJSONWine(listVino);
		
		JsonUtility.writeFileFromJSONArray(items, "wine", folder);
		System.out.println("Finito!");
	}
}

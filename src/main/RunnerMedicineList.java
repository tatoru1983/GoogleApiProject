package main;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Properties;

import org.json.simple.JSONArray;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import entity.Medicina;
import utility.GoogleUtility;
import utility.JsonUtility;
import utility.PropertiesUtility;

public class RunnerMedicineList {

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
		final String spreadsheetIdMedicine = props.getProperty("spreadsheetIdMedicine");
		final String medicine = props.getProperty("sheetNameMedicine");
		//Reparto1
		range = medicine.concat("!A2:C300");
		List<Medicina> listMedicine = GoogleUtility.getMedicineByRange(spreadsheetIdMedicine, range, HTTP_TRANSPORT);
		
		JSONArray items = JsonUtility.getJSONItems(listMedicine);
		
		JsonUtility.writeFileFromJSONArray(items, "medicines", folder);
		System.out.println("Finito!");
	}
}

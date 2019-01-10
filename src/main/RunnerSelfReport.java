package main;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.GeneralSecurityException;
import java.util.Properties;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import entity.Lettura;
import utility.DataUtility;
import utility.GoogleUtility;
import utility.JsonUtility;
import utility.PropertiesUtility;

public class RunnerSelfReport {

	private static Properties props;

	static {
		try{
			props = PropertiesUtility.getPropValues();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	};

	public static void main(String[] args) throws IOException, GeneralSecurityException {
		String folder = args[0];
		// Build a new authorized API client service.
		final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		final String spreadsheetId = props.getProperty("spreadsheetIdAutolettura");
		BigDecimal firstYear = new BigDecimal(2018);
		BigDecimal lastYear = DataUtility.getCurrentYear();
		Vector<Lettura> vecSenA1 = new Vector<Lettura>(); 
		Vector<Lettura> vecSenA2 = new Vector<Lettura>(); 
		Vector<Lettura> vecSenA3 = new Vector<Lettura>(); 
		Vector<Lettura> vecEni = new Vector<Lettura>();
		Vector<Lettura> vecAbc = new Vector<Lettura>();
		for(int i=firstYear.intValue(); i<=lastYear.intValue(); i++ ) {
			final String sheetName = Integer.toString(i);
			String range = "";
			//SEN A1
			range = sheetName.concat("!A2:M2");
			Lettura letturaSenA1 = GoogleUtility.getLetturaByRange(spreadsheetId, range, HTTP_TRANSPORT, sheetName);
			//SEN A2
			range = sheetName.concat("!A3:M3");
			Lettura letturaSenA2 = GoogleUtility.getLetturaByRange(spreadsheetId, range, HTTP_TRANSPORT, sheetName);
			//SEN A3
			range = sheetName.concat("!A4:M4");
			Lettura letturaSenA3 = GoogleUtility.getLetturaByRange(spreadsheetId, range, HTTP_TRANSPORT, sheetName);
			//ENI
			range = sheetName.concat("!A5:M5");
			Lettura letturaEni = GoogleUtility.getLetturaByRange(spreadsheetId, range, HTTP_TRANSPORT, sheetName);
			//ABC
			range = sheetName.concat("!A6:M6");
			Lettura letturaAbc = GoogleUtility.getLetturaByRange(spreadsheetId, range, HTTP_TRANSPORT, sheetName);

			vecSenA1.add(letturaSenA1);
			vecSenA2.add(letturaSenA2);
			vecSenA3.add(letturaSenA3);
			vecEni.add(letturaEni);
			vecAbc.add(letturaAbc);
		}

		//creo i JSON
		JSONArray sen = new JSONArray();
		for(int i=0; i<vecSenA1.size(); i++) {
			Lettura letturaSenA1 = vecSenA1.get(i);
			Lettura letturaSenA2 = vecSenA2.get(i);
			Lettura letturaSenA3 = vecSenA3.get(i);
			JSONArray senYear = JsonUtility.getJSONFromSEN(letturaSenA1, letturaSenA2, letturaSenA3);
			for(int j=0; j<senYear.size(); j++) {
				JSONObject senMonth = (JSONObject) senYear.get(j);
				sen.add(senMonth);
			}
		}
		JsonUtility.writeFileFromJSONArray(sen, "SEN", folder);

		JSONArray eni = new JSONArray();
		for(Lettura letturaEni : vecEni) {
			JSONArray eniYear = JsonUtility.getJSONFromENI(letturaEni);
			for(int j=0; j<eniYear.size(); j++) {
				JSONObject eniMonth = (JSONObject) eniYear.get(j);
				eni.add(eniMonth);
			}
		}
		JsonUtility.writeFileFromJSONArray(eni, "ENI", folder);

		JSONArray abc = new JSONArray();
		for(Lettura letturaAbc : vecAbc) {
			JSONArray abcYear = JsonUtility.getJSONFromABC(letturaAbc);
			for(int j=0; j<abcYear.size(); j++) {
				JSONObject abcMonth = (JSONObject) abcYear.get(j);
				abc.add(abcMonth);
			}
		}
		JsonUtility.writeFileFromJSONArray(abc, "ABC", folder);
		System.out.println("Finito!");
	}
}

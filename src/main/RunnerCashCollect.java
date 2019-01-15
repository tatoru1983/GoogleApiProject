package main;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import org.jfree.data.general.DefaultPieDataset;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import entity.InfoUtenza;
import entity.Lettura;
import utility.ChartUtility;
import utility.DataUtility;
import utility.GoogleUtility;
import utility.JsonUtility;
import utility.PropertiesUtility;

public class RunnerCashCollect {

	private static Properties props;

	static {
		try{
			props = PropertiesUtility.getPropValues();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	};

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException, GeneralSecurityException {
		String folder = args[0];
		// Build a new authorized API client service.
		final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		final String spreadsheetId = props.getProperty("spreadsheetIdSpese");
		BigDecimal firstYear = new BigDecimal(2018);
		BigDecimal lastYear = DataUtility.getCurrentYear();
		Vector<InfoUtenza> vecSpeseAbc = new Vector<InfoUtenza>();
		Vector<InfoUtenza> vecSpeseSen = new Vector<InfoUtenza>();
		Vector<InfoUtenza> vecSpeseEni = new Vector<InfoUtenza>();
		Vector<InfoUtenza> vecSpeseCondominio = new Vector<InfoUtenza>();
		Vector<InfoUtenza> vecSpeseCondominioExtra = new Vector<InfoUtenza>();
		Vector<InfoUtenza> vecSpeseTari = new Vector<InfoUtenza>();
		Vector<InfoUtenza> vecSpeseTelefono = new Vector<InfoUtenza>();
		Vector<InfoUtenza> vecSpeseTelepass = new Vector<InfoUtenza>();
		Vector<InfoUtenza> vecSpeseCanone = new Vector<InfoUtenza>();

		for(int i=firstYear.intValue(); i<=lastYear.intValue(); i++ ) {
			final String sheetName = Integer.toString(i);
			String range = "";
			//ABC
			range = sheetName.concat("!A2:M2");
			InfoUtenza utenzaAbc = GoogleUtility.getInfoUtenzaByRange(spreadsheetId, range, HTTP_TRANSPORT, sheetName, "ABC");
			//SEN
			range = sheetName.concat("!A3:M3");
			InfoUtenza utenzaSen = GoogleUtility.getInfoUtenzaByRange(spreadsheetId, range, HTTP_TRANSPORT, sheetName, "SEN");
			//ENI
			range = sheetName.concat("!A4:M4");
			InfoUtenza utenzaEni = GoogleUtility.getInfoUtenzaByRange(spreadsheetId, range, HTTP_TRANSPORT, sheetName, "ENI");
			//Condominio
			range = sheetName.concat("!A5:M5");
			InfoUtenza utenzaCondominio = GoogleUtility.getInfoUtenzaByRange(spreadsheetId, range, HTTP_TRANSPORT, sheetName, "CONDOMINIO");
			//Condominio (extra)
			range = sheetName.concat("!A6:M6");
			InfoUtenza utenzaCondominioExtra = GoogleUtility.getInfoUtenzaByRange(spreadsheetId, range, HTTP_TRANSPORT, sheetName, "CONDOMINIO_EXTRA");
			//TARI
			range = sheetName.concat("!A7:M7");
			InfoUtenza utenzaTari = GoogleUtility.getInfoUtenzaByRange(spreadsheetId, range, HTTP_TRANSPORT, sheetName, "TARI");
			//Telefono
			range = sheetName.concat("!A8:M8");
			InfoUtenza utenzaTelefono = GoogleUtility.getInfoUtenzaByRange(spreadsheetId, range, HTTP_TRANSPORT, sheetName, "TELEFONO");
			//Telepass
			range = sheetName.concat("!A9:M9");
			InfoUtenza utenzaTelepass = GoogleUtility.getInfoUtenzaByRange(spreadsheetId, range, HTTP_TRANSPORT, sheetName, "TELEPASS");
			//Canone RAI
			range = sheetName.concat("!A10:M10");
			InfoUtenza utenzaCanone = GoogleUtility.getInfoUtenzaByRange(spreadsheetId, range, HTTP_TRANSPORT, sheetName, "CANONE");
			
			vecSpeseAbc.add(utenzaAbc);
			vecSpeseSen.add(utenzaSen);
			vecSpeseEni.add(utenzaEni);
			vecSpeseCondominio.add(utenzaCondominio);
			vecSpeseCondominioExtra.add(utenzaCondominioExtra);
			vecSpeseTari.add(utenzaTari);
			vecSpeseTelefono.add(utenzaTelefono);
			vecSpeseTelepass.add(utenzaTelepass);
			vecSpeseCanone.add(utenzaCanone);
		}

		//creo i JSON
		JSONArray spese = new JSONArray();
		for(int i=0; i<vecSpeseAbc.size(); i++) {
			InfoUtenza utenzaAbc = vecSpeseAbc.get(i);
			InfoUtenza utenzaSen = vecSpeseSen.get(i);
			InfoUtenza utenzaEni = vecSpeseEni.get(i);
			InfoUtenza utenzaCondominio = vecSpeseCondominio.get(i);
			InfoUtenza utenzaCondominioExtra = vecSpeseCondominioExtra.get(i);
			InfoUtenza utenzaTari = vecSpeseTari.get(i);
			InfoUtenza utenzaTelefono = vecSpeseTelefono.get(i);
			InfoUtenza utenzaTelepass = vecSpeseTelepass.get(i);
			InfoUtenza utenzaCanone = vecSpeseCanone.get(i);
			JSONArray year = JsonUtility.getJSONYear(utenzaAbc, utenzaSen, utenzaEni, utenzaCondominio, utenzaCondominioExtra, utenzaTari, utenzaTelefono, utenzaTelepass, utenzaCanone);
			for(int j=0; j<year.size(); j++) {
				JSONObject month = (JSONObject) year.get(j);
				spese.add(month);
			}
		}
		JsonUtility.writeFileFromJSONArray(spese, "spese", folder);
		
		System.out.println("Finito!");
	}

}

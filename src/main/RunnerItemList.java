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
import utility.GoogleUtility;
import utility.JsonUtility;
import utility.PropertiesUtility;

public class RunnerItemList {

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
		final String garageReparto1 = props.getProperty("sheetNameGarageReparto1");
		final String garageReparto2 = props.getProperty("sheetNameGarageReparto2");
		//Reparto1
		range = garageReparto1.concat("!A2:C200");
		List<ElementoLista> listGarageRep1 = GoogleUtility.getElementiListaByRange(spreadsheetIdGarage, range, HTTP_TRANSPORT, garageReparto1);
		//Reparto2
		range = garageReparto2.concat("!A2:C200");
		List<ElementoLista> listGarageRep2 = GoogleUtility.getElementiListaByRange(spreadsheetIdGarage, range, HTTP_TRANSPORT, garageReparto2);
		//Balcone
		final String spreadsheetIdBalcone = props.getProperty("spreadsheetIdBalcone");
		final String balconeReparto1 = props.getProperty("sheetNameBalconeReparto1");
		final String balconeReparto2 = props.getProperty("sheetNameBalconeReparto2");
		//Reparto1
		range = balconeReparto1.concat("!A2:C200");
		List<ElementoLista> listBalconeRep1 = GoogleUtility.getElementiListaByRange(spreadsheetIdBalcone, range, HTTP_TRANSPORT, balconeReparto1);
		//Reparto2
		range = balconeReparto2.concat("!A2:C200");
		List<ElementoLista> listBalconeRep2 = GoogleUtility.getElementiListaByRange(spreadsheetIdBalcone, range, HTTP_TRANSPORT, balconeReparto2);
		

		List<ElementoLista> listGarage = new ArrayList<ElementoLista>();
		List<ElementoLista> listBalcone = new ArrayList<ElementoLista>();
		
		listGarage.addAll(listGarageRep1);
		listGarage.addAll(listGarageRep2);
		
		listBalcone.addAll(listBalconeRep1);
		listBalcone.addAll(listBalconeRep2);
		
		JSONArray items = JsonUtility.getJSONItems(listGarage, listBalcone);
		
		JsonUtility.writeFileFromJSONArray(items, "items", folder);
		System.out.println("Finito!");
	}
}

package utility;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;

import entity.ElementoLista;
import entity.InfoUtenza;
import entity.Lettura;
import entity.Medicina;
import entity.Vino;
import entity.dylandog.Albo;
import prova.ProvaMainClass;

public class GoogleUtility {
    public static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
    public static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    public static final String TOKENS_DIRECTORY_PATH = "tokens";
    
    public static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS_READONLY);
    public static final String CREDENTIALS_FILE_PATH = "/credentials.json";
    
    public static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = ProvaMainClass.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }
    
    public static Lettura getLetturaByRange(String spreadsheetId, String range, NetHttpTransport HTTP_TRANSPORT, String year) throws IOException {
    	Sheets service = new Sheets.Builder(HTTP_TRANSPORT, GoogleUtility.JSON_FACTORY, GoogleUtility.getCredentials(HTTP_TRANSPORT))
				.setApplicationName(GoogleUtility.APPLICATION_NAME).build();
		ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
		List<List<Object>> values = response.getValues();
		if (values == null || values.isEmpty()) {
			System.out.println("No data found.");
			return null;
		} else {
			for (List row : values) {
				Lettura lettura = new Lettura(row, year);
				return lettura;
			}
		}
		return null;
    }
    
    public static InfoUtenza getInfoUtenzaByRange(String spreadsheetId, String range, NetHttpTransport HTTP_TRANSPORT, String year, String utenzaName) throws IOException {
    	Sheets service = new Sheets.Builder(HTTP_TRANSPORT, GoogleUtility.JSON_FACTORY, GoogleUtility.getCredentials(HTTP_TRANSPORT))
				.setApplicationName(GoogleUtility.APPLICATION_NAME).build();
		ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
		List<List<Object>> values = response.getValues();
		if (values == null || values.isEmpty()) {
			System.out.println("No data found.");
			return null;
		} else {
			for (List row : values) {
				InfoUtenza utenza = new InfoUtenza(row, year);
				utenza.setUtenza(utenzaName);
				return utenza;
			}
		}
		return null;
    }
    
    public static List<ElementoLista> getElementiListaByRange(String spreadsheetId, String range, NetHttpTransport HTTP_TRANSPORT, String reparto) throws IOException {
    	List<ElementoLista> result = new ArrayList<ElementoLista>();
    	Sheets service = new Sheets.Builder(HTTP_TRANSPORT, GoogleUtility.JSON_FACTORY, GoogleUtility.getCredentials(HTTP_TRANSPORT))
				.setApplicationName(GoogleUtility.APPLICATION_NAME).build();
		ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
		List<List<Object>> values = response.getValues();
		if (values == null || values.isEmpty()) {
			System.out.println("No data found.");
			return null;
		} else {
			for (List row : values) {
				ElementoLista elemento = new ElementoLista(row);
				if(elemento!=null && elemento.getTipo()!=null) {
					elemento.setReparto(reparto);
					result.add(elemento);
				}
			}
		}
		return result;
    }
    
    public static List<Medicina> getMedicineByRange(String spreadsheetId, String range, NetHttpTransport HTTP_TRANSPORT) throws IOException {
    	List<Medicina> result = new ArrayList<Medicina>();
    	Sheets service = new Sheets.Builder(HTTP_TRANSPORT, GoogleUtility.JSON_FACTORY, GoogleUtility.getCredentials(HTTP_TRANSPORT))
				.setApplicationName(GoogleUtility.APPLICATION_NAME).build();
		ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
		List<List<Object>> values = response.getValues();
		if (values == null || values.isEmpty()) {
			System.out.println("No data found.");
			return null;
		} else {
			for (List row : values) {
				Medicina medicina = new Medicina(row);
				if(medicina!=null && medicina.getTipo()!=null) {
					result.add(medicina);
				}
			}
		}
		return result;
    }
    
    public static List<Vino> getWineByRange(String spreadsheetId, String range, NetHttpTransport HTTP_TRANSPORT) throws IOException {
    	List<Vino> result = new ArrayList<Vino>();
    	Sheets service = new Sheets.Builder(HTTP_TRANSPORT, GoogleUtility.JSON_FACTORY, GoogleUtility.getCredentials(HTTP_TRANSPORT))
				.setApplicationName(GoogleUtility.APPLICATION_NAME).build();
		ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
		List<List<Object>> values = response.getValues();
		if (values == null || values.isEmpty()) {
			System.out.println("No data found.");
			return null;
		} else {
			for (List row : values) {
				Vino vino = new Vino(row);
				if(vino!=null && vino.getTipo()!=null) {
					result.add(vino);
				}
			}
		}
		return result;
    }
    
    public static List<Albo> getDylanDogByRange(String spreadsheetId, String range, NetHttpTransport HTTP_TRANSPORT) throws IOException {
    	List<Albo> result = new ArrayList<Albo>();
    	Sheets service = new Sheets.Builder(HTTP_TRANSPORT, GoogleUtility.JSON_FACTORY, GoogleUtility.getCredentials(HTTP_TRANSPORT))
				.setApplicationName(GoogleUtility.APPLICATION_NAME).build();
		ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
		List<List<Object>> values = response.getValues();
		if (values == null || values.isEmpty()) {
			System.out.println("No data found.");
			return null;
		} else {
			List<String> artistaString = new ArrayList<String>();
			
			//primo ciclo, scorro gli artisti
			for (List row : values) {
				if(row.size()>3 && row.get(3)!=null)
					artistaString.add(row.get(3).toString());
				if(row.size()>4 && row.get(4)!=null)
					artistaString.add(row.get(4).toString());
				if(row.size()>5 && row.get(5)!=null)
					artistaString.add(row.get(5).toString());
				if(row.size()>6 && row.get(6)!=null)
					artistaString.add(row.get(6).toString());
			}
			HashMap artistaHash = AggregationUtility.getHashArtistaFromListString(artistaString);
			
			//secondo ciclo, costruisco gli albi
			for (List row : values) {
				Albo albo = new Albo(row, artistaHash);
				result.add(albo);
			}
		}
    	return result;
    }

}

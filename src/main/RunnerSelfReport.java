package main;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.jfree.data.category.DefaultCategoryDataset;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import entity.Lettura;
import utility.ChartUtility;
import utility.GoogleUtility;
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
		// Build a new authorized API client service.
		final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		final String spreadsheetId = props.getProperty("spreadsheetIdAutolettura");
		final String sheetName = props.getProperty("sheetNameAutolettura");
		final String range = sheetName.concat("!A2:M6");
		Sheets service = new Sheets.Builder(HTTP_TRANSPORT, GoogleUtility.JSON_FACTORY, GoogleUtility.getCredentials(HTTP_TRANSPORT))
				.setApplicationName(GoogleUtility.APPLICATION_NAME)
				.build();
		ValueRange response = service.spreadsheets().values()
				.get(spreadsheetId, range)
				.execute();
		List<List<Object>> values = response.getValues();
		List<Lettura> letture = new ArrayList<Lettura>();
		if (values == null || values.isEmpty()) {
			System.out.println("No data found.");
		} else {
			for (List row : values) {
				Lettura lettura = new Lettura(row);
				letture.add(lettura);
			}
			//costruisco l'immagine
			DefaultCategoryDataset lineChartDataset = new DefaultCategoryDataset();
			for(Lettura lettura : letture) {
				lineChartDataset.addValue(lettura.getGennaio(), lettura.getUtenza(), "Gennaio");
				lineChartDataset.addValue(lettura.getFebbraio(), lettura.getUtenza(), "Febbraio");
				lineChartDataset.addValue(lettura.getMarzo(), lettura.getUtenza(), "Marzo");
				lineChartDataset.addValue(lettura.getAprile(), lettura.getUtenza(), "Aprile");
				lineChartDataset.addValue(lettura.getMaggio(), lettura.getUtenza(), "Maggio");
				lineChartDataset.addValue(lettura.getGiugno(), lettura.getUtenza(), "Giugno");
				lineChartDataset.addValue(lettura.getLuglio(), lettura.getUtenza(), "Luglio");
				lineChartDataset.addValue(lettura.getAgosto(), lettura.getUtenza(), "Agosto");
				lineChartDataset.addValue(lettura.getSettembre(), lettura.getUtenza(), "Settembre");
				lineChartDataset.addValue(lettura.getOttobre(), lettura.getUtenza(), "Ottobre");
				lineChartDataset.addValue(lettura.getNovembre(), lettura.getUtenza(), "Novembre");
				lineChartDataset.addValue(lettura.getDicembre(), lettura.getUtenza(), "Dicembre");
			}
			
			//Line Chart Globale
			ChartUtility.createLineChart("Consumi Anno 2018", "Mesi", "Consumi", lineChartDataset, "consumi2018");
			
			//Line Chart per utenza
			for(Lettura lettura : letture) {
				DefaultCategoryDataset lineChartDatasetUtenza = new DefaultCategoryDataset();
				lineChartDatasetUtenza.addValue(lettura.getGennaio(), lettura.getUtenza(), "Gennaio");
				lineChartDatasetUtenza.addValue(lettura.getFebbraio(), lettura.getUtenza(), "Febbraio");
				lineChartDatasetUtenza.addValue(lettura.getMarzo(), lettura.getUtenza(), "Marzo");
				lineChartDatasetUtenza.addValue(lettura.getAprile(), lettura.getUtenza(), "Aprile");
				lineChartDatasetUtenza.addValue(lettura.getMaggio(), lettura.getUtenza(), "Maggio");
				lineChartDatasetUtenza.addValue(lettura.getGiugno(), lettura.getUtenza(), "Giugno");
				lineChartDatasetUtenza.addValue(lettura.getLuglio(), lettura.getUtenza(), "Luglio");
				lineChartDatasetUtenza.addValue(lettura.getAgosto(), lettura.getUtenza(), "Agosto");
				lineChartDatasetUtenza.addValue(lettura.getSettembre(), lettura.getUtenza(), "Settembre");
				lineChartDatasetUtenza.addValue(lettura.getOttobre(), lettura.getUtenza(), "Ottobre");
				lineChartDatasetUtenza.addValue(lettura.getNovembre(), lettura.getUtenza(), "Novembre");
				lineChartDatasetUtenza.addValue(lettura.getDicembre(), lettura.getUtenza(), "Dicembre");
				ChartUtility.createLineChart("Consumi ".concat(lettura.getUtenza()) .concat(" 2018"), "Mesi", "Consumi", lineChartDatasetUtenza, "consumi_".concat(lettura.getUtenza()) .concat("_2018"));
			}
		}
		System.out.println("Finito!");
	}
}

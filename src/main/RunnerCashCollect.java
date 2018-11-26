package main;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import entity.InfoUtenza;
import utility.GoogleUtility;
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

	public static void main(String[] args) throws IOException, GeneralSecurityException {
		// Build a new authorized API client service.
		final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		final String spreadsheetId = props.getProperty("spreadsheetIdSpese2018");
		final String sheetName = props.getProperty("sheetNameSpese2018");
		final String range = sheetName.concat("!A2:M10");
		Sheets service = new Sheets.Builder(HTTP_TRANSPORT, GoogleUtility.JSON_FACTORY, GoogleUtility.getCredentials(HTTP_TRANSPORT))
				.setApplicationName(GoogleUtility.APPLICATION_NAME)
				.build();
		ValueRange response = service.spreadsheets().values()
				.get(spreadsheetId, range)
				.execute();
		List<List<Object>> values = response.getValues();
		List<InfoUtenza> utenze = new ArrayList<InfoUtenza>();
		if (values == null || values.isEmpty()) {
			System.out.println("No data found.");
		} else {
			for (List row : values) {
				InfoUtenza utenza = new InfoUtenza(row);
				utenze.add(utenza);
			}

			DefaultPieDataset dataset = new DefaultPieDataset( );
			for(InfoUtenza utenza : utenze) {
				dataset.setValue(utenza.getUtenza(), utenza.getSomma() );
			}

			JFreeChart chart = ChartFactory.createPieChart(
					"Consumi totali",   // chart title
					dataset,          // data
					true,             // include legend
					true,
					false);

			int width = 640;   /* Width of the image */
			int height = 480;  /* Height of the image */ 
			File pieChart = new File( "ConsumiTotali.jpeg" ); 
			ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
		}
		System.out.println("Finito!");
	}

}

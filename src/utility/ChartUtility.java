package utility;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class ChartUtility {
	
	private static String folder = "/reports/";

	public static void createPieChart(String title, DefaultPieDataset dataset, String fileName) throws IOException {
		JFreeChart chart = ChartFactory.createPieChart(
				title,   // chart title
				dataset,          // data
				true,             // include legend
				true,
				true);

		int width = 640;   /* Width of the image */
		int height = 480;  /* Height of the image */ 
		File pieChart = new File(fileName.concat(".jpeg")); 
		ChartUtilities.saveChartAsJPEG(pieChart, chart, width, height );
	}
	
	public static void createLineChart(String title, String vTitle, String hTitle, DefaultCategoryDataset lineChartDataset, String fileName) throws IOException {

		JFreeChart lineChartObject = ChartFactory.createLineChart(
				title,
				vTitle,
				hTitle,
				lineChartDataset,PlotOrientation.VERTICAL,
				true,true,false);

		int width = 640;    /* Width of the image */
		int height = 480;   /* Height of the image */ 
		File lineChart = new File(fileName.concat(".jpeg")); 
		ChartUtilities.saveChartAsJPEG(lineChart, lineChartObject, width, height);
	}
}

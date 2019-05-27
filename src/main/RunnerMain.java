package main;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.json.simple.parser.ParseException;

public class RunnerMain {

	public static void main(String[] args) throws IOException, GeneralSecurityException, ParseException {
		String step = args[0];
		String[] argsStep = {args[1]};
		
		switch(step) {
		case "CASH_COLLECT":
			RunnerCashCollect.main(argsStep);
			break;
		case "SELF_REPORT":
			RunnerSelfReport.main(argsStep);
			break;
		case "ITEM_LIST":
			RunnerItemList.main(argsStep);
			break;
		case "MEDICINE_LIST":
			RunnerMedicineList.main(argsStep);
			break;
		case "WINE_LIST":
			RunnerWine.main(argsStep);
			break;
		case "AGGREGATE_JSONS":
			RunnerAggregateJsons.main(argsStep);
			break;
		}
	}

}

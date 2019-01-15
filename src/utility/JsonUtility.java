package utility;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import entity.ElementoLista;
import entity.InfoUtenza;
import entity.Lettura;

public class JsonUtility {

	@SuppressWarnings("unchecked")
	public static JSONArray getJSONFromSEN(Lettura letturaSenA1, Lettura letturaSenA2, Lettura letturaSenA3) {
		JSONObject gennaio = new JSONObject();
		gennaio.put("label", "Gennaio;".concat(letturaSenA1.getYear()));
		gennaio.put("SENA1", letturaSenA1.getGennaio());
		gennaio.put("SENA2", letturaSenA2.getGennaio());
		gennaio.put("SENA3", letturaSenA3.getGennaio());
		
		JSONObject febbraio = new JSONObject();
		febbraio.put("label", "Febbraio;".concat(letturaSenA1.getYear()));
		febbraio.put("SENA1", letturaSenA1.getFebbraio());
		febbraio.put("SENA2", letturaSenA2.getFebbraio());
		febbraio.put("SENA3", letturaSenA3.getFebbraio());
		
		JSONObject marzo = new JSONObject();
		marzo.put("label", "Marzo;".concat(letturaSenA1.getYear()));
		marzo.put("SENA1", letturaSenA1.getMarzo());
		marzo.put("SENA2", letturaSenA2.getMarzo());
		marzo.put("SENA3", letturaSenA3.getMarzo());
		
		JSONObject aprile = new JSONObject();
		aprile.put("label", "Aprile;".concat(letturaSenA1.getYear()));
		aprile.put("SENA1", letturaSenA1.getAprile());
		aprile.put("SENA2", letturaSenA2.getAprile());
		aprile.put("SENA3", letturaSenA3.getAprile());
		
		JSONObject maggio = new JSONObject();
		maggio.put("label", "Maggio;".concat(letturaSenA1.getYear()));
		maggio.put("SENA1", letturaSenA1.getMaggio());
		maggio.put("SENA2", letturaSenA2.getMaggio());
		maggio.put("SENA3", letturaSenA3.getMaggio());
		
		JSONObject giugno = new JSONObject();
		giugno.put("label", "Giugno;".concat(letturaSenA1.getYear()));
		giugno.put("SENA1", letturaSenA1.getGiugno());
		giugno.put("SENA2", letturaSenA2.getGiugno());
		giugno.put("SENA3", letturaSenA3.getGiugno());
		
		JSONObject luglio = new JSONObject();
		luglio.put("label", "Luglio;".concat(letturaSenA1.getYear()));
		luglio.put("SENA1", letturaSenA1.getLuglio());
		luglio.put("SENA2", letturaSenA2.getLuglio());
		luglio.put("SENA3", letturaSenA3.getLuglio());
		
		JSONObject agosto = new JSONObject();
		agosto.put("label", "Agosto;".concat(letturaSenA1.getYear()));
		agosto.put("SENA1", letturaSenA1.getAgosto());
		agosto.put("SENA2", letturaSenA2.getAgosto());
		agosto.put("SENA3", letturaSenA3.getAgosto());
		
		JSONObject settembre = new JSONObject();
		settembre.put("label", "Settembre;".concat(letturaSenA1.getYear()));
		settembre.put("SENA1", letturaSenA1.getSettembre());
		settembre.put("SENA2", letturaSenA2.getSettembre());
		settembre.put("SENA3", letturaSenA3.getSettembre());
		
		JSONObject ottobre = new JSONObject();
		ottobre.put("label", "Ottobre;".concat(letturaSenA1.getYear()));
		ottobre.put("SENA1", letturaSenA1.getOttobre());
		ottobre.put("SENA2", letturaSenA2.getOttobre());
		ottobre.put("SENA3", letturaSenA3.getOttobre());
		
		JSONObject novembre = new JSONObject();
		novembre.put("label", "Novembre;".concat(letturaSenA1.getYear()));
		novembre.put("SENA1", letturaSenA1.getNovembre());
		novembre.put("SENA2", letturaSenA2.getNovembre());
		novembre.put("SENA3", letturaSenA3.getNovembre());
		
		JSONObject dicembre = new JSONObject();
		dicembre.put("label", "Dicembre;".concat(letturaSenA1.getYear()));
		dicembre.put("SENA1", letturaSenA1.getDicembre());
		dicembre.put("SENA2", letturaSenA2.getDicembre());
		dicembre.put("SENA3", letturaSenA3.getDicembre());
		
		JSONArray result = new JSONArray();
		if(!gennaio.get("SENA1").toString().equals("0"))
			result.add(gennaio);
		if(!febbraio.get("SENA1").toString().equals("0"))
			result.add(febbraio);
		if(!marzo.get("SENA1").toString().equals("0"))
			result.add(marzo);
		if(!aprile.get("SENA1").toString().equals("0"))
			result.add(aprile);
		if(!maggio.get("SENA1").toString().equals("0"))
			result.add(maggio);
		if(!giugno.get("SENA1").toString().equals("0"))
			result.add(giugno);
		if(!luglio.get("SENA1").toString().equals("0"))
			result.add(luglio);
		if(!agosto.get("SENA1").toString().equals("0"))
			result.add(agosto);
		if(!settembre.get("SENA1").toString().equals("0"))
			result.add(settembre);
		if(!ottobre.get("SENA1").toString().equals("0"))
			result.add(ottobre);
		if(!novembre.get("SENA1").toString().equals("0"))
			result.add(novembre);
		if(!dicembre.get("SENA1").toString().equals("0"))
			result.add(dicembre);
		
		return result;
	}

	@SuppressWarnings("unchecked")
	public static JSONArray getJSONFromENI(Lettura lettura) {
		JSONObject gennaio = new JSONObject();
		gennaio.put("label", "Gennaio;".concat(lettura.getYear()));
		gennaio.put("ENI", lettura.getGennaio());
		
		JSONObject febbraio = new JSONObject();
		febbraio.put("label", "Febbraio;".concat(lettura.getYear()));
		febbraio.put("ENI", lettura.getFebbraio());
		
		JSONObject marzo = new JSONObject();
		marzo.put("label", "Marzo;".concat(lettura.getYear()));
		marzo.put("ENI", lettura.getMarzo());
		
		JSONObject aprile = new JSONObject();
		aprile.put("label", "Aprile;".concat(lettura.getYear()));
		aprile.put("ENI", lettura.getAprile());
		
		JSONObject maggio = new JSONObject();
		maggio.put("label", "Maggio;".concat(lettura.getYear()));
		maggio.put("ENI", lettura.getMaggio());
		
		JSONObject giugno = new JSONObject();
		giugno.put("label", "Giugno;".concat(lettura.getYear()));
		giugno.put("ENI", lettura.getGiugno());
		
		JSONObject luglio = new JSONObject();
		luglio.put("label", "Luglio;".concat(lettura.getYear()));
		luglio.put("ENI", lettura.getLuglio());
		
		JSONObject agosto = new JSONObject();
		agosto.put("label", "Agosto;".concat(lettura.getYear()));
		agosto.put("ENI", lettura.getAgosto());
		
		JSONObject settembre = new JSONObject();
		settembre.put("label", "Settembre;".concat(lettura.getYear()));
		settembre.put("ENI", lettura.getSettembre());
		
		JSONObject ottobre = new JSONObject();
		ottobre.put("label", "Ottobre;".concat(lettura.getYear()));
		ottobre.put("ENI", lettura.getOttobre());
		
		JSONObject novembre = new JSONObject();
		novembre.put("label", "Novembre;".concat(lettura.getYear()));
		novembre.put("ENI", lettura.getNovembre());
		
		JSONObject dicembre = new JSONObject();
		dicembre.put("label", "Dicembre;".concat(lettura.getYear()));
		dicembre.put("ENI", lettura.getDicembre());
		
		JSONArray result = new JSONArray();
		if(!gennaio.get("ENI").toString().equals("0"))
			result.add(gennaio);
		if(!febbraio.get("ENI").toString().equals("0"))
			result.add(febbraio);
		if(!marzo.get("ENI").toString().equals("0"))
			result.add(marzo);
		if(!aprile.get("ENI").toString().equals("0"))
			result.add(aprile);
		if(!maggio.get("ENI").toString().equals("0"))
			result.add(maggio);
		if(!giugno.get("ENI").toString().equals("0"))
			result.add(giugno);
		if(!luglio.get("ENI").toString().equals("0"))
			result.add(luglio);
		if(!agosto.get("ENI").toString().equals("0"))
			result.add(agosto);
		if(!settembre.get("ENI").toString().equals("0"))
			result.add(settembre);
		if(!ottobre.get("ENI").toString().equals("0"))
			result.add(ottobre);
		if(!novembre.get("ENI").toString().equals("0"))
			result.add(novembre);
		if(!dicembre.get("ENI").toString().equals("0"))
			result.add(dicembre);
		
		return result;
	}

	@SuppressWarnings("unchecked")
	public static JSONArray getJSONFromABC(Lettura lettura) {
		JSONObject gennaio = new JSONObject();
		gennaio.put("label", "Gennaio;".concat(lettura.getYear()));
		gennaio.put("ABC", lettura.getGennaio());
		
		JSONObject febbraio = new JSONObject();
		febbraio.put("label", "Febbraio;".concat(lettura.getYear()));
		febbraio.put("ABC", lettura.getFebbraio());
		
		JSONObject marzo = new JSONObject();
		marzo.put("label", "Marzo;".concat(lettura.getYear()));
		marzo.put("ABC", lettura.getMarzo());
		
		JSONObject aprile = new JSONObject();
		aprile.put("label", "Aprile;".concat(lettura.getYear()));
		aprile.put("ABC", lettura.getAprile());
		
		JSONObject maggio = new JSONObject();
		maggio.put("label", "Maggio;".concat(lettura.getYear()));
		maggio.put("ABC", lettura.getMaggio());
		
		JSONObject giugno = new JSONObject();
		giugno.put("label", "Giugno;".concat(lettura.getYear()));
		giugno.put("ABC", lettura.getGiugno());
		
		JSONObject luglio = new JSONObject();
		luglio.put("label", "Luglio;".concat(lettura.getYear()));
		luglio.put("ABC", lettura.getLuglio());
		
		JSONObject agosto = new JSONObject();
		agosto.put("label", "Agosto;".concat(lettura.getYear()));
		agosto.put("ABC", lettura.getAgosto());
		
		JSONObject settembre = new JSONObject();
		settembre.put("label", "Settembre;".concat(lettura.getYear()));
		settembre.put("ABC", lettura.getSettembre());
		
		JSONObject ottobre = new JSONObject();
		ottobre.put("label", "Ottobre;".concat(lettura.getYear()));
		ottobre.put("ABC", lettura.getOttobre());
		
		JSONObject novembre = new JSONObject();
		novembre.put("label", "Novembre;".concat(lettura.getYear()));
		novembre.put("ABC", lettura.getNovembre());
		
		JSONObject dicembre = new JSONObject();
		dicembre.put("label", "Dicembre;".concat(lettura.getYear()));
		dicembre.put("ABC", lettura.getDicembre());
		
		JSONArray result = new JSONArray();
		if(!gennaio.get("ABC").toString().equals("0"))
			result.add(gennaio);
		if(!febbraio.get("ABC").toString().equals("0"))
			result.add(febbraio);
		if(!marzo.get("ABC").toString().equals("0"))
			result.add(marzo);
		if(!aprile.get("ABC").toString().equals("0"))
			result.add(aprile);
		if(!maggio.get("ABC").toString().equals("0"))
			result.add(maggio);
		if(!giugno.get("ABC").toString().equals("0"))
			result.add(giugno);
		if(!luglio.get("ABC").toString().equals("0"))
			result.add(luglio);
		if(!agosto.get("ABC").toString().equals("0"))
			result.add(agosto);
		if(!settembre.get("ABC").toString().equals("0"))
			result.add(settembre);
		if(!ottobre.get("ABC").toString().equals("0"))
			result.add(ottobre);
		if(!novembre.get("ABC").toString().equals("0"))
			result.add(novembre);
		if(!dicembre.get("ABC").toString().equals("0"))
			result.add(dicembre);
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public static JSONArray getJSONYear(InfoUtenza... utenzeYear) {
		JSONObject gennaio = new JSONObject();
		JSONObject febbraio = new JSONObject();
		JSONObject marzo = new JSONObject();
		JSONObject aprile = new JSONObject();
		JSONObject maggio = new JSONObject();
		JSONObject giugno = new JSONObject();
		JSONObject luglio = new JSONObject();
		JSONObject agosto = new JSONObject();
		JSONObject settembre = new JSONObject();
		JSONObject ottobre = new JSONObject();
		JSONObject novembre = new JSONObject();
		JSONObject dicembre = new JSONObject();
		for (InfoUtenza utenza : utenzeYear) {
			gennaio.put("label", "Gennaio;".concat(utenza.getYear()));
			gennaio.put(utenza.getUtenza(), utenza.getGennaio());
			
			febbraio.put("label", "Febbraio;".concat(utenza.getYear()));
			febbraio.put(utenza.getUtenza(), utenza.getFebbraio());
			
			marzo.put("label", "Marzo;".concat(utenza.getYear()));
			marzo.put(utenza.getUtenza(), utenza.getMarzo());
			
			aprile.put("label", "Aprile;".concat(utenza.getYear()));
			aprile.put(utenza.getUtenza(), utenza.getAprile());
			
			maggio.put("label", "Maggio;".concat(utenza.getYear()));
			maggio.put(utenza.getUtenza(), utenza.getMaggio());
			
			giugno.put("label", "Giugno;".concat(utenza.getYear()));
			giugno.put(utenza.getUtenza(), utenza.getGiugno());
			
			luglio.put("label", "Luglio;".concat(utenza.getYear()));
			luglio.put(utenza.getUtenza(), utenza.getLuglio());
			
			agosto.put("label", "Agosto;".concat(utenza.getYear()));
			agosto.put(utenza.getUtenza(), utenza.getAgosto());
			
			settembre.put("label", "Settembre;".concat(utenza.getYear()));
			settembre.put(utenza.getUtenza(), utenza.getSettembre());
			
			ottobre.put("label", "Ottobre;".concat(utenza.getYear()));
			ottobre.put(utenza.getUtenza(), utenza.getOttobre());
			
			novembre.put("label", "Novembre;".concat(utenza.getYear()));
			novembre.put(utenza.getUtenza(), utenza.getNovembre());
			
			dicembre.put("label", "Dicembre;".concat(utenza.getYear()));
			dicembre.put(utenza.getUtenza(), utenza.getDicembre());
		}
		
		JSONArray result = new JSONArray();
		result.add(gennaio);
		result.add(febbraio);
		result.add(marzo);
		result.add(aprile);
		result.add(maggio);
		result.add(giugno);
		result.add(luglio);
		result.add(agosto);
		result.add(settembre);
		result.add(ottobre);
		result.add(novembre);
		result.add(dicembre);
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public static JSONArray getJSONItems(List<ElementoLista> listGarage, List<ElementoLista> listBalcone) {
		JSONArray result = new JSONArray();
		JSONArray resultGarage = new JSONArray();
		JSONArray resultBacone = new JSONArray();
		
		for (ElementoLista elementoListaGarage : listGarage) {
			JSONObject garageItem = new JSONObject();
			garageItem.put("reparto", elementoListaGarage.getReparto());
			garageItem.put("tipo", elementoListaGarage.getTipo());
			garageItem.put("marca", elementoListaGarage.getMarca());
			garageItem.put("qta", elementoListaGarage.getQta());
			resultGarage.add(garageItem);
		}
		for (ElementoLista elementoListaBalcone : listBalcone) {
			JSONObject balconeItem = new JSONObject();
			balconeItem.put("reparto", elementoListaBalcone.getReparto());
			balconeItem.put("tipo", elementoListaBalcone.getTipo());
			balconeItem.put("marca", elementoListaBalcone.getMarca());
			balconeItem.put("qta", elementoListaBalcone.getQta());
			resultBacone.add(balconeItem);
		}
		JSONObject garage = new JSONObject();
		garage.put("garage", resultGarage);
		JSONObject balcone = new JSONObject();
		balcone.put("balcone", resultBacone);
		
		result.add(garage);
		result.add(balcone);
		
		return result;
	}

	public static void writeFileFromJSONArray(JSONArray array, String nameFile, String folder) throws IOException {
		//StringWriter out = new StringWriter();
		FileWriter file = new FileWriter( folder.concat("/").concat(nameFile).concat(".json"),false);
		StringWriter out = new StringWriter();
		array.writeJSONString(out);
		file.write(out.toString());
		file.close();
	}
}

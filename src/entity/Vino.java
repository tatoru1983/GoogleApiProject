package entity;

import java.math.BigDecimal;
import java.util.List;

public class Vino {
	
	private String tipo;
	private String denominazione;
	private String colore;
	private String origine;
	private String vol;
	private String provenienza;
	private String marca;
	private String qta;
	private String altro;
	private BigDecimal annata;
	
	public Vino(List row) {
		super();
		if(row!=null || row.size()>0) {
			if(row.size()>0)
				this.tipo = row.get(0).toString();
			if(row.size()>1)
				this.denominazione = row.get(1).toString();
			if(row.size()>2)
				this.colore = row.get(2).toString();
			if(row.size()>3)
				this.origine = row.get(3).toString();
			if(row.size()>4)
				this.vol = row.get(4).toString();
			if(row.size()>5)
				this.provenienza = row.get(5).toString();
			if(row.size()>6)
				this.marca = row.get(6).toString();
			if(row.size()>7)
				this.qta = row.get(7).toString();
			if(row.size()>8)
				this.altro = row.get(8).toString();
			if(row.size()>9)
				this.annata = getBGValue(row.get(9));
		}
	}

	
	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getDenominazione() {
		return denominazione;
	}


	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}


	public String getColore() {
		return colore;
	}


	public void setColore(String colore) {
		this.colore = colore;
	}


	public String getOrigine() {
		return origine;
	}


	public void setOrigine(String origine) {
		this.origine = origine;
	}


	public String getVol() {
		return vol;
	}


	public void setVol(String vol) {
		this.vol = vol;
	}


	public String getProvenienza() {
		return provenienza;
	}


	public void setProvenienza(String provenienza) {
		this.provenienza = provenienza;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getQta() {
		return qta;
	}


	public void setQta(String qta) {
		this.qta = qta;
	}


	public String getAltro() {
		return altro;
	}


	public void setAltro(String altro) {
		this.altro = altro;
	}


	public BigDecimal getAnnata() {
		return annata;
	}


	public void setAnnata(BigDecimal annata) {
		this.annata = annata;
	}


	private BigDecimal getBGValue(Object obj) {
		if(obj==null)
			return new BigDecimal(0);
		try {
			String valueString = obj.toString().replaceAll(",", ".");
			BigDecimal bdValue = new BigDecimal(valueString);
			return bdValue;
		}catch(Exception ex) {
			return new BigDecimal(0);
		}
	}
}

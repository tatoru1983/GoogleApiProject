package entity;

import java.math.BigDecimal;
import java.util.List;

public class InfoUtenza {
	private String utenza;
	private BigDecimal gennaio = new BigDecimal(0);
	private BigDecimal febbraio = new BigDecimal(0);
	private BigDecimal marzo = new BigDecimal(0);
	private BigDecimal aprile = new BigDecimal(0);
	private BigDecimal maggio = new BigDecimal(0);
	private BigDecimal giugno = new BigDecimal(0);
	private BigDecimal luglio = new BigDecimal(0);
	private BigDecimal agosto = new BigDecimal(0);
	private BigDecimal settembre = new BigDecimal(0);
	private BigDecimal ottobre = new BigDecimal(0);
	private BigDecimal novembre = new BigDecimal(0);
	private BigDecimal dicembre = new BigDecimal(0);
	private String year;
	
	public InfoUtenza(List row){
		super();
		this.utenza = row.get(0).toString();
		if(row.size()>1)
			this.gennaio = getBGValue(row.get(1));
		if(row.size()>2)
			this.febbraio = getBGValue(row.get(2));
		if(row.size()>3)
			this.marzo = getBGValue(row.get(3));
		if(row.size()>4)
			this.aprile = getBGValue(row.get(4));
		if(row.size()>5)
			this.maggio = getBGValue(row.get(5));
		if(row.size()>6)
			this.giugno = getBGValue(row.get(6));
		if(row.size()>7)
			this.luglio = getBGValue(row.get(7));
		if(row.size()>8)
			this.agosto = getBGValue(row.get(8));
		if(row.size()>9)
			this.settembre = getBGValue(row.get(9));
		if(row.size()>10)
			this.ottobre = getBGValue(row.get(10));
		if(row.size()>11)
			this.novembre = getBGValue(row.get(11));
		if(row.size()>12)
			this.dicembre = getBGValue(row.get(12));
	}
	
	public InfoUtenza(List row, String year){
		super();
		this.utenza = row.get(0).toString();
		if(row.size()>1)
			this.gennaio = getBGValue(row.get(1));
		if(row.size()>2)
			this.febbraio = getBGValue(row.get(2));
		if(row.size()>3)
			this.marzo = getBGValue(row.get(3));
		if(row.size()>4)
			this.aprile = getBGValue(row.get(4));
		if(row.size()>5)
			this.maggio = getBGValue(row.get(5));
		if(row.size()>6)
			this.giugno = getBGValue(row.get(6));
		if(row.size()>7)
			this.luglio = getBGValue(row.get(7));
		if(row.size()>8)
			this.agosto = getBGValue(row.get(8));
		if(row.size()>9)
			this.settembre = getBGValue(row.get(9));
		if(row.size()>10)
			this.ottobre = getBGValue(row.get(10));
		if(row.size()>11)
			this.novembre = getBGValue(row.get(11));
		if(row.size()>12)
			this.dicembre = getBGValue(row.get(12));
		
		this.year = year;
	}
	
	public String getUtenza() {
		return utenza;
	}
	public void setUtenza(String utenza) {
		this.utenza = utenza;
	}
	public BigDecimal getGennaio() {
		return gennaio;
	}
	public void setGennaio(BigDecimal gennaio) {
		this.gennaio = gennaio;
	}
	public BigDecimal getFebbraio() {
		return febbraio;
	}
	public void setFebbraio(BigDecimal febbraio) {
		this.febbraio = febbraio;
	}
	public BigDecimal getMarzo() {
		return marzo;
	}
	public void setMarzo(BigDecimal marzo) {
		this.marzo = marzo;
	}
	public BigDecimal getAprile() {
		return aprile;
	}
	public void setAprile(BigDecimal aprile) {
		this.aprile = aprile;
	}
	public BigDecimal getMaggio() {
		return maggio;
	}
	public void setMaggio(BigDecimal maggio) {
		this.maggio = maggio;
	}
	public BigDecimal getGiugno() {
		return giugno;
	}
	public void setGiugno(BigDecimal giugno) {
		this.giugno = giugno;
	}
	public BigDecimal getLuglio() {
		return luglio;
	}
	public void setLuglio(BigDecimal luglio) {
		this.luglio = luglio;
	}
	public BigDecimal getAgosto() {
		return agosto;
	}
	public void setAgosto(BigDecimal agosto) {
		this.agosto = agosto;
	}
	public BigDecimal getSettembre() {
		return settembre;
	}
	public void setSettembre(BigDecimal settembre) {
		this.settembre = settembre;
	}
	public BigDecimal getOttobre() {
		return ottobre;
	}
	public void setOttobre(BigDecimal ottobre) {
		this.ottobre = ottobre;
	}
	public BigDecimal getNovembre() {
		return novembre;
	}
	public void setNovembre(BigDecimal novembre) {
		this.novembre = novembre;
	}
	public BigDecimal getDicembre() {
		return dicembre;
	}
	public void setDicembre(BigDecimal dicembre) {
		this.dicembre = dicembre;
	}
	
	public BigDecimal getSomma(){
		return gennaio.add(febbraio).add(marzo).add(aprile).add(maggio).add(giugno)
				.add(luglio).add(agosto).add(settembre).add(ottobre).add(novembre).add(dicembre);
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

	@Override
	public String toString() {
		return "InfoUtenza [utenza=" + utenza + ", gennaio=" + gennaio + ", febbraio=" + febbraio + ", marzo=" + marzo
				+ ", aprile=" + aprile + ", maggio=" + maggio + ", giugno=" + giugno + ", luglio=" + luglio
				+ ", agosto=" + agosto + ", settembre=" + settembre + ", ottobre=" + ottobre + ", novembre=" + novembre
				+ ", dicembre=" + dicembre + "]";
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
}

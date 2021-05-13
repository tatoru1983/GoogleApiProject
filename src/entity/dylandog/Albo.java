package entity.dylandog;

import java.util.HashMap;
import java.util.List;

import utility.AggregationUtility;

public class Albo {
	
	private String numero;
	private String titolo;
	private EdizioneEnum edizione;
	private int anno;
	
	private List<Artista> soggetto;
	private List<Artista> sceneggiatura;
	private List<Artista> disegni;
	private List<Artista> copertina;
	
	private boolean check = false;
	
	
	public Albo(List row, HashMap artistaHash) {
		super();
		if(row!=null || row.size()>0) {
			if(row.size()>0)
				this.check = "OK".equals(row.get(0));
			if(row.size()>1)
				this.numero = row.get(1).toString();
			if(row.size()>2)
				this.titolo = row.get(2).toString();
			if(row.size()>7 && row.get(7)!=null && !"".contentEquals(row.get(7).toString()))
				try {
					this.edizione = EdizioneEnum.get(row.get(7).toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			if(row.size()>8)
				this.anno = Integer.parseInt(row.get(8).toString());
			
			//valori lista
			if(row.size()>3 && row.get(3)!=null && !"".contentEquals(row.get(3).toString()))
				this.soggetto = AggregationUtility.getArtistaFromString(row.get(3).toString());
			if(row.size()>4 && row.get(4)!=null && !"".contentEquals(row.get(4).toString()))
				this.sceneggiatura = AggregationUtility.getArtistaFromString(row.get(4).toString());
			if(row.size()>5 && row.get(5)!=null && !"".contentEquals(row.get(5).toString()))
				this.disegni = AggregationUtility.getArtistaFromString(row.get(5).toString());
			if(row.size()>6 && row.get(6)!=null && !"".contentEquals(row.get(6).toString()))
				this.copertina = AggregationUtility.getArtistaFromString(row.get(6).toString());
		}
	}
	
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public List<Artista> getSoggetto() {
		return soggetto;
	}
	public void setSoggetto(List<Artista> soggetto) {
		this.soggetto = soggetto;
	}
	public List<Artista> getSceneggiatura() {
		return sceneggiatura;
	}
	public void setSceneggiatura(List<Artista> sceneggiatura) {
		this.sceneggiatura = sceneggiatura;
	}
	public List<Artista> getDisegni() {
		return disegni;
	}
	public void setDisegni(List<Artista> disegni) {
		this.disegni = disegni;
	}
	public List<Artista> getCopertina() {
		return copertina;
	}
	public void setCopertina(List<Artista> copertina) {
		this.copertina = copertina;
	}

	public EdizioneEnum getEdizione() {
		return edizione;
	}

	public void setEdizione(EdizioneEnum edizione) {
		this.edizione = edizione;
	}

	@Override
	public String toString() {
		return "Albo [numero=" + numero + ", titolo=" + titolo + ", edizione=" + edizione + ", anno=" + anno
				+ ", soggetto=" + soggetto + ", sceneggiatura=" + sceneggiatura + ", disegni=" + disegni
				+ ", copertina=" + copertina + ", check=" + check + "]";
	}

}

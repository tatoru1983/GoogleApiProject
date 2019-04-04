package entity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Medicina {

	private String marca;
	private String tipo;
	private Date scadenza;
	
	public Medicina(List row) {
		super();
		if(row!=null || row.size()>0) {
			if(row.size()>0)
				this.marca = row.get(0).toString();
			if(row.size()>1)
				this.tipo = row.get(1).toString();
			if(row.size()>2)
				this.scadenza = getDateValue(row.get(2));
		}
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Date getScadenza() {
		return scadenza;
	}

	public void setScadenza(Date scadenza) {
		this.scadenza = scadenza;
	}
	
	@Override
	public String toString() {
		return "Medicina [marca=" + marca + ", tipo=" + tipo + ", scadenza=" + scadenza + "]";
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

	private Date getDateValue(Object obj) {
		if(obj==null)
			return new Date();
		try {
			String valueString = obj.toString();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date dateValue = formatter.parse(valueString);
			return dateValue;
		}catch(Exception ex) {
			return new Date();
		}
	}

}

package entity;

import java.math.BigDecimal;
import java.util.List;

public class ElementoLista {
	
	private String reparto;
	private String tipo;
	private String marca;
	private BigDecimal qta;
	
	public ElementoLista(List row) {
		super();
		if(row!=null || row.size()>0) {
			if(row.size()>0)
				this.tipo = row.get(0).toString();
			if(row.size()>1)
				this.marca = row.get(1).toString();
			if(row.size()>2)
				this.qta = getBGValue(row.get(2));
		}
	}

	public String getReparto() {
		return reparto;
	}

	public void setReparto(String reparto) {
		this.reparto = reparto;
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

	public BigDecimal getQta() {
		return qta;
	}

	public void setQta(BigDecimal qta) {
		this.qta = qta;
	}

	@Override
	public String toString() {
		return "ElementoLista [reparto=" + reparto + ", tipo=" + tipo + ", marca=" + marca + ", qta=" + qta + "]";
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

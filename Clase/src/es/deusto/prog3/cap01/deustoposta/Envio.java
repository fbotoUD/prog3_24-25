package es.deusto.prog3.cap01.deustoposta;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Envio implements Comparable<Envio>{
	
	private String identificador;
	private Ubicacion destino;
	private Date fechaEntrega;
	
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	public Envio(String identificador, Ubicacion destino, String fechaEntrega) {
		this.identificador = identificador;
		this.destino = destino;
		try {
			this.fechaEntrega = format.parse(fechaEntrega);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public String getIdentificador() {
        return identificador;
    }
    public Ubicacion getDestino() {
		return destino;
	}
    public Date getFechaEntrega() {
		return fechaEntrega;
	}
    
    public abstract double getPeso();
    
    @Override
    public String toString() {
    	return identificador + " Entrega: " + format.format(fechaEntrega);
    }
    
    @Override
    public boolean equals(Object obj) {
    	return identificador.equals(((Envio)obj).getIdentificador());
    }
    
    @Override
    public int compareTo(Envio o) {
    	
    	return fechaEntrega.compareTo(o.getFechaEntrega());
    }
}

package es.deusto.prog3.cap01.deustoposta;


public class Ubicacion {
	
	private double coordenadaX;
    private double coordenadaY;

    public Ubicacion(double coordenadaX, double coordenadaY) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public double getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public double getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }
    
    @Override
    public boolean equals(Object obj) {
    	return (coordenadaX == ((Ubicacion)obj).getCoordenadaX() && 
    			coordenadaY == ((Ubicacion)obj).getCoordenadaY());
    }
}

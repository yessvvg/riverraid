/*
 * nos sirve para poder crear nuestro arraylis para el top
 */
package riverraid;

class Jugador implements Comparable<Jugador>{

	private String nombre;
	private int puntaje;

	public Jugador() {
	}

	public Jugador(String nombre, int puntaje) {
            //System.out.println("dfsfg"+puntaje);
		this.nombre = nombre;
		this.puntaje = puntaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntaje() {
            
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
            //System.out.println("dfsfg"+puntaje);
		this.puntaje = puntaje;
	}

	@Override
	public String toString() {
		return this.getNombre() + "  : " + this.getPuntaje();
	}

    @Override
    public int compareTo(Jugador j) {
        return j.puntaje -this.puntaje;
    }
}

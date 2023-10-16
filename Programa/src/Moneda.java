/**
 * Esta clase abstracta es la base (superclase) para los distintas clases que representan una moneda de un valor espesifico.
 */
public abstract class Moneda implements Comparable<Moneda> {

    /**
     * Constructor por defecto.
     */
    public Moneda() {
    }

    /**
     * Es como un método getter para la serie de la moneda.
     *
     * @return La dirección en memoria del objeto, esto representa su serie.
     */
    public String getSerie() {
        return super.toString();
    }

    /**
     * Método abstracto para obtener el valor de la moneda, las subsclases lo deben sobreescribir.
     */
    public abstract int getValor();

    /**
     * Método compareTo() sobreescrito de la interfaz Comaparable y con el objetivo de obtener información al comparar dos monedas.
     * 
     * @param moneda La moneda con la que se quiera comparar el valor.
     * 
     * @return Devuelve 1 si el valor de las monedas comparadas es el mismo y 0 si sus valores son distintos.
     */
    @Override
    public int compareTo(Moneda moneda) {
        if(this.getValor() == moneda.getValor()) {
            return 1;
        } else {
            return 0;
        }
    }
}

/**
 * Esta es una subclase abstracta de Producto y puede representa algun tipo de dulse.
 */
public abstract class Dulce extends Producto {
    private int serie;

    /**
     * Constructor personalizado de Dulce que permite asignarle un número de serie.
     * 
     * @param serie Es el número que representa la serie del objeto.
     */
    public Dulce(int numSerie) {
        super();
        this.serie=numSerie;
    }

    /**
     * Este es un método getter para obtener el número de serie.
     * 
     * @return La serie de la dulce.
     */
    public int getSerie() {
        return serie; 
    }
}
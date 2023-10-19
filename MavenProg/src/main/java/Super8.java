/**
 * Esta es una subclase de Bebida y representa una super8.
 */
public class Super8 extends Bebida {

    /**
     * Constructor personalizado de Super8 que permite asignarle un número de serie.
     * 
     * @param serie Es el número que representa la serie del objeto.
     */
    public Super8 (int serie) {
        super(serie);
    }

    /**
     * Este método es para representarse asi mismo al consumirse.
     * 
     * @return Un string diciendo que es una super8.
     */
    public String consumir() {
        return "super8";
    }
}
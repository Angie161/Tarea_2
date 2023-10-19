/**
 * Esta es la supersuperclase de todos los productos del programa (Cocacola, Sprite, Fanta, Snickers, Super8) y es para dar la base a estos.
 */
public abstract class Producto {

    /**
     * Constructor por defecto.
     */
    public Producto() {

    }

    /**
     * Método abstracto que será utilizado por todas las subsubclases para representar lo que son.
     */
    public abstract String consumir();
}

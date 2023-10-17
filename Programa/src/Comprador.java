/**
 * Esta clase simula un comprador que intenta comprar algo en la máquina expendedora con una moneda.
 */
public class Comprador {
    private String sonido;
    private int vuelto=0;

    /**
     * Este es un constructor personalizado y realiza la operación de comprar un producto en el expendedor.
     *
     * @param moneda                    Una Moneda con lo que se pagará.
     * @param cualProducto              El tipo de producto que se desea comprar.
     * @param expendedor                El Expendedor en el cual se va a comprar.
     * @throws PagoIncorrectoException   En caso de que la Moneda sea nula.
     * @throws PagoInsuficienteException Si el valor de las monedas es menor al del producto.
     * @throws NoHayProductoException    En caso de que no quede el producto que se intenta comprar.
     */
    public Comprador(Moneda moneda, TipoProducto cualProducto, Expendedor expendedor) throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException {
        try {
            sonido = expendedor.comprarProducto(moneda, cualProducto).consumir();
        } catch(PagoIncorrectoException | NoHayProductoException | PagoInsuficienteException e) {
            sonido = null;
            throw e;
        } finally {
            while (true) {
                try {
                    vuelto += expendedor.getVuelto().getValor();
                } catch (Exception e) {
                    break;
                }
            }
        }
    }

    /**
     * Este es un constructor personalizado y realiza la operación de comprar un producto en el expendedor.
     *
     * @return La cantidad de vuelto que se devolvio al comprar.
     */
    public int cuantoVuelto(){
        return vuelto;
    }

    /**
     * Este es un constructor personalizado y realiza la operación de comprar un producto en el expendedor.
     *
     * @return Un string que explica que se consumio.
     */
    public String queConsumiste(){
        return sonido;
    }
}

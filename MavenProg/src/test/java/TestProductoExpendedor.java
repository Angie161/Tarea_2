import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de tipo Test Unitario para probar específicamente la compra de productos y las excepciones relacionados con la existencia de estos.
 */
public class TestProductoExpendedor {
    private Expendedor expendedor;

    private Moneda pesos100;
    private Moneda pesos500;
    private Moneda pesos1000;
    private Moneda pesos1500;

    private TipoProducto sprite;
    private TipoProducto cocacola;
    private TipoProducto super8;
    private TipoProducto cebollas;

    @BeforeEach
    void setup() {
        expendedor = new Expendedor(2);
        pesos100 = new Moneda100();
        pesos500 = new Moneda500();
        pesos1000 = new Moneda1000();
        pesos1500 = new Moneda1500();
        sprite = TipoProducto.SPRITE;
        super8 = TipoProducto.SUPER8;
        cocacola = TipoProducto.COCA;
    }

    /**
     * Prueba de compra de una bebida en un depósito de 2 productos
     */
    @Test
    @DisplayName("Test Una Bebida")
    void testCompraUnaBebida() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        assertNotNull(expendedor.comprarProducto(pesos1500, sprite));
    }

    /**
     * Prueba de compra de dos dulces en un depósito de 2 productos
     */
    @Test
    @DisplayName("Test Dos Dulces")
    void testCompraDosDulces() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        assertNotNull(expendedor.comprarProducto(pesos1000, super8));
        assertNotNull(expendedor.comprarProducto(pesos1500, super8));
    }

    /**
     * Verifica que al intentar sacar 3 productos de un depósito que contiene solo 2 Bebidas, arroje la excepción NoHayProductoException, no recibirá el producto pero sí la moneda empleada.
     */
    @Test
    @DisplayName("Test Excepcion NoHayProductoException")
    void testNoHayProductos() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        expendedor.comprarProducto(pesos1500, cocacola);
        expendedor.comprarProducto(pesos1500, cocacola);
        assertThrows(NoHayProductoException.class, () -> {
            assertNull(expendedor.comprarProducto(pesos1500, cocacola));
        });
        assertEquals(1500,expendedor.getVuelto().getValor());
        assertNull(expendedor.getVuelto());
    }

    /** Verifica que al intentar comprar un producto no registrado dentro del enum (un producto nulo), arroje la excepción de NoHayProductoException y devuelva la moneda.*/
    @Test
    @DisplayName("Test No existe el producto")
    void testNoExisteElProducto() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        assertThrows(NoHayProductoException.class, () -> {
            expendedor.comprarProducto(pesos500, cebollas);
        });
        assertEquals(500,expendedor.getVuelto().getValor());
        assertNull(expendedor.getVuelto());
    }


}

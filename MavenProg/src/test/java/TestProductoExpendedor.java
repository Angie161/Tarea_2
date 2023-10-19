import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de tipo Test Unitario para probar diferentes métodos y aspectos de nuestro programa, para poder detectar fallas y corroborar casos normales.
 */
public class TestExpendedor {
    private Expendedor expendedor;

    private Moneda pesos100;
    private Moneda pesos500;
    private Moneda pesos1000;
    private Moneda pesos1500;
    private Moneda Mnull;

    private TipoProducto sprite;
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
    }

    /**
     * Prueba de compra de una bebida en un depósito de 2 productos
     */
    @Test
    @DisplayName("Test Una Bebida")
    void testCompraUnaBebida() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        expendedor.comprarProducto(pesos1500, sprite);
    }

    /**
     * Prueba de compra de dos dulces en un depósito de 2 productos
     */
    @Test
    @DisplayName("Test Dos Dulces")
    void testCompraDosDulces() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        expendedor.comprarProducto(pesos1000, super8);
        expendedor.comprarProducto(pesos1500, super8);
    }

    /**
     * Verifica que al intentar sacar 3 productos de un depósito que contiene solo 2 dulces, arroje la excepción NoHayProductoException.
     */
    @Test
    @DisplayName("Test Excepcion NoHayProductoException")
    void testNoHayProductos() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        expendedor.comprarProducto(pesos1000, super8);
        expendedor.comprarProducto(pesos1500, super8);
        assertThrows(NoHayProductoException.class, () -> {
            expendedor.comprarProducto(pesos1500, super8);
        });
    }

    /** Verifica que al intentar comprar un producto no registrado dentro del enum (un producto nulo), arroje la excepción de NoHayProductoException.*/
    @Test
    @DisplayName("Test No existe el producto")
    void testNoExisteElProducto() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        assertThrows(NoHayProductoException.class, () -> {
            expendedor.comprarProducto(pesos100, cebollas);
        });
    }

    /**
     * Verifica que al intentar comprar un producto con una moneda de menor valor que el precio, arroje la excepción PagoInsuficienteException.
     * En este caso la Sprite cuesta 1300 y le entregaremos una moneda de 500
     */
    @Test
    @DisplayName("Test Excepcion PagoInsuficiente")
    void testPagoInsuficiente() {
        assertThrows(PagoInsuficienteException.class, () -> {
            expendedor.comprarProducto(pesos500, sprite);
        });
    }

    /**
     * Verifica que al intentar comprar con una moneda nula, arroje la excepción PagoIncorrectoException.
     */
    @Test
    @DisplayName("Test Excepcion PagoIncorrectoException")
    void testPagoIncorrecto() {
        assertThrows(PagoIncorrectoException.class, () -> {
            expendedor.comprarProducto(Mnull, sprite);
        });
    }
}

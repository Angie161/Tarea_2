import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de tipo Test Unitario para probar específicamente los casos de vueltos dentro de la clase Expendedor.
 *
 * @author Angie Ramírez
 */
public class TestVueltoExpendedor {
    private Expendedor expendedor;

    private Moneda pesos100;
    private Moneda pesos500;
    private Moneda pesos1000;
    private Moneda pesos1500;
    private Moneda Mnull;

    private TipoProducto sprite;
    private TipoProducto super8;

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
     * Verifica que al intentar comprar con una moneda nula, arroje la excepción PagoIncorrectoException.
     */
    @Test
    @DisplayName("Test Excepcion PagoIncorrectoException")
    void testPagoIncorrecto() {
        assertThrows(PagoIncorrectoException.class, () -> {
            expendedor.comprarProducto(Mnull, sprite);
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
     * Verifica que al comprar un producto con una moneda de valor exacto, nos entregue nulo (No haya vuelto).
     */
    @Test
    @DisplayName("Test Sin Vuelto")
    void SinVuelto() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        expendedor.comprarProducto(pesos100, super8);
        assertNull(expendedor.getVuelto());
    }

    /**
     * Verifica que al comprar un producto con una moneda de valor mayor, nos entregue el vuelto correspondiente en monedas de 100.
     */
    @Test
    @DisplayName("Test Vuelto Correspondiente")
    void Vuelto() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        expendedor.comprarProducto(pesos500, super8);
        assertEquals(100,expendedor.getVuelto().getValor());
        assertEquals(100,expendedor.getVuelto().getValor());
        assertEquals(100,expendedor.getVuelto().getValor());
        assertEquals(100,expendedor.getVuelto().getValor());
        assertNull(expendedor.getVuelto());
    }
}

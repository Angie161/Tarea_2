import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestExpendedor {
    private Expendedor expendedor;
    private Moneda pesos100;
    private Moneda pesos

    @BeforeEach
    void setup() {
        expendedor=new Expendedor(2);
    }

    @Test
    @DisplayName("Test Una Bebida")
    void testCompraUnaBebida() {

    }

    @Test
    @DisplayName("Test Dos Dulces")
    void testCompraDosDulces() {

    }

    @Test
    @DisplayName("Test Excepcion NoHayProductoException")
    void testNoHayProductos() {

    }

    @Test
    @DisplayName("Test Excepcion PagoIncorrectoException")
    void testPagoIncorrecto() {

    }

    @Test
    @DisplayName("Test Excepcion PagoInsuficiente")
    void testPagoInsuficiente() {

    }
}

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de tipo Test Unitario para probar los métodos de la clase comprador, y los posibles exceptions a ocurrir.
 */
public class TestComprador {
	private Comprador comprador;
	private Moneda moneda;
	private Expendedor expendedor;

    /**
     * Inicializa las variables que emplearán todas las pruebas de los tests.
     */
	@BeforeEach
    void setup() {
    	moneda = new Moneda1500();
    	expendedor = new Expendedor(3);
    }

    /**
     * Realiza una compra normal, con una moneda válida y con productos en la máquina expendedora. Verifica que sí se consuma el producto solicitado y que el valor del vuelto sea el correcto
     */
    @Test
    @DisplayName("Test de Comprador.")
    void testComprarConTodoBien() {
        try{
            comprador = new Comprador(moneda, TipoProducto.SPRITE, expendedor);
            assertTrue(comprador.queConsumiste().equals("sprite"));
            assertEquals(200,comprador.cuantoVuelto());
        } catch(Exception e) {
            assertTrue(false);
        }
    }

    /**
     * Verifica que al realizar una compra en un depósito vacío, arroje el error de NoHayProductoException.
     */
    @Test
    @DisplayName("Test de NoHayProductoException.")
    void testComprarSinProducto() {
        moneda = new Moneda1500();
        try{
            comprador = new Comprador(moneda, TipoProducto.SPRITE, expendedor);
        } catch(NoHayProductoException e) {
            assertTrue(true);
        } catch (PagoInsuficienteException e) {
            throw new RuntimeException(e);
        } catch (PagoIncorrectoException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Verifica que al comprar un producto de menor valor, arroje el error de PagoInsuficienteException.
     */
    @Test
    @DisplayName("Test de PagoInsuficienteException.")
    void testComprarConMenosDinero() {
        moneda = new Moneda1000();
        try{
            comprador = new Comprador(moneda, TipoProducto.COCA, expendedor);
        } catch(PagoInsuficienteException e) {
            assertTrue(true);
        } catch (NoHayProductoException e) {
            throw new RuntimeException(e);
        } catch (PagoIncorrectoException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Verifica que al intentar realizar una compra con una moneda nula, arroje el error PagoIncorrectoException.
     */
    @Test
    @DisplayName("Test de PagoIncorrectoException.")
    void testComprarSinMoneda() {
        moneda = null;
        try{
            comprador = new Comprador(moneda, TipoProducto.COCA, expendedor);
        } catch(PagoIncorrectoException e) {
            assertTrue(true);
        } catch (NoHayProductoException e) {
            throw new RuntimeException(e);
        } catch (PagoInsuficienteException e) {
            throw new RuntimeException(e);
        }
    }
}
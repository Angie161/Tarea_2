import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestComprador {
	private Comprador comprador;
	private Moneda moneda;
	private Expendedor expendedor;

	@BeforeEach
    void setup() {
    	moneda = new Moneda1500();
    	expendedor = new Expendedor(3);
    }


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

    @Test
    @DisplayName("Test de NoHayProductoException.")
    void testComprarSinProducto() {
        moneda = new Moneda1500();
        try{
            comprador = new Comprador(moneda, TipoProducto.SPRITE, expendedor);
        } catch(NoHayProductoException e) {
            assertTrue(true);
        }
    }

    @Test
    @DisplayName("Test de PagoInsuficienteException.")
    void testComprarConMenosDinero() {
        moneda = new Moneda1000();
        try{
            comprador = new Comprador(moneda, TipoProducto.COCA, expendedor);
        } catch(PagoInsuficienteException e) {
            assertTrue(true);
        }
    }

    @Test
    @DisplayName("Test de PagoIncorrectoException.")
    void testComprarSinMoneda() {
        moneda = null;
        try{
            comprador = new Comprador(moneda, TipoProducto.COCA, expendedor);
        } catch(PagoIncorrectoException e) {
            assertTrue(true);
        }
    }
}
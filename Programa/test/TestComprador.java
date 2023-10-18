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
    	moneda1500 = new Moneda1500();
    	expendedor = new Expendedor(3);
    }


    @Test
    @DisplayName("Test de Comprador.")
    void testComprar() {
    	comprador = new Comprador(moneda, SPRITE);
    	assertTrue(comprador.queConsumiste().equals("sprite"));
    	assertEquals(200,comprador.cuantoVuelto());
    }
}
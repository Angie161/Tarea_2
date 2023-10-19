import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestComprador {
	private Comprador comprador;
	private Moneda moneda;
	private Expendedor expendedor;
	private TipoProducto sprite;

	@BeforeEach
    void setup() {
		Moneda1500 moneda1500 = new Moneda1500();
    	expendedor = new Expendedor(3);
		sprite=TipoProducto.SPRITE;
    }


    @Test
    @DisplayName("Test de Comprador.")
    void testComprar() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {

		comprador = new Comprador(moneda, sprite,expendedor);
    	assertTrue(comprador.queConsumiste().equals("sprite"));
    	assertEquals(200,comprador.cuantoVuelto());
    }
}
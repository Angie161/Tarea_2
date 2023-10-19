import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestMoneda {
    private Moneda moneda100;
    private Moneda moneda500;
    private Moneda moneda1000;
    private Moneda moneda1500;

    @BeforeEach
    void setup() {
    	moneda100 = new Moneda100();
    	moneda500 = new Moneda500();
    	moneda1000 = new Moneda1000();
    	moneda1500 = new Moneda1500();
    }

    @Test
    @DisplayName("Test del método getValor() de las monedas.")
    void testgetValor() {
    	assertEquals(100,moneda100.getValor());
    	assertEquals(500,moneda100.getValor());
    	assertEquals(1000,moneda100.getValor());
    	assertEquals(1500,moneda100.getValor());
    }

    @Test
    @DisplayName("Test del método compareTo() de las monedas.")
    void testCompreTo() {
    	Moneda monedaAux100 = new Moneda100();
    	Moneda monedaAux500 = new Moneda500();
    	Moneda monedaAux1000 = new Moneda1000();
    	Moneda monedaAux1500 = new Moneda1500();

    	assertEquals(1,moneda100.compareTo(monedaAux100));
    	assertEquals(1,moneda500.compareTo(monedaAux500));
    	assertEquals(1,moneda1000.compareTo(monedaAux1000));
    	assertEquals(1,moneda1500.compareTo(monedaAux1500));
    	assertEquals(0,moneda100.compareTo(moneda500));
    	assertEquals(0,moneda100.compareTo(moneda1000));
    	assertEquals(0,moneda100.compareTo(moneda1500));
    	assertEquals(0,moneda500.compareTo(moneda1000));
    	assertEquals(0,moneda500.compareTo(moneda1500));
    	assertEquals(0,moneda1000.compareTo(moneda1500));
    }
}
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    	assertEqual(100,moenda100.getValor());
    	assertEqual(500,moenda500.getValor());
    	assertEqual(1000,moenda1000.getValor());
    	assertEqual(1500,moenda1500.getValor());
    }

    @Test
    @DisplayName("Test del método compareTo() de las monedas.")
    void testCompreTo() {
    	Moneda moneda100Aux = new Moneda100();
    	Moneda moneda500Aux = new Moneda500();
    	Moneda moneda1000Aux = new Moneda1000();
    	Moneda moneda1500Aux = new Moneda1500();

    	assertEqual(1,moneda100.compareTo(monedaAux100));
    	assertEqual(1,moneda500.compareTo(monedaAux500));
    	assertEqual(1,moneda1000.compareTo(monedaAux1000));
    	assertEqual(1,moneda1500.compareTo(monedaAux1500));
    	assertEqual(0,moneda100.compareTo(moneda500));
    	assertEqual(0,moneda100.compareTo(moneda1000));
    	assertEqual(0,moneda100.compareTo(moneda1500));
    	assertEqual(0,moneda500.compareTo(moneda1000));
    	assertEqual(0,moneda500.compareTo(moneda1500));    
    	assertEqual(0,moneda1000.compareTo(moneda1500));    
    }
}
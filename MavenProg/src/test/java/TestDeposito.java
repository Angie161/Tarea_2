import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.PrimitiveIterator;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Clase de tipo Test Unitario para probar el correcto funcionamiento de la clase Deposito.
 */
public class TestDeposito {
    private Deposito deposito;
    private Moneda moneda1;
    private Moneda moneda2;
    private Bebida cocacola;
    private Bebida sprite;

    /** Inicializa las variables que emplearán todas las pruebas de los tests. */
    @BeforeEach
    void setup() {
        moneda1=new Moneda100();
        moneda2=new Moneda1000();
        cocacola=new CocaCola(111);
        sprite=new Sprite(222);

        deposito=new Deposito();
    }

    /**
     * Verifica que tras agregar elementos al depósito, este no esté vacío.
     */
    @Test
    @DisplayName("Test Agregado de monedas")
    void AgregadoMonedas(){
        deposito.add(moneda1);
        deposito.add(moneda2);
        assertNotNull(deposito);
    }

    /**
     * Verifica el correcto vaciado del depósito. Tras añadir 2 bebidas y sacarlas, que al 3er intento retorne nulo.
     */
    @Test
    @DisplayName("Test Sacando Bebidas del Depósito")
    void SacadoBebidas(){
        deposito.add(cocacola);
        deposito.add(sprite);
        assertNotNull(deposito);

        assertNotNull(deposito.get());
        assertNotNull(deposito.get());
        assertNull(deposito.get());
    }

    /**
     * Verifica el correcto recuento de productos en el depósito.
     */
    @Test
    @DisplayName("Test Recuento de las bebidas del Depósito")
    void RecuentoBebidas(){
        assertEquals(0,deposito.check());
        deposito.add(cocacola);
        assertEquals(1,deposito.check());
        deposito.add(sprite);
        assertEquals(2,deposito.check());

        deposito.get();
        deposito.get();
        assertEquals(0,deposito.check());
    }



}

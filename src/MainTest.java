import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Proves unitaries del Main
 *
 * @author Mei i Abigail
 * @version 1.0
 */
class MainTest {
    /**
     * AssertEquals()
     * Comprova que la posició d'un jugador dins l'equip és correcta.
     * S'espera que el segon jugador afegit estigui a la posició 1
     */
    @Test
    void buscarPosicioJugador() {
        Equip eq1 = new Equip("FC Barcelona");
        Jugador j1 = new Jugador("Ter", "Stegen", null, 5, 1000000, 1, "POR", 90);
        Jugador j2 = new Jugador("Lamine", "Yamal", null, 5, 2000000, 11, "DAV", 92);

        eq1.getJugadors().add(j1);
        eq1.getJugadors().add(j2);
        assertEquals(j2, eq1.getJugadors().get(1));
    }

    /**
     * AssertArrayEquals()
     * Comprova que les posicions possibles d'un jugador són les correctes.
     * S'espera que l'array de les posicions possibles contingui: POR, DEF, MIG, DAV
     */
    @Test
    void possicionsPoossibles() {
        String[] posicions = {"POR", "DEF", "MIG", "DAV"};
        assertArrayEquals(Jugador.POSICIONS_POSSIBLES, posicions);
    }

    /**
     * AssertNotSame()
     * Comprova que dos jugadors diferents no són el mateix objecte
     * S'espera que j1 i j2 siguin referències diferents
     */
    @Test
    public void testObjectes() {
        Jugador j1 = new Jugador("Ter", "Stegen", null, 5, 1000000, 1, "POR", 90);
        Jugador j2 = new Jugador("Lamine", "Yamal", null, 5, 2000000, 11, "DAV", 92);

        assertNotSame(j1, j2);
    }

    /*
    Asserts no usats:
    - assertNull/assertNotNull
    - assertThrows
    - assertTrue/assertFalse
    - assertAll
     */

}
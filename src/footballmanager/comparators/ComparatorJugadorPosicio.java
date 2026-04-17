package footballmanager.comparators;
import footballmanager.classes.Jugador;
import java.util.Comparator;

/**
 * Comparador de tipus Jugador segons la seva posició:<br>
 * - Si les posicions són diferents, s'ordena alfabèticament<br>
 * - Si tenen la mateixa posició, s'ordena de major a menor la seva qualitat
 *
 * @author Mei
 * @version 1.0
 */
public class ComparatorJugadorPosicio implements Comparator<Jugador> {
    @Override
    public int compare(Jugador j1, Jugador j2) {
        int comparacioPosicio = j1.getPosicio().compareTo(j2.getPosicio());

        if (comparacioPosicio != 0) {
            comparacioPosicio = j1.getPosicio().compareTo(j2.getPosicio()); // alfabèticament
        } else {
            comparacioPosicio = Double.compare(j2.getQualitat(), j1.getQualitat()); // qualitat
        }

        return comparacioPosicio;
    }
}

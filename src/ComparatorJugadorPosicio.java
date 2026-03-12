import java.util.Comparator;

/**
 * Comparador de tipus Jugador segons la seva posició
 * Per als jugadors/es que tenen la mateixa posició, ordenarem de major a menor qualitat
 *
 * @author Mei
 */
public class ComparatorJugadorPosicio implements Comparator<Jugador> {
    @Override
    public int compare(Jugador j1, Jugador j2) {
        if (j1.getPosicio().compareTo(j2.getPosicio()) != 0) {
            return j1.getPosicio().compareTo(j2.getPosicio()); // alfabètic
        } else {
            return Double.compare(j2.getQualitat(), j1.getQualitat()); // major a menor qualitat
        }
    }
}

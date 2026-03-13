import java.util.Comparator;

/**
 * Comparador de tipus Jugador segons la seva qualitat
 * En cas de qualitats iguals, ordenarem de major a menor motivació
 * Si de nou hi ha dos valors iguals, ordenarem alfabèticament pel cognom
 *
 * @author Mei
 * @version 1.0
 */

public class ComparatorJugadorQualitat implements Comparator<Jugador> {
    @Override
    public int compare(Jugador j1, Jugador j2) {
        if (Double.compare(j2.getQualitat(), j1.getQualitat()) != 0) {
            return Double.compare(j2.getQualitat(), j1.getQualitat()); // major a menor
        } else if (Double.compare(j2.getNivellMotivacio(), j1.getNivellMotivacio()) != 0) {
            return Double.compare(j2.getNivellMotivacio(), j1.getNivellMotivacio()); // major a menor
        } else {
            return j1.getCognom().compareTo(j2.getCognom()); // alfabètic
        }
    }
}

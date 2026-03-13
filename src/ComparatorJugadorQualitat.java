import java.util.Comparator;

/**
 * Comparador de tipus Jugador segons la seva qualitat:<br>
 * - Si les qualitats són diferents, s'ordena de major a menor<br>
 * - En cas de qualitats iguals, s'ordena la motivació de major a menor<br>
 * - Si de nou hi ha dos valors iguals, s'ordena alfabèticament pel cognom
 *
 * @author Mei
 * @version 1.0
 */

public class ComparatorJugadorQualitat implements Comparator<Jugador> {
    @Override
    public int compare(Jugador j1, Jugador j2) {
        int comparacioQualitat = Double.compare(j2.getQualitat(), j1.getQualitat());

        if (comparacioQualitat != 0) {
            comparacioQualitat = Double.compare(j2.getQualitat(), j1.getQualitat()); // qualitat
        } else if (Double.compare(j2.getNivellMotivacio(), j1.getNivellMotivacio()) != 0) {
            comparacioQualitat = Double.compare(j2.getNivellMotivacio(), j1.getNivellMotivacio()); // motivació
        } else {
            comparacioQualitat = j1.getCognom().compareTo(j2.getCognom()); // cognom
        }

        return comparacioQualitat;
    }
}

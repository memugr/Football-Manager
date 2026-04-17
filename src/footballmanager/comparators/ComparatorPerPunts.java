package footballmanager.comparators;
import footballmanager.classes.FitxaEquip;
import java.util.Comparator;

/**
 * Comparador per ordenar equips per punts
 * En cas de tenir el mateix número de punts, serà
 * per la diferència entre els gols a favor i els gols en contra.
 *
 * @author Mei
 * @version 1.0
 */
public class ComparatorPerPunts implements Comparator<FitxaEquip> {
    @Override
    public int compare(FitxaEquip e1, FitxaEquip e2) {
        if (e2.getPunts() != e1.getPunts()) {
            return e2.getPunts() - e1.getPunts();
        }
        return e2.getDiferenciaGols() - e1.getDiferenciaGols();
    }
}

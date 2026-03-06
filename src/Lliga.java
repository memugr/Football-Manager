import java.util.ArrayList;
import java.util.Random;

/**
 * Classe Lliga.
 *
 * @author Abigail i Mei
 * @version 1.0
 */
public class Lliga {
    //Atributs
    private String nom;
    private int quantitatEquips;
    private ArrayList<FitxaEquip> equips;

    //Constructors

    /**
     * Constructor amb només el nom
     *
     * @param nom
     */
    public Lliga(String nom) {
        this.nom = nom;
    }

    /**
     * Constructor Lliga completa
     *
     * @param nom
     * @param quantitatEquips
     * @param equips
     *
     */
    public Lliga(String nom, int quantitatEquips, ArrayList<FitxaEquip> equips) {
        this(nom);
        this.quantitatEquips = quantitatEquips;
        this.equips = equips;
    }

    //Getters
    public String getNom() {
        return nom;
    }

    public int getQuantitatEquips() {
        return quantitatEquips;
    }

    public ArrayList<FitxaEquip> getEquips() {
        return equips;
    }

    //Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setQuantitatEquips(int quantitatEquips) {
        this.quantitatEquips = quantitatEquips;
    }

    public void setEquips(ArrayList<FitxaEquip> equips) {
        this.equips = equips;
    }

    //Mètodes

    /**
     * Afegeix un nou equip al llistat de la lliga
     * @param nouEquip
     */
    public void afegirEquip(Equip nouEquip) {
        this.equips.add(new FitxaEquip(nouEquip));
        System.out.println("Equip " + nouEquip + "s'ha afegit correctament a la lliga " + this.nom);
    }

    /**
     * Disputa
     */
    public void disputarPartits() {
        Random rand = new Random();

        for (int i = 0; i < equips.size(); i++) {
            for (int j = i + 1; j < equips.size(); j++) {
                int golsLocal = rand.nextInt(6);
                int golsVisitant = rand.nextInt(6);
                equips.get(i).afegirResultat(golsLocal, golsVisitant);
                equips.get(j).afegirResultat(golsVisitant, golsLocal);
            }
        }
    }

    public void consultarEquipsGolsFavor() {
    }

    public void consultarEquipsGolsContra() {
    }

    /**
     * Mostra la classificació ordenada amb el comparadodor per punts
     *
     * @see ComparatorPerPunts
     */
    public void mostrarClassificacio() {
        equips.sort(new ComparatorPerPunts());
        System.out.println("=== CLASSIFICACIÓ " + nom + " === ");
        for (FitxaEquip eq : equips) {
            System.out.println(
                    eq.getEquip().getNom() +
                    "\nPunts: " + eq.getPunts() +
                    "\nPartits disputats: " + eq.getPartitsDisputats() +
                    "\nGols a Favor: " + eq.getGolsFavor() +
                    "\nGols en Contra: " + eq.getGolsContra());
        }
    }
}

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
     * Disputa partits automàticament amb un Randomizer
     * Recorre tots els equips de la lliga i els enfronta entre si,
     * assegurant que cada parella d'equips només es trobin una vegada.
     *
     */
    public void disputarPartits() {
        Random rand = new Random();

        for (int i = 0; i < equips.size(); i++) { // Recorrem tots els equips
            for (int j = i + 1; j < equips.size(); j++) { // Recorre un altre equip
                int golsLocal = rand.nextInt(6);
                int golsVisitant = rand.nextInt(6);

                equips.get(i).afegirResultat(golsLocal, golsVisitant); //Actualitza la fitxa de l'equip local
                equips.get(j).afegirResultat(golsVisitant, golsLocal); //Actualitza la fitxa de l'equip visitant (invertit)
            }
        }
    }

    public void consultarEquipsGolsFavor() {
    }

    public void consultarEquipsGolsContra() {
    }

    /**
     * Mostra la classificació ordenada amb el Comparator per punts
     *
     * @see ComparatorPerPunts
     */
    public void mostrarClassificacio() {
        if (equips.isEmpty()) {
            System.out.println("No hi ha equips a la lliga.");
        } else {
            equips.sort(new ComparatorPerPunts());
            System.out.println("=== CLASSIFICACIÓ " + nom + " ===");
            for (FitxaEquip eq : equips) {
                System.out.println("----------");
                System.out.println(
                        eq.getEquip().getNom() +
                        "\nPunts: " + eq.getPunts() +
                        "\nPartits disputats: " + eq.getPartitsDisputats() +
                        "\nGols a Favor: " + eq.getGolsFavor() +
                        "\nGols en Contra: " + eq.getGolsContra() +
                        "\nDiferència de gols: " + eq.getDiferenciaGols());
            }
            System.out.println("----------");
        }
    }
}

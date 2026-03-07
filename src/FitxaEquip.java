/**
 * Fitxa de cada equip per guardar els partits disputats, punts i gols a favor i en contra
 *
 * @author Mei
 * @version 1.0
 *
 */
public class FitxaEquip {
    //Atributs
    private Equip equip;
    private int partitsDisputats, punts, golsFavor, golsContra;

    /**
     * Constructor inicial de la fitxa d'un equip
     * @param equip
     */
    public FitxaEquip(Equip equip) {
        this.equip = equip;
        this.partitsDisputats = 0;
        this.punts = 0;
        this.golsFavor = 0;
        this.golsContra = 0;
    }

    // Getters
    public Equip getEquip() {
        return equip;
    }

    public int getPartitsDisputats() {
        return partitsDisputats;
    }

    public int getPunts() {
        return punts;
    }

    public int getGolsFavor() {
        return golsFavor;
    }

    public int getGolsContra() {
        return golsContra;
    }

    public int getDiferenciaGols() {
        return golsFavor - golsContra;
    }

    public void afegirResultat(int golsF, int golsC) {
        this.golsFavor += golsF;
        this.golsContra += golsC;
        this.partitsDisputats++;

        if (golsF > golsC) {
            punts += 3; // victòria
        } else if (golsF == golsC) {
            punts += 1; // empat
        }
        // derrota = 0 punts
    }
}

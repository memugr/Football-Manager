/**
 * Classe Equip. Mostra la informació de cada equip.
 *
 * Cada equip té un entrenador i un llistat de jugadors/es.
 *
 * Es calcula la qualitat mitjana dels equips, en base la qualitat dels jugadors.
 *
 * @author Abigail
 * @version 1.0
 */
public class Equip {

    private String nom, ciutat, nomEstadi, nomPresident;
    private int anyFundacio;
    private boolean donatAlta = false;

    public Equip() {}

    public Equip(String nom) {
        this.nom = nom;
    }

    /**
     * Constructor amb paràmetres:
     * @param anyFundacio
     * @param nomPresident
     * @param nomEstadi
     * @param ciutat
     * @param nom
     */
    public Equip(int anyFundacio, String nomPresident, String nomEstadi, String ciutat, String nom) {
        this.anyFundacio = anyFundacio;
        this.nomPresident = nomPresident;
        this.nomEstadi = nomEstadi;
        this.ciutat = ciutat;
        this.nom = nom;
    }

    /**
     * Constructor amb paràmetres:
     * @param nom
     * @param ciutat
     * @param anyFundacio
     */
    public Equip(String nom, String ciutat, int anyFundacio) {
        this.nom = nom;
        this.ciutat = ciutat;
        this.anyFundacio = anyFundacio;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCiutat() {
        return ciutat;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    public String getNomEstadi() {
        return nomEstadi;
    }

    public void setNomEstadi(String nomEstadi) {
        this.nomEstadi = nomEstadi;
    }

    public String getNomPresident() {
        return nomPresident;
    }

    public void setNomPresident(String nomPresident) {
        this.nomPresident = nomPresident;
    }

    public int getAnyFundacio() {
        return anyFundacio;
    }

    public void setAnyFundacio(int anyFundacio) {
        this.anyFundacio = anyFundacio;
    }

    public boolean isDonatAlta() {
        return donatAlta;
    }

    public void setDonatAlta(boolean donatAlta) {
        this.donatAlta = donatAlta;
    }

    /**
     * Mètode toString.
     * @return: informació de cada equip.
     */
    @Override
    public String toString() {
        return "----------\nDades d'equip\n" +
                "Nom: " + nom +
                "\nCiutat: " + ciutat +
                "\nNom de l'estadi: " + nomEstadi +
                "\nNom del president: " + nomPresident +
                "\nAny de fundació: " + anyFundacio +
                "\n----------";
    }

    public void mostrarQualitatMitjana (){}

    public void mostrarJugadors (){}

    public void fitxarJugador (){}

    public void fitxarEntrenador (){}

    public void destituirEntrenador (){}

    public void modificarPresident (){}

}

import java.util.ArrayList;

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
    private double qualitatMitjaEquip;
    private Entrenador entrenador;
    private ArrayList<Jugador> jugadors = new ArrayList<>();

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

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


    public void calcularMitjanaEquip ()  {
        if (jugadors.isEmpty()) {
            qualitatMitjaEquip = 0;
        } else {
            double suma = 0;
            for (Jugador jugador : jugadors) {
                suma += jugador.getQualitat();
            }
            qualitatMitjaEquip = suma/jugadors.size();
        }

    }

    public void mostrarQualitatMitjana () {
        if (qualitatMitjaEquip == 0 && jugadors.isEmpty()) {
            System.out.println("Encara no s'ha calculat la qualitat mitjana de l'equip.");
        } else {
            System.out.println("La qualitat mitjana de l'equip es " + Equip.this.nom + " és: " +  qualitatMitjaEquip);
        }

    }

    public void mostrarJugadors (){
        if  (jugadors.isEmpty()) {
            System.out.println("Aquest equip encara no té jugadors.");
        } else {
            System.out.println("Jugadors de l'equip " + this.nom + ":");
            for(Jugador j : jugadors){
                System.out.println(j.toString());
            };
        }
    }

    public void fitxarEntrenador (Entrenador entrenador) {
        if (this.entrenador != null) {
            System.out.println("Aquest equip ja té un entrenador: " + this.entrenador.getNom() + " " +
                    this.entrenador.cognom);
        } else {
            this.entrenador = entrenador;
            System.out.println("S'ha fitxat l'entrenador " + this.entrenador.getNom() + " " +
                    this.entrenador.getCognom() + " per l'equip " + this.nom + ".");
        }
    }

    public void fitxarJugador (){}

    public void destituirEntrenador (){
        if (this.entrenador == null) {
            System.out.println("No hi ha cap entrenador assignat.");
        } else {
            String nomEntrenador = this.entrenador.getNom() + " " + this.entrenador.getCognom();
            this.entrenador = null;
            System.out.println("S'ha destituït a l'entrenador " + nomEntrenador);
        }
    }

    public void modificarPresident(String nouPresident) {
        if (nomPresident == null || nomPresident.isEmpty()) {
            System.out.println("Encara no hi havia president assignat.");
        } else if (nomPresident.equals(nouPresident)) {
            System.out.println("Ja és el president actual!");
        } else {
            System.out.println("El president " + nomPresident + " ha estat substituït per " + nouPresident);
        }
        this.nomPresident = nouPresident;
    }
}

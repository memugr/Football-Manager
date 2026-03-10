import java.util.ArrayList;

/**
 * Classe Equip. Representa un equip de futbol amb la informació bàsica.
 *
 * Cada equip té un entrenador i un llistat de jugadors/es.
 *
 * Es calcula la qualitat mitjana dels equips, en base la qualitat dels jugadors.
 *
 * @author Abigail
 * @version 1.0
 */
public class Equip {

    //Atributs
    private String nom, ciutat, nomEstadi, nomPresident;
    private int anyFundacio;
    private boolean donatAlta = false;
    private double qualitatMitjaEquip;

    //Entrenador de l'equip.
    private Entrenador entrenador;

    //Llista de jugadors que formen part de l'equip.
    private ArrayList<Jugador> jugadors = new ArrayList<>();

    //Getter i Setter de l'entrenador
    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    /**
     * Constructor que només rep el nom de l'equip.
     * @param nom
     */
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

    // Getters i setters
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

    public ArrayList<Jugador> getJugadors() {
        return jugadors;
    }

    /**
     * Mètode toString de l'equip.
     *
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

    /**
     * Calcula la qualitat mitjana de l'equip.
     *
     * Si no hi ha jugadors, la qualitat és 0.
     */
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

    /**
     * Mostra la qualitat mitjana de l'equip.
     * Si encara no s'ha calculat i no hi ha jugadors, avisa l'usuari.
     */
    public void mostrarQualitatMitjana () {
        if (qualitatMitjaEquip == 0 && jugadors.isEmpty()) {
            System.out.println("Encara no s'ha calculat la qualitat mitjana de l'equip.");
        } else {
            System.out.println("La qualitat mitjana de l'equip es " + Equip.this.nom + " és: " +  qualitatMitjaEquip);
        }

    }

    /**
     * Mostra tots els jugadors de l'equip.
     * Si no n'hi ha cap, informa l'usuari.
     */
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

    /**
     * Assigna un entrenador a l'equip.
     * Si ja n'hi ha un, mostra un missatge indicant-ho.
     *
     * @param entrenador Entrenador a assignar.
     */
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

    /**
     * Afegeix un jugador a l'equip si encara no hi forma part.
     *
     * @param jugador Jugador que es vol fitxar.
     */
    public void fitxarJugador (Jugador jugador){
        if (jugador == null) {
            System.out.println("No hi ha jugador per fitxar.");
        }else if (jugador.getNom().equals(this.nom) || jugador.getCognom().equals(this.nom)) {
            System.out.println("El jugador " + jugador.getNom() + " " + jugador.getCognom() + " ja forma part de l'equip " + this.nom + ".");
        }else {
            jugadors.add(jugador);
            System.out.println("S'ha fitxat el jugador " + jugador.getNom() + " " +
                    jugador.getCognom() + " a l'equip " + this.nom + ".");
        }
    }

    /**
     * Elimina l'entrenador actual de l'equip.
     * Si no n'hi ha cap, informa l'usuari.
     */
    public void destituirEntrenador (){
        if (this.entrenador == null) {
            System.out.println("No hi ha cap entrenador assignat a " + this.nom);
        } else {
            String nomEntrenador = this.entrenador.getNom() + " " + this.entrenador.getCognom();
            this.entrenador = null;
            System.out.println("S'ha destituït a l'entrenador " + nomEntrenador);
        }
    }

    /**
     * Modifica el president de l'equip.
     *
     * @param nouPresident Nom del nou president.
     */
    public void modificarPresident(String nouPresident) {
        if (nomPresident == null || nomPresident.isEmpty()) {
            this.nomPresident = nouPresident;
            System.out.println("Nou president: " + nouPresident);
        } else if (nomPresident.equals(nouPresident)) {
            System.out.println(nouPresident + "ja és el president actual de " + this.nom);
        } else {
            System.out.println("El president " + nomPresident + " ha estat substituït per " + nouPresident);
        }

    }
}

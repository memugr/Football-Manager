import java.util.Date;

/**
 * Classe Entrenador. Hereta de la classe Persona.
 *
 * @author Abigail
 * @version 1.0
 */
public class Entrenador extends Persona {
    //Atributs
    private int numTorneigGuanyats;
    private boolean seleccionadorNacional = false;

    /**
     * Constructor de Persona on el seu nivell per definició és de 5
     *
     * @param nom
     * @param cognom
     * @param dataNaixement
     * @param souAnual
     */
    public Entrenador(String nom, String cognom, Date dataNaixement, double souAnual) {
        super(nom, cognom, dataNaixement, souAnual);
    }
    /**
     * Constructor complet d'un Entrenador.
     *
     * @param nom Nom de l'entrenador.
     * @param cognom Cognom de l'entrenador.
     * @param dataNaixement Data de naixement.
     * @param souAnual Sou anual assignat.
     * @param numTorneigGuanyats Nombre de tornejos guanyats.
     * @param seleccionadorNacional Indica si és seleccionador nacional
     */
    public Entrenador(String nom, String cognom, Date dataNaixement, double souAnual, int numTorneigGuanyats, boolean seleccionadorNacional) {
        super(nom, cognom, dataNaixement, souAnual);
        this.numTorneigGuanyats = numTorneigGuanyats;
        this.seleccionadorNacional = seleccionadorNacional;
    }

    /**
     * Constructor amb el nivell de motivació ja definit
     * @param nom
     * @param cognom
     * @param dataNaixement
     * @param nivellMotivacio
     * @param souAnual
     * @param tornejosGuanyats
     * @param esSeleccionador
     */
    public Entrenador(String nom, String cognom, Date dataNaixement, int nivellMotivacio, double souAnual, int tornejosGuanyats, boolean esSeleccionador) {
        super(nom, cognom, dataNaixement, nivellMotivacio, souAnual);
        this.numTorneigGuanyats = tornejosGuanyats;
        this.seleccionadorNacional = esSeleccionador;
    }

    //Getters i setters
    public int getNumTorneigGuanyats() {
        return numTorneigGuanyats;
    }

    public void setNumTorneigGuanyats(int numTorneigGuanyats) {
        this.numTorneigGuanyats = numTorneigGuanyats;
    }

    public boolean isSeleccionadorNacional() {
        return seleccionadorNacional;
    }

    public void setSeleccionadorNacional(boolean seleccionadorNacional) {
        this.seleccionadorNacional = seleccionadorNacional;
    }

    /**
     * Mostra la informació de l'entrenador,incloent les dades de Persona i els atributs propis.
     */

    @Override
    public String toString() {
        return "Entrenador: " + '\n' +
                super.toString() +
                "\nNúmero de tornejos guanyats: " + numTorneigGuanyats +
                "\nÉs seleccionador nacional: " + seleccionadorNacional;
    }

    /**
     * Mètode que incrementa el sou anual de l'entrenador.
     */
    public void incrementarSou () {
        double souActual = this.souAnual;
        double souNou = this.souAnual + 1.005;
        this.souAnual = souNou;
        System.out.println("El sou de l'entrenador ha pujat. Ara el sou aunual serà: " + souNou);
    }

    /**
     * Aplica l'efecte d'un entrenament sobre la motivació.
     * Si és seleccionador nacional, la motivació puja més.
     */
    @Override
    public void entrenament() {
        if (this.seleccionadorNacional) {
            this.nivellMotivacio += 0.3;
        } else {
            this.nivellMotivacio += 0.15;
        }
    }
}

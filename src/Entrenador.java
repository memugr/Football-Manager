import java.util.Date;

/**
 * Classe Entrenador.
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

    public Entrenador(String nom, String cognom, Date dataNaixement, double souAnual, int numTorneigGuanyats, boolean seleccionadorNacional, int motivacio) {
        super(nom, cognom, dataNaixement, souAnual);
        this.numTorneigGuanyats = numTorneigGuanyats;
        this.seleccionadorNacional = seleccionadorNacional;
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


    @Override
    public String toString() {
        return super.toString() +
                "\nNúmero de tornejos guanyats: " + numTorneigGuanyats +
                "\nÉs seleccionador nacional: " + seleccionadorNacional;
    }

    public void incrementarSou () {
        double souActual = this.souAnual;
        double souNou = this.souAnual + 1.005;
        this.souAnual = souNou;
        System.out.println("El sou de l'entrenador ha pujat. Ara el sou aunual serà: " + souNou);
    }

    @Override
    public void entrenament() {
        if (this.seleccionadorNacional) {
            this.nivellMotivacio += 0.3;
        } else {
            this.nivellMotivacio += 0.15;
        }
    }
}

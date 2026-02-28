import java.util.Date;

/**
 * Classe Entrenador.
 *
 * @author Abigail
 * @version 1.0
 */
public class Entrenador extends Persona {
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
    private int numTorneigGuanyats, motivacio;
    private boolean seleccionadorNacional = false;

    public Entrenador(String nom, String cognom, Date dataNaixement, double souAnual, int numTorneigGuanyats, boolean seleccionadorNacional, int motivacio) {
        super(nom, cognom, dataNaixement, souAnual);
        this.numTorneigGuanyats = numTorneigGuanyats;
        this.seleccionadorNacional = seleccionadorNacional;
        this.motivacio = motivacio;
    }

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

    public int getMotivacio() {
        return motivacio;
    }

    public void setMotivacio(int motivacio) {
        this.motivacio = motivacio;
    }


    @Override
    public String toString() {
        return super.toString() + "Número de tornejos guanyats: " + numTorneigGuanyats + "\nMotivacio: " +
                motivacio + "\nÉs seleccionador nacional: " + seleccionadorNacional;
    }

    public void incrementarSou (){
        double souActual = this.souAnual;
        double souNou = this.souAnual + 1.005;
        this.souAnual = souNou;
        System.out.println("El sou de l'entrenador ha pujat. Ara el sou aunual serà: " + souNou);
    }

    @Override
    public void entrenament() {
        if (this.seleccionadorNacional == true) {
            this.nivellMotivacio += 0.3;
        }else  {
            this.nivellMotivacio += 0.15;
        }
    }
}

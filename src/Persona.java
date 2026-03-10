import java.util.Date;

/**
 * Classe Persona
 *
 * @author Mei
 * @version 1.0
 */

public abstract class Persona {
    //Atributs
    protected String nom, cognom;
    protected Date dataNaixement;
    protected double nivellMotivacio;
    protected double souAnual;

    /**
     * Contrustor Persona sense sou anual
     * @param nom
     * @param cognom
     * @param dataNaixement
     */
    public Persona(String nom, String cognom, Date dataNaixement) {
        this.nom = nom;
        this.cognom = cognom;
        this.dataNaixement = dataNaixement;
        this.nivellMotivacio = 5;
    }

    /**
     * Constructor amb sou anual
     * @param nom
     * @param cognom
     * @param dataNaixement
     * @param souAnual
     */
    public Persona(String nom, String cognom, Date dataNaixement, double souAnual) {
        this(nom, cognom, dataNaixement);
        this.souAnual = souAnual;
    }

    /**
     * Constructor amb tots els paràmetres
     * @param nom
     * @param cognom
     * @param dataNaixement
     * @param nivellMotivacio
     * @param souAnual
     */
    public Persona(String nom, String cognom, Date dataNaixement, double nivellMotivacio, double souAnual) {
        this.nom = nom;
        this.cognom = cognom;
        this.dataNaixement = dataNaixement;
        this.nivellMotivacio = nivellMotivacio;
        this.souAnual = souAnual;
    }

    //Getters
    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public Date getDataNaixement() {
        return dataNaixement;
    }

    public double getNivellMotivacio() {
        return nivellMotivacio;
    }

    public double getSouAnual() {
        return souAnual;
    }

    //Setters: nom, cognom i data de naixement no poden ser modificables
    public void setSouAnual(double souAnual) {
        this.souAnual = souAnual;
    }

    //Mètodes
    /**
     * Mètode entrenament que augmenta la motivació en 0.2 punts
     */
    public void entrenament() {
        if (this.nivellMotivacio + 0.2 <= 10) {
            this.nivellMotivacio += 0.2;
        }
    }

    /**
     * Mètode toStirng de Persona
     * @return Informació de la persona
     */
    @Override
    public String toString() {
        return "Nom: " + nom + '\n' +
                "Cognom: " + cognom + '\n' +
                "Data Naixement: " + dataNaixement + '\n' +
                "Nivell de motivació: " + nivellMotivacio + '\n' +
                "Sou Anual: " + souAnual;
    }
}

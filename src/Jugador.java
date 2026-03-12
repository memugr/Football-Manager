import java.util.Date;
import java.util.Random;

/**
 * Classe jugador
 *
 * @author Mei
 * @version 1.0
 */
public class Jugador extends Persona {
    //Atributs
    /**
     * Posicions finals del jugador
     */
    public static final String[] POSICIONS_POSSIBLES = {"POR", "DEF", "MIG", "DAV"};

    /**
     * Dorsal del jugador
     */
    private int dorsal;
    /**
     * Posició del jugador
     */
    private String posicio;
    /**
     * Qualitat del jugador
     */
    private double qualitat;

    //Constructor

    /**
     *
     * @param nom
     * @param cognom
     * @param dataNaixement
     * @param nivellMotivacio
     * @param souAnual
     * @param dorsal
     * @param posicio
     * @param qualitat
     */
    public Jugador(String nom, String cognom, Date dataNaixement, double nivellMotivacio, double souAnual, int dorsal, String posicio, double qualitat) {
        super(nom, cognom, dataNaixement, nivellMotivacio, souAnual);
        this.dorsal = dorsal;
        this.posicio = posicio;
        this.qualitat = qualitat;
    }

    //Getters
    public int getDorsal() {
        return dorsal;
    }

    public String getPosicio() {
        return posicio;
    }

    public double getQualitat() {
        return qualitat;
    }

    //Setters
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    //Mètodes
    /**
     * Genera la qualitat del jugador
     * @return Qualitat randomitzada
     */
    public double generarQualitat() {
        return new Random().nextInt(71) + 30; // entre 30 i 100
    }

    /**
     * Canvia la posició del jugador si el nombre randomitzat és menor a 5%
     */
    private void canviDePosicio() {
        if (Math.random() < 0.05) {
            String posicioAnterior = this.posicio;
            String novaPosicio = POSICIONS_POSSIBLES[new Random().nextInt(POSICIONS_POSSIBLES.length)];
            this.posicio = novaPosicio;
            this.qualitat += 1;
            System.out.println("El jugador " + nom + " " + cognom + " ha canviat de posició: " + posicioAnterior + " -> " + this.posicio);
        }
    }

    /**
     * Executa la classe pare i augmenta la qualitat del jugador a partir d'un número aleatori
     */
    @Override
    public void entrenament() {
        super.entrenament();
        canviDePosicio();

        double aleatori = Math.random();

        if (aleatori < 0.70) {
            qualitat += 0.1;
            System.out.println("Qualitat augmentada en 0.1. Nova qualitat: " + qualitat);
        } else if (aleatori < 0.90) {
            qualitat += 0.2;
            System.out.println("Qualitat augmentada en 0.2. Nova qualitat: " + qualitat);
        } else {
            qualitat += 0.3;
            System.out.println("Qualitat augmentada en 0.3. Nova qualitat: " + qualitat);
        }
    }

    /**
     * Mètode toString per ensenyar la informació d'un jugador
     * @return Informació d'un jugador
     */
    @Override
    public String toString() {
        return "Jugador: " + '\n' +
                super.toString() + '\n' +
                "Dorsal: " + dorsal + '\n' +
                "Posició: " + posicio + '\n' +
                "Qualitat: " + qualitat;
    }
}
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
     * Comptador per saber quants jugadors existeixen
     */
    private static int comptadorJugadors = 0;

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
     * Constructor del jugador
     *
     * @param nom
     * @param cognom
     * @param dataNaixement
     * @param souAnual
     * @param dorsal
     * @param posicio
     */
    public Jugador(String nom, String cognom, Date dataNaixement, double souAnual, int dorsal, String posicio) {
        super(nom, cognom, dataNaixement, souAnual);
        this.dorsal = dorsal;
        this.posicio = posicio;
        this.qualitat = generarQualitat();
        comptadorJugadors++;
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
     * Executa la classe pare i augmente la qualitat del jugador a partir d'un número aleatori
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
     * Ensenya per pantalla les posicions possibles per un jugador
     */
    public void ensenyarPosicionsPossibles() {
        System.out.println("Possicions possibles: ");
        for (int i = 0; i < POSICIONS_POSSIBLES.length; i++) {
            System.out.println((i + 1) + ". " + POSICIONS_POSSIBLES[i]);
        }
    }

    /**
     * Mètode toString per ensenyar la informació d'un jugador
     * @return Informació d'un jugador
     */
    @Override
    public String toString() {
        return "Jugador: " +
                "Nom: " + nom + '\n' +
                "Cognom: " + cognom + '\n' +
                "Data Naixement: " + dataNaixement + '\n' +
                "Nivell de motivació: " + nivellMotivacio + '\n' +
                "Sou Anual: " + souAnual + '\n' +
                "Dorsal: " + dorsal + '\n' +
                "Posició: " + posicio + '\n' +
                "Qualitat: " + qualitat;
    }
}
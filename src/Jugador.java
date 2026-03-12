import java.util.Date;
import java.util.Objects;
import java.util.Random;

/**
 * Classe jugador
 *
 * @author Mei
 * @version 1.0
 */
public class Jugador extends Persona {
    //Atributs
    public static final String[] POSICIONS_POSSIBLES = {"POR", "DEF", "MIG", "DAV"};

    private int dorsal;
    private String posicio;
    private double qualitat;

    //Constructor

    /**
     * Constructor d'un objecte Jugador
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
     * Comprova si dos jugadors són iguals
     * Dos jugadors es consideren iguals si tenen el mateix nom i dorsal
     *
     * @param o L'objecte a comparar
     * @return true si els jugadors tenen el mateix nom i dorsal, false en cas contrari
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return dorsal == jugador.dorsal && nom.equalsIgnoreCase(jugador.nom);
    }

    /**
     * Genera el codi hash del jugador basat en el nom i el dorsal
     * Consistent amb el mètode equals()
     *
     * @return codi hash del jugador
     */
    @Override
    public int hashCode() {
        return Objects.hash(nom, dorsal);
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
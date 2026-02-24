import java.util.Date;

/**
 * Classe jugador
 *
 * @author Mei
 * @version 1.0
 */
public class Jugador extends Persona {
    //Atributs
    /**
     * Dorsal del jugador
     */
    private int dorsal;
    /**
     * Posicions finals del jugador
     */
    final String[] POSICIONS_POSSIBLES = {"POR", "DEF", "MIG", "DAV"};
    private String posicio;
    /**
     * Qualitat del jugador
     */
    private double qualitat;

    //Constructor

    /**
     * Constructor Jugador
     *
     * @param nom
     * @param cognom
     * @param dataNaixement
     * @param souAnual
     * @param dorsal
     * @param posicio
     * @param qualitat
     */
    public Jugador(String nom, String cognom, Date dataNaixement, double souAnual, int dorsal, String posicio, double qualitat) {
        super(nom, cognom, dataNaixement, souAnual);
        this.dorsal = dorsal;
        this.posicio = posicio;
        this.qualitat = qualitat;
    }
}
import java.util.ArrayList;

/**
 * Classe Lliga.
 *
 * @author Abigail i Mei
 * @version 1.0
 */
public class Lliga {
    //Atributs
    private String nom;
    private int quantitatEquips;
    private ArrayList<Equip> equips;

    //Constructors
    public Lliga(String nom) {
        this.nom = nom;
    }

    public Lliga(String nom, int quantitatEquips, ArrayList<Equip> equips) {
        this(nom);
        this.quantitatEquips = quantitatEquips;
        this.equips = equips;
    }

    //Getters
    public String getNom() {
        return nom;
    }

    public int getQuantitatEquips() {
        return quantitatEquips;
    }

    public ArrayList<Equip> getEquips() {
        return equips;
    }

    //Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setQuantitatEquips(int quantitatEquips) {
        this.quantitatEquips = quantitatEquips;
    }

    public void setEquips(ArrayList<Equip> equips) {
        this.equips = equips;
    }

    //Mètodes
    public void afegirEquips() {
    }

    public void disputarPartits() {
    }

    public void consultarEquipsGolsFavor() {
    }

    public void consultarEquipsGolsContra() {
    }

    public void mostrarClassificacio() {
    }
}

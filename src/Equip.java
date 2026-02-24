public class Equip {

    private String nom, ciutat, nomEstadi, nomPresident;
    private int anyFundacio;

    public Equip() {}

    public Equip(String nom) {
        this.nom = nom;
    }

    public Equip(int anyFundacio, String nomPresident, String nomEstadi, String ciutat, String nom) {
        this.anyFundacio = anyFundacio;
        this.nomPresident = nomPresident;
        this.nomEstadi = nomEstadi;
        this.ciutat = ciutat;
        this.nom = nom;
    }

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

    public void mostrarQualitatMitjana (){}

    public void mostrarJugadors (){}

    public void fitxarJugador (){}

    public void fitxarEntrenador (){}

    public void destituirEntrenador (){}

    public void modificarPresident (){}



}

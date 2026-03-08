import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe Main
 *
 * @author Mei i Abigail
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------\n  Football Manager\n--------------------");
        carregarFitxatges();

        int opcioUser = getOpcioUsuari();
        switch (opcioUser) {
            case 1:
                mostrarAdmin();
                break;
            case 2:
                mostrarGestor();
                break;
        }
    }

    private static void carregarFitxatges() {}

    /**
     * Demana a l'usuari si és Admin o Gestor d'Equips
     * @return opció del tipus d'usuari
     */
    public static int getOpcioUsuari() {
        Scanner sc = new Scanner(System.in);
        int opcio = -1;

        do {
            try {
                System.out.print("Ets administrador (1) o gestor d'equip (2)? ");
                opcio = sc.nextInt();

                if (opcio < 1 || opcio > 2) {
                    System.out.println("Opció invàlida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Caràcter invàlid, només números!");
                sc.nextLine();
            }
        } while (opcio < 1 || opcio > 2);

        return opcio;
    }

    // ADMIN (Abi)
    public static void mostrarAdmin() {
        System.out.println("Benvingut al Politècnics Football Manager, Admin.");
        System.out.println("Escull una opció: ");
        System.out.println("-----\nMenú:\n-----");
        System.out.println("1. Veure classificació lliga actual." +
                "\n2. Donar d'alta un equip." +
                "\n3. Donar d'alta jugador/a o entrenador/a." +
                "\n4. Consultar dades del equip." +
                "\n5. Consultar dades del jugador/a del equip." +
                "\n6. Disputar nova lliga." +
                "\n7. Realitzar sessió d'entrenament (del mercat de fitxatges)." +
                "\n8. Desar dades dels equips." +
                "\n0. Sortir.");
    }

    //----------------------------------------------------------------------------------------------------//
    //GESTOR D'EQUIPS (Mei)

    /**
     * Mostra el programa principal del gestor d'equips
     */
    public static void mostrarGestor() {
        System.out.println("Benvingut al Politècnics Football Manager, Gestor d'Equips.");

        //Atributs
        int opcioGestor;

        do {
            mostrarMenuGestor();
            opcioGestor = getOpcioGestor();
            opcionsProgramaGestor(opcioGestor);

        } while (opcioGestor != 0);
    }

    public static void mostrarMenuGestor() {
        System.out.println("\n1. Veure classificació lliga actual");
        System.out.println("2. Gestionar el meu equip ⚽");
        System.out.println("3. Consultar dades d'un equip");
        System.out.println("4. Consultar dades jugador/a d'un equip");
        System.out.println("5. Transferir jugador/a");
        System.out.println("6. Desar dades equips");
        System.out.println("0. Sortir");
        System.out.print("Selecciona una opció: ");
    }

    private static int getOpcioGestor() {
        Scanner sc = new Scanner(System.in);
        int opcio = -1;

        try {
            opcio = sc.nextInt();

            if (opcio < 0 || opcio > 6) {
                System.out.println("Opció no vàlida");
            }
        } catch (InputMismatchException e) {
            System.out.println("Caràcter no vàlid, només números");
            sc.nextLine();
        }
        return opcio;
    }

    public static void opcionsProgramaGestor(int opcioGestor) {
        switch (opcioGestor) {
            case 1:
                veureClassificacio();
                break;
            case 2:
                mostrarGestionarEquip();
                break;
            case 3:
                //consultarDadesEquip();
                break;
            case 4:
                //consultarDadesJugador();
                break;
            case 5:
                //transferirJugador();
                break;
            case 6:
                //desarDadesEquips();
                break;
            case 0:
                System.out.println("Sortint del programa");
                break;
        }
    }

    private static void veureClassificacio() {

    }

    private static void mostrarGestionarEquip() {
        System.out.println("\nGestió d'Equips");
        int opcioGestionarEquip;

        do {
            mostrarMenuGestionar();
            opcioGestionarEquip = getOpcioGestionarEquip();
            opcionsProgramaGestionarEquips(opcioGestionarEquip);
        } while (opcioGestionarEquip != 0);
    }

    private static void mostrarMenuGestionar() {
        System.out.println("\n1. Donar de baixa l'equip");
        System.out.println("2. Modificar president/a");
        System.out.println("3. Destituir entrenador/a");
        System.out.println("4. Fitxar jugador/a o entrenador/a");
        System.out.println("0. Sortir");
        System.out.print("Selecciona la teva opció: ");
    }

    private static int getOpcioGestionarEquip() {
        Scanner sc = new Scanner(System.in);
        int opcio = -1;

        try {
            opcio = sc.nextInt();

            if (opcio < 0 || opcio > 4) {
                System.out.println("Opció no vàlida");
            }
        } catch (InputMismatchException e) {
            System.out.println("Caràcter no vàlid, només números");
            sc.nextLine();
        }
        return opcio;
    }

    private static void opcionsProgramaGestionarEquips(int opcioGestionarEquip) {
        switch (opcioGestionarEquip) {
            case 1:
                //donarBaixaEquip();
                break;
            case 2:
                //modificarPresident();
                break;
            case 3:
                //destituirEntrenador();
                break;
            case 4:
                //fitxarJugadorEntrenador();
                break;
            case 0:
                System.out.println("Sortint de Gestionar el meu equip, tornant al menú principal");
        }
    }
}
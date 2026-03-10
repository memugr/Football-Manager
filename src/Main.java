import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------\n  Football Manager\n--------------------");
        carregarFitxatges();

        int opcioUsuari = getOpcioUsuari();
        mostrarOpcioUsuari(opcioUsuari);
    }

    private static void mostrarOpcioUsuari(int opcioUsuari) {
        switch (opcioUsuari) {
            case 1:
                mostrarAdmin();
                break;
            case 2:
                mostrarGestor();
                break;
        }
    }

    public static int getOpcioUsuari() {
        Scanner sc = new Scanner(System.in);
        int opcioUsuari = -1;

        do {
            try {
                System.out.print("Ets administrador (1) o gestor d'equip (2)? ");
                opcioUsuari = sc.nextInt();

                if (opcioUsuari < 1 || opcioUsuari > 2) {
                    System.out.println("Opció invàlida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Caràcter invàlid, només números!");
                sc.nextLine();
            }
        } while (opcioUsuari < 1 || opcioUsuari > 2);

        return opcioUsuari;
    }

    private static void carregarFitxatges() {}

    public static void mostrarClassificacioLliga (){}

    // ADMIN
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
    //Casos de la opcion menu admin
    public static void opcionsMenuAdmin (){
        switch (getOpcioAdmin()) {
            case 1:
                // Veure classificació lliga actual
                break;
            case 2:
                //Donar alta equip
                break;
            case 3:
                //Donar alta jugador o entrenador
                break;
            case 4:
                //Consultar dades del equip
                break;
            case 5:
                //Consultar dades del jugador
                break;
            case 6:
                //Disputar nova lliga
                break;
            case 7:
                //Sessió entrenament
                break;
            case 8:
                //Guardar dades de l'equip
                break;
            case 0:
                //Sortir
                break;
        }
    }
//Creo que esto no es!
    public static int getOpcioAdmin (){
        Scanner sc = new Scanner(System.in);
        int opcioAdmin = -1;

        try {
            opcioAdmin = sc.nextInt();
            if (opcioAdmin < 0 || opcioAdmin > 8) {
                System.out.println("Opció no vàlida");
            }
        }catch (InputMismatchException e){
            System.out.println("Caràcter no vàlid, només números");
            sc.nextLine();
        }
        return opcioAdmin;
    }


    //GESTOR D'EQUIPS
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

    public static void opcionsProgramaGestor(int opcioGestor) {
        switch (opcioGestor) {
            case 1:
                //veureClassificacio();
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
}
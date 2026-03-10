import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        ArrayList<Persona> mercatFitxatges = new ArrayList<>();
        ArrayList<Equip> equips = new ArrayList<>();
        Lliga lliga = null;

        String fileName = "src/fitxers/mercat_fitxatges.txt";
        carregarFitxatges(fileName, mercatFitxatges);

        System.out.println("--------------------\n  Football Manager\n--------------------");
        int opcioUser = getOpcioUsuari();
        mostrarOpcionsPrograma(opcioUser, mercatFitxatges, equips, lliga);
    }

    private static void mostrarOpcionsPrograma(int opcioUser, ArrayList<Persona> mercatFitxatges, ArrayList<Equip> equips, Lliga lliga) {
        switch (opcioUser) {
            case 1:
                mostrarAdmin();
                break;
            case 2:
                mostrarGestor(mercatFitxatges, equips, lliga);
                break;
        }
    }

    private static void carregarFitxatges(String fileName, ArrayList<Persona> mercatFitxatges) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");

                char tipusPersonona = parts[0].charAt(0);
                String nom = parts[1];
                String cognom = parts[2];
                Date dataNaixement = formatData.parse(parts[3]);
                int motivacio = Integer.parseInt(parts[4]);
                double souAnual = Double.parseDouble(parts[5]);

                if (tipusPersonona == 'J') {
                    int dorsal = Integer.parseInt(parts[6]);
                    String posicio =  parts[7];
                    double qualitat = Double.parseDouble(parts[8]);

                    Jugador j = new Jugador(nom, cognom, dataNaixement, motivacio, souAnual, dorsal, posicio, qualitat);
                    mercatFitxatges.add(j);

                } else if (tipusPersonona == 'E') {
                    int tornejosGuanyats = Integer.parseInt(parts[6]);
                    boolean esSeleccionador = Boolean.parseBoolean(parts[7]);

                    Entrenador e = new Entrenador(nom, cognom, dataNaixement, motivacio, souAnual, tornejosGuanyats, esSeleccionador);
                    mercatFitxatges.add(e);
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Fitxer no trobat");
        } catch (IOException e) {
            System.out.println("Error llegint el fitxer");
        } catch (ParseException e) {
            System.out.println("Error llegint el fitxer");
        }
    }

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
        mostrarMenuAdmin();
    }

    private static void mostrarMenuAdmin() {
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
    public static void mostrarGestor(ArrayList<Persona> mercatFitxatges, ArrayList<Equip> equips, Lliga lliga) {
        System.out.println("Benvingut al Politècnics Football Manager, Gestor d'Equips.");

        //Atributs
        int opcioGestor;

        do {
            mostrarMenuGestor();
            opcioGestor = getOpcioGestor();
            opcionsProgramaGestor(opcioGestor, mercatFitxatges, equips, lliga);

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

    public static void opcionsProgramaGestor(int opcioGestor, ArrayList<Persona> mercatFitxatges, ArrayList<Equip> equips, Lliga lliga) {
        switch (opcioGestor) {
            case 1:
                veureClassificacio(lliga);
                break;
            case 2:
                mostrarGestionarEquip();
                break;
            case 3:
                consultarDadesEquip(equips);
                break;
            case 4:
                consultarDadesJugador(equips, mercatFitxatges);
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

    /**
     * Mostra la classificació de la lliga
     * @param lliga
     */
    private static void veureClassificacio(Lliga lliga) {
        if (lliga == null) {
            System.out.println("No hi ha cap lliga disputada/activa");
        } else {
            lliga.mostrarClassificacio();
        }
    }

    /**
     * Mostra l'apartat de "Gestionar el Meu Equip"
     */
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

    private static void consultarDadesEquip(ArrayList<Equip> equips) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nBUSCADOR EQUIP\nIntrodueix el nom de l'equip: ");
        String nomEquipTrobar = sc.nextLine();
        int pos = buscarPosicioEquip(equips, nomEquipTrobar);

        if (pos != -1) {
            Equip eq = equips.get(pos);
            System.out.println("\nEquip trobat");
            System.out.println(eq.toString());
        } else {
            System.out.println("Equip " + nomEquipTrobar + " no s'ha trobat");
        }
    }

    private static int buscarPosicioEquip(ArrayList<Equip> equips, String nomEquipTrobar) {
        boolean trobat = false;
        int i = 0, pos = -1;

        while (!trobat && i < equips.size()) {
            if (equips.get(i).getNom().equalsIgnoreCase(nomEquipTrobar)) {
                trobat = true;
                pos = i;
            }
            i++;
        }
        return pos;
    }

    private static void consultarDadesJugador(ArrayList<Equip> equips, ArrayList<Persona> mercatFitxatges) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nBUSCADOR JUGADOR/A\nPrimer introdueix l'equip del jugador/a ");
        String nomEquipTrobar = sc.nextLine();
        int posEquip = buscarPosicioEquip(equips, nomEquipTrobar);

        if (posEquip != -1) {
            System.out.print("\nEquip trobat, introdueix el nom del jugador/a: ");
            String nomJugadorTrobar = sc.nextLine();
            System.out.print("\nIntrodueix el dorsal del jugador/a: ");
            int dorsalJugadorTrobar = sc.nextInt();

            Equip eq = equips.get(posEquip);



        } else {
            System.out.println("Equip o jujador no s'ha trobat");
        }

    }
}
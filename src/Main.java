import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

        String fileNameMercat = "src/fitxers/mercat_fitxatges.txt";
        carregarFitxatges(fileNameMercat, mercatFitxatges);
        String fileNameEquips = "src/fitxers/data_equips.txt";
        carregarEquips(fileNameEquips, equips);

        System.out.println("--------------------\n  Football Manager\n--------------------");
        System.out.print("Ets administrador (1) o gestor d'equip (2)? ");
        int opcioUser = getOpcioUsuari();
        mostrarOpcionsPrograma(opcioUser, mercatFitxatges, equips, lliga);
    }



    private static void mostrarOpcionsPrograma(int opcioUser, ArrayList<Persona> mercatFitxatges, ArrayList<Equip> equips, Lliga lliga) {
        switch (opcioUser) {
            case 1:
                mostrarAdmin(mercatFitxatges, equips, lliga);
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

                char tipusPersona = parts[0].charAt(0);
                String nom = parts[1];
                String cognom = parts[2];
                Date dataNaixement = formatData.parse(parts[3]);
                int motivacio = Integer.parseInt(parts[4]);
                double souAnual = Double.parseDouble(parts[5]);

                if (tipusPersona == 'J') {
                    int dorsal = Integer.parseInt(parts[6]);
                    String posicio = parts[7];
                    double qualitat = Double.parseDouble(parts[8]);

                    Jugador j = new Jugador(nom, cognom, dataNaixement, motivacio, souAnual, dorsal, posicio, qualitat);
                    mercatFitxatges.add(j);

                } else if (tipusPersona == 'E') {
                    int tornejosGuanyats = Integer.parseInt(parts[6]);
                    boolean esSeleccionador = Boolean.parseBoolean(parts[7]);

                    Entrenador e = new Entrenador(nom, cognom, dataNaixement, motivacio, souAnual, tornejosGuanyats, esSeleccionador);
                    mercatFitxatges.add(e);
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Fitxer no trobat");
        } catch (IOException | ParseException e) {
            System.out.println("Error llegint el fitxer");
        }
    }

    private static void carregarEquips(String fileNameEquips, ArrayList<Equip> equips) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileNameEquips));
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String line;
            Equip equipActual = null;

            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    if (line.equals("---")) {
                        if (equipActual != null) {
                            equips.add(equipActual);
                            equipActual = null;
                        }
                    } else if (line.startsWith("J;")) {
                        Jugador j = crearJugador(line, sdf);
                        if (equipActual != null) {
                            equipActual.getJugadors().add(j);
                        }
                    } else {
                        equipActual = crearEquip(line);
                    }
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Fitxer d'equips no trobat");
        } catch (IOException e) {
            System.out.println("Error llegint el fitxer d'equips");
        }
    }

    private static Jugador crearJugador(String line, SimpleDateFormat sdf) {
        String[] parts = line.split(";");
        String nom = parts[1];
        String cognom = parts[2];
        Date dataNaixement = null;

        try {
            dataNaixement = sdf.parse(parts[3]);
        } catch (ParseException e) {
            System.out.println("Error en la data del jugador " + nom);
        }

        double motivacio = Double.parseDouble(parts[4]);
        double souAnual = Double.parseDouble(parts[5]);
        int dorsal = Integer.parseInt(parts[6]);
        String posicio = parts[7];
        double qualitat = Double.parseDouble(parts[8]);

        return new Jugador(nom, cognom, dataNaixement, motivacio, souAnual, dorsal, posicio, qualitat);
    }

    private static Equip crearEquip(String line) {
        String[] parts = line.split(";");

        String nom = parts[0];
        String ciutat = parts[1];
        int anyFundacio = Integer.parseInt(parts[2]);

        String nomEstadi;
        if (parts[3].equals("null")) {
            nomEstadi = null;
        } else {
            nomEstadi = parts[3];
        }

        String nomPresident;
        if (parts[4].equals("null")) {
            nomPresident = null;
        } else {
            nomPresident = parts[4];
        }

        Equip eq = new Equip(anyFundacio, nomPresident, nomEstadi, ciutat, nom);
        return eq;
    }

    /**
     * Guarda l'opció introduida per l'usuari 1 o 2
     *
     * @return opció del tipus d'usuari
     */
    public static int getOpcioUsuari() {
        Scanner sc = new Scanner(System.in);
        int opcio = -1;

        do {
            try {
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

    public static void mostrarAdmin(ArrayList<Persona> mercatFitxatges, ArrayList<Equip> equips, Lliga lliga) {
        System.out.println("Benvingut al Politècnics Football Manager, Admin.");
        int opcioAdmin;
        do {
            mostrarMenuAdmin();
            opcioAdmin = getOpcioAdmin();
            opcionsProgramaAdmin(opcioAdmin, mercatFitxatges, equips, lliga);
        } while (opcioAdmin != 0);
    }

    private static void mostrarMenuAdmin() {
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
        System.out.print("Escull una opció: ");
    }
    public static void opcionsProgramaAdmin (int opcioAmin, ArrayList<Persona> mercatFitxatges, ArrayList<Equip> equips, Lliga lliga){
        switch (opcioAmin){
            case 1:
                veureClassificacio(lliga);
                break;
            case 2:
                donarAltaEquip(equips);
                break;
            case 3:
                donarAltaJugadorEntrenador(mercatFitxatges);
                break;
            case 4:
                consultarDadesEquip(equips);
                break;
            case 5:
                consultarDadesJugador(equips);
                break;
            case 6:
                //disputar lliga
                break;
            case 7:
                //realitzar entrenament
                break;
            case 8:
                desarDadesEquips(equips);
                break;
            case 0:
                System.out.println("Fins després, Admin!");
                break;
        }
    }

    private static void donarAltaEquip(ArrayList<Equip> equips) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nDONAR D'ALTA A UN EQUIP");
        String nomEquipNou;

        do {
            System.out.print("Escriu el nom de l'equip: ");
            nomEquipNou = sc.nextLine();

            if(comprobarExisteixEquip(equips, nomEquipNou)){
                System.out.println("Aquest equip ja està donat d'alta. Torna-ho a intentar.");
            }
        } while (comprobarExisteixEquip(equips, nomEquipNou));

        int anyFundacio = 0;
        boolean valid = false;

        int anyActual = java.time.Year.now().getValue();

        do {
            try {
                System.out.print("Introdueix l'any de fundació: ");
                anyFundacio = Integer.parseInt(sc.nextLine());

                if (String.valueOf(anyFundacio).length() != 4) {
                    System.out.println("Error: l'any ha de tenir 4 dígits.");
                } else if (anyFundacio > anyActual) {
                    System.out.println("Error: l'any no pot ser superior a l'any actual (" + anyActual + ").");
                } else {
                    valid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: has d'introduir un número vàlid.");
            }
        } while (!valid);

        System.out.print("Introdueix el nom de la ciutat: ");
        String nomCiutat = sc.nextLine();

        String nomEstadi = null, nomPresident = null;

        System.out.print("Vols introduïr el nom de l'estadi? (s/n) ");
        char respostaEstadi = getRespostaUsuari();
        if (respostaEstadi == 's') {
            System.out.print("Introdueix el nom de l'estadi: ");
            nomEstadi = sc.nextLine();
        }

        System.out.print("Vols introduïr el nom del president? (s/n) ");
        char respostaPresident = getRespostaUsuari();
        if (respostaPresident == 's') {
            System.out.print("Introdueix el nom del president: ");
            nomPresident = sc.nextLine();
        }

        Equip nouEquip = new Equip(anyFundacio, nomPresident, nomEstadi, nomCiutat, nomEquipNou);
        equips.add(nouEquip);
        System.out.println("El nou equip s'ha afegit correctament!");
    }

    private static void donarAltaJugadorEntrenador(ArrayList<Persona> mercatFitxatges) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Vols donar d'alta un Jugador (1) o un Entrenador (2)? ");
        int opcio = getOpcioPersona();

        int motivacio = 5;
        System.out.print("Introdueix el nom: ");
        String nomPersona = sc.nextLine();
        System.out.print("Introdueix el cognom: ");
        String cognomPersona = sc.nextLine();

        Date dataNaixement = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        boolean dataValida = false;

        do {
            try{
                System.out.print("Introdueix la data de naixement (dd/MM/yyyy): ");
                dataNaixement = sdf.parse(sc.nextLine());
                dataValida = true;
            } catch(ParseException e){
                System.out.println("Format incorrecte.");
            }
        } while (!dataValida);

        double souAnual = 0;
        boolean souValid = false;
        do {
            try{
                System.out.print("Introdueix el sou anual: ");
                souAnual = sc.nextDouble();
                sc.nextLine();
                souValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Format incorrecte. Només números.");
            }
        } while (!souValid);

        //jugador
        if (opcio == 1) {
            int dorsal = 0;
            boolean dorsalvalid = false;

            do {
                try {
                    System.out.print("Introdueix el número de dorsal: ");
                    dorsal = sc.nextInt();
                    sc.nextLine();
                    dorsalvalid = true;
                } catch (InputMismatchException e) {
                    System.out.println("Has d'introduir un número vàlid. Torna a provar.");
                }
            } while (!dorsalvalid);

            String posicio = "";
            boolean posicioValida = false;

            System.out.println("Posicions disponibles:");
            for (String pos : Jugador.POSICIONS_POSSIBLES) {
                System.out.println(" * " + pos);
            }

            do {
                System.out.print("Introduiex la posició del jugador: ");
                posicio = sc.nextLine();
                posicioValida = false;
                for (String pos : Jugador.POSICIONS_POSSIBLES) {
                    if (pos.equalsIgnoreCase(posicio)) {
                        posicioValida = true;
                    }
                }
                if (!posicioValida) {
                    System.out.println("Posició no vàlida. Torna a provar.");
                }
            } while (!posicioValida);

            double qualitatJugador = Math.random() * 10;
            Jugador jugador1 = new Jugador(nomPersona, cognomPersona, dataNaixement, motivacio, souAnual, dorsal, posicio, qualitatJugador);

            mercatFitxatges.add(jugador1);
            System.out.println("Jugador donat d'alta correctament!");

        } else { //entrenador
            int tornejos = 0;
            boolean numValid = false;
            do {
                try {
                    System.out.print("Introdueix el número de tornejos guanyats: ");
                    tornejos = sc.nextInt();
                    sc.nextLine();
                    numValid = true;
                } catch (InputMismatchException e) {
                    System.out.println("Error. Introdueix un número vàlid.");
                }
            } while (!numValid);

            boolean esSeleccionadorNacional = false;
            System.out.print("És seleccionador nacional? (s/n) ");
            char resposta = getRespostaUsuari();

            if (resposta == 's') {
                esSeleccionadorNacional = true;
            }

            Entrenador entrenador1 = new Entrenador(nomPersona, cognomPersona, dataNaixement,
                    motivacio, souAnual, tornejos, esSeleccionadorNacional);
            mercatFitxatges.add(entrenador1);
            System.out.println("Entrenador donat d'alta correctament!");
        }
    }

    private static boolean comprobarExisteixEquip(ArrayList<Equip> equips, String nomEquipNou) {
        boolean existeix = false;
        int index = 0;

        while (!existeix & index < equips.size()) {
            if (equips.get(index).getNom().equalsIgnoreCase(nomEquipNou)){
                existeix = true;
            }
            index++;
        }

        return existeix;
    }

    public static int getOpcioPersona() {
        Scanner sc = new Scanner(System.in);
        int opcioPersona = -1;
        do {
            try {
                opcioPersona = sc.nextInt();
                if (opcioPersona < 1 || opcioPersona > 2) {
                    System.out.println("Opció no vàlida. Torna-ho a intentar.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Caràcter no vàlid. Només números.");
                sc.nextLine();
            }
        } while (opcioPersona < 1 || opcioPersona > 2);
        return opcioPersona;
    }

    public static int getOpcioAdmin () {
        Scanner sc = new Scanner(System.in);
        int opcio = -1;
        try {
            opcio = sc.nextInt();
            if (opcio < 0 || opcio > 8) {
                System.out.println("Opció no vàlida.");
            }
        }catch (InputMismatchException e) {
            System.out.println("Caràcter no vàlid. Només números.");
            sc.nextLine();
        }
        return opcio;
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
                mostrarGestionarEquip(equips, mercatFitxatges);
                break;
            case 3:
                consultarDadesEquip(equips);
                break;
            case 4:
                consultarDadesJugador(equips);
                break;
            case 5:
                transferirJugador(equips);
                break;
            case 6:
                desarDadesEquips(equips);
                break;
            case 0:
                System.out.println("Sortint del programa");
                break;
        }
    }

    /**
     * Mostra la classificació de la lliga
     *
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
    private static void mostrarGestionarEquip(ArrayList<Equip> equips, ArrayList<Persona> mercatFitxatges) {
        System.out.print("\nGESTIÓ D'EQUIPS");
        int opcioGestionarEquip;

        do {
            mostrarMenuGestionar();
            opcioGestionarEquip = getOpcioGestionarEquip();
            opcionsProgramaGestionarEquips(opcioGestionarEquip, equips, mercatFitxatges);
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

    private static void opcionsProgramaGestionarEquips(int opcioGestionarEquip, ArrayList<Equip> equips, ArrayList<Persona> mercatFitxatges) {
        switch (opcioGestionarEquip) {
            case 1:
                donarBaixaEquip(equips);
                break;
            case 2:
                modificarPresident(equips);
                break;
            case 3:
                destituirEntrenador(equips, mercatFitxatges);
                break;
            case 4:
                fitxarJugadorEntrenador(equips, mercatFitxatges);
                break;
            case 0:
                System.out.println("Sortint de Gestionar el meu equip, tornant al menú principal");
        }
    }

    private static void donarBaixaEquip(ArrayList<Equip> equips) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nDONAR DE BAIXA EQUIP\nNom de l'equip: ");
        String nomEquip = sc.nextLine();
        int posEquip = buscarPosicioEquip(equips, nomEquip);

        if (posEquip != -1) {
            System.out.print("Equip " + nomEquip + " trobat\nSegur/a que vols eliminar " + nomEquip + "? S/N ");
            char respostaUsuari = getRespostaUsuari();

            if (respostaUsuari == 's') {
                equips.remove(posEquip);
                System.out.println("Equip " + nomEquip + " eliminat");
            } else {
                System.out.println("Operació cancel·lada");
            }
        } else {
            System.out.println("Equip " + nomEquip + " no existeix");
        }
    }

    private static void modificarPresident(ArrayList<Equip> equips) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nMODIFICAR PRESIDENT\nIndica l'equip: ");
        String nomEquip = sc.nextLine();

        int posEquip = buscarPosicioEquip(equips, nomEquip);

        if (posEquip != -1) {
            System.out.println("Equip " + nomEquip + " trobat");
            System.out.print("Indica el nou president: ");
            String nouPresident = sc.nextLine();

            equips.get(posEquip).modificarPresident(nouPresident);
        } else {
            System.out.println("Equip no existeix");
        }
    }

    private static void destituirEntrenador(ArrayList<Equip> equips, ArrayList<Persona> mercatFitxatges) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nDESTITUIR ENTRENADOR\nIndica l'equip: ");
        String nomEquip = sc.nextLine();

        int posEquip = buscarPosicioEquip(equips, nomEquip);

        if (posEquip != -1) {
            Equip equip = equips.get(posEquip);
            System.out.println("Equip " + nomEquip + " trobat");

            if (equip.getEntrenador() == null) {
                System.out.println("Aquest equip no té cap entrenador assignat.");
            } else {
                String nomEntrenadorComplet = equip.getEntrenador().getNom() + " " + equip.getEntrenador().getCognom();
                System.out.print("Segur que vols destituir " + nomEntrenadorComplet + "? S/N ");
                char respostaUsuari = getRespostaUsuari();

                if (respostaUsuari == 's') {
                    Entrenador entrenadorDestituir = equip.getEntrenador();
                    equip.destituirEntrenador();
                    mercatFitxatges.add(entrenadorDestituir);
                } else {
                    System.out.println("Operació cancel·lada");
                }
            }
        } else {
            System.out.println("Equip " + nomEquip + " no existeix");
        }
    }

    private static void fitxarJugadorEntrenador(ArrayList<Equip> equips, ArrayList<Persona> mercatFitxatges) {
        System.out.println("FITXATGE JUGADOR/ENTRENADOR");
        System.out.print("Indica el tipus de fitxatge; jugador/a (1) o entrenador/a (2): ");
        int opcioUsuari = getOpcioUsuari();

        mostrarFitxatges(opcioUsuari, equips, mercatFitxatges);
    }

    private static void mostrarFitxatges(int opcioUsuari, ArrayList<Equip> equips, ArrayList<Persona> mercatFitxatges) {
        switch (opcioUsuari) {
            case 1:
                fitxarJugador(equips, mercatFitxatges);
                break;
            case 2:
                fitxarEntrenador(equips, mercatFitxatges);
        }
    }

    private static void fitxarJugador(ArrayList<Equip> equips, ArrayList<Persona> mercatFitxatges) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Jugador> jugadorsDisponibles = new ArrayList<>();
        for (Persona p : mercatFitxatges) {
            if (p instanceof Jugador) {
                jugadorsDisponibles.add((Jugador) p);
            }
        }

        System.out.println("\nFITXAR JUGADOR/A\nTens aquí tots els jugadors/es disponibles per fitxar:");
        System.out.println("----------");
        getJugadorsDisponibles(jugadorsDisponibles);
        System.out.println("----------");

        int opcioUsuari = getOpcioJugador(jugadorsDisponibles);
        System.out.print("Indica l'equip per fitxar: ");
        String nomEquip = sc.nextLine();

        int posEquip = buscarPosicioEquip(equips, nomEquip);

        if (posEquip != -1) {
            System.out.println("Equip " + nomEquip + " trobat");

            Jugador jugador = jugadorsDisponibles.get(opcioUsuari);
            Equip equip = equips.get(posEquip);
            equip.fitxarJugador(jugador);

            mercatFitxatges.remove(jugador);
        } else {
            System.out.println("Equip " + nomEquip + " no existeix");
        }
    }

    private static int getOpcioJugador(ArrayList<Jugador> jugadorsDisponibles) {
        Scanner sc = new Scanner(System.in);
        int opcioUsuari = -1;
        do {
            try {
                System.out.print("Indica el número del jugador a fitxar: ");
                opcioUsuari = sc.nextInt() - 1;
                sc.nextLine();
                if (opcioUsuari < 0 || opcioUsuari >= jugadorsDisponibles.size()) {
                    System.out.println("Número invàlid, introdueix entre 1 i " + jugadorsDisponibles.size());
                }
            } catch (InputMismatchException e) {
                System.out.println("Caràcter invàlid, només números");
                sc.nextLine();
            }
        } while (opcioUsuari < 0 || opcioUsuari >= jugadorsDisponibles.size());
        return opcioUsuari;
    }

    private static void getJugadorsDisponibles(ArrayList<Jugador> jugadorsDisponibles) {
        jugadorsDisponibles.sort(new ComparatorJugadorQualitat());
        System.out.println("Total de jugadors/es disponibles: " + jugadorsDisponibles.size());
        for (int i = 0; i < jugadorsDisponibles.size(); i++) {
            Jugador j = jugadorsDisponibles.get(i);
            System.out.println((i + 1) + ". " + j.getNom() + " " + j.getCognom() +
                    " | Qualitat: " + j.getQualitat() +
                    " | Motivació: " + j.getNivellMotivacio());
        }
    }

    private static void fitxarEntrenador(ArrayList<Equip> equips, ArrayList<Persona> mercatFitxatges) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Entrenador> entrenadorsDisponibles = new ArrayList<>();
        for (Persona p : mercatFitxatges) {
            if (p instanceof Entrenador) {
                entrenadorsDisponibles.add((Entrenador) p);
            }
        }

        System.out.println("\nFITXAR ENTRENADOR/A\nTens aquí tots els entrenadors/es disponibles per fitxar:");
        System.out.println("----------");
        getEntrenadorsDisponibles(entrenadorsDisponibles);
        System.out.println("----------");

        int opcioUsuari = getOpcioEntrenador(entrenadorsDisponibles);
        System.out.print("Indica l'equip per fitxar: ");
        String nomEquip = sc.nextLine();

        int posEquip = buscarPosicioEquip(equips, nomEquip);

        if (posEquip != -1) {
            System.out.println("Equip " + nomEquip + " trobat");

            Entrenador entrenador = entrenadorsDisponibles.get(opcioUsuari);
            Equip equip = equips.get(posEquip);
            equip.fitxarEntrenador(entrenador);

            mercatFitxatges.remove(entrenador);
        } else {
            System.out.println("Equip " + nomEquip + " no existeix");
        }
    }

    private static int getOpcioEntrenador(ArrayList<Entrenador> entrenadorsDisponibles) {
        Scanner sc = new Scanner(System.in);
        int opcioUsuari = -1;
        do {
            try {
                System.out.print("Indica el número de l'entrenador/a a fitxar: ");
                opcioUsuari = sc.nextInt() - 1;
                sc.nextLine();

                if (opcioUsuari < 0 || opcioUsuari >= entrenadorsDisponibles.size()) {
                    System.out.println("Número invàlid, introdueix entre 1 i " + entrenadorsDisponibles.size());
                }
            } catch (InputMismatchException e) {
                System.out.println("Caràcter invàlid, només números");
                sc.nextLine();
            }
        } while (opcioUsuari < 0 || opcioUsuari >= entrenadorsDisponibles.size());
        return opcioUsuari;
    }

    private static void getEntrenadorsDisponibles(ArrayList<Entrenador> entrenadorsDisponibles) {
        System.out.println("Total d'entrenadors/es disponibles: " + entrenadorsDisponibles.size());
        for (int i = 0; i < entrenadorsDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + entrenadorsDisponibles.get(i).getNom() + " " + entrenadorsDisponibles.get(i).getCognom());
        }
    }

    public static void consultarDadesEquip(ArrayList<Equip> equips) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nBUSCADOR EQUIP\nIntrodueix el nom de l'equip: ");
        String nomEquipTrobar = sc.nextLine();
        int pos = buscarPosicioEquip(equips, nomEquipTrobar);

        if (pos != -1) {
            Equip eq = equips.get(pos);
            System.out.println("\nEquip " + nomEquipTrobar + " trobat");
            System.out.println(eq.toString());
            eq.mostrarJugadors();
        } else {
            System.out.println("Equip " + nomEquipTrobar + " no existeix");
        }
    }

    public static int buscarPosicioEquip(ArrayList<Equip> equips, String nomEquipTrobar) {
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

    public static void consultarDadesJugador(ArrayList<Equip> equips) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nBUSCADOR JUGADOR/A\nPrimer introdueix l'equip del jugador/a ");
        String nomEquipTrobar = sc.nextLine();
        int posEquip = buscarPosicioEquip(equips, nomEquipTrobar);

        if (posEquip != -1) {
            System.out.print("Equip trobat, introdueix el nom del jugador/a: ");
            String nomJugadorTrobar = sc.nextLine();
            System.out.print("Introdueix el dorsal del jugador/a: ");
            int dorsalJugadorTrobar = sc.nextInt();

            Equip eq = equips.get(posEquip);
            int posJugador = buscarPosicioJugador(eq, nomJugadorTrobar, dorsalJugadorTrobar);

            if (posJugador != -1) {
                System.out.println("\nJugador " + nomJugadorTrobar + " trobat");
                System.out.println(eq.getJugadors().get(posJugador));
            } else {
                System.out.println("\nJugador " + nomJugadorTrobar + " no trobat");
            }
        } else {
            System.out.println("Equip " + nomEquipTrobar + " no existeix");
        }
    }

    public static int buscarPosicioJugador(Equip eq, String nomJugadorTrobar, int dorsalJugadorTrobar) {
        int i = 0, pos = -1;
        boolean trobat = false;

        while (!trobat && i < eq.getJugadors().size()) {
            Jugador j = eq.getJugadors().get(i);
            if (j.getNom().equalsIgnoreCase(nomJugadorTrobar) && j.getDorsal() == dorsalJugadorTrobar) {
                trobat = true;
                pos = i;
            }
            i++;
        }
        return pos;
    }

    private static void transferirJugador(ArrayList<Equip> equips) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nTRANSFERÈNCIA DE JUGADOR/A\nEquip original: ");
        String nomEquipOriginal = sc.nextLine();
        System.out.print("Equip destinació: ");
        String nomEquipDestinacio = sc.nextLine();

        int posEquipOriginal = buscarPosicioEquip(equips, nomEquipOriginal);
        int posEquipDesinacio = buscarPosicioEquip(equips, nomEquipDestinacio);

        if (posEquipOriginal != -1 && posEquipDesinacio != -1) {
            System.out.print("\nPerfecte, els 2 equips existeixen\nIntrodueix el nom del jugador/a: ");
            String nomJugadorTrobar = sc.nextLine();
            System.out.print("Introdueix el dorsal del jugador/a: ");
            int dorsalJugadorTrobar = sc.nextInt();

            Equip eqOriginal = equips.get(posEquipOriginal);
            Equip eqDestinacio = equips.get(posEquipDesinacio);

            int posJugador = buscarPosicioJugador(eqOriginal, nomJugadorTrobar, dorsalJugadorTrobar);

            if (posJugador != -1) {
                System.out.println("\nJugador " + nomJugadorTrobar + " trobat");
                System.out.print("Vols transferir " + nomJugadorTrobar + " (Equip original: " + eqOriginal.getNom() +
                        ") a l'equip " + eqDestinacio.getNom() + "? S/N ");

                char respostaUsuari = getRespostaUsuari();

                if (respostaUsuari == 's') {
                    Jugador jugador = eqOriginal.getJugadors().get(posJugador);

                    // Verificar que el dorsal no estigui ocupat a l'equip destí
                    int posJugadorDestinacio = buscarPosicioJugadorDorsal(eqDestinacio, jugador.getDorsal());

                    while (posJugadorDestinacio != -1) {
                        System.out.print("El dorsal " + jugador.getDorsal() + " ja està ocupat. Introdueix un nou dorsal: ");
                        int nouDorsal = sc.nextInt();
                        posJugadorDestinacio = buscarPosicioJugadorDorsal(eqDestinacio, nouDorsal);

                        if (posJugadorDestinacio == -1) {
                            jugador.setDorsal(nouDorsal);
                        }
                    }

                    eqOriginal.getJugadors().remove(posJugador);
                    eqDestinacio.getJugadors().add(jugador);
                    System.out.println("Jugador " + nomJugadorTrobar + " transferit correctament a " + eqDestinacio.getNom());
                } else {
                    System.out.println("Transferència cancel·lada");
                }
            }
        } else {
            System.out.println("No s'ha pogut trobar alguns dels equips indicats");
        }
    }

    public static char getRespostaUsuari() {
        Scanner sc = new Scanner(System.in);
        char respostaUsuari;

        do {
            respostaUsuari = sc.nextLine().toLowerCase().charAt(0);

            if (respostaUsuari != 's' && respostaUsuari != 'n') {
                System.out.println("Resposta invàlida, només y o n");
            }
        } while (respostaUsuari != 's' && respostaUsuari != 'n');

        return respostaUsuari;
    }

    public static int buscarPosicioJugadorDorsal(Equip eq, int dorsal) {
        int i = 0, pos = -1;
        boolean trobat = false;

        while (!trobat && i < eq.getJugadors().size()) {
            if (eq.getJugadors().get(i).getDorsal() == dorsal) {
                trobat = true;
                pos = i;
            }
            i++;
        }
        return pos;
    }

    public static void desarDadesEquips(ArrayList<Equip> equips) {
        String fileName = "src/fitxers/data_equips.txt";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, false))) {
            for (Equip e : equips) {
                String nomEstadi;
                if (e.getNomEstadi() != null) {
                    nomEstadi = e.getNomEstadi();
                } else {
                    nomEstadi = "null";
                }

                String nomPresident;
                if (e.getNomPresident() != null) {
                    nomPresident = e.getNomPresident();
                } else {
                    nomPresident = "null";
                }

                bw.write(e.getNom() + ";" + e.getCiutat() + ";" + e.getAnyFundacio() + ";" +
                        nomEstadi + ";" + nomPresident);
                bw.newLine();

                for (Jugador j : e.getJugadors()) {
                    bw.write("J;" +
                            j.getNom() + ";" + j.getCognom() + ";" + sdf.format(j.getDataNaixement()) + ";" + // ✅ sdf.format
                            j.getNivellMotivacio() + ";" + j.getSouAnual() + ";" +
                            j.getDorsal() + ";" + j.getPosicio() + ";" + j.getQualitat());
                    bw.newLine();
                }

                bw.write("---");
                bw.newLine();
            }
            System.out.println("Tots els equips s'han guardat correctament");
        } catch (IOException e) {
            System.out.println("Error en escriure al fitxer");
        }
    }
}
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------\n  Football Manager\n--------------------");
        carregarFitxatges();

        int opcioUser = getOpcioUsuari();
        switch (opcioUser) {
            case 1:
                mostrarMenuAdmin();
                break;
            case 2:
                menuGestor();
                break;
        }
    }

    public static void menuGestor() {
        System.out.println("Benvingut al Politècnics Football Manager, Gestor d'Equips.");
    }

    public static void mostrarMenuAdmin() {
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

    private static void carregarFitxatges() {}
}
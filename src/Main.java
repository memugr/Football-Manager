import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        preguntarUsuario();

        int opcio = sc.nextInt();

        if (opcio == 1) {
            do {
                mostrarMenu();
                switch (opcio) {
                    case 1:

                }

            } while (opcio != 0);
        }else if (opcio == 2) {

        }

    }

    private static void preguntarUsuario() {
        System.out.println("--------------------\n  Football Manager\n--------------------");
        System.out.println("Ets administrador(1) o gestor d'equips(2)?");
    }

    private static void mostrarMenu() {
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
                "\n9. Sortir.");
    }
}

import java.util.Scanner;

// Excepciones personalizadas
class CorreoInvalido extends Exception {
    public CorreoInvalido(String mensaje) {
        super(mensaje);
    }
}

class PasswordInvalida extends Exception {
    public PasswordInvalida(String mensaje) {
        super(mensaje);
    }
}

class EdadInvalida extends Exception {
    public EdadInvalida(String mensaje) {
        super(mensaje);
    }
}

public class ManejoExcepciones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nBienvenido Usuario, vamos a agregar una cuenta nueva, por favor, siga las instrucciones: \n");

        // ----------------------
        // Correo
        // ----------------------
        while (true) {
            try {
                System.out.print("Correo (debe contener @): ");
                String correo = scanner.nextLine();
                if (!correo.contains("@")) {
                    throw new CorreoInvalido("El correo debe contener un '@'");
                }
                System.out.println("Correo válido\n");
                break;
            } catch (CorreoInvalido error) {
                System.out.println(error.getMessage());
            }
        }
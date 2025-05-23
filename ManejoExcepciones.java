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

        // ----------------------
        // Password
        // ----------------------
        while (true) {
            try {
                System.out.print("Password (mínimo 8 caracteres, con mayúscula y número): ");
                String password = scanner.nextLine();
                if (password.length() < 8) {
                    throw new PasswordInvalida("La contraseña debe tener al menos 8 caracteres");
                }
                if (!password.chars().anyMatch(Character::isUpperCase)) {
                    throw new PasswordInvalida("La contraseña debe contener al menos una mayúscula");
                }
                if (!password.chars().anyMatch(Character::isDigit)) {
                    throw new PasswordInvalida("La contraseña debe contener al menos un número");
                }
                System.out.println("Contraseña válida\n");
                break;
            } catch (PasswordInvalida error) {
                System.out.println(error.getMessage());
            }
        }

        // ----------------------
        // Edad
        // ----------------------
        while (true) {
            try {
                System.out.print("Edad (número entre 1 y 119): ");
                String edadInput = scanner.nextLine();
                if (!edadInput.matches("\\d+")) {
                    throw new EdadInvalida("Ingrese un número válido");
                }
                int edad = Integer.parseInt(edadInput);
                if (edad <= 0 || edad >= 120) {
                    throw new EdadInvalida("La edad debe estar entre 1 y 119");
                }
                System.out.println("Edad válida, gracias Usuario");
                break;
            } catch (EdadInvalida error) {
                System.out.println(error.getMessage());
            }
        }

        scanner.close();
    }
}
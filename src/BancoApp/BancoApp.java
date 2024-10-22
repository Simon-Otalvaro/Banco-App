package BancoApp;
import java.util.Scanner;

public class BancoApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Solicitar datos para la primera cuenta
            System.out.print("Ingrese el nombre del titular de la cuenta 1: ");
            String titular1 = scanner.nextLine();
            System.out.print("Ingrese el saldo inicial de la cuenta 1: ");
            double saldo1 = scanner.nextDouble();
            Cuenta cuenta1 = new Cuenta(titular1, saldo1);

            // Solicitar datos para la segunda cuenta
            System.out.print("Ingrese el nombre del titular de la cuenta 2: ");
            scanner.nextLine();  // Limpiar el buffer del scanner
            String titular2 = scanner.nextLine();
            System.out.print("Ingrese el saldo inicial de la cuenta 2: ");
            double saldo2 = scanner.nextDouble();
            Cuenta cuenta2 = new Cuenta(titular2, saldo2);

            // Depósito
            System.out.print("Ingrese el monto a depositar en la cuenta 1: ");
            double montoDeposito = scanner.nextDouble();
            cuenta1.depositar(montoDeposito);

            // Retiro
            System.out.print("Ingrese el monto a retirar de la cuenta 2: ");
            double montoRetiro = scanner.nextDouble();
            cuenta2.retirar(montoRetiro);

            // Transferencia
            System.out.print("Ingrese el monto a transferir de la cuenta 1 a la cuenta 2: ");
            double montoTransferencia = scanner.nextDouble();
            cuenta1.transferir(cuenta2, montoTransferencia);

        } catch (SaldoInsuficiente | MontoValido e) {
            // Manejo de las excepciones
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close(); // Cerrar el scanner al final
        }
    }
}

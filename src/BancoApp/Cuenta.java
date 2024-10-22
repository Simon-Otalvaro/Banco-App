package BancoApp;

public class Cuenta {
    private String titular;
    private double saldo;

    public Cuenta(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void depositar(double monto) throws MontoValido {
        if (monto <= 0) {
            throw new MontoValido("El monto a depositar debe ser positivo.");
        }
        saldo += monto;
        System.out.println("Depósito exitoso. Saldo actual: $" + saldo);
    }

    public void retirar(double monto) throws SaldoInsuficiente, MontoValido {
        if (monto <= 0) {
            throw new MontoValido("El monto a retirar debe ser positivo.");
        }
        if (saldo < monto) {
            throw new SaldoInsuficiente("Saldo insuficiente para retirar $" + monto);
        }
        saldo -= monto;
        System.out.println("Retiro exitoso. Saldo actual: $" + saldo);
    }

    public void transferir(Cuenta destino, double monto) throws SaldoInsuficiente, MontoValido {
        if (monto <= 0) {
            throw new MontoValido("El monto a transferir debe ser positivo.");
        }
        this.retirar(monto); // Intenta retirar de la cuenta actual
        destino.depositar(monto); // Deposita en la cuenta de destino
        System.out.println("Transferencia exitosa de $" + monto + " a " + destino.getTitular());
    }
}

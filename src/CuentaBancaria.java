import java.util.Random;
import java.util.Scanner;

public class CuentaBancaria {

    //Clase Random para generar un numero de cuenta al azar
    Random numAzar = new Random();

    // Declaracion de atributos
    private String numeroCuenta;
    private String nombreTitular;
    private double saldo;


    // Constructores
    public CuentaBancaria() {
        this.saldo = 0.0;
    }
    public CuentaBancaria(String numeroCuenta, String nombreTitular) {
        this.numeroCuenta = numeroCuenta;
        this.nombreTitular = nombreTitular;
        this.saldo = 0.0;
    }

    public CuentaBancaria(String numeroCuenta, String nombreTitular, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.nombreTitular = nombreTitular;
        this.saldo = saldo; 
    }

    // getter
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    // Metodo de recibir monto y sumar al saldo
    public double depositar(Scanner entrada) {
        System.out.print("Ingrese el monto a depositar: ");
        var monto = Double.parseDouble(entrada.nextLine());
        if (monto < 0) {
            System.out.println("El monto debe ser positivo");
        } else {
            saldo += monto;
        }
        return saldo;
    }

    // Metodo de restar al saldo
    public double retirar(Scanner entrada) {
        System.out.println("Ingrese el monto a retirar: ");
        var monto = Double.parseDouble(entrada.nextLine());
        if (monto < 0) {
            System.out.println("El monto debe ser positivo");
        } else if (monto > saldo) {
            System.out.println("El saldo es inferior al monto solicitado");
        } else {
            saldo -= monto;
        }
        return saldo;
    }

    // Metodo que muestra toda la informacion de la cuenta
    public void mostrarInformacion() {
        System.out.printf("""
                Información de la cuenta bancaria
                Numero de cuenta: %s
                Titular: %s
                Saldo: %,.2f
                """, numeroCuenta, nombreTitular, saldo);
    }

    //Metodo para crear cuenta bancaria
    public void crearCuenta(Scanner entrada) {
        System.out.println();
        System.out.print("""
                --- Creando cuenta ---
                Ingrese nombre del titular: """);
        nombreTitular = entrada.nextLine();
        numeroCuenta = String.format("%08d",numAzar.nextInt(100_000_000));
        System.out.printf("""
                Cuenta creada exitosamente
                Titular: %s
                Numero de cuenta: %s
                """, nombreTitular, numeroCuenta);
    }

}

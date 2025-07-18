import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        CuentaBancaria cuenta = null;
        var salir = false;

        //ciclo do-while
        do{
        System.out.print("""
                *** Bienvenido a su Banco ***
                Menu
                \t1. Crear cuenta bancaria
                \t2. Depositar dinero
                \t3. Retirar dinero
                \t4. Consultar saldo
                \t0. Salir
                Selecciona una opcion: """);
            var opcion = Integer.parseInt(entrada.nextLine());

            //Ciclo switch con el argumento de la opción proporcionada por el usuario
            switch (opcion) {
                case 1:
                    cuenta = new CuentaBancaria("", "");
                    cuenta.crearCuenta(entrada);
                    break;
                case 2:
                    if (cuenta != null) {
                       cuenta.depositar(entrada); 
                    } else {
                        System.out.println("Primero debe crear una cuenta.");
                    }
                    break;
                case 3:
                    if (cuenta != null) {
                       cuenta.retirar(entrada); 
                    } else {
                        System.out.println("Primero debe crear una cuenta.");
                    }
                    break;
                case 4:
                    if (cuenta != null) {
                       cuenta.mostrarInformacion(); 
                    } else {
                        System.out.println("Primero debe crear una cuenta.");
                    }
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }

        System.out.println("Presione ENTER para continuar");
        entrada.nextLine();
        System.out.println();


        } while(!salir);   

        //Mensaje final y cierra el escanner
        System.out.println("""
                Saliendo de la cuenta...
                Hasta pronto.
                """);
        entrada.close();
 
    }

}

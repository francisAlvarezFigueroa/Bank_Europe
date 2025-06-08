package cl.duoc.bankeurope;
import cl.duoc.bankeurope.modelos.Banco;
import static cl.duoc.bankeurope.utilidades.ConsolaUtil.*;
import static cl.duoc.bankeurope.utilidades.GestorEntradaSalida.*; // importa todos los métodos estáticos
import static cl.duoc.bankeurope.constantes.Constantes.*;

public class Main {
    public static void main(String[] args) {

        // CREAR BANCO________________________________________________________________________________
        Banco bancoEurope = new Banco();
        System.out.println("Nombre banco: " + bancoEurope.getNombre()); // verificar creación objeto banco
        System.out.println("Cantidad empleados: " + bancoEurope.getCantidadEmpleados());

        // BIENVENIDA AL SISTEMA
        System.out.println("    BIENVENIDO AL SISTEMA DE GESTIÓN DE CUENTAS DEL BANK EUROPE 🏦📚    ");

        // MENU PRINCIPAL_____________________________________________________________________________
        mostrarEncabezado(MENU_PRINCIPAL);
        int opcMenuPrincipal=0;
        do {
            mostrarMenuPrincipal();
            opcMenuPrincipal=obtenerNumeroScanner("Ingrese el número de la acción que desea realizar: (1-7) ", 1,7);
            clearConsole(); // deja espacio para que se vea el mensaje
            if(!LISTA_OPCIONES.contains(opcMenuPrincipal)){
                System.out.println("Opción ingresada no es válida. Intente nuevamente.");
            }else{

            }
        }while(opcMenuPrincipal!=7 || (opcMenuPrincipal<1 || opcMenuPrincipal>7));

    }

    // MOSTRAR METODOS A USAR EN MENU

    private static void mostrarMenuPrincipal (){
        System.out.println("|            1. REGISTRAR CLIENTE                                                         |");
        System.out.println("|            2. VER DATOS CLIENTE                                                         |");
        System.out.println("|            3. VER DATOS CUENTA                                                          |");
        System.out.println("|            4. DEPOSITAR                                                                 |");
        System.out.println("|            5. GIRAR                                                                     |");
        System.out.println("|            6. CONSULTAR SALDO                                                           |");
        System.out.println("|            7. SALIR                                                                     |");
        System.out.println("|_________________________________________________________________________________________|");
    }

    private static void aplicarTransacciones (int opcMenuPrincipal, Banco bankEurope){
        switch (opcMenuPrincipal){
            case 1: // REGISTRAR CLIENTE_____________________________________________________________
                break;
            case 2: // VER DATOS CLIENTE_____________________________________________________________
                break;
            case 3: // VER DATOS CUENTA______________________________________________________________
                break;
            case 4: // DEPOSITAR_____________________________________________________________________
                break;
            case 5: // GIRAR_________________________________________________________________________
                break;
            case 6: // CONSULTAR SALDO_______________________________________________________________
                break;
            case 7: // SALIR_________________________________________________________________________
                System.out.println("Saliendo del sistema. Gracias por visitar " + bankEurope.getNombre());
                break;
        }
    }

}
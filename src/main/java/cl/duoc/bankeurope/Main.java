package cl.duoc.bankeurope;
import cl.duoc.bankeurope.controladores.ControladorBanco;
import cl.duoc.bankeurope.modelos.Banco;
import cl.duoc.bankeurope.modelos.clientes.Cliente;
import cl.duoc.bankeurope.servicios.ServiciosBanco;
import cl.duoc.bankeurope.servicios.ServiciosCliente;
import cl.duoc.bankeurope.servicios.ServiciosCuenta;
import static cl.duoc.bankeurope.utilidades.ConsolaUtil.*;
import static cl.duoc.bankeurope.utilidades.GestorEntradaSalida.*; // importa todos los métodos estáticos
import static cl.duoc.bankeurope.constantes.Constantes.*;

public class Main {
    public static void main(String[] args) {

        // INSTANCIAS DE SERVICIOS_________________________________________________________________________________________
        // profe, esto vi que se podia hacer asi que decidi tratar a ver si funciona, quizá hay una manera mejor

        Banco bancoEurope = new Banco();
        ServiciosBanco serviciosBanco = new ServiciosBanco(bancoEurope);
        ServiciosCliente serviciosCliente = new ServiciosCliente(serviciosBanco);
        ServiciosCuenta serviciosCuenta = new ServiciosCuenta(serviciosBanco, bancoEurope);
        ControladorBanco controladorBanco= new ControladorBanco(serviciosBanco);
        //________________________________________________________________________________________________________________


        // BIENVENIDA AL SISTEMA
        // _____________________________________________________________________________________________________________
        System.out.println("    BIENVENIDO AL SISTEMA DE GESTIÓN DE CUENTAS DE: " + bancoEurope.getNombre()  + "🏦📚    ");

        // MENU PRINCIPAL
        // _____________________________________________________________________________________________________________

        int opcMenuPrincipal=0;
        do {
            mostrarMenuPrincipal();

            opcMenuPrincipal=obtenerNumeroScanner("Ingrese el número de la acción que desea realizar: (1-7) ", 1,7);

            clearConsole(); // deja espacio para que se vea el mensaje

            if(!LISTA_OPCIONES.contains(opcMenuPrincipal)){
                System.out.println("Opción ingresada no es válida. Intente nuevamente.");

            }else{
                aplicarTransacciones(opcMenuPrincipal,bancoEurope, serviciosBanco,serviciosCuenta,serviciosCliente,controladorBanco);
            }
        }while(opcMenuPrincipal!=7);
    }


    private static void mostrarMenuPrincipal (){
        mostrarEncabezado(MENU_PRINCIPAL);
        System.out.println("|            1. REGISTRAR CLIENTE                                                         |");
        System.out.println("|            2. VER DATOS CLIENTE                                                         |");
        System.out.println("|            3. VER DATOS CUENTA                                                          |");
        System.out.println("|            4. DEPOSITAR                                                                 |");
        System.out.println("|            5. GIRAR                                                                     |");
        System.out.println("|            6. CONSULTAR SALDO                                                           |");
        System.out.println("|            7. SALIR                                                                     |");
        System.out.println("|_________________________________________________________________________________________|");
    }

    private static void aplicarTransacciones (int opcMenuPrincipal, Banco bankEurope, ServiciosBanco serviciosBanco, ServiciosCuenta serviciosCuenta, ServiciosCliente serviciosCliente, ControladorBanco controladorBanco){

        switch (opcMenuPrincipal){
            case 1: // REGISTRAR CLIENTE_____________________________________________________________
                mostrarEncabezado(MENU_REGISTRAR_CLIENTE);
                Cliente cliente =  controladorBanco.registrarClienteDesdeConsola();
                serviciosBanco.registrarCliente(cliente);
                clearConsole();
                break;
            case 2: // VER DATOS CLIENTE_____________________________________________________________
                mostrarEncabezado(MENU_DATOS_CLIENTE);
                controladorBanco.verDatosCliente(bankEurope);
                clearConsole();
                break;
            case 3: // VER DATOS CUENTA______________________________________________________________
                mostrarEncabezado(MENU_DATOS_CUENTA);
                controladorBanco.verDatosCuenta(bankEurope);
                clearConsole();
                break;
            case 4: // DEPOSITAR_____________________________________________________________________
                mostrarEncabezado(MENU_DEPOSITAR);
                controladorBanco.depositar(bankEurope,serviciosCuenta);
                clearConsole();
                break;
            case 5: // GIRAR_________________________________________________________________________
                mostrarEncabezado(MENU_GIRAR);
                controladorBanco.girar(bankEurope, serviciosCuenta);
                clearConsole();
                break;
            case 6: // CONSULTAR SALDO_______________________________________________________________
                mostrarEncabezado(MENU_CONSULTAR_SALDO);
                controladorBanco.consultarSaldo(bankEurope);
                clearConsole();
                break;
            case 7: // SALIR_________________________________________________________________________
                System.out.println("Saliendo del sistema...");
                mostrarMensajeDespedida(NOMBRE_BANCO);
                break;
        }
    }


}
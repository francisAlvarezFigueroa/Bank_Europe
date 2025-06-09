package cl.duoc.bankeurope.utilidades;


public class ConsolaUtil {


    public static void mostrarEncabezado (String tipoMenu){
        System.out.println("___________________________________________________________________________________________");
        System.out.println("                                 📖 MENÚ: " + tipoMenu );
        System.out.println("___________________________________________________________________________________________");
    }
    public static void mostrarMensajeDespedida(String nombre){
        System.out.println("___________________________________________________________________________________________");
        System.out.println("                    📘 GRACIAS POR VISITAR EL SISTEMA DE GESTIÓN DE + " + nombre);
        System.out.println("___________________________________________________________________________________________");
    }

    public static void mostrarMensajeRegistroClienteExitoso (String rutCliente){
        System.out.println("_________________________________________________________________________________________");
        System.out.println("    El cliente rut: " + rutCliente + " ha sido registrado existosamente ✅");
        System.out.println("_________________________________________________________________________________________");
    }

    public static void clearConsole() {
        int cantidadLineas = 3;
        for (int i = 0; i <= cantidadLineas; i++) {
            System.out.println();
        }
        System.out.println("_________________________________________________________________________________________");

    }

}

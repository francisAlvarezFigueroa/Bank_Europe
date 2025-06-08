package cl.duoc.bankeurope.utilidades;
import java.util.Scanner;

import static cl.duoc.bankeurope.utilidades.ValidadorUtil.*;

/** La clase GestorEntradaSalida gestiona los mensajes al usuario desde la consola
 * y recoge la información que provee el usuario. Los métodos empleados aquí son estáticos
 * ya que quiero usarlos sin instanciar la clase, quiero que estén disponibles independiente de su clase.
  */


public class GestorEntradaSalida {
    private static Scanner scanner = new Scanner(System.in);

    // METODO PARA OBETENER TEXTO DE SCANNER___________________________________________________________

    /** El método obtenerTextoScanner:
     * recibe mensaje, muestra mensaje y valída el imput del usuario ya que debe seguir preguntando
     * si el usuario no escribe un campo requerido
     */
    public static String obtenerTextoScanner (String mensajeParaUsuario){
        String lineaLeida= "";
        do {
            System.out.println(mensajeParaUsuario); // muestra el mensaje al usuario
            lineaLeida = scanner.nextLine().trim(); // lee la línea y corta espacios blancos
            return lineaLeida;
        }while(isFieldBlank(lineaLeida));
    }

    public static int obtenerNumeroScanner (String mensajeParaUsuario, int startRange, int endRange){
        Scanner scan= new Scanner(System.in);
        int numeroLeido=0;
        boolean opcValida =false;

        do {
            System.out.println(mensajeParaUsuario); // muestra el mensaje al usuario

            try{
                numeroLeido= Integer.parseInt(scan.nextLine()); // lee linea y convierte a int
                opcValida = isNumberValid(numeroLeido,startRange,endRange);
            }catch (NumberFormatException e){
                System.out.println("Dato ingresado no válido. Intente nuevamente.");
                opcValida=false;
            }
        }while(!opcValida);
        return numeroLeido;
    }

    public static void clearConsole() {
        int cantidadLineas = 3;
        for (int i = 0; i <= cantidadLineas; i++) {
            System.out.println();
        }
        System.out.println("_________________________________________________________________________________________");

    }


}

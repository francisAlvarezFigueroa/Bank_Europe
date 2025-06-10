package cl.duoc.bankeurope.utilidades;
import java.util.InputMismatchException;
import java.util.Scanner;

import static cl.duoc.bankeurope.utilidades.ValidadorUtil.*;



public class GestorEntradaSalida {
    private static Scanner scanner = new Scanner(System.in);

    // METODO PARA OBETENER TEXTO DE SCANNER___________________________________________________________


    public static String obtenerTextoScanner(String mensajeParaUsuario){
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

    public static long obtenerNumeroCuentaEntrada(String mensaje) {
        Long numeroCuenta = null;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print(mensaje);
            try {
                numeroCuenta = scanner.nextLong();
                scanner.nextLine(); // Limpiar el buffer: consume el resto de la línea, incluyendo el '\n'
                int longitud = String.valueOf(Math.abs(numeroCuenta)).length();
                if (longitud==9) {
                    entradaValida = true; // Si llegamos aquí, la entrada es válida
                }
            } catch (InputMismatchException e) {
                // Captura si el usuario no introduce un entero
                System.out.println("Entrada inválida. Por favor, introduzca un número válido.");
                scanner.nextLine(); // Importante: Limpiar el buffer de la entrada incorrecta para evitar un bucle infinito
            } catch (Exception e) {
                // Captura cualquier otra excepción inesperada
                System.out.println("Ocurrió un error inesperado al leer la entrada: " + e.getMessage());
                scanner.nextLine(); // Limpiar el buffer por si acaso
            }
        }
        return numeroCuenta;
    }

    public static long obtenerMontoEntrada(String mensaje) {
        Long monto = null;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print(mensaje);
            try {
                monto = scanner.nextLong();
                scanner.nextLine(); // Limpiar el buffer: consume el resto de la línea, incluyendo el '\n'
                if (monto > 0) {
                    entradaValida = true; // Si llegamos aquí, la entrada es válida
                } else {
                    System.out.println("Entrada inválida. Por favor, introduzca un monto válido.");
                }
            } catch (InputMismatchException e) {
                // Captura si el usuario no introduce un entero
                System.out.println("Entrada inválida. Por favor, introduzca un monto válido.");
                scanner.nextLine(); // Importante: Limpiar el buffer de la entrada incorrecta para evitar un bucle infinito
            } catch (Exception e) {
                // Captura cualquier otra excepción inesperada
                System.out.println("Ocurrió un error inesperado al leer la entrada: " + e.getMessage());
                scanner.nextLine(); // Limpiar el buffer por si acaso
            }
        }
        return monto;
    }
    public static String obtenerRutDeEntrada(String mensaje) {
        String rut = "";
        do {
            rut = obtenerTextoScanner(mensaje);
            if (!validarFormatoRut(rut)) {
                System.out.println("Formato incorrecto. Ejemplo válido: 1.123.456-7");
            }
        } while (!validarFormatoRut(rut));
        return rut;
    }

    public static boolean validarFormatoRut(String rut) {
        return rut.matches("^\\d{1,2}\\.\\d{3}\\.\\d{3}-[\\dkK]$");
    }

    public static String obtenerTextoDeEntrada(String mensaje) {
        String texto = "";
        do {
            texto = obtenerTextoScanner(mensaje);
        } while (isFieldBlank(texto));
        return texto;
    }


    public static boolean isFieldBlank(String field) {
        if (field.isBlank()) {
            System.out.println("Campo requerido, por favor ingrese valor.");
            return true;
        }
        return false;
    }




}

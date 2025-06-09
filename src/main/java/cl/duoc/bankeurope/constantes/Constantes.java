package cl.duoc.bankeurope.constantes;

import java.util.Arrays;
import java.util.List;

/** esta clase almacena todos los valores de opc y menu que son constantes y finales en el código
 *
 */
public class Constantes {
    public static final String NOMBRE_BANCO = "BANK EUROPE";
    public static final long CANTIDAD_EMPLEADOS = 20000;


    public static final int OPCION_REGISTRAR_CLIENTE = 1;
    public static final int OPCION_VER_DATOS_CLIENTE = 2;
    public static final int OPCION_VER_DATOS_CUENTA =3;
    public static final int OPCION_DEPOSITAR_CUENTA = 4;
    public static final int OPCION_GIRAR_CUENTA = 5;
    public static final int OPCION_CONSULTAR_SALDO = 6;
    public static final int OPCION_SALIR = 7;


    public static final String OPCION_TEST = "T";


    public static final String OPCION_CUENTA_CORRIENTE = "CORRIENTE";
    public static final String OPCION_CUENTA_AHORRO = "AHORRO";
    public static final String OPCION_CUENTA_DIGITAL = "DIGITAL";


    public static final String MENU_PRINCIPAL= "PRINCIPAL";
    public static final String MENU_REGISTRAR_CLIENTE= "REGISTRAR CLIENTE";
    public static final String MENU_DATOS_CLIENTE= "DATOS CLIENTE";
    public static final String MENU_DATOS_CUENTA= "DATOS CUENTA";
    public static final String MENU_DEPOSITAR= "DEPOSITAR";
    public static final String MENU_GIRAR= "GIRAR";
    public static final String MENU_CONSULTAR_SALDO= "CONSULTAR SALDO";

    public static final String TIPO_MONEDA_CHILE = " CLP ";  // TIPO DE MONEDA SEGÚN CORRESPONDA

    public static final List<Integer> LISTA_OPCIONES = Arrays.asList(OPCION_REGISTRAR_CLIENTE, OPCION_VER_DATOS_CLIENTE, OPCION_VER_DATOS_CUENTA, OPCION_DEPOSITAR_CUENTA, OPCION_GIRAR_CUENTA, OPCION_CONSULTAR_SALDO, OPCION_SALIR);

}

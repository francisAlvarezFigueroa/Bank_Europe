package cl.duoc.bankeurope.servicios;
import cl.duoc.bankeurope.modelos.cuentas.CuentaAhorros;
import cl.duoc.bankeurope.modelos.cuentas.CuentaBancaria;
import cl.duoc.bankeurope.modelos.cuentas.CuentaCorriente;
import cl.duoc.bankeurope.modelos.cuentas.CuentaDigital;

import static cl.duoc.bankeurope.constantes.Constantes.*;

public class CuentaService {

    // STATIC METHODS___________________________________________________________________________________________________

    public static CuentaBancaria crearCuentaNueva (String tipoCuenta, long numeroCuenta){
        switch (tipoCuenta){
            case OPCION_CUENTA_CORRIENTE:
                return new CuentaCorriente(numeroCuenta);
            case OPCION_CUENTA_AHORRO:
                return new CuentaAhorros(numeroCuenta,7);
            case OPCION_CUENTA_DIGITAL:
                return new CuentaDigital(numeroCuenta);
        }
    return null;
        //todo: manejar este null (preguntar profe)
    }

}

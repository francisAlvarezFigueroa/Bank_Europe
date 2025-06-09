package cl.duoc.bankeurope.servicios;
import cl.duoc.bankeurope.modelos.cuentas.tipos.CuentaAhorros;
import cl.duoc.bankeurope.modelos.cuentas.base.CuentaBancaria;
import cl.duoc.bankeurope.modelos.cuentas.tipos.CuentaCorriente;
import cl.duoc.bankeurope.modelos.cuentas.tipos.CuentaDigital;

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

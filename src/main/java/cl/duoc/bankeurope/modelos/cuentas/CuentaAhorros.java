package cl.duoc.bankeurope.modelos.cuentas;
import cl.duoc.bankeurope.interfaces.InfoCliente;

import static cl.duoc.bankeurope.constantes.Constantes.OPCION_CUENTA_AHORRO;
import static cl.duoc.bankeurope.constantes.Constantes.OPCION_CUENTA_CORRIENTE;

public class CuentaAhorros extends CuentaBancaria implements InfoCliente {

    protected int cantidadGirosPermitidos;

    // OVERLOADED CONSTRUCTORS _______________________________________________________________________
    public CuentaAhorros(long saldo, long numeroCuenta, float porcentajeInteres, int cantidadGirosPermitidos) {
        super(saldo, numeroCuenta, porcentajeInteres);
        this.cantidadGirosPermitidos = cantidadGirosPermitidos;
    }

    public CuentaAhorros(long saldo, long numeroCuenta, int cantidadGirosPermitidos) {
        super(saldo, numeroCuenta);
        this.cantidadGirosPermitidos = cantidadGirosPermitidos;
    }

    public CuentaAhorros(long numeroCuenta, int cantidadGirosPermitidos) {
        super(numeroCuenta);
        this.cantidadGirosPermitidos = cantidadGirosPermitidos;
    }

    public CuentaAhorros(long numeroCuenta, long saldo){
        super(saldo, numeroCuenta);
        cantidadGirosPermitidos=7;
    }

    // GETTERS AND SETTERS ___________________________________________________________________________

    public int getCantidadGirosPermitidos() {
        return cantidadGirosPermitidos;
    }

    public void setCantidadGirosPermitidos(int cantidadGirosPermitidos) {
        this.cantidadGirosPermitidos = cantidadGirosPermitidos;
    }

    //METHODS ________________________________________________________________________________________
    @Override
    public double calcularInteres() {
        setPorcentajeInteres(0.006f);
        double interesAnual = saldo * getPorcentajeInteres();
        return interesAnual;
    }

    @Override
    public void mostrarInformacionCliente() {
        System.out.println("Tipo de cuenta              : " + OPCION_CUENTA_AHORRO);
        System.out.println("Número de cuenta            : " + getNumeroCuenta());
        System.out.println("Saldo                       : " + getSaldo());
        System.out.println("Cantidad giros permitidos   : " + getCantidadGirosPermitidos());
    }
}

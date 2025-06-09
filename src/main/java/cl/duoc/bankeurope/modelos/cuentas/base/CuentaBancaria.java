package cl.duoc.bankeurope.modelos.cuentas.base;
import cl.duoc.bankeurope.interfaces.InfoCuenta;

import static cl.duoc.bankeurope.constantes.Constantes.*;
public  abstract class CuentaBancaria implements InfoCuenta {

    // todo: crear metodo abstracto para mostrar saldo
    //todo: revisar como calcular interes mirando ejemplo cuenta ahorro bankBoston

    protected long saldo;
    protected long numeroCuenta;
    protected float porcentajeInteres;


    // OVERLOADED CONSTRUCTORS_________________________________________________________________________

    public CuentaBancaria(long saldo, long numeroCuenta, float porcentajeInteres) {
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
        this.porcentajeInteres = porcentajeInteres;
    }

    public CuentaBancaria(long saldo, long numeroCuenta) {
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public CuentaBancaria (long numeroCuenta){
        this.numeroCuenta=numeroCuenta;
        saldo=0L;
    }

    // GETTERS AND SETTERS _____________________________________________________________________________

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta (long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public float getPorcentajeInteres() {
        return porcentajeInteres;
    }

    public void setPorcentajeInteres(float porcentajeInteres) {
        this.porcentajeInteres = porcentajeInteres;
    }

    // METHODS_________________________________________________________________________________________

    public abstract double calcularInteres ();  // solo declaracion, obliga implementacion en subclases
    public abstract void depositarMonto(long monto);
    public abstract void girarMonto(long monto);

    @Override
    public void mostrarInformacionCuenta() {

    }

    /* public void mostrarSaldo(long numeroCuenta){
        if (verificarCuentaExiste(numeroCuenta)) {
            System.out.println("Saldo actual: $" + cuentas.get(numeroCuenta).getSaldo() + TIPO_MONEDA_CHILE);
        } else {
            System.out.println("No se ha encontrado cuenta con ese número.");
        }
    }

    */

}

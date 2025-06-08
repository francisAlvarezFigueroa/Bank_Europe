package cl.duoc.bankeurope.modelos.cuentas;
import static cl.duoc.bankeurope.constantes.Constantes.*;
import cl.duoc.bankeurope.interfaces.InfoCliente;

public class CuentaCorriente extends CuentaBancaria implements InfoCliente {

    protected long limiteSobregiro;  // todas las cuentas corrientes inician con 200.000 de sobregiro
    protected long sobregiroActual;


    // CONSTRUCTORES_________________________________________________________________________________

    public CuentaCorriente(long saldo, long numeroCuenta, float porcentajeInteres, long limiteSobregiro, long sobregiroActual) {
        super(saldo, numeroCuenta, porcentajeInteres);
        this.limiteSobregiro = limiteSobregiro;
        this.sobregiroActual = sobregiroActual;
    }

    public CuentaCorriente(long saldo, long numeroCuenta) {
        super(saldo, numeroCuenta);
        limiteSobregiro= 200000L;
        sobregiroActual=0L; // todas las cuentas inician con 0 de sobregiro
    }

    public CuentaCorriente(long numeroCuenta) {
        super(numeroCuenta);
        limiteSobregiro=200000L;
        sobregiroActual=0L;
    }

    // GETTERS AND SETTERS___________________________________________________________________________

    public long getLimiteSobregiro() {
        return limiteSobregiro;
    }

    public void setLimiteSobregiro(long limiteSobregiro) {
        limiteSobregiro = limiteSobregiro;
    }

    public long getSobregiroActual() {
        return sobregiroActual;
    }

    public void setSobregiroActual(long sobregiroActual) {
        this.sobregiroActual = sobregiroActual;
    }


    // METHODS_______________________________________________________________________________________
    @Override
    public void mostrarInformacionCliente() {
        System.out.println("Tipo de cuenta      : " + OPCION_CUENTA_CORRIENTE);
        System.out.println("Número de cuenta    : " + getNumeroCuenta());
        System.out.println("Saldo               : " + getSaldo());
        System.out.println("Sobregiro inicial   : " + getLimiteSobregiro());
        System.out.println("Sobregiro Actual    : " + getSobregiroActual());
    }

    @Override
    public double calcularInteres() {
        setPorcentajeInteres(0.002f);
        double interesAnual = saldo * getPorcentajeInteres();
        return interesAnual;
    }
}
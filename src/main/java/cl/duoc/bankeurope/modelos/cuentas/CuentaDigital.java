package cl.duoc.bankeurope.modelos.cuentas;
import cl.duoc.bankeurope.interfaces.InfoCuenta;
import static cl.duoc.bankeurope.constantes.Constantes.OPCION_CUENTA_DIGITAL;

public class CuentaDigital extends CuentaBancaria implements InfoCuenta {

    protected long limiteMontoDiario;

    //OVERLOADED CONSTRUCTORS________________________________________________________________________
    public CuentaDigital(long saldo, long numerocuenta, long limiteMontoDiario){
        super(saldo,numerocuenta);
        this.limiteMontoDiario= limiteMontoDiario;
    }
    public CuentaDigital(long saldo, long numeroCuenta) {
        super(saldo, numeroCuenta);
        limiteMontoDiario = 200000L;
    }

    public CuentaDigital(long numeroCuenta) {
        super(numeroCuenta);
        limiteMontoDiario = 200000L;
    }

    //GETTERS AND SETTERS____________________________________________________________________________

    public long getLimiteMontoDiario() {
        return limiteMontoDiario;
    }

    public void setLimiteMontoDiario(long limiteMontoDiario) {
        this.limiteMontoDiario = limiteMontoDiario;
    }

    //METHODS _______________________________________________________________________________________
    @Override
    public void mostrarInformacionCuenta() {
        System.out.println("Tipo de cuenta      : " + OPCION_CUENTA_DIGITAL);
        System.out.println("Número de cuenta    : " + getNumeroCuenta());
        System.out.println("Saldo               : $" + getSaldo());
        System.out.println("Limite monto diario : $" + getLimiteMontoDiario());
    }

    @Override
    public double calcularInteres() {
        setPorcentajeInteres(0.004f);
        double interesAnual = saldo * getPorcentajeInteres();
        return interesAnual;
    }
}

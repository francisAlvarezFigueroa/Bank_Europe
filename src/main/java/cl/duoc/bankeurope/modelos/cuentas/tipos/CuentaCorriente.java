package cl.duoc.bankeurope.modelos.cuentas.tipos;
import static cl.duoc.bankeurope.constantes.Constantes.*;
import cl.duoc.bankeurope.interfaces.InfoCuenta;
import cl.duoc.bankeurope.modelos.cuentas.base.CuentaBancaria;

public class CuentaCorriente extends CuentaBancaria {

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
    public void mostrarInformacionCuenta() {
        System.out.println("Tipo de cuenta      : " + OPCION_CUENTA_CORRIENTE);
        System.out.println("Número de cuenta    : " + getNumeroCuenta());
        System.out.println("Saldo               : $" + getSaldo());
        System.out.println("Sobregiro inicial   : $" + getLimiteSobregiro());
        System.out.println("Sobregiro Actual    : $" + getSobregiroActual());
    }

    @Override
    public double calcularInteres() {
        setPorcentajeInteres(0.002f);
        double interesAnual = saldo * getPorcentajeInteres();
        return interesAnual;
    }

    @Override
    public void depositarMonto(long monto) {
        if(monto<=0){
            System.out.println("El monto a depositar debe ser mayor a $0" +  TIPO_MONEDA_CHILE);
            return;
        }

        if (sobregiroActual > 0) {
            // si hay sobregiro primero se debe saldar ese monto
            if (monto >= sobregiroActual) {
                long remanente = monto - sobregiroActual;  // almacena lo que queda si el monto cubre el sobregiro
                setSobregiroActual(0L); // dejar el sobregiro en 0
                setSaldo(getSaldo() + remanente); // aumenta el saldo en lo que quedó
                System.out.println("Sobregiro pagado completamente ✅");
                System.out.println("Nuevo saldo: $" + getSaldo() + TIPO_MONEDA_CHILE);
            } else { // en caso que el monto sea menor al sobregiro
                setSobregiroActual(sobregiroActual - monto);
                System.out.println("Se han pagado $" + monto + TIPO_MONEDA_CHILE + "de su sobregiro.");
                System.out.println("Sobregiro utilizado: $" + getSobregiroActual() + TIPO_MONEDA_CHILE); // el sobregiro que aun queda por pagar
            }
        }else{ // si no hay sobregiro solo aumenta el saldo
            setSaldo(getSaldo() + monto);
            System.out.println("Depósito realizado con éxito ✅");
            System.out.println("Saldo actual: $" + getSaldo() + TIPO_MONEDA_CHILE);
        }
    }

    @Override
    public void girarMonto(long monto) {
        long saldoActual = getSaldo();
        // Calcular el total disponible incluyendo el límite de sobregiro restante
        long disponibleTotal = saldoActual + (limiteSobregiro - sobregiroActual);

        if (monto > disponibleTotal) {
            System.out.println("Giro no realizado. Fondos insuficientes, límite de sobregiro excedido ❌");
        } else {
            if (saldoActual >= monto) {
                // Hay suficiente saldo
                setSaldo(saldoActual - monto);
                System.out.println("Giro realizado con éxito✅");
                System.out.println("Nuevo saldo: $" + getSaldo() + TIPO_MONEDA_CHILE);
            } else {
                // Necesita usar sobregiro
                long montoASobregirar = monto - saldoActual;
                setSobregiroActual(sobregiroActual + montoASobregirar);
                setSaldo(0L); // El saldo queda en 0
                System.out.println("Giro realizado con sobregiro.");
                System.out.println("Sobregiro utilizado: $" + montoASobregirar + TIPO_MONEDA_CHILE);
                System.out.println("Sobregiro total actual: $" + getSobregiroActual() + TIPO_MONEDA_CHILE );
                System.out.println("Sobregiro disponible: $" + (limiteSobregiro - getSobregiroActual()) + TIPO_MONEDA_CHILE);
            }
        }

    }
}
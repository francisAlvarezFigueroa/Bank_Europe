package cl.duoc.bankeurope.modelos.cuentas.tipos;
import cl.duoc.bankeurope.interfaces.InfoCuenta;
import cl.duoc.bankeurope.modelos.cuentas.base.CuentaBancaria;
import static cl.duoc.bankeurope.constantes.Constantes.*;
//_____________________________________________END IMPORTS_____________________________________________________________

public class CuentaAhorros extends CuentaBancaria implements InfoCuenta{

    protected int cantidadGirosPermitidos;
    protected int contadorGiros;  // todas las cuentas se crean con 0 giros realizados

    // OVERLOADED CONSTRUCTORS _______________________________________________________________________
    public CuentaAhorros(long saldo, long numeroCuenta, float porcentajeInteres, int cantidadGirosPermitidos) {
        super(saldo, numeroCuenta, porcentajeInteres);
        this.cantidadGirosPermitidos = cantidadGirosPermitidos;
        this.contadorGiros=0;
    }

    public CuentaAhorros(long saldo, long numeroCuenta, int cantidadGirosPermitidos) {
        super(saldo, numeroCuenta);
        this.cantidadGirosPermitidos = cantidadGirosPermitidos;
        this.contadorGiros=0;

    }

    public CuentaAhorros(long numeroCuenta, int cantidadGirosPermitidos) {
        super(numeroCuenta);
        this.cantidadGirosPermitidos = cantidadGirosPermitidos;
        this.contadorGiros=0;

    }

    public CuentaAhorros(long numeroCuenta, long saldo){
        super(saldo, numeroCuenta);
        cantidadGirosPermitidos=7;
        this.contadorGiros=0;

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
    public void mostrarInformacionCuenta() {
        System.out.println("___________________________________________________________________________________________");
        System.out.println("Tipo de cuenta              : " + OPCION_CUENTA_AHORRO);
        System.out.println("Número de cuenta            : " + getNumeroCuenta());
        System.out.println("Saldo                       : $" + getSaldo() + TIPO_MONEDA_CHILE);
        System.out.println("Cantidad giros permitidos   : " + getCantidadGirosPermitidos());
    }

    @Override
    public void depositarMonto(long monto) {
       setSaldo(getSaldo() + monto);
        System.out.println("Depósito realizado con éxito ✅");
        System.out.println("Saldo actual: $" + getSaldo() + TIPO_MONEDA_CHILE);
    }

    @Override
    public void girarMonto(long monto) {
        if(monto<=0) {
            System.out.println("El monto a depositar debe ser mayor a $0" + TIPO_MONEDA_CHILE);
            return;
        }

        if (monto>0 && getSaldo() >= monto) {
            setSaldo((getSaldo() - monto)); // solo se puede girar si es que hay dinero
            contadorGiros++;
            System.out.println("Giro realizado con éxito ✅");
            System.out.println("Saldo actual: $" + getSaldo() + TIPO_MONEDA_CHILE);
            System.out.println("Giros restantes para conservar el interés: " + (cantidadGirosPermitidos - contadorGiros));
        } else{
                System.out.println("Fondos insuficientes. No se puede realizar giro ❌");
        }


    }
}

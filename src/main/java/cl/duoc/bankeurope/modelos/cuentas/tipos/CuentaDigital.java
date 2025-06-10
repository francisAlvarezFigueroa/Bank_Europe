package cl.duoc.bankeurope.modelos.cuentas.tipos;
import cl.duoc.bankeurope.modelos.cuentas.base.CuentaBancaria;
import static cl.duoc.bankeurope.constantes.Constantes.OPCION_CUENTA_DIGITAL;
import static cl.duoc.bankeurope.constantes.Constantes.TIPO_MONEDA_CHILE;

public class CuentaDigital extends CuentaBancaria{

    protected long limiteMontoDiario; // no se puede recibir ni enviar montos de más de esta suma

    //OVERLOADED CONSTRUCTORS________________________________________________________________________
    public CuentaDigital(long saldo, long numeroCuenta, long limiteMontoDiario){
        super(saldo,numeroCuenta);
        this.limiteMontoDiario= limiteMontoDiario;
    }
    public CuentaDigital(long saldo, long numeroCuenta) {
        super(saldo, numeroCuenta);
        limiteMontoDiario = 100000L;
    }

    public CuentaDigital(long numeroCuenta) {
        super(numeroCuenta);
        limiteMontoDiario = 100000L;
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
        System.out.println("Saldo               : $" + getSaldo() + TIPO_MONEDA_CHILE);
        System.out.println("Limite monto diario : $" + getLimiteMontoDiario() + TIPO_MONEDA_CHILE);
    }

    @Override
    public double calcularInteres() {
        setPorcentajeInteres(0.004f);
        double interesAnual = saldo * getPorcentajeInteres();
        return interesAnual;
    }

    @Override
    public void depositarMonto(long monto) {
        if(monto<=0){
            System.out.println("El monto a depositar debe ser mayor a $0" +  TIPO_MONEDA_CHILE);
            return;
        }

        if(monto>getLimiteMontoDiario()){
            System.out.println("Ha excedido el límite de depósito diario para una cuenta digital");
            System.out.println("Intente con un monto menor o igual a : $ " + getLimiteMontoDiario() + TIPO_MONEDA_CHILE);
        }else{
            setSaldo(getSaldo()+monto);
            System.out.println("Depósito realizado con éxito ✅");
            System.out.println("Saldo actual: $" + getSaldo() + TIPO_MONEDA_CHILE);
        }
    }

    @Override
    public void girarMonto(long monto) {
        //todo: no prioritario: Crear métodos para giros y depósitos exitosos y fallidos en utilidades.
        if(monto<=0){
            System.out.println("El monto a girar debe ser mayor a $0" +  TIPO_MONEDA_CHILE);
            return;
        }

        if(monto>getLimiteMontoDiario()){
            System.out.println("Se ha excedido el límite de giro diario para una cuenta digital");
            System.out.println("Intente con un monto menor o igual a : " + getLimiteMontoDiario() + TIPO_MONEDA_CHILE);
        }else{
            setSaldo(getSaldo()-monto);
            System.out.println("Giro realizado con éxito✅");
            System.out.println("Nuevo saldo: $" + getSaldo() + TIPO_MONEDA_CHILE);
        }

    }
}

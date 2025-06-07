package cl.duoc.bankeurope.modelos.cuentas;

public  abstract class CuentaBancaria  {

    protected long saldo;
    protected long numeroCuenta;



    // CONSTRUCTOR Y SOBRECARGA DE CONSTRUCTOR _______________________________________________________
    public CuentaBancaria(long saldo, long numeroCuenta) {
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public CuentaBancaria (long numeroCuenta){
        this.numeroCuenta=numeroCuenta;
        saldo=0L;
    }

    // GETTERS Y SETTERS _____________________________________________________________________________

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

    // MÉTODO ABSTRACTO PARA CALCULAR INTERÉS_________________________________________________________

    public abstract double calcularInteres ();  // solo declaracion, obliga implementacion en subclases
}

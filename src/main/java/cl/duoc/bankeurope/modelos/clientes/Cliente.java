package cl.duoc.bankeurope.modelos.clientes;
import cl.duoc.bankeurope.interfaces.InfoCliente;
import cl.duoc.bankeurope.modelos.cuentas.base.CuentaBancaria;


import static cl.duoc.bankeurope.servicios.ServiciosCuenta.*;

public class Cliente implements InfoCliente {
    protected String nombre;
    protected String apellidoPaterno;
    protected String apellidoMaterno;
    protected String rut;
    private String domicilio;
    private String comuna;
    private String numeroTelefono;
    private long numeroCuenta;
    private String tipoCuenta;
    private CuentaBancaria cuentabancaria;

    // CONSTRUCTOR___________________________________________________________________________________
    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, String rut, String domicilio, String comuna, String numeroTelefono, long numeroCuenta, String tipoCuenta, CuentaBancaria cuentabancaria) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.rut = rut;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.numeroTelefono = numeroTelefono;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.cuentabancaria = crearCuentaNueva(tipoCuenta, numeroCuenta);
    }


    // GETTERS Y SETTERS_______________________________________________________________________________

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public CuentaBancaria getCuentabancaria() {
        return cuentabancaria;
    }

    public void setCuentabancaria(CuentaBancaria cuentabancaria) {
        this.cuentabancaria = cuentabancaria;
    }

    // METHODS _________________________________________________________________________________________________________


    @Override
    public void mostrarInformacionCliente() {
        System.out.println("___________________________________________________________________________________________");
        System.out.println("|       Nombre              : " + getNombre().toUpperCase());
        System.out.println("|       Apellido Paterno    : " + getApellidoPaterno().toUpperCase());
        System.out.println("|       Apellido Materno    : " + getApellidoMaterno().toUpperCase());
        System.out.println("|       Rut                 : " + getRut().toUpperCase());
        System.out.println("|       Domicilio           : " + getDomicilio().toUpperCase());
        System.out.println("|       Comuna              : " + getComuna().toUpperCase());
        System.out.println("|       Número de teléfono  : " + getNumeroTelefono());
        System.out.println("|       Tipo de cuenta      : " + getTipoCuenta().toUpperCase());
        System.out.println("___________________________________________________________________________________________");
    }
}

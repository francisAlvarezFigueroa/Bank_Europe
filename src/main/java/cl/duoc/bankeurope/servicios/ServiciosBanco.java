package cl.duoc.bankeurope.servicios;
import cl.duoc.bankeurope.modelos.Banco;
import cl.duoc.bankeurope.modelos.clientes.Cliente;
import cl.duoc.bankeurope.modelos.cuentas.base.CuentaBancaria;
import cl.duoc.bankeurope.modelos.cuentas.tipos.CuentaAhorros;
import cl.duoc.bankeurope.modelos.cuentas.tipos.CuentaCorriente;
import cl.duoc.bankeurope.modelos.cuentas.tipos.CuentaDigital;
import static cl.duoc.bankeurope.constantes.Constantes.*;
import static cl.duoc.bankeurope.utilidades.ConsolaUtil.*;


public class ServiciosBanco {

    private Banco banco;

    // CONSTRUCTOR___________________________________________________________________________________________________
    public ServiciosBanco (Banco banco){ // recibe la instancia de banco
        this.banco= banco;
    }

    //METHODS_________________________________________________________________________________________________________

    public boolean verificarClienteExiste(String rutCliente) {
        return banco.getClientes().containsKey(rutCliente);  // busco el rut en el hashmap de clientes
    }

    public boolean verificarCuentaExiste(Long numeroCuenta) {
        return banco.getCuentasBancarias().containsKey(numeroCuenta); // busco el n cuenta en HM cuentasBancarias
    }

    public void registrarCliente(Cliente cliente) {
        if (verificarClienteExiste(cliente.getRut())) {
            System.out.println("Cliente ya existe. No es posible registrarlo nuevamente ❌");
            return;
        }

        if (verificarCuentaExiste(cliente.getNumeroCuenta())) { //todo: ask clarification
            System.out.println("Este número de cuenta ya existe. No es posible registrarlo nuevamente ❌");
            return;
        }

        // Si no existe el cliente ni la cuenta, podemos proceder a crearla
        CuentaBancaria cuentaNueva = crearCuentaNueva(cliente.getTipoCuenta(), cliente.getNumeroCuenta());

        if(cuentaNueva==null){
            System.out.println("Tipo de cuenta no válido. No se puede crear la cuenta bancaria.");
            return;
        }

        // asignar la cuenta al cliente
        cliente.setCuentaBancaria(cuentaNueva);
        //todo: volver a este problema

        //registrar al cliente y su cuenta

        banco.getClientes().put(cliente.getRut(), cliente); // agrego al nuevo cliente a mi HM
        banco.getCuentasBancarias().put(cliente.getNumeroCuenta(), cuentaNueva); // asocia numero de cuenta con Cuenta
        banco.getRelacionCuentaCliente().put(cliente.getNumeroCuenta(), cliente.getRut()); // asocia numero de cuenta con rut
        mostrarMensajeRegistroClienteExitoso(cliente.getRut());
    }

    public CuentaBancaria crearCuentaNueva(String tipoCuenta, long numeroCuenta) {
        switch (tipoCuenta) {
            case OPCION_CUENTA_CORRIENTE:
                return new CuentaCorriente(numeroCuenta);
            case OPCION_CUENTA_AHORRO:
                return new CuentaAhorros(numeroCuenta, 7);
            case OPCION_CUENTA_DIGITAL:
                return new CuentaDigital(numeroCuenta);
            default:
                return null;
        }
    }
}

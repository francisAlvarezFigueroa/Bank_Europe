package cl.duoc.bankeurope.modelos;
import java.util.HashMap;

import cl.duoc.bankeurope.modelos.clientes.Cliente;
import cl.duoc.bankeurope.modelos.cuentas.base.CuentaBancaria;

import static cl.duoc.bankeurope.constantes.Constantes.*;

public class Banco {
    protected String nombre;
    protected long cantidadEmpleados;

    //HASHMAPS________________________________________________________________________________________
    private HashMap <String, Cliente> clientes;
    private HashMap<Long, CuentaBancaria> cuentasBancarias;
    private HashMap<Long, String> relacionCuentaCliente; // hashmap que asocia un numero de cuenta a un rut de cliente

    // remember: it has to be Long because HashMaps only work w/ objects, not primitives

    // OVERLOADED CONSTRUCTORS________________________________________________________________________

    public Banco() {
        this.nombre = NOMBRE_BANCO;
        this.clientes = new HashMap<>(); // se crean los hashmaps al momento de crear el banco
        this.cuentasBancarias = new HashMap<>();
        this.relacionCuentaCliente = new HashMap<>();
    }

    public Banco(String nombre) {
        this.nombre = nombre;
        this.clientes = new HashMap<>(); // se crean los hashmaps al momento de crear el banco
        this.cuentasBancarias = new HashMap<>();
        this.relacionCuentaCliente = new HashMap<>();
    }


    // GETTERS Y SETTERS _____________________________________________________________________________


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getCantidadEmpleados() {
        return cantidadEmpleados;
    }

    public void setCantidadEmpleados(long cantidadEmpleados) {
        this.cantidadEmpleados = cantidadEmpleados;
    }

    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(HashMap<String, Cliente> clientes) {
        this.clientes = clientes;
    }

    public HashMap<Long, CuentaBancaria> getCuentasBancarias() {
        return cuentasBancarias;
    }

    public void setCuentasBancarias(HashMap<Long, CuentaBancaria> cuentasBancarias) {
        this.cuentasBancarias = cuentasBancarias;
    }

    public HashMap<Long, String> getRelacionCuentaCliente() {
        return relacionCuentaCliente;
    }

    public void setRelacionCuentaCliente(HashMap<Long, String> relacionCuentaCliente) {
        this.relacionCuentaCliente = relacionCuentaCliente;
    }
}

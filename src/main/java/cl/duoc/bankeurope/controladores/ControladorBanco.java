package cl.duoc.bankeurope.controladores;

import cl.duoc.bankeurope.modelos.Banco;
import cl.duoc.bankeurope.modelos.clientes.Cliente;
import cl.duoc.bankeurope.servicios.ServiciosBanco;
import cl.duoc.bankeurope.servicios.ServiciosCliente;
import cl.duoc.bankeurope.servicios.ServiciosCuenta;

import static cl.duoc.bankeurope.constantes.Constantes.*;
import static cl.duoc.bankeurope.utilidades.ConsolaUtil.mostrarEncabezado;
import static cl.duoc.bankeurope.utilidades.GestorEntradaSalida.*;

public class ControladorBanco {
    private ServiciosBanco serviciosBanco;
    private Banco banco;
    private ServiciosCuenta serviciosCuenta;
    private ServiciosCliente serviciosCliente;

    // CONSTRUCTOR_____________________________________________________________________________________________________

    public ControladorBanco (ServiciosBanco serviciosBanco){
        this.serviciosBanco=serviciosBanco;
    }

    public Cliente registrarClienteDesdeConsola(){
        String rutCliente = obtenerTextoScanner("Ingrese Rut del cliente: (incluya puntos y guion. Ej: 1.111.111-1)");
        String nombreCliente = obtenerTextoScanner("Ingrese primer nombre del cliente:");
        String apellidoPaterno = obtenerTextoScanner("Ingrese apellido paterno del cliente:");
        String apellidoMaterno = obtenerTextoScanner("Ingrese apellido materno del cliente:");
        String domicilio = obtenerTextoScanner("Ingrese domicilio del cliente:");
        String comuna= obtenerTextoScanner("Ingrese comuna del cliente:");
        int numeroDeTelefono = obtenerNumeroScanner("Ingrese número de teléfono:", 8,12);
        long numeroCuenta = obtenerNumeroScanner("Ingrese numero Cuenta", 8,10);
        String tipoCuenta = obtenerTextoScanner("Ingrese el tipo de cuenta a crear: (Corriente/ ahorro/ digital)").toUpperCase();

      // crea al cliente como objeto
        return new Cliente(rutCliente,nombreCliente,apellidoPaterno,apellidoMaterno,domicilio,comuna,numeroDeTelefono,numeroCuenta,tipoCuenta);
    }

    public void depositar(Banco bankEurope, ServiciosCuenta serviciosCuenta) {
        if (bankEurope.getCuentasBancarias().isEmpty()) {
            System.out.println("No se ha registrado ningúna cuenta. Registre cliente en opción 1 del menú principal");
            return;
        } else {
            Long cuentaTarget = 0L;
            do {
                cuentaTarget = obtenerNumeroCuentaEntrada("Ingrese número de cuenta a depositar: ");
                long monto = obtenerMontoEntrada("Ingrese monto a depositar: ");
                serviciosCuenta.depositarMontoCuenta(cuentaTarget, monto);
            } while (cuentaTarget <= 0);
        }
    }

    public void girar(Banco bankEurope, ServiciosCuenta serviciosCuenta) {
        if (bankEurope.getCuentasBancarias().isEmpty()) {
            System.out.println("No se ha registrado ningúna cuenta. Registre cliente en opción 1 del menú principal");
            return;
        } else {
            Long cuentaTarget = 0L;
            do {
                cuentaTarget = obtenerNumeroCuentaEntrada("Ingrese número de cuenta a girar: ");
                long monto = obtenerMontoEntrada("Ingrese monto a girar: ");
                serviciosCuenta.girarMontoCuenta(cuentaTarget, monto);
            } while (cuentaTarget <= 0);
        }
    }

    public void consultarSaldo(Banco bankEurope) {
        if (bankEurope.getCuentasBancarias().isEmpty()) {
            System.out.println("No se ha registrado ningúna cuenta. Registre cliente en opción 1 del menú principal");
            return;
        } else {
            Long cuentaTarget = 0L;
            do {
                cuentaTarget = obtenerNumeroCuentaEntrada("Ingrese número de cuenta a consultar saldo: ");
                serviciosCuenta.mostrarSaldoCuenta(cuentaTarget);
            } while (cuentaTarget <= 0);
        }
    }

    public void verDatosCliente(Banco bankEurope) {
        if (bankEurope.getClientes().isEmpty()) {
            System.out.println("No se ha registrado ningún cliente. Registre cliente en opción 1 del menú principal");

            return;
        } else {
            String rutTarget = obtenerRutDeEntrada("Ingrese rut del cliente a buscar (incluya puntos y guión): ").toUpperCase();
            serviciosCliente.mostrarInformacionCliente(rutTarget);
        }

    }

    public void verDatosCuenta(Banco bankEurope) {
        mostrarEncabezado(MENU_DATOS_CUENTA); // Usamos la nueva constante para el encabezado
        if (bankEurope.getCuentasBancarias().isEmpty()) {
            System.out.println("No se ha registrado ninguna cuenta. Registre cliente en opción 1 del menú principal");
            return;
        } else {
            Long cuentaTarget = obtenerNumeroCuentaEntrada("Ingrese el número de cuenta para ver los detalles: ");
            if (serviciosBanco.verificarCuentaExiste(cuentaTarget)) {
                bankEurope.getCuentasBancarias().get(cuentaTarget).mostrarInformacionCuenta(); // Llama al método polimórfico
            } else {
                System.out.println("No se ha encontrado cuenta con ese número.");
            }
        }
    }
}

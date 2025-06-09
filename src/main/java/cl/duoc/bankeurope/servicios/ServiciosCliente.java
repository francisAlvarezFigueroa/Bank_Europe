package cl.duoc.bankeurope.servicios;
import cl.duoc.bankeurope.interfaces.InfoCliente;
import cl.duoc.bankeurope.modelos.clientes.Cliente;
import static cl.duoc.bankeurope.utilidades.ConsolaUtil.*;

public class ServiciosCliente implements InfoCliente {
    private ServiciosBanco serviciosBanco;

    //CONSTRUCTOR___________________________________________________________________________________________________
    public ServiciosCliente (ServiciosBanco serviciosBanco){
        this.serviciosBanco=serviciosBanco;
    }
    // todo: revisar y estudiar cómo pasar métodos no estáticos mediante una instancia de otro servicio

    public void mostrarInformacionCliente(Cliente cliente){
         if(serviciosBanco.verificarClienteExiste(cliente.getRut())) {
             mostrarEncabezado("Información Cliente");
             System.out.println("___________________________________________________________________________________________");
             System.out.println("|       Nombre              : " + cliente.getNombre().toUpperCase());
             System.out.println("|       Apellido Paterno    : " + cliente.getApellidoPaterno().toUpperCase());
             System.out.println("|       Apellido Materno    : " + cliente.getApellidoMaterno().toUpperCase());
             System.out.println("|       Rut                 : " + cliente.getRut().toUpperCase());
             System.out.println("|       Domicilio           : " + cliente.getDomicilio().toUpperCase());
             System.out.println("|       Comuna              : " + cliente.getComuna().toUpperCase());
             System.out.println("|       Número de teléfono  : " + cliente.getNumeroTelefono());
             System.out.println("|       Tipo de cuenta      : " + cliente.getTipoCuenta().toUpperCase());
             System.out.println("___________________________________________________________________________________________");
         }
    }

    // mostrar datos cuenta del cliente

    public void mostrarInformacionCuentaCliente (Cliente cliente){
        if(cliente.getCuentaBancaria()==null){
            System.out.println("Este cliente no tiene una cuenta bancaria asociada");
            return;
        }
        mostrarEncabezado("Información Cuenta Cliente");
        cliente.getCuentaBancaria().mostrarInformacionCuenta();
    }

}

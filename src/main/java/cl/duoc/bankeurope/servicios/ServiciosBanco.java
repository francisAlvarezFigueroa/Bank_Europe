package cl.duoc.bankeurope.servicios;
import cl.duoc.bankeurope.modelos.Banco;




public class ServiciosBanco {

    public boolean verificarCuentaExiste(long numeroCuenta) {
        boolean existeCuenta = false;
        if (Banco.getCuentasBancarias().containsKey(numeroCuenta)) {
            existeCuenta = true;
        }
        return existeCuenta;
    }

}

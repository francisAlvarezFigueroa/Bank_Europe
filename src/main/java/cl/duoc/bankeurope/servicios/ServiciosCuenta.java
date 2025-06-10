package cl.duoc.bankeurope.servicios;
import cl.duoc.bankeurope.modelos.Banco;

import static cl.duoc.bankeurope.constantes.Constantes.*;

public class ServiciosCuenta {

    private ServiciosBanco serviciosBanco;
    private Banco banco;

    //CONSTRUCTOR
    public ServiciosCuenta (ServiciosBanco serviciosBanco, Banco banco){
        this.serviciosBanco=serviciosBanco;
        this.banco=banco;
    }

    //METHODS___________________________________________________________________________________________________

    public void depositarMontoCuenta(long numeroCuenta, long monto) {
        if (serviciosBanco.verificarCuentaExiste(numeroCuenta) && monto > 0) {
            banco.getCuentasBancarias().get(numeroCuenta).depositarMonto(monto); //traigo la lista busco numero de cuenta y en ese numero deposito monto
        } else {
            System.out.println("Número o monto inválido. No se puede realizar depósito.");
        }
    }

    public void girarMontoCuenta (long numeroCuenta, long monto){
        if(serviciosBanco.verificarCuentaExiste(numeroCuenta) && monto>0){
            banco.getCuentasBancarias().get(numeroCuenta).girarMonto(monto);
        }else{
            System.out.println("No se puede realizar giro.");
        }
    }

    public void mostrarSaldoCuenta (long numeroCuenta){
        if(serviciosBanco.verificarCuentaExiste(numeroCuenta)){
            banco.getCuentasBancarias().get(numeroCuenta).mostrarInformacionCuenta();
        }else{
            System.out.println("No se puede encontrar cuenta.");
        }
    }

    public void calcularInteresAnual (long numeroCuenta){
        if(serviciosBanco.verificarCuentaExiste(numeroCuenta)){
            if(banco.getCuentasBancarias().get(numeroCuenta).getSaldo()>0){
                double interes = banco.getCuentasBancarias().get(numeroCuenta).calcularInteres();
                System.out.println("Se han generado: " + interes + TIPO_MONEDA_CHILE + "durante el periodo anual.");
            }
        }
    }





}

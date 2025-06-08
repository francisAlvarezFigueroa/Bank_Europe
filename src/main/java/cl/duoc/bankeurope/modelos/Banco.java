package cl.duoc.bankeurope.modelos;
import static cl.duoc.bankeurope.constantes.Constantes.*;

public class Banco {
    protected String nombre;
    protected long cantidadEmpleados;


    // OVERLOADED CONSTRUCTORS________________________________________________________________________

    public Banco (String nombre, long cantidadEmpleados){
        this.nombre= nombre;
        this.cantidadEmpleados= cantidadEmpleados;
    }

    public Banco (){
        this.nombre= NOMBRE_BANCO;
        this.cantidadEmpleados= CANTIDAD_EMPLEADOS;
    }

    public Banco (String nombre){
        this.nombre= nombre;
        this.cantidadEmpleados= CANTIDAD_EMPLEADOS;
    }

    public Banco (long cantidadEmpleados){
        this.nombre= NOMBRE_BANCO;
        this.cantidadEmpleados= cantidadEmpleados;
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
}

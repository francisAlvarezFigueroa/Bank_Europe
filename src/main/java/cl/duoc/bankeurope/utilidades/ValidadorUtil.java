package cl.duoc.bankeurope.utilidades;

public class ValidadorUtil {

    // valida si entradas son blank
    // valida formatos de rut o numeros


    /** El método isFieldBlank es una forma de verificar si el usuario ingresó algún valor
     * @param field recibe un texto entrado por el usuario.
     * @return true si field es blank.
     */
    public static boolean isFieldBlank (String field){
        if(field.isBlank()){
            System.out.println("Campo requerido, por favor ingrese un valor según lo indicado");
            return true;
        }
        return  false;
    }

    public static boolean isNumberValid (int opcNumero, int startRange, int endRange){ // al momento de usarlo se debe establecer el rango permitido dentro del menú
        if(opcNumero<startRange || opcNumero>endRange){
            System.out.println("Número ingresado no es válido. Intente nuevamente.");
            return false;
        }
        return true;
    }



}

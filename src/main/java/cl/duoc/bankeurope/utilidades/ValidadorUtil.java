package cl.duoc.bankeurope.utilidades;

public class ValidadorUtil {

    public static boolean isFieldBlank (String field){
        if(field.isBlank()){
            System.out.println("Campo requerido, por favor ingrese un valor según lo indicado");
            return true;
        }
        return  false;
    }

    public static boolean isNumberValid (int opcNumero, int startRange, int endRange){ // al momento de usarlo se debe establecer el rango permitido dentro del menú
        if(opcNumero<startRange && opcNumero>endRange){
            System.out.println("Número ingresado no es válido. Intente nuevamente.");
            return false;
        }
        return true;
    }



}

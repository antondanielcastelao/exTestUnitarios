/**
 * Clase para el exámen de Test Unitarios de COD
 * Comprueba si la letra del DNI es correcta
 */

public class Main {
    public static void main(String[] args) {
        DNI dni = new DNI();
        if (dni.comprobarDNI("00000000",'T')) {
            System.out.println("El DNI es correcto");
        } else {
            System.out.println("El DNI no es correcto");
        }

    }

    public Main() {

    }
}
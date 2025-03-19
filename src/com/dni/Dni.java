package com.dni;

public class Dni {
    public Dni() {}
    /**
     * Cmprueba DNI y su letra para ver si es correcto
     * @param dni
     * @param letra
     * @return true si es correcto, false si no lo es
     */
    public static boolean comprobarDNI (String dni, char letra){
        // calcula la letra del DNI
        char letraCalculada = calcularLetraDNI(dni);
        // compara la letra del DNI con la letra pasada por parámetro
        return letraCalculada == letra;
    }

    /**
     * Calcula la letra de un DNI
     * @param dni
     * @return la letra del DNI
     */
    public static char calcularLetraDNI (String dni) {
        // array de caracteres con las letras del DNI
        char[] letrasDNI = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        // calcula el resto de dividir el DNI entre 23
        int resto = Integer.parseInt(dni) % 23;
        // devuelve la letra correspondiente al resto
        return letrasDNI[resto];
    }
}

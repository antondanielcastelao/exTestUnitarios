## Examen de Test Unitarios

---

### Enunciado

Con el código de este repositorio realiza:

- (*4 puntos*) Los test unitarios de los **dos** métodos, utiliza test **parametrizados**. Suponiendo que la `string` com.dni.Dni, siempre es un com.dni.Dni válido.
- (*2 puntos*) En el código, hay un error, ¿lo pudiste comprabar en los test? ¿Plantea la solución?
- (*3 puntos*) Si no hubiera una comprobación previamente encuanto a la longitud de la `string` del com.dni.Dni, ¿Qué hay que cambiar en los tests para que comprueben estos casos?

Entrega tu repositorio con el código y los test. Además un `Readme` explicando y justificando cada apartado

Formato del `Readme` *1 punto*

---
## Detección de error con los tests
Probando las funciones con una lista que engloba todas las letras, notamos
dos errores en las letras S y Q. Contrastamos la información con la web oficial
del Ministerio de Interior para ver que nuestros parámetros del test son 
correctos y el error es del programa. El diccionario de letras para el DNI está mal,
concretamente habría que cambiar la S por la Q de esta manera:
```java
char[] letrasDNI = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'}; 'S', 'V', 'H', 'L', 'C', 'K', 'E'};
```
Repitiendo la pila de tests, ahora ya no tenemos ningún fallo.

## Manejo de DNIs con menos de 8 cifras
Haciendo una prueba whitebox o de caja blanca echamos un vistazo al código de la clase Dni, y nos damos cuenta de que 
el método para calcular la letra del DNI no hace ningún filtrado en cuanto 
al input por parámetros, por lo que decido incluir en mi pila de tests el numero 23 y la letra T.

```java
    @ParameterizedTest(name = "{0}{1}")
    @DisplayName("calcularLetraDNI")
    @CsvSource({
            "23, 'T'"
    })
    public void testCalcularLetraDNI(String nif, char expected) {
        char letra = dni.calcularLetraDNI(nif);
        Assertions.assertEquals(letra, expected, "La letra es incorrecta");
    }
```
Como era de esperar, da como válido ese tipo de casos. Así mismo, el método comprobarDNI que depende del otro también daría fallos. 
La solución sería tan facil de implementar como hacer una comprobación de la longitud del string del parámetro 
de esta manera.
```java
public static char calcularLetraDNI(String nif) {
    if (nif.length() != 8) {
        // codigo para manejar la excepción aqui
        throw new IllegalArgumentException("El DNI tiene q tener 8 dígitos");
    }
}
```
Ahora, podemos implementar tanto en una de nuestras pilas de tests o creando una nueva 
los casos en los que el DNI no cumple con estos 8 digitos.
```java
    @ParameterizedTest(name = "{0}{1}")
    @DisplayName("DNIs sin 8 digitos")
    @CsvSource({
            "23, 'T'",
            "null, 'T'",
            "0000023, 'T'",
            "000023, 'T'",
            "00023, 'T'",
            "0023, 'T'",
            "023, 'T'"
    })
```

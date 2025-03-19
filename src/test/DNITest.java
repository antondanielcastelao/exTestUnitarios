package test;

import com.dni.Dni;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DNITest {

    static Dni dni;
    @BeforeAll
    public static void inicializarClase() {
        dni = new Dni();
    }
    // Test parametrizado del método "comprobarDNI"
    @ParameterizedTest( name = "{0}{1}")
    @DisplayName("comprobarDNI")
    @CsvSource({
            "00000000, 'T'",
            "00000001, 'R'",
            "00000002, 'W'",
            "00000003, 'A'",
            "00000004, 'G'",
            "00000005, 'M'",
            "00000006, 'Y'",
            "00000007, 'F'",
            "00000008, 'P'",
            "00000009, 'D'",
            "00000010, 'X'",
            "00000011, 'B'",
            "00000012, 'N'",
            "00000013, 'J'",
            "00000014, 'Z'",
            "00000015, 'S'",
            "00000016, 'Q'",
            "00000017, 'V'",
            "00000018, 'H'",
            "00000019, 'L'",
            "00000020, 'C'",
            "00000021, 'K'",
            "00000022, 'E'"
    })
    public void testComprobarDNI(String nif, char letra){

        Assertions.assertTrue(dni.comprobarDNI(nif, letra));

    }

    // Pila de test para el metodo calcularLetraDNI

    @ParameterizedTest(name = "{0}{1}")
    @DisplayName("calcularLetraDNI")
    @CsvSource({
            "00000000, 'T'",
            "00000001, 'R'",
            "00000002, 'W'",
            "00000003, 'A'",
            "00000004, 'G'",
            "00000005, 'M'",
            "00000006, 'Y'",
            "00000007, 'F'",
            "00000008, 'P'",
            "00000009, 'D'",
            "00000010, 'X'",
            "00000011, 'B'",
            "00000012, 'N'",
            "00000013, 'J'",
            "00000014, 'Z'",
            "00000015, 'S'",
            "00000016, 'Q'",
            "00000017, 'V'",
            "00000018, 'H'",
            "00000019, 'L'",
            "00000020, 'C'",
            "00000021, 'K'",
            "00000022, 'E'"
    })
    public void testCalcularLetraDNI(String nif, char expected) {
        char letra = dni.calcularLetraDNI(nif);
        Assertions.assertEquals(letra, expected, "La letra es incorrecta");
    }

    // tests dni que no tienen 8 digitos
}

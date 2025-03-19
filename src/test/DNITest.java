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
            "39485788, 'D'",
            "00000000, 'T'",
            "45733588, 'C'",
            "11595568, 'A'",
            "03655251, 'E'"
    })
    public void testComprobarDNI(String nif, char letra){

        Assertions.assertTrue(dni.comprobarDNI(nif, letra));

    }


}

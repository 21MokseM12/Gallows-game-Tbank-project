package backend.academy.gallow_game.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiffLevelValidatorTest {

    private final DiffLevelValidator diffLevelValidator = new DiffLevelValidator();

    public static Stream<Arguments> isValid_Success_Provider() {
        return Stream.of(
            Arguments.of("1"),
            Arguments.of("2"),
            Arguments.of("3"),
            Arguments.of("4")
        );
    }

    @ParameterizedTest
    @MethodSource("isValid_Success_Provider")
    @DisplayName("Проверка валидации корректных данных")
    public void isValid_Success(String data) {
        assertTrue(diffLevelValidator.isValid(data));
    }

    public static Stream<Arguments> isValid_Denied_Provider() {
        return Stream.of(
            Arguments.of("5"),
            Arguments.of(""),
            Arguments.of(","),
            Arguments.of("Hello, world!"),
            Arguments.of(new String())
        );
    }

    @ParameterizedTest
    @MethodSource("isValid_Denied_Provider")
    @DisplayName("Проверка валидации некорректных данных")
    public void isValid_Denied(String data) {
        assertFalse(diffLevelValidator.isValid(data));
    }
}

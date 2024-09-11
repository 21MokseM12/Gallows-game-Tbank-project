package backend.academy.gallow_game.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CategoryValidatorTest {

    private final CategoryValidator categoryValidator = new CategoryValidator();

    public static Stream<Arguments> isValid_Success_Provider(){
        return Stream.of(
            Arguments.of("1"),
            Arguments.of("2"),
            Arguments.of("3"),
            Arguments.of("4"),
            Arguments.of("5"),
            Arguments.of("6")
        );
    }

    @ParameterizedTest
    @MethodSource("isValid_Success_Provider")
    @DisplayName("Проверка валидации корректных данных")
    public void isValid_Success(String data) {
        assertTrue(categoryValidator.isValid(data));
    }

    public static Stream<Arguments> isValid_Wrong_Provider() {
        return Stream.of(
            Arguments.of("ttttttttttttttttt"),
            Arguments.of(""),
            Arguments.of(new String()),
            Arguments.of("7")
        );
    }

    @ParameterizedTest
    @MethodSource("isValid_Wrong_Provider")
    @DisplayName("Проверка валидации некорректных данных")
    public void isValid_Wrong(String data) {
        assertFalse(categoryValidator.isValid(data));
    }
}

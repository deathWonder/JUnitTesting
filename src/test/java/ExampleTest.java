import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ExampleTest {

    Example sut = new Example();

    @ParameterizedTest
    @MethodSource("plusSource")
    public void plusTest(int a, int b, int expected) {
        //act
        int result = sut.plus(a, b);
        //assert
        Assertions.assertEquals(expected, result);
    }

    //arrange
    public static Stream<Arguments> plusSource() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(10, 20, 30),
                Arguments.of(-50, 20, -30)
        );
    }

    @ParameterizedTest
    @MethodSource("minFunctionSource")
    public void minFunctionTest(int a, int b, int expected) {
        //act
        int result = sut.minFunction(a, b);
        //assert
        Assertions.assertEquals(expected, result);
    }

    //arrange
    public static Stream<Arguments> minFunctionSource() {
        return Stream.of(
                Arguments.of(1, 2, 1),
                Arguments.of(10, 20, 10),
                Arguments.of(-50, 20, -50)
        );
    }

    @Test
    public void divisionTest() {
        //arrange
        int a = 5;
        int b = 0;
        Class<ArithmeticException> expected = ArithmeticException.class;
        //assert                            //act
        Assertions.assertThrowsExactly(expected, () -> sut.division(a, b));
    }

}

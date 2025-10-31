import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SneakyNumbersTests {
    private final SneakyNumbers solver = new SneakyNumbers();

    @ParameterizedTest(name = "nums={0}, -> expected={1}")
    @MethodSource("sneakyNumbersCases")
    void getSneakyNumbersTest(int[] nums, int[] expected) {
        int[] result = solver.getSneakyNumbers(nums);

        // Check both expected numbers are present in result
        Assertions.assertEquals(2, result.length, "Result should have length 2");

        // Check both expected numbers are present in result
        Assertions.assertTrue(
                (result[0] == expected[0] && result[1] == expected[1]) ||
                         (result[0] == expected[1] && result[1] == expected[0]),
                "Result does not match expected sneaky numbers"
        );
    }

    static Stream<Arguments> sneakyNumbersCases() {
        return Stream.of(
                arguments(new int[]{7, 7, 8, 1, 4, 4}, new int[]{7, 4}),
                arguments(new int[]{3, 4, 2, 9, 3, 4}, new int[]{3, 4}),
                arguments(new int[]{1, 9, 5, 3, 7, 5, 2, 4, 8, 6, 8}, new int[]{5, 8})
        );
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TwoSumTests {
    private final TwoSum solver = new TwoSum();

    // Brute Force tests
    @ParameterizedTest(name = "BruteForce: nums={0}, target={1} -> expected={2}")
    @MethodSource("twoSumCases")
    void twoSumBruteForceTest(int[] nums, int target, int[] expected) {
        int[] result = solver.twoSumBruteForce(nums, target);
        Assertions.assertArrayEquals(expected, result);
    }

    // HashMap tests
    @ParameterizedTest(name = "HashMap: nums={0}, target={1} -> expected={2}")
    @MethodSource("twoSumCases")
    void twoSumHashMapTest(int[] nums, int target, int[] expected) {
        int[] result = solver.twoSumHashMap(nums, target);
        Assertions.assertArrayEquals(expected, result);
    }

    static Stream<Arguments> twoSumCases() {
        return Stream.of(
                arguments(new int[]{1, 3, 14, 20}, 4, new int[]{0, 1}),
                arguments(new int[]{7, 1, 5}, 6, new int[]{1, 2}),
                arguments(new int[]{4, 4}, 8, new int[]{0, 1})
        );
    }
}

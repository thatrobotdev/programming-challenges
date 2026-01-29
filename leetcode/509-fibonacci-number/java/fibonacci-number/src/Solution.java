import java.util.function.Function;

public class Solution {
    static final int max = 30;

    // Recursive algorithm
    public static int fib_recursive(int n) {
        if (n < 2) {
            return n;
        } else {
            return fib_recursive(n - 1) + fib_recursive(n - 2);
        }
    }

    // Polynomial algorithm
    public static int fib_divide(int n) {
        if (n < 2) {
            return n;
        } else {
            int[] fibNums = new int[n];
            fibNums[0] = 1;
            fibNums[1] = 1;

            for (int i = 2; i < n; i++) {
                fibNums[i] = fibNums[i - 1] + fibNums[i - 2];
            }

            return fibNums[n - 1];
        }
    }

    public static void main(String[] args) {
        final Function<Integer, Integer> fibAlgorithm = Solution::fib_divide;

        for(int i = 0; i <= max; i++) {
            System.out.println("n = " + i + ": " + fibAlgorithm.apply(i));
        }
    }
}
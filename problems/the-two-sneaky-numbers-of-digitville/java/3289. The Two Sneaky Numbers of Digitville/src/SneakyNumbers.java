import java.util.HashSet;

/**
 * <h1>3289. The Two Sneaky Numbers of Digitville</h1>
 * By James Kerrane
 * <ul>
 *     <li>Source: <a href="https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/">https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/</a></li>
 *     <li>Difficulty: Easy</li>
 *     <li>Topics: Array, Hash Table, Math</li>
 * </ul>
 *
 * <p>In the town of Digitville, there was a list of numbers called <code>nums</code> containing integers from
 * <code>0</code> to <code>n - 1</code>. Each number was supposed to appear exactly once in the list, however,
 * <b>two</b> mischievous numbers sneaked in an <i>additional time</i>, making the list longer than usual.</p>
 *
 * <p>As the town detective, your task is to find these two sneaky numbers. Return an array of size <b>>two</b>
 * containing the two numbers (in <i>any order</i>), so peace can return to Digitville.</p>
 *
 * <p>(examples modified from original)</p>
 * <h3>Example 1</h3>
 * <q>
 *     <p><b>Input:</b> <code>nums = [7, 7, 8, 1, 4, 4]</code></p>
 *     <p><b>Output:</b> <code>[7, 4]</code></p>
 *     <p><b>Explanation:</b> The numbers 7 and 4 each appear twice in the array.</p>
 * </q>
 *
 * <h3>Example 2</h3>
 * <q>
 *     <p><b>Input:</b> <code>nums = [3, 4, 2, 9, 3, 4]</code></p>
 *     <p><b>Output:</b> <code>[3, 4]</code></p>
 *     <p><b>Explanation:</b> The numbers 3 and 4 each appear twice in the array.</p>
 * </q>
 *
 * <h3>Example 3</h3>
 * <q>
 *     <p><b>Input:</b> <code>nums = [1, 9, 5, 3, 7, 5, 2, 4, 8, 6, 8]</code></p>
 *     <p><b>Output:</b> <code>[5, 8]</code></p>
 *     <p><b>Explanation:</b> The numbers 5 and 8 each appear twice in the array.</p>
 * </q>
 *
 * <h3>Constraints</h3>
 * <ul>
 *     <li><code>2 <= n <= 100</code></li>
 *     <li><code>nums.length == n + 2</code></li>
 *     <li><code>0 <= nums[i] < n</code></li>
 *     <li>The input is generated such that <code>nums</code> contains <b>exactly</b> two repeated elements.</li>
 * </ul>
 */
public class SneakyNumbers {
    /**
     * Use HashSet to keep track of duplicate numbers.
     * <p><a href="https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/submissions/1816484776">Submission</a></p>
     * <p><b>Submitted:</b> Oct 30, 2025</p>
     *
     * <p><b>Performance:</b></p>
     * <ul>
     *     <li><b>Runtime:</b> 2 ms — beats 63.09%</li>
     *     <li><b>Memory:</b> 44.98 MB — beats 27.53%</li>
     * </ul>
     *
     * @param nums numbers of Digitville which contains two duplicates
     * @return array containing the two duplicate numbers
     */
    public int[] getSneakyNumbers(int[] nums) {
        int[] sneakyNumbers = new int[2];
        boolean firstFound = false;
        HashSet<Integer> map = new HashSet<>();

        // Loop through nums
        for (int num : nums) {

            // If we've already seen the num, it's a duplicate!
            if (map.contains(num)) {

                // If it's our first duplicate, we save in the first index, otherwise second and return
                if (!firstFound) {
                    sneakyNumbers[0] = num;
                    firstFound = true;
                } else {
                    sneakyNumbers[1] = num;
                    return sneakyNumbers;
                }
            }

            // Add seen num to map
            map.add(num);
        }

        throw new IllegalArgumentException("Digitville is safe! Could not find two sneaky numbers.");
    }
}
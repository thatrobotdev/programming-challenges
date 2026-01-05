import java.util.HashMap;

/**
 * <h1>1. Two Sum</h1>
 * By James Kerrane
 * <ul>
 *     <li>Source: <a href="https://leetcode.com/problems/two-sum/">https://leetcode.com/problems/two-sum/</a></li>
 *     <li>Difficulty: Easy</li>
 *     <li>Topics: Array, Hash Table</li>
 * </ul>
 *
 * <p>Given an array of integers `nums` and an integer <code>target</code>, return <i>indices of the two numbers such that
 * they add up to <code>target</code></i>.</p>
 *
 * <p>You may assume that each input would have <b><i>exactly</i> one solution</b>, and you may not use the <i>same</i>
 * element twice.</p>
 *
 * <p>You can return the answer in any order.</p>
 *
 * <p>(examples modified from original)</p>
 * <h3>Example 1</h3>
 * <q>
 *     <p><b>Input:</b> <code>nums = [1, 3, 14, 20], target = 4</code></p>
 *     <p><b>Output:</b> <code>[0, 1]</code></p>
 *     <p><b>Explanation:</b> <code>Because nums[0] + nums[1] == 4, we return [0, 1].</code></p>
 * </q>
 *
 * <h3>Example 2</h3>
 * <q>
 *     <p><b>Input:</b> <code>nums = [7, 1, 5], target = 6</code></p>
 *     <p><b>Output:</b> <code>[1, 2]</code></p>
 * </q>
 *
 * <h3>Example 3</h3>
 * <q>
 *     <p><b>Input:</b> <code>nums = [4, 4], target = 8</code></p>
 *     <p><b>Output:</b> <code>[0, 1]</code></p>
 * </q>
 *
 * <h3>Constraints</h3>
 * <ul>
 *     <li><code>2 <= nums.length <= 10<sup>4</sup></code></li>
 *     <li><code>-10<sup>9</sup> <= nums[i] <= 10<sup>9</sup></code></li>
 *     <li><code>-10<sup>9</sup> <= target <= 10<sup>9</sup></code></li>
 * </ul>
 */
public class TwoSum {
    /**
     * Approach 1: Use HashMap to keep track of complements.
     * <p><a href="https://leetcode.com/problems/two-sum/submissions/1816412928">Submission</a></p>
     * <p><b>Submitted:</b> Oct 30, 2025</p>
     *
     * <p><b>Performance:</b></p>
     * <ul>
     *     <li><b>Runtime:</b> 2 ms — beats 99.07%</li>
     *     <li><b>Memory:</b> 45.36 MB — beats 10.66%</li>
     * </ul>
     *
     * @param nums array of integers
     * @param target integer to add up to
     * @return indices of the two numbers such that they add up to target
     */
    public int[] twoSumHashMap(int[] nums, int target) {
        // Create a HashMap to store numbers and their indexes for fast lookups
        HashMap<Integer, Integer> map = new HashMap<>();

        // Loop through all numbers
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // Calculate complement (num + complement = target)
            int complement = target - num;

            // If the map contains a number we know is a complement, we've found the index that adds up to target!
            if(map.containsKey(complement)) {
                // Return that index and the current index
                return new int[] {map.get(complement), i};
            }

            // Put the current number into the map
            map.put(num, i);
        }

        throw new IllegalArgumentException("No two sum solution.");
    }

    /**
     * Approach 2: O(n<sup>2</sup>) Brute Force.
     * <p><a href="https://leetcode.com/problems/two-sum/submissions/1816412289">Submission</a></p>
     * <p><b>Submitted:</b> Oct 30, 2025</p>
     *
     * <p><b>Performance:</b></p>
     * <ul>
     *     <li><b>Runtime:</b> 89 ms — beats 5.05%</li>
     *     <li><b>Memory:</b> 45.14 MB — beats 32.84%</li>
     * </ul>
     *
     * @param nums array of integers
     * @param target integer to add up to
     * @return indices of the two numbers such that they add up to target
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        // Loop through each number
        for(int i = 0; i < nums.length; i++) {

            // Loop each number for each number
            for(int j = 0; j < nums.length; j++) {
                /*
                    If not current number (cannot use the same element twice),
                    and the numbers add up to the target, we have found the answer
                 */
                if(i != j && nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        throw new IllegalArgumentException("No two sum solution.");
    }
}
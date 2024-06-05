import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LargestSum {
    /**
     * Get the largest possible sum that can be obtained from a pair of values in the list. A number can't be added
     * to itself, unless there are duplicates.
     *
     * @param nums a list of ints.
     * @return the largest possible sum of separate numbers from nums.
     */
    public int bigSum(List<Integer> nums){
        Set<Integer> seen = new HashSet<>();
        int maxSum = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i).equals(nums.get(j)) && !seen.contains(nums.get(i))) {
                    int sum = nums.get(i) * 2; // Add the number to itself if it's a duplicate
                    maxSum = Math.max(maxSum, sum);
                    seen.add(nums.get(i));
                } else if (!nums.get(i).equals(nums.get(j))) {
                    int sum = nums.get(i) + nums.get(j);
                    maxSum = Math.max(maxSum, sum);
                }
            }
        }
        return maxSum;
    }
}

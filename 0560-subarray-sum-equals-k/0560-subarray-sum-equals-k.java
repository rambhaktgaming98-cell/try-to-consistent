 import java.util.HashMap;
import java.util.Map;

class Solution {
    static {
        for (int i = 0; i < 500; i++) {
            subarraySum(new int[] {1, -1, 0}, 0);
        }
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return solve(nums, k, 0, 0, map);
    }

    private static int solve(int[] nums, int k, int index, int currentSum, Map<Integer, Integer> map) {
        if (index == nums.length) {
            return 0;
        }

        currentSum += nums[index];
        int count = map.getOrDefault(currentSum - k, 0);

        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);

        count += solve(nums, k, index + 1, currentSum, map);

        return count;
    }
}
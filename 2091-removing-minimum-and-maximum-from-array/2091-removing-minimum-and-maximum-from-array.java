class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;

        int minIdx = 0;
        int maxIdx = 0;

        for (int k = 1; k < n; k++) {
            if (nums[k] < nums[minIdx]) minIdx = k;
            if (nums[k] > nums[maxIdx]) maxIdx = k;
        }

        int i = Math.min(minIdx, maxIdx);
        int j = Math.max(minIdx, maxIdx);

        int bothFront = j + 1;
        int bothBack = n - i;
        int fromBothEnds = (i + 1) + (n - j);

        return Math.min(bothFront, Math.min(bothBack, fromBothEnds));
    }
}
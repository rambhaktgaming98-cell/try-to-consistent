 class Solution {
    public int stoneGameVIII(int[] stones) {
        int totalSum = 0;
        for (int stone : stones) {
            totalSum += stone;
        }

        int dp = totalSum;
        for (int i = stones.length - 1; i > 1; i--) {
            totalSum -= stones[i];
            dp = Math.max(dp, totalSum - dp);
        }

        return dp;
    }
}
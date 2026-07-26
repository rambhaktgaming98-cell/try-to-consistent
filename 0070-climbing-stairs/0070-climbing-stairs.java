class Solution {
    public int climbStairs(int n) {
        if (n == 1)
            return n;
        if (n == 2)
            return n;

        int climb1 = 1;
        int climb2 = 2;
        for (int i = 3; i <= n; i++) {
            int current = climb1 + climb2;

            climb1 = climb2;
            climb2 = current;

        }
        return climb2;
    }
}
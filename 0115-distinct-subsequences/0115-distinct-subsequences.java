class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m < n) return 0;

        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            char sc = s.charAt(i);
            for (int j = n; j >= 1; j--) {
                if (sc == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return (int) dp[n];
    }
}
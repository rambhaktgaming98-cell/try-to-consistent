 class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        int n = s.length();
        
        long[] last = new long[26];
        long total = 0;

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            long newSubseq = (total + 1) % MOD;
            long diff = (newSubseq - last[idx] + MOD) % MOD;
            
            total = (total + diff) % MOD;
            last[idx] = newSubseq;
        }

        return (int) total;
    }
}
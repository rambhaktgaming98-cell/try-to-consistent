 import java.util.Arrays;

class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = n - 1; i >= 0; i--) {
            int[] curCount = Arrays.copyOf(count, 26);
            boolean prefixValid = true;

            for (int j = 0; j < i; j++) {
                int idx = target.charAt(j) - 'a';
                if (--curCount[idx] < 0) {
                    prefixValid = false;
                    break;
                }
            }

            if (!prefixValid) continue;

            int targetChar = target.charAt(i) - 'a';
            for (int c = targetChar + 1; c < 26; c++) {
                if (curCount[c] > 0) {
                    curCount[c]--;
                    StringBuilder ans = new StringBuilder();
                    ans.append(target, 0, i);
                    ans.append((char) ('a' + c));

                    for (int k = 0; k < 26; k++) {
                        while (curCount[k] > 0) {
                            ans.append((char) ('a' + k));
                            curCount[k]--;
                        }
                    }
                    return ans.toString();
                }
            }
        }

        return "";
    }
}
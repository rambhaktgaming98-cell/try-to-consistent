 import java.util.Arrays;

class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }

        int oddCount = 0;
        int oddChar = -1;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                oddChar = i;
            }
        }

        if (oddCount > 1) {
            return "";
        }

        int halfLen = n / 2;
        int[] halfCount = new int[26];
        for (int i = 0; i < 26; i++) {
            halfCount[i] = count[i] / 2;
        }

        int[] exactHalfCount = Arrays.copyOf(halfCount, 26);
        boolean canMatchPrefix = true;
        for (int i = 0; i < halfLen; i++) {
            int idx = target.charAt(i) - 'a';
            if (--exactHalfCount[idx] < 0) {
                canMatchPrefix = false;
                break;
            }
        }

        if (canMatchPrefix) {
            StringBuilder sb = new StringBuilder();
            sb.append(target, 0, halfLen);
            if (n % 2 != 0) {
                sb.append((char) ('a' + oddChar));
            }
            for (int i = halfLen - 1; i >= 0; i--) {
                sb.append(target.charAt(i));
            }
            String candidate = sb.toString();
            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        for (int i = halfLen - 1; i >= 0; i--) {
            int[] curHalfCount = Arrays.copyOf(halfCount, 26);
            boolean prefixValid = true;

            for (int j = 0; j < i; j++) {
                int idx = target.charAt(j) - 'a';
                if (--curHalfCount[idx] < 0) {
                    prefixValid = false;
                    break;
                }
            }

            if (!prefixValid) continue;

            int targetChar = target.charAt(i) - 'a';
            for (int c = targetChar + 1; c < 26; c++) {
                if (curHalfCount[c] > 0) {
                    curHalfCount[c]--;

                    StringBuilder left = new StringBuilder();
                    left.append(target, 0, i);
                    left.append((char) ('a' + c));

                    for (int k = 0; k < 26; k++) {
                        while (curHalfCount[k] > 0) {
                            left.append((char) ('a' + k));
                            curHalfCount[k]--;
                        }
                    }

                    StringBuilder full = new StringBuilder(left);
                    if (n % 2 != 0) {
                        full.append((char) ('a' + oddChar));
                    }
                    full.append(left.reverse());

                    return full.toString();
                }
            }
        }

        return "";
    }
}
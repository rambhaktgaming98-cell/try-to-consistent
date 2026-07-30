class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        int sign = 1;
        int num = 0;
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        if (i >= n)
            return 0;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }
        while (i < n) {
            char currentChar = s.charAt(i);
            if (currentChar >= '0' && currentChar <= '9') {
                int digit = currentChar - '0';

                if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && digit > 7)) {
                    if (sign == 1) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
                num = (num * 10) + digit;
            } else {
                break;
            }
            i++;
        }
        return num * sign;
    }
}

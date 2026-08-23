 class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int mid = n / 2;

        int leftSum = 0;
        int rightSum = 0;
        int leftQ = 0;
        int rightQ = 0;

        for (int i = 0; i < mid; i++) {
            if (num.charAt(i) == '?') {
                leftQ++;
            } else {
                leftSum += num.charAt(i) - '0';
            }

            if (num.charAt(i + mid) == '?') {
                rightQ++;
            } else {
                rightSum += num.charAt(i + mid) - '0';
            }
        }

        if ((leftQ + rightQ) % 2 == 1) {
            return true;
        }

        int sumDiff = leftSum - rightSum;
        int qDiff = rightQ - leftQ;

        return sumDiff * 2 != qDiff * 9;
    }
}
class Solution {
    public int findGCD(int[] nums) {
        int minVal = nums[0];
        int maxVal = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minVal)
                minVal = nums[i];
            if (nums[i] > maxVal)
                maxVal = nums[i];
        }  
        return gcd(minVal, maxVal);
    }
     private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
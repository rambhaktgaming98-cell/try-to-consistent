class Solution {
    public boolean uniformArray(int[] nums1) {
        int minVal = Integer.MAX_VALUE;
        int oddCount = 0;

        for (int i = 0; i < nums1.length; i++) {
            int x = nums1[i];
            if (x < minVal) {
                minVal = x;
            }
            oddCount += (x & 1);
        }

        return (minVal & 1) == 1 || oddCount == 0;
    }
}
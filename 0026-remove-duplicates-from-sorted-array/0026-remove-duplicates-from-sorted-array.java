class Solution {
    public int removeDuplicates(int[] nums) {
        int A=nums.length;
        if(A==0){
         return 0;
        }
        int i=0;
        for(int j=1;j<A;j++)
        if (nums[j] != nums[i]){
            i++;
            nums[i]=nums[j] ;
        }return i+1;
    }
}
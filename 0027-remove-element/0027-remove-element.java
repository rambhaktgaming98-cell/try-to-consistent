class Solution {
    public int removeElement(int[] nums, int val) {
        int A=nums.length;
        int i =0;
        for ( int j=0 ;j<A; j++){
        if (nums[j]!=val){    
        nums[i]=nums[j];
        i++;}
        
    } return i ;
  }  
}
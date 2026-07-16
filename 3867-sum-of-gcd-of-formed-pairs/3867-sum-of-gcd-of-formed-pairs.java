class Solution {
    public long gcdSum(int[] nums) {
        int A=nums.length;
        int prefix[] = new int[A];
        int maxSofar=0;
        for (int i=0 ; i < A;i++){
           maxSofar= Math.max( maxSofar,nums[i]);
          prefix[i] = C(nums[i], maxSofar);
           
        }
        Arrays.sort(prefix);

        int left=0;
        int right=A-1;
        long total=0;
        while(left < right){
         total = total + C(prefix[left], prefix[right]);
         left++;
         right--;
        }
        return total;}
        private int C(int a,int b){
            if(b==0){
            return a;
             }
            else{
                return C(b,a%b);
            }
        }
    
}
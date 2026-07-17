class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxval=0;
        for(int num : nums){
          maxval =Math.max(maxval,num);
    }
    long[] countpairs=new long[maxval+1];
    int numfreq []= new int[maxval+1];
    for (int num : nums){
        numfreq[num]++;
    }
    for (int i=1;i<=maxval;i++){
        long multiplecount=0;
        for (int j=i;j<=maxval;j+=i){
            multiplecount += numfreq[j];  
         
        countpairs[i]=multiplecount*(multiplecount-1)/2;
        }
    }
        for(int i=maxval;i>=1;i--)
        for (int j = 2 * i; j <= maxval; j += i)
        {
            countpairs[i]-=countpairs[j];
        }
    for (int i=1;i<=maxval;i++)
    {
        countpairs[i]+=countpairs[i-1];
    }
    int[] result=new int[queries.length];
    for(int q=0;q<queries.length;q++){
    long target=queries[q];
    int left = 1;
    int right = maxval;
    int bestbucket=maxval;
    while(left<=right){
        int mid = left + (right - left) / 2;
        if (countpairs[mid] > target) {  
            bestbucket = mid;
            right = mid - 1;
        }  else{
        left=mid+1;   
     }
    }
    result[q]=bestbucket;
    }
  return result;
    }
}

    

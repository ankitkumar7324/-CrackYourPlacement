class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int max = 0;
        int i=0;
        if(n==1){
            return nums[0];
        }
       while(i<n-1){
          int sum = nums[i];
          while(i<n-1 && nums[i]<nums[i+1]){
             sum+=nums[i+1];
             i++;
          }
          max = Math.max(max,sum);
          i++;
       } 
       return max;
    }
}
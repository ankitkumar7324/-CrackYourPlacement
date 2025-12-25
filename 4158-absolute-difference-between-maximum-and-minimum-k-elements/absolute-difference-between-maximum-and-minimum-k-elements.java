class Solution {
    public int absDifference(int[] nums, int k) {
        int n = nums.length;
        if(n==1){
            return 0;
        }
        Arrays.sort(nums);
        int max = 0;
        int min = 0;
        for(int i=0;i<k;i++){
            max += nums[n-1-i];
            min += nums[i];
        }
        return Math.abs(max-min);
    }
}
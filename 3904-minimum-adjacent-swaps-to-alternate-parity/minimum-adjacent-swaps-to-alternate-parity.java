class Solution {
    public int minswap(int nums[],int state){
        int n = nums.length;
        int minswaps = 0;
        int curr = 0;
        for(int i=0;i<n;i++){
            if(nums[i]%2==state){
                minswaps += Math.abs(i-curr);
                curr+=2;
            }
        }
        return minswaps;
    }
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int oddcnt=0,evencnt=0;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0) evencnt++;
            else oddcnt++;
        }
        if(Math.abs(evencnt-oddcnt)>1) return -1;
        if((evencnt-oddcnt)==1) return minswap(nums,0);
        else if((oddcnt-evencnt)==1) return minswap(nums,1);
        else return Math.min(minswap(nums,0),minswap(nums,1));
    }
}
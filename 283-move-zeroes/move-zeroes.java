class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int j=-1;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                j=i;
                break;
            }
        }
        if(j==-1) return;
        int m = j;
        int w = j+1;
        while(w<n){
            if(nums[w]!=0){
               int temp = nums[m];
               nums[m] = nums[w];
               nums[w] = temp;
               m++;
            }
            w++;
        }
        return;
    }
}
class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            int a = nums[i]%2;
            int b = nums[i+1]%2;
            if(a==b){
                return false;
            }
        }
        return true;
    }
}
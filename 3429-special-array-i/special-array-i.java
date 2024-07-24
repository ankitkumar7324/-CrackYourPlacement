class Solution {
    public boolean isArraySpecial(int[] nums) {
        if(nums.length <= 1)
        {
            return true;
        }
        int i=0;
        
        while(i<nums.length-1)
        {
            int j=i+1;
            if(nums[i]%2==0 && nums[j]%2==0)
            {
                return false;
            }
            else if(nums[i]%2!=0 && nums[j]%2!=0)
            {
                return false;
            }
            i++;
        }
        return true;
    }
}
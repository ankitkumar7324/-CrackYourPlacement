class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            int num = Math.abs(nums[i]);
            int idx=num-1;
            if(nums[idx]<0)
            {
                return num;
            }

            nums[idx]=-nums[idx];
        }
        return -1;
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length-1;i++)
        {
            map.put(nums[i],i);
            
        }

        for(int i=0;i<nums.length;i++)
        {
            int comp = target - nums[i];
            if(map.containsKey(comp) && map.get(comp)!=i)
            {
                return new int[]{i,map.get(comp)};
            }
        }
        return null;
        
    }
}
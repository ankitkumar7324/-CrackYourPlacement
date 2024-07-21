class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        int n= nums.length;
        for(int i=0;i<n;i++)
        {
            int num = Math.abs(nums[i]);
            int idx = num-1;
            if(nums[idx]<0)
            {
                answer.add(num);
            }

            nums[idx] *= -1;
        }
        return answer;
    }
}
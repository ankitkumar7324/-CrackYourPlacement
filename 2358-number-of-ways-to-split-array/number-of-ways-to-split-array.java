class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long sum = 0;
        long cnt = 0;

        // Calculate the total sum of the array
        for (int num : nums) {
            sum += num;
        }

        long leftSum = 0; // To track the sum of the left partition
        for (int i = 0; i < n - 1; i++) {
            leftSum += nums[i];
            long rightSum = sum - leftSum;

            // Check if the left sum is greater than or equal to the right sum
            if (leftSum >= rightSum) {
                cnt++;
            }
        }
        return (int) cnt; // Convert the result to int before returning
    }
}
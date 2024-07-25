class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int n = height.length;
        int j = n-1;
        int max=0;
        while(i<j)
        {
            if(height[i]<height[j])
            {
                max=Math.max(max,height[i]*(j-i));
                i++;
            }
            else
            {
                max=Math.max(max,height[j]*(j-i));
                j--;
            }
        }
        return max;
    }
}
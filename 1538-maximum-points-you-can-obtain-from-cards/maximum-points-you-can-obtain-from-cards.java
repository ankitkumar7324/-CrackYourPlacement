class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int maxsum = 0;
        int leftsum =0;
        int rightsum=0;
        
        for(int i=0;i<k;i++)
        {
            leftsum+=cardPoints[i];
            
        }
        maxsum = leftsum;
        int idx = cardPoints.length-1;
        for(int i=k-1;i>=0;i--)
        {
            leftsum-=cardPoints[i];
            rightsum+= cardPoints[idx];
            maxsum = Math.max(maxsum,leftsum + rightsum);
            idx--;
        }

        return maxsum;
    }
}
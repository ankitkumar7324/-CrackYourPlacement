class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int sum;
        int n = happiness.length;
        long result = 0;
        for(int i=0;i<k;i++){
            sum = happiness[n-1-i]-i;
            if(sum>=0){
                result += sum;
            }else{
                return result;
            }
        }
        return result;
    }
}
class Solution {
    public int[] minOperations(String boxes) {
        List<Integer> ones = new ArrayList<>();
        for(int i=0;i<boxes.length();i++){
            if(boxes.charAt(i)=='1'){
                ones.add(i);
            }
        }
        int n = boxes.length();
        int l = ones.size();
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<l;j++){
                ans[i] += Math.abs(ones.get(j)-i);
            }
        }
        return ans;
        
    }
}
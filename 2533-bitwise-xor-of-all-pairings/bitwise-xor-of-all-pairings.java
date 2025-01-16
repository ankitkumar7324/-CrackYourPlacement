class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int ans=0;
        if(n1%2==0 && n2%2==0){
            return 0;
        }else if(n1%2==1 && n2%2==1){
            for(int it : nums1){
                ans^=it;
            }
            for(int i : nums2){
                ans^=i;
            }
            
        }else{
            if(n1%2==0){
                for(int it : nums1){
                    ans^=it;
                }
            }else{
                for(int it : nums2){
                    ans^=it;
                }
            }
        }
        return ans;
    }
}
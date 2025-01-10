class Solution {
    public int[] word(String str){
        int cnt[] = new int[26];
        for(char ch : str.toCharArray()){
            cnt[ch-'a']++;
        }
        return cnt;
    }
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int count2[] = new int[26];
        for(String str : words2){
            int cnt[] = word(str);
            for(int i=0;i<26;i++){
                count2[i] = Math.max(count2[i],cnt[i]);
            }
        }

        List<String> ans = new ArrayList<>();
        for(String str : words1){
            int cnt[] = word(str);
            boolean isSubset = true;
            for(int i=0;i<26;i++){
                if(cnt[i]<count2[i]){
                    isSubset = false;
                    break;
                }
            }
            if(isSubset==true){

            ans.add(str);
            }

        }
        return ans;
    }
}
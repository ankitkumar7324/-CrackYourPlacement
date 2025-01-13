class Solution {
    public int minimumLength(String s) {
        
        int freq[] = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        for(int i=0;i<26;i++){
            while(freq[i]>=3){
                freq[i]-=2;
            }
        }
        int len = 0;
        for(int i=0;i<26;i++){
            len+=freq[i];
        }
        return len;

    }
}
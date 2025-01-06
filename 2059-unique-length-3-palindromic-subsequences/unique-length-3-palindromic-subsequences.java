class Solution {
    public int countPalindromicSubsequence(String s) {
        // Arrays to store first and last occurrence of each character
        HashMap<Character,Integer> firstOcc = new HashMap<>();
        HashMap<Character,Integer> lastOcc = new HashMap<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(!firstOcc.containsKey(ch)){
                firstOcc.put(ch,i);
            }
            lastOcc.put(ch,i);
        }
        int cnt=0;
        for(char ch : firstOcc.keySet()){
            int first = firstOcc.get(ch);
            int last = lastOcc.get(ch);
            if(first==last) continue;
            HashSet<Character> set = new HashSet<>();
            for(int j = first+1;j<last;j++){
                set.add(s.charAt(j));
            }
            cnt+=set.size();
        }
        return cnt;
    
    }
}
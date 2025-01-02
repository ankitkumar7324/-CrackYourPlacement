class Solution {
    // public boolean check(String str){
    //     char c1 = str.charAt(0);
    //     char c2 = str.charAt(str.length()-1);
    //     boolean left = false;
    //     boolean right = false;
    //     if(c1=='a' || c1 == 'e' || c1 == 'i' || c1 == 'o' || c1 == 'u'){
    //         left = true;
    //     }
    //     if(c2=='a' || c2 == 'e' || c2 == 'i' || c2 == 'o' || c2 == 'u'){
    //         right = true;
    //     }
    //     return left&&right;
    // }
    public boolean check(String str) {
        // Check if the word starts and ends with a vowel
        char c1 = str.charAt(0);
        char c2 = str.charAt(str.length() - 1);
        return (isVowel(c1) && isVowel(c2));
    }

    public boolean isVowel(char c) {
        // Check if the character is a vowel
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        // HashMap<Integer,Boolean> map = new HashMap<>();
        // for(int i=0;i<words.length;i++){
        //     if(check(words[i])==true){
        //         map.put(i,true);
        //     }else{
        //         map.put(i,false);
        //     }
        // }
        // int n= queries.length;
        // int[] ans = new int[n];
        // for(int i=0;i<queries.length;i++){
        //     int start = queries[i][0];
        //     int end = queries[i][1];
        //     int cnt=0;
        //     for(int st=start;i<=end;st++){
        //         if(map.containsKey(st)==true){
        //             cnt++;
        //             map.put(st,false);
        //         }
        //     }
        //     ans[i]=cnt;
            
        // }
        // return ans;
        
        int n = words.length;

        // Step 1: Build a prefix sum array
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (check(words[i]) ? 1 : 0);
        }

        // Step 2: Answer each query in O(1) time
        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            ans[i] = prefix[end + 1] - prefix[start];
        }

        return ans;
    }
}
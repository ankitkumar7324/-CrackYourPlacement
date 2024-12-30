class Solution {
    class Pair{
        String first;
        int second;
        public Pair(String first,int second){
            this.first = first;
            this.second = second;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord , 1));
        Set<String> st = new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            st.add(wordList.get(i));
        }
        st.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int step = q.peek().second;
            if(word.equals(endWord)) return step;
            q.remove();
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i]=ch;
                    String replacedWord = new String(replacedCharArray);
                    if(st.contains(replacedWord)){
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord,step+1));
                    }
                }
            }
        }
        return 0;
    }
}
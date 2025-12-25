class Solution {
    private int countVowels(String words,String vowels){
        int count = 0;
        for(char ch : words.toCharArray()){
            if(vowels.indexOf(ch)!=-1){
                count++;
            }
        }
        return count;
    }
    public String reverseWords(String s) {
        String words[] = s.trim().split(" ");
        String vowels = "aeiou";
        int count = countVowels(words[0],vowels);
        for(int i=1;i<words.length;i++){
            if(countVowels(words[i],vowels)==count){
                StringBuilder sb = new StringBuilder(words[i]);
                sb.reverse();
                words[i] = sb.toString();
            }
        }
        StringBuilder answer = new StringBuilder("");
        for(String word : words){
            answer.append(word);
            answer.append(" ");
        }
        return answer.toString().trim();
    }
}
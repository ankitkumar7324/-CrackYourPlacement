class Solution {
    private int countChars(String str, char ch) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == ch) {
                count++;
            }
        }
        return count;
    }
    public int maxScore(String s) {
        int max = 0;
        for(int i=1;i<s.length();i++){
            int leftZeros = countChars(s.substring(0, i), '0');
            int rightOnes = countChars(s.substring(i), '1');
            max = Math.max(max, leftZeros + rightOnes);
        }
        return max;
    }
}
class Solution {
    public int countPalindromicSubsequence(String s) {
        // Arrays to store first and last occurrence of each character
        int[] firstOccurrence = new int[26];
        int[] lastOccurrence = new int[26];
        
        // Initialize the arrays with -1
        for (int i = 0; i < 26; i++) {
            firstOccurrence[i] = -1;
            lastOccurrence[i] = -1;
        }
        
        // Fill first and last occurrence arrays
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (firstOccurrence[index] == -1) {
                firstOccurrence[index] = i;
            }
            lastOccurrence[index] = i;
        }
        
        // HashSet to store unique palindromic subsequences
        HashSet<String> uniquePalindromes = new HashSet<>();
        
        // Iterate through each character from 'a' to 'z'
        for (int i = 0; i < 26; i++) {
            if (firstOccurrence[i] != -1 && lastOccurrence[i] != -1 && firstOccurrence[i] < lastOccurrence[i]) {
                int start = firstOccurrence[i];
                int end = lastOccurrence[i];
                
                // Check characters between the first and last occurrence
                for (int j = start + 1; j < end; j++) {
                    char middleChar = s.charAt(j);
                    String palindrome = "" + (char) (i + 'a') + middleChar + (char) (i + 'a');
                    uniquePalindromes.add(palindrome);
                }
            }
        }
        
        // Return the size of the HashSet
        return uniquePalindromes.size();
    
    }
}
import java.util.*;

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int dp[][] = longestCommonSubsequence(str1, str2);
        StringBuilder s = new StringBuilder();
        int n = str1.length(), m = str2.length();
        int i = 0, j = 0;

        // Construct the shortest common supersequence
        while (i < n && j < m) {
            if (str1.charAt(i) == str2.charAt(j)) { 
                // If characters match, take it and move diagonally
                s.append(str1.charAt(i));
                i++; j++;
            } else {
                // Take the character from str1 or str2 based on LCS path
                if (i < n - 1 && dp[i + 1][j] == dp[i][j]) {
                    s.append(str1.charAt(i));
                    i++;
                } else {
                    s.append(str2.charAt(j));
                    j++;
                }
            }
        }

        // Add remaining characters
        while (i < n) s.append(str1.charAt(i++));
        while (j < m) s.append(str2.charAt(j++));

        return s.toString();
    }

    // Function to compute LCS DP table
    public int[][] longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        solve(text1, text2, 0, 0, dp);
        return dp;
    }

    // Memoized LCS function
    public int solve(String text1, String text2, int ind1, int ind2, int dp[][]) {
        int n = text1.length();
        int m = text2.length();
        if (ind1 == n || ind2 == m) return 0;
        if (dp[ind1][ind2] != -1) return dp[ind1][ind2];

        if (text1.charAt(ind1) == text2.charAt(ind2)) {
            return dp[ind1][ind2] = 1 + solve(text1, text2, ind1 + 1, ind2 + 1, dp);
        } else {
            int opt1 = solve(text1, text2, ind1, ind2 + 1, dp);
            int opt2 = solve(text1, text2, ind1 + 1, ind2, dp);
            return dp[ind1][ind2] = Math.max(opt1, opt2);
        }
    }
}
class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if (n < k)
            return false;

        int freq[] = new int[26];

        for (int i = 0; i < n; i++)
            freq[s.charAt(i) - 'a']++;

        int odd_count = 0;

        for (int p : freq)
            if (p % 2 == 1)
                odd_count++;

        if (odd_count > k)
            return false;

        return true;
    }
}
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true; // If both strings are already equal

        int count = 0;
        int first = -1, second = -1; // To store indices where characters differ

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count == 1) first = i;
                else if (count == 2) second = i;
                else return false; // More than 2 mismatches → cannot swap
            }
        }

        // Only return true if swapping s1[first] and s1[second] makes s1 == s2
        return count == 2 && 
               s1.charAt(first) == s2.charAt(second) && 
               s1.charAt(second) == s2.charAt(first);
    }
}

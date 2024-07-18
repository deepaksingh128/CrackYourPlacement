class Solution {
    // Using Sliding Window approach
    // t.c.=> O(n)  , s.c.=> O(n)
    
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int n = s.length();
        int i = 0;
        int j = 0;
        int maxLen = 0;
        int maxFreq = 0;

        while (j < n) {
            int len = j - i + 1;

            char rightChar = s.charAt(j);
            count.put(rightChar, count.getOrDefault(rightChar, 0) + 1);
            maxFreq = Math.max(maxFreq, count.get(rightChar));

            while ((j - i + 1) - maxFreq > k) {
                char leftChar = s.charAt(i);
                count.put(leftChar, count.get(leftChar) - 1);
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }

        return maxLen;
    }
}

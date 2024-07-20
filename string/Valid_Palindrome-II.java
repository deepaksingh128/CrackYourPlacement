class Solution {
    // Method 1:- Recursive solution
    // Method 2:- Two pointers

    public boolean validPalindrome(String s) {
        if (s.length() == 1) return true;

        return helper (s);
    }

    public boolean helper (String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char charLeft  = s.charAt(left);
            char charRight = s.charAt(right);

            if (charLeft != charRight) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }

            left ++;
            right --;
        }

        return true;
    }

    public boolean isPalindrome (String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left ++;
            right --;
        }
        return true;
    }
}

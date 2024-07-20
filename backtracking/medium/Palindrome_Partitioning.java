class Solution {
    // Solved Using Levels and options logic
    
    List<List<String>> res = new ArrayList<>();
    List<String> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        partitionHelper (s);
        return res;
    }

    public boolean isPalindrome (String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if (leftChar != rightChar) {
                return false;
            }
            left ++;
            right --;
        }

        return true;
    }

    public void partitionHelper (String s) {
        int n = s.length();
        
        if (n == 0) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i=0; i<n; i++) {
            String prefix = s.substring(0, i+1);
            String remainString = s.substring(i+1);

            if (isPalindrome (prefix)) {
                ans.add(prefix);
                partition (remainString);
                ans.remove(ans.size() - 1);
            }
        }
    }
}

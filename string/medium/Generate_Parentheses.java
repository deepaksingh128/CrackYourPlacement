class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n, 0, 0, res, "");
        return res;
    }

    public void helper (int n, int open, int close, List<String> res, String curr) {
        if (open == n && close == n) {
            res.add(curr);
            return;
        }

        if (open <= n) {
            curr += '(';
            helper (n, open+1, close, res, curr);
            curr = curr.substring(0, curr.length()-1);
        }

        if (close < open) {
            curr += ')';
            helper (n, open, close+1, res, curr);
            curr = curr.substring(0, curr.length()-1);
        }
    }
}

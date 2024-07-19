class Solution {
    // Same as subsets using backtracking
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        helper (n, res, new ArrayList<>(), k, 1);
        return res;
    }

    public void helper (int n, List<List<Integer>> res, List<Integer> ans, int k, int start) {
        if (ans.size() == k) {
            res.add(new ArrayList<>(ans));
        }

        for (int i=start; i<=n; i++) {

            ans.add(i);
            helper(n, res, ans, k, i + 1);
            ans.remove(ans.size() - 1);

        }
    }
}

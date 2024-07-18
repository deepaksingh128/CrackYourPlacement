class Solution {
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        return res;
    }

    public void helper(int[] nums, int idx, List<Integer> curr) {
        if(idx == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        // take 
        curr.add(nums[idx]);
        helper(nums, idx+1, curr);
        curr.remove(curr.size() - 1);

        // do not take
        helper(nums, idx+1, curr);

    } 
}

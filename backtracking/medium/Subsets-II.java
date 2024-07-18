class Solution {
  
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       List<List<Integer>> res = new ArrayList<>();
       Arrays.sort(nums);  // it will help in avoiding duplicate subsets

       helper(nums, res, new ArrayList<>(), 0); 
       return res;
    }

    void helper(int[] nums, List<List<Integer>> res, List<Integer> curr, int idx) {
        if(idx == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        // take
        curr.add(nums[idx]);
        helper(nums, res, curr, idx+1);
        curr.remove(curr.size()-1);

        // do not take :- when not taking, we will not take all that elements present
        // beacuse these will create duplicate subsets
        while(idx+1 < nums.length && nums[idx] == nums[idx+1]) {
            idx++;
        }
        helper(nums, res, curr, idx+1);
    }
}

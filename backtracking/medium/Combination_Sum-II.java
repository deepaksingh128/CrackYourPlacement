class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);  // helps in handling duplicates more conviniently
        List<List<Integer>> res = new ArrayList<>();

        helper(candidates, res, new ArrayList<>(), target, 0);
        return res;
    }

    public void helper(int[] candidates, List<List<Integer>> res, List<Integer> 
    tempList, int targetRemain, int start) {
        if (targetRemain == 0) {
            res.add(new ArrayList<>(tempList));
        }

        for (int i=start; i<candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }
            if (candidates[i] > targetRemain) {
                break;
            }

            tempList.add(candidates[i]);
            helper(candidates, res, tempList, targetRemain - candidates[i], i + 1);
            tempList.remove(tempList.size() -1);
        }
    }
}

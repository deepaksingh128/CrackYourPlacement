class Solution {
    long total = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        Map<Long, Integer> map = new HashMap<>();
        map.put(0l, 1);
        pathSumHelper(root, 0l, targetSum, map);  
        return (int)total;  
    }

    public void pathSumHelper (TreeNode node, long currSum, 
            int targetSum, Map<Long, Integer> map) {
        if (node == null) return;

        currSum += node.val;

        if (map.containsKey(currSum - targetSum)) {
            total += map.get(currSum - targetSum);
        }

        map.put (currSum, map.getOrDefault(currSum, 0) + 1);
        pathSumHelper (node.left, currSum, targetSum, map);
        pathSumHelper (node.right, currSum, targetSum, map);

        map.put (currSum, map.get(currSum) - 1);

        return;
    }
}

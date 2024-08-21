class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                tree.get(manager[i]).add(i);
            }
        }

        return dfs(headID, tree, informTime);
    }

    private int dfs(int employeeID, List<List<Integer>> tree, int[] informTime) {
        int maxTime = 0;
        for (int subordinate : tree.get(employeeID)) {
            maxTime = Math.max(maxTime, dfs(subordinate, tree, informTime));
        }
        return informTime[employeeID] + maxTime;
    }
}

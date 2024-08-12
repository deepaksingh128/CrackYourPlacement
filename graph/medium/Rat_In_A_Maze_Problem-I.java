class Solution {
    
    private ArrayList<String> res;
    
    public ArrayList<String> findPath(int[][] mat) {
        res = new ArrayList<>();
        int n = mat.length;
        
        if (mat[0][0] == 0 || mat[n-1][n-1] == 0) {
            return res;
        }
        
        
        boolean[][] vis = new boolean[n][n];
        
        
        dfs (0, 0, vis, mat, "");
        
        return res;
    }
    
    public void dfs (int i, int j, boolean[][] vis, int[][] mat, String str) {
        
        
        if (i == mat.length-1 && j == mat[0].length-1) {
            res.add(str);
            return;
        }
        
        vis[i][j] = true;
        
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        char[] dirChar = {'U', 'D', 'R', 'L'};
        
        for(int k=0; k<4; k++) {
            int newX = i + dir[k][0];
            int newY = j + dir[k][1];
            
            if(isSafe(newX, newY, mat) && vis[newX][newY] == false && mat[newX][newY] == 1){
                
                str += dirChar[k];
                dfs (newX, newY, vis, mat, str);
                str = str.substring(0, str.length() - 1);   // backtrack
            }
        }
        
        vis[i][j] = false;   // backtrack 
    }
    
    public boolean isSafe (int i, int j, int[][] mat) {
            return i >= 0 && i < mat.length && j >= 0 && j < mat[0].length;
    }    
}

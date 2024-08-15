class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    
    // Using BFS :- 
    
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        int[] dx = {-2, -2, -1, 1, -1, 1, 2, 2};
        int[] dy = {-1, 1, 2, 2, -2, -2, -1, 1};
        
        boolean[][] isVis = new boolean[N+1][N+1];
        Queue<Coordinates> q = new LinkedList<>();
        q.add(new Coordinates(KnightPos[0], KnightPos[1]));
        isVis[KnightPos[0]][KnightPos[1]] = true;
        
        
        int moveCount = 0;
        while (!q.isEmpty()) {
            int nodeAtCurrentBreadth = q.size();
            
            for (int count=0; count < nodeAtCurrentBreadth; count++) {
                Coordinates curr = q.poll();
                
                if (curr.x == TargetPos[0] && curr.y == TargetPos[1]) {
                    return moveCount;
                }
                
                for (int i=0; i<8; i++) {
                    int newX = curr.x + dx[i];
                    int newY = curr.y + dy[i];
                    
                    if (isValid(newX, newY, N) && isVis[newX][newY] == false) {
                        isVis[newX][newY] = true;
                        q.add (new Coordinates(newX, newY));
                    }
                }
            }
            
            moveCount ++;
        }
        
        return  moveCount;
    }
    
    boolean isValid (int x, int y, int N) {
        if (x <= 0 || y <= 0 || x > N || y > N) {
            return false;
        }
        return true;
    }
    
    class Coordinates {
        int x;
        int y;
        
        Coordinates (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

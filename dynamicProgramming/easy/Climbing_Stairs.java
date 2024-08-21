class Solution {
    // Method 2 :- (Bottom Up)
    //          Without extra space

    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        
        int a = 1;
        int b = 2;
        int c = a + b;

        for (int i=3; i<=n; i++) {
            c = a + b;
            a = b; 
            b = c;
        }

        return c;
    }
}

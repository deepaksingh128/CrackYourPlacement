

// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        
        int lo = 0;
        int hi = stalls[n-1] - stalls[0];
        int ans = 0;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (noOfCowsFind(stalls, mid) >= k) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid -1;
            }
        }
        
        return ans;
    }
    
    public static int noOfCowsFind (int[] stalls, int diff) {
        int noOfCows = 1;
        int currPos = 0;
        
        for (int i=1; i<stalls.length; i++) {
            int currDiff = stalls[i] - stalls[currPos];
            if (currDiff >= diff) {
                noOfCows ++;
                currPos = i;
            }
        }
        
        return noOfCows;
    } 
}

class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        Collections.sort(a);
        long ans = a.get(n-1) - a.get(0);
        
        for (int i=0; i<n-m+1; i++) {
            int currDiff = a.get(i+m-1) - a.get(i);
            ans = Math.min(ans, currDiff);
        }
        
        return ans;
    }
}

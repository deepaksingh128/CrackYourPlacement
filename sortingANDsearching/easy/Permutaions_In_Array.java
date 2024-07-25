class Solution {
    public boolean isPossible(long a[], long b[], int n, long k) {
        Arrays.sort(a);
        
        Long[] bLong = new Long[n];
        for (int i = 0; i < n; i++) {
            bLong[i] = b[i];
        }
        Arrays.sort(bLong, Collections.reverseOrder());
        
        for (int i = 0; i < n; i++) {
            if (a[i] + bLong[i] < k) {
                return false;
            }
        }
        
        return true;
    }
}

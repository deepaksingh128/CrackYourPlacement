class Solution {
    // Function to find minimum number of pages.
    public static long findPages(int n, int[] arr, int m) {
        int cumSum = 0;
        int max = Integer.MIN_VALUE;
        
        for (int i=0; i<n; i++) {
            cumSum += arr[i];
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        
        if (m > n) {
            return -1l;
        }
        
        if (m == 1) return cumSum;
        
        long ans = cumSum;
        int lo = max;
        int hi = cumSum;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (noOfStudentsRequired (arr, mid) <= m) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return ans;
    }
    
    public static int noOfStudentsRequired (int[] arr, int pages) {
        int noOfStudents = 1;
        int currPages = arr[0];
        
        for (int i=1; i<arr.length; i++) {
            if (currPages + arr[i] > pages) {
                noOfStudents ++;
                currPages = arr[i];
            } else {
                currPages += arr[i];
            }
        }
        
        return noOfStudents;
    }
    
};

    public static int lenOfLongSubarr (int A[], int N, int K) {
        // t.c.=> O(n*log(n))   , s.c.=> O(n)   , log(n) => HashMap worst case
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int maxLength = 0;
        int preSum = 0;
        
        for (int i=0; i<N; i++) 
        {
            preSum += A[i];
            
            if (preSum == K) {
                maxLength = i + 1;
            }
            
            if (map.containsKey(preSum - K)) {
                maxLength = Math.max(maxLength, i - map.get(preSum - K));
            }
            
            if (!map.containsKey(preSum)) {
                map.put(preSum, i);
            }
    
        }
        
        return maxLength;
    }
    
}

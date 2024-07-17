class Solution {
    // Using prefix sum 
    // leave the window of size k , and slide each time
    // Note:- We can solve this problem using TWO POINTER as well
  
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int max = 0;
       int[] prefix = new int[n];
       prefix[0] = cardPoints[0];

       // prefix sum
       for(int i=1; i<n; i++){
           prefix[i] = prefix[i-1] + cardPoints[i];
       }
       // special case
       if(k == n) return prefix[n-1];

       int notTake = 0;
       for(int i=0; i<=k; i++){
           int j = n-k-1+i;
           if(i == 0){
               notTake = prefix[j];
           }else{
               notTake = prefix[j] - prefix[i-1];    // sum of subarray we are going to remove
           }
           max = Math.max(max, prefix[n-1] - notTake);
           notTake = 0;
       }
       return max;
    }
}

class Solution 
{ 
	public static long[] productExceptSelf(int nums[], int n) 
	{
	    long[] ans = new long[n];
        long totalProduct = 1;
        int count = 0;
        
        for (int i=0; i<n; i++) {
            if (nums[i] != 0) {
                totalProduct *= nums[i];
            } else {
                count++;
            }
        }
        
        for (int i=0; i<n; i++) {
            if (nums[i] != 0 && count > 0) {
                ans[i] = 0;
            } else if (nums[i] == 0 && count > 1) {
                ans[i] = 0;
            } else if (nums[i] == 0 && count == 1) {
                ans[i] = totalProduct;
                
            } else {
                ans[i] = totalProduct / nums[i];
            }
        }
        
        
        return ans;
	} 
}

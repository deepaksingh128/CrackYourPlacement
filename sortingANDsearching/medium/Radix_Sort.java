class Solution
{
    static void radixSort(int arr[], int n) 
    { 
        int max = Integer.MIN_VALUE;
        
        for (int ele: arr) {
            if (ele > max) {
                max = ele;
            }
        }
        
        int exp = 1;
        
        while (exp <= max) {
            countSort (arr, exp);
            exp = exp * 10;
        }
    } 
    
    static void countSort (int[] arr, int exp) {
        int[] ans = new int[arr.length];
        
        // create a freq array
        int[] freqArr = new int[10];
        
        for (int i=0; i<arr.length; i++) {
            freqArr[(arr[i] / exp) % 10]++;
        }
        
        
        // convert freq array to prefix sum array
        for (int i=1; i<freqArr.length; i++) {
            freqArr[i] += freqArr[i-1];
        }
        
        
        // traverse the original array from last
        for (int i=arr.length-1; i>=0; i--) {
            int pos = freqArr[(arr[i] / exp) % 10] -1;
            ans[pos] = arr[i];
            freqArr[(arr[i] / exp) % 10] --;
        }
        
        // fill original array from ans array
        for (int i=0; i<arr.length; i++) {
            arr[i] = ans[i];
        }
        
    }
}

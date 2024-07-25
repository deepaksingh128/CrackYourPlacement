class Solution {
  // Another approach => Using HashMap
    public int findPair(int n, int x, int[] arr) {
        Arrays.sort(arr);  // Step 1: Sort the array

        for (int i = 0; i < n; i++) {  // Step 2: Iterate through the array
            if (binarySearch(arr, i, arr[i] + x) || binarySearch(arr, i, arr[i] - x)) {
                return 1;
            }
        }
        return -1;
    }
    
    // Helper method for binary search
    private boolean binarySearch(int[] arr, int currentIndex, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target && mid != currentIndex) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}

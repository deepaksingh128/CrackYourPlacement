class Solution {
    // t.c. => O(m + n)
    // s.c. => O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Idx = m - 1;
        int nums2Idx = n - 1;
        int sortedIdx = m + n - 1;

        while ( nums1Idx >= 0 && nums2Idx >= 0 ) {
            if ( nums1[nums1Idx] > nums2[nums2Idx] ) {
                nums1[sortedIdx] = nums1[nums1Idx];
                sortedIdx --;
                nums1Idx --;
            } else if ( nums1[nums1Idx] <= nums2[nums2Idx] ) {
                nums1[sortedIdx] = nums2[nums2Idx];
                sortedIdx --;
                nums2Idx --;
            }
        }

        while ( nums1Idx >= 0) {
            nums1[sortedIdx] = nums1[nums1Idx];
            nums1Idx --;
            sortedIdx --;
        }

        while ( nums2Idx >= 0) {
            nums1[sortedIdx] = nums2[nums2Idx];
            nums2Idx --;
            sortedIdx --;
        }
    }
}

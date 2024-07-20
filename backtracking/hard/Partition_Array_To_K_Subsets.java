class Solution
{
    public boolean isKPartitionPossible(int a[], int n, int k)
    {
		if (k == 1) return true;
		if (k > n) return false;
		
		int totalSum = 0;
		for (int i=0; i<n; i++) {
		    totalSum += a[i];
		}
		if (totalSum % k != 0) {
		    return false;
		}
		
		int[] sumOfSubsets = new int[k];
		
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for (int i=0; i<k; i++) {
		    ans.add(new ArrayList<>());
		}
		
		return helper(a, k, ans, sumOfSubsets, 0, 0);
    }
    
    public boolean helper (int[] a, int k, ArrayList<ArrayList<Integer>> ans, int[] sumOfSubsets, int noOfSubsets, int i) {
        
        if (i == a.length) {
            if (noOfSubsets == k) {
                boolean flag = true;
                for (int j=0; j<sumOfSubsets.length-1; j++) {
                    if (sumOfSubsets[j] != sumOfSubsets[j+1]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }
            return false;
        }
        
        for (int j=0; j<ans.size(); j++) {
            if (ans.get(j).size() > 0) {
                ans.get(j).add(a[i]);
                sumOfSubsets[j] += a[i];
                if (helper(a, k, ans, sumOfSubsets, noOfSubsets, i + 1)) {
                    return true;
                }
                ans.get(j).remove(ans.get(j).size()-1);
                sumOfSubsets[j] -= a[i];
            } else {
                ans.get(j).add(a[i]);
                sumOfSubsets[j] += a[i];
                if (helper(a, k, ans, sumOfSubsets, noOfSubsets + 1, i + 1)) {
                    return true;
                }
                ans.get(j).remove(ans.get(j).size()-1);
                sumOfSubsets[j] -= a[i];
                break;
            }
        }
        
        return false;
    }
    
}

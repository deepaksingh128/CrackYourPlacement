class Solution
{ 
    static String maxNumber = "";
    
    public static String findMaximumNum(String str, int k){
            maxNumber = str;           
            helper(str.toCharArray(), k, 0);
            return maxNumber;
    }
    
    public static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
    
    public static void helper(char[] str, int k, int index) {
        if (k == 0) {
            return;
        }
        for (int i=index; i<str.length-1; i++) {
            
            for (int j=i+1; j<str.length; j++) {
                
                if (str[j] >  str[i] ) {
                    swap(str, i, j);
                               
                    String currentNumber = new String(str);
                    if (currentNumber.compareTo(maxNumber) > 0) {
                        maxNumber = currentNumber;
                    }
                    
                    helper (str, k - 1, index + 1);
                    // backtrack
                    swap(str, i, j);
                }
            }
        }
    }
}

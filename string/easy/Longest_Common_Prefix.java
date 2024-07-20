class Solution {
    public String longestCommonPrefix(String[] strs) {
        int j=0;
        int n = strs.length;
        
        // find length of min length string in the array
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int len = strs[i].length();
            min = Math.min(min, len);
        } 
        int k;
        boolean flag = false;
        for(k=0; k<min; k++){
            for(int p=0; p<n-1; p++){
                if(strs[p].charAt(k) != strs[p+1].charAt(k)){
                     flag = true;
                     break;
                }
            }
            if(flag == true){
                break;
            }
        }
        StringBuilder sb = new StringBuilder("");
        for(int s=0; s<k; s++){
            sb.append(strs[0].charAt(s));
        }

        return sb.toString();
    }
}

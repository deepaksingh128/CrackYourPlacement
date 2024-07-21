class Solution {

    public String reverseWords(String s) {
      StringBuilder sb = new StringBuilder();
      StringBuilder curr = new StringBuilder();
      int n = s.length();
      int i = n-1;
      
      // removing trailing spaces
      while(i >= 0 && s.charAt(i) == ' '){
          i--;
      }

      while(i >= 0){
          while(i >= 0 && s.charAt(i) != ' '){
              char ch = s.charAt(i);
              curr.append(ch);
              i--;
          }

          if(sb.length() != 0){
              sb.append(" "+curr.reverse());
          }else{
              sb.append(curr.reverse());
          }

          curr.delete(0,curr.length());
          i--;
          // remove extra spaces
          while(i >= 0 && s.charAt(i) == ' '){
              i--;
          }
      }
      return sb.toString();
    }
}

class Solution {
    public int evalRPN(String[] tokens) {
        // Using stack :- t.c.=> O(n),   s.c.=> O(n)
        
        ArrayDeque<Integer> st = new ArrayDeque<>();

        for (int i=0; i<tokens.length; i++) {

            if (isOperator(tokens[i])) {
                int secondOperand = st.pop();
                int firstOperand = st.pop();

                int ans = 0;

                switch (tokens[i]) {
                    case "+" :
                        ans = firstOperand + secondOperand;
                        break;
                    case "-" :
                        ans = firstOperand - secondOperand;
                        break;
                    case "*" :
                        ans = firstOperand * secondOperand;
                        break;
                    case "/" :
                        ans = firstOperand / secondOperand;
                        break;
                }
                st.push (ans);
            } else {
                st.push (Integer.parseInt(tokens[i]));
            }
        }

        return st.peek();
    }

    public boolean isOperator (String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"); 
    }
}

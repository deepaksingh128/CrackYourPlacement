class MyQueue {
    // Method 2 :- Amortised

    ArrayDeque<Integer> input = new ArrayDeque<>();
    ArrayDeque<Integer> output = new ArrayDeque<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        if (!output.isEmpty()) {
            return output.pop();
        } else {
            while (!input.isEmpty()){
                output.push (input.pop());
            }
            if (!output.isEmpty()) {
                return output.pop();
            } else {
                return -1;
            }
        }
    }
    
    public int peek() {
        if (!output.isEmpty()) {
            return output.peek();
        } else {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
            if (!output.isEmpty()) {
                return output.peek();
            } else {
                return -1;
            }
        }
    }
    
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}

class twoStacks {
    int [] data;
    int size;
    int top1;
    int top2;
    
    twoStacks() {
        size = 100;      // from the given constraints
        data = new int[size];
        top1 = -1;
        top2 = data.length;
    }

    // Function to push an integer into the stack1.
    void push1(int x) {
        top1 ++;
        data[top1] = x;
    }

    // Function to push an integer into the stack2.
    void push2(int x) {
        top2 --;
        data[top2] = x;
    }

    // Function to remove an element from top of the stack1.
    int pop1() {
        if (top1 == -1) return -1;
        int val = data[top1--];
        return val;
    }

    // Function to remove an element from top of the stack2.
    int pop2() {
        if (top2 == data.length) return -1;
        int val = data[top2++];
        return val;
    }
}

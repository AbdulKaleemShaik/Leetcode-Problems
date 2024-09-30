class CustomStack {

    int maxSize;
    int top = -1;
    int[] stack;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (isFull())
            return;
        stack[++top] = x;

    }

    public int pop() {
        if (!isEmpty()) {
            return stack[top--];
        }
        return -1;
    }

    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, maxSize); i++) {
            stack[i] = stack[i] + val;
        }

    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
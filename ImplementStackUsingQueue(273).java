import java.util.Stack;

class MyQueue {
    Stack<Integer> inst;
    Stack<Integer> que;

    public MyQueue() {
        inst = new Stack<>();
        que = new Stack<>();
    }

    public void push(int x) {
        inst.push(x);
    }

    public int pop() {
        if (que.empty()) {
            while (!inst.isEmpty()) {
                que.push((inst.pop()));
            }
        }
        return que.pop();
    }

    public int peek() {
        if (que.empty()) {
            while (!inst.isEmpty()) {
                que.push((inst.pop()));
            }
        }
        return que.peek();

    }

    public boolean empty() {
        return que.isEmpty() && inst.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
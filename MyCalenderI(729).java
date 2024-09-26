class MyCalendar {

    Tree root;

    public class Tree {
        int start;
        int end;
        Tree left;
        Tree right;

        Tree(int a, int b) {
            this.start = a;
            this.end = b;
        }
    }

    public MyCalendar() {
        root = null;
    }

    public boolean book(int start, int end) {

        if (root == null) {
            root = new Tree(start, end);
            return true;
        }
        return insert(root, start, end);
    }

    private boolean insert(Tree node, int start, int end) {
        if (node == null) {
            return false;
        }
        if (end <= node.start) {
            if (node.left == null) {
                node.left = new Tree(start, end);
                return true;
            } else
                return insert(node.left, start, end);
        }
        if (start >= node.end) {
            if (node.right == null) {
                node.right = new Tree(start, end);
                return true;
            } else
                return insert(node.right, start, end);
        }
        return false;
    }
}
/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
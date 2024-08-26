


import java.util.ArrayList;
import java.util.List;

class Solution {
    // public List<Integer> postorder(Node root) {
    // List<Integer> ans = new ArrayList<>();
    // Stack<Node> st1 = new Stack<>();
    // Stack<Node> st2 = new Stack<>();
    // if (root == null)
    // return ans;
    // st1.add(root);
    // Node curr = root;
    // while (!st1.isEmpty()) {
    // curr = st1.pop();
    // st2.add(curr);
    // for (Node i : curr.children) {
    // st1.add(i);
    // }
    // }
    // while (!st2.isEmpty()) {
    // ans.add(st2.pop().val);
    // }

    // return ans;
    // }
    public List<Integer> postorder(Node root) {
        ArrayList<Integer> a = new ArrayList<>();
        postorder(root, a);
        return a;
    }

    void postorder(Node root, ArrayList<Integer> a) {
        if (root != null) {
            for (int i = 0; i < root.children.size(); i++) {
                postorder(root.children.get(i), a);
            }
            a.add(root.val);
        }
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
package leetcode_challenges.trees;

public class InsertNode {

    public static TreeNode insert(TreeNode head, int data) {
        if (head == null) {
            var node = new TreeNode();
            node.data = data;
            return node;
        }

        if (head.data < data) {
            head.right = insert(head.right, data);
        } else {
            head.left = insert(head.left, data);
        }

        return head;
    }
}

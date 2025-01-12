package leetcode_challenges.trees;

import leetcode_challenges.linked_list.ListNode;

import java.util.List;

public class PrintLeafNodes {

    private static void printLeafNode(TreeNode head) {
        if (head == null) return;

        if (head.left == null && head.right == null) {
            System.out.println(head.data);
        }

        if (head.left != null) {
            printLeafNode(head.left);
        }

        if (head.right != null) {
            printLeafNode(head.right);
        }
    }

    public static void main(String[] args) {
        var nodes = List.of(100, 80, 50, 90, 30, 60, 90, 85, 120, 110, 108, 115, 140, 150);

        var head = new TreeNode();
        head.data = nodes.get(0);

        for (var node : nodes) {
            head = InsertNode.insert(head, node);
        }
        printLeafNode(head);
    }
}

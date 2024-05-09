package binarytree.leetcode;

public class LowestDiff {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6));
        System.out.println(getMinimumDifference(node));
    }

    public static int getMinimumDifference(TreeNode root) {
        preOrderTraversal(root);
        return MIN;
    }

    public static Integer MIN = Integer.MAX_VALUE;

    public static Integer first = Integer.MAX_VALUE;
    public static Integer second = Integer.MAX_VALUE;


    public static void preOrderTraversal(TreeNode node) {
        if (node == null || node.val > second) {
            return;
        }
        if (node.val < first) {
            second = first;
            first = node.val;

        }
        if (node.val < second && node.val > first) {
            second = node.val;
        }
        if ((second - first) < MIN) {
            MIN = second - first;
        }
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
}
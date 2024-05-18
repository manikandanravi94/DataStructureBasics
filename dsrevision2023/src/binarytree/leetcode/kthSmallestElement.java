package binarytree.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class kthSmallestElement {
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

    public static List<Integer> integers;

    public static int output = 0;

    public static int count =0;

    public static int kthSmallest(TreeNode root, int k) {
        integers = new ArrayList<>();
//            loadIntegers(root);
//           integers.sort(Comparator.comparing(Integer::intValue));
//           return integers.get(k-1);
        count=0;
        output=0;
        inOrderTraversal(root,k);
        return output;
    }

    public static void inOrderTraversal(TreeNode root, int k){
        if(root==null || k==count){
            return;
        }
        inOrderTraversal(root.left,k);
        count++;
        if(count==k){
            output=root.val;
        }

        inOrderTraversal(root.right,k);
    }


    public static void loadIntegers(TreeNode root) {
        if (root == null) {
            return;
        }
        integers.add(root.val);
        loadIntegers(root.left);
        loadIntegers(root.right);
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        System.out.println(kthSmallest(node, 1));
        TreeNode node1 = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6));
        System.out.println(kthSmallest(node, 3));
    }

}

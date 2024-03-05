package binarytree;

public class BinaryTreeIMPL {

    private Node current;

    public void add(int value) {
        Node node = new Node(value, null, null);
        if (isNodeEmpty(current)) {
            current = node;
            return;
        }
        Node temp = current;
        while (temp != null) {
            if (temp.getValue() > value) {
                if (isNodeEmpty(temp.getLeftChild())) {
                    temp.setLeftChild(node);
                    break;
                }
                temp = temp.getLeftChild();
            } else {
                if (isNodeEmpty(temp.getRightChild())) {
                    temp.setRightChild(node);
                    break;
                }
                temp = temp.getRightChild();
            }
        }
    }

    public boolean find(int value) {
        Node temp = current;

        while (temp != null) {
            if (temp.getValue() == value) {
                return true;
            }

            if (temp.getValue() > value) {
                temp = temp.getLeftChild();
            } else {
                temp = temp.getRightChild();
            }
        }
        return false;
    }

    public void print(Node node) {
        System.out.println(node.getValue());
        if (node.getLeftChild() != null) {
            print(node.getLeftChild());
        }
        if (node.getRightChild() != null) {
            print(node.getRightChild());
        }
    }

    public void preOrderTraversal(Node node) {
        if (isNodeEmpty(node))
            return;
        System.out.println(node.getValue());
        preOrderTraversal(node.getLeftChild());
        preOrderTraversal(node.getRightChild());
    }

    public void inOrderTraversal(Node node) {
        if (isNodeEmpty(node))
            return;
        inOrderTraversal(node.getLeftChild());
        System.out.println(node.getValue());
        inOrderTraversal(node.getRightChild());
    }

    public void postOrderTraversal(Node node) {
        if (isNodeEmpty(node))
            return;
        postOrderTraversal(node.getLeftChild());
        postOrderTraversal(node.getRightChild());
        System.out.println(node.getValue());
    }

    private static boolean isNodeEmpty(Node node) {
        return node == null;
    }

    public int height(Node node){
        if(isNodeEmpty(node))
            return 0;
        if(isNodeEmpty(node.getLeftChild())&& isNodeEmpty(node.getRightChild())){
            return 0;
        }
        return 1+Math.max(height(node.getLeftChild()),height(node.getRightChild()));
    }

    public int minValue(Node node){
        if(node==null){
            return Integer.MAX_VALUE;
        }
        if(node.getLeftChild()==null && node.getRightChild()==null){
            return node.getValue();
        }
        return Math.min(Math.min(minValue(node.getLeftChild()),minValue(node.getRightChild())), node.getValue());
    }

    public static void main(String[] args) {
        BinaryTreeIMPL binaryTree = new BinaryTreeIMPL();
        binaryTree.add(7);
        binaryTree.add(5);
        binaryTree.add(6);
        binaryTree.add(3);
        binaryTree.add(4);
        binaryTree.add(8);
        binaryTree.print(binaryTree.current);
        System.out.println(binaryTree.find(3));
        System.out.println("Pre order traversal");
        binaryTree.preOrderTraversal(binaryTree.current);
        System.out.println("in order traversal");
        binaryTree.inOrderTraversal(binaryTree.current);
        System.out.println("post order traversal");
        binaryTree.postOrderTraversal(binaryTree.current);
        System.out.println("height of the binary tree : " + binaryTree.height(binaryTree.current));
        System.out.println("min value in a tree" + binaryTree.minValue(binaryTree.current));
    }
}

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

    public int height(Node node) {
        if (isNodeEmpty(node))
            return 0;
        if (isNodeEmpty(node.getLeftChild()) && isNodeEmpty(node.getRightChild())) {
            return 0;
        }
        return 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

    public int minValue(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        if (isNodeEmpty(node.getLeftChild()) && isNodeEmpty(node.getRightChild())) {
            return node.getValue();
        }
        return Math.min(Math.min(minValue(node.getLeftChild()), minValue(node.getRightChild())), node.getValue());
    }

    public boolean equals(BinaryTreeIMPL tree) {
        return equals(this.current, tree.current);
    }

    private boolean equals(Node first, Node second) {
        if (isNodeEmpty(first) && isNodeEmpty(second)) {
            return true;
        }
        if (isNodeEmpty(first) || isNodeEmpty(second) || first.getValue() != second.getValue()) {
            return false;
        }
        if (!equals(first.getLeftChild(), second.getLeftChild()) || !equals(first.getRightChild(), second.getRightChild())) {
            return false;
        }
        return true;
    }

    public boolean isValidBinaryTree() {
        if (isNodeEmpty(this.current)) {
            return true;
        }
        isTreeValid(Integer.MIN_VALUE, this.current, Integer.MAX_VALUE);
        return true;
    }

    public boolean isTreeValid(Integer min, Node node, Integer max) {
        if (!(min < node.getValue() && node.getValue() > max)) {
            return false;
        }
        boolean isLeftLess = true;
        boolean isRightMore = true;
        if (!isNodeEmpty(node.getLeftChild())) {
            isLeftLess = isTreeValid(Integer.MIN_VALUE, node.getLeftChild(), node.getValue());
        }
        if (!isNodeEmpty(node.getRightChild())) {
            isRightMore = isTreeValid(node.getValue(), node.getRightChild(), Integer.MAX_VALUE);
        }
        if(!isLeftLess || !isRightMore){
            return false;
        }
        return true;
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
        BinaryTreeIMPL binaryTree1 = new BinaryTreeIMPL();
        binaryTree1.add(7);
        binaryTree1.add(5);
        binaryTree1.add(6);
        binaryTree1.add(2);
        binaryTree1.add(4);
        binaryTree1.add(8);
        System.out.println(binaryTree.equals(binaryTree1));

        System.out.println(binaryTree1.isValidBinaryTree());
    }
}

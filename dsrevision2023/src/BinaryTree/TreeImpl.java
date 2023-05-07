package BinaryTree;

/*
hints.. always while condition to check current!=null
current.leftchild!=null assign the value vice versa for bigger value
 */
public class TreeImpl {

    private Node root;

    public void insert(int value) {
        if (root == null) {
            this.root = new Node(value, null, null);
        } else {
            Node current = root;
            while (current != null) {
                if (value < current.value) {
                    if (current.leftChild == null) {
                        current.leftChild = new Node(value, null, null);
                        break;
                    }
                    current = current.leftChild;
                } else {
                    if (current.rightChild == null) {
                        current.rightChild = new Node(value, null, null);
                        break;
                    }
                    current = current.rightChild;
                }
            }

        }

    }

    /*
        check for the current != null if the value is less assign the left child to current and iterate vice versa for right child
     */
    public boolean find(int value) {
        Node current = this.root;
        while (current != null) {
            if (current.value == value)
                return true;
            if (current.value > value) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }
        return false;
    }

    public void preOrderTraversal(Node node) {
        System.out.println(node.value);
        preTraversal(node.leftChild);
        preTraversal(node.rightChild);
    }

    public void postOrderTraversal(Node node) {
        postTraversal(node.leftChild);
        postTraversal(node.rightChild);
        System.out.println(node.value);
    }

    public void inOrderTraversal(Node node) {
        inTraversal(node.leftChild);
        System.out.println(node.value);
        inTraversal(node.rightChild);

    }

    private void preTraversal(Node node) {
        if (node != null) {
            preOrderTraversal(node);
        }
    }

    private void postTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node);
        }
    }

    private void inTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node);
        }
    }

    public static void main(String[] args) {
        TreeImpl tree = new TreeImpl();
        tree.insert(7);
        tree.insert(4);
        tree.insert(1);
        tree.insert(10);
        tree.insert(8);
        tree.insert(9);
        tree.insert(3);
        System.out.println(tree.find(3));
        System.out.println("Pre Order Traversal");
        tree.preOrderTraversal(tree.root);
        System.out.println("Post Order Traversal");
        tree.postOrderTraversal(tree.root);
        System.out.println("in Order Traversal");
        tree.inOrderTraversal(tree.root);


    }
}

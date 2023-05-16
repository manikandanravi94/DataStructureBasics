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
/*
below is one way not to use too many iterative methods to solve the pre order
 */
    public void preOrderTraversal(Node node) {
        if(node==null)
            return;
        System.out.println(node.value);
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
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

    public int height(){
        return height(this.root);
    }

    private int height(Node node) {
        if(node==null)
            return -1;
        if(isLeaf(node)){
            return 0;
        }
        return 1+Math.max(height(node.leftChild),height(node.rightChild));
    }

    /*
    To find a minimum value in a binary tree, we have to do the post order traversal. if it is a binary search tree, we can take return the left most value
     */
    public void min(){
        System.out.println(getMinimumValue(this.root));
    }

    private int getMinimumValue(Node node){
        if(node==null){
            return Integer.MAX_VALUE;
        }
        if(isLeaf(node)){
            return node.value;
        }

        return Math.min(Math.min(getMinimumValue(node.leftChild),getMinimumValue(node.rightChild)), node.value);

    }

    private static boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
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
        System.out.println("height of the tree: "+tree.height());
        tree.min();

    }
}

package com.mani.tree;

public class TreeImpl {

    private Node root;
    private Node current;

    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value, Node leftChild, Node rightChild) {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TreeImpl{" +
                "root=" + root +
                '}';
    }

    private void insert(int element){
        Node node = new Node( element,null,null);
        if(this.root ==null){
         this.root=node;
        return;
        }
        this.current=this.root;
        //boolean flag=true;
        while(this.current!=null){
           // this.previous=this.current;
            if(this.current.getValue()>element){
                if(this.current.getLeftChild()==null){
                    this.current.setLeftChild(node);
                    break;
                }
                this.current=this.current.getLeftChild();
            }else if(this.current.getValue()<element){
                if(this.current.getRightChild()==null){
                    this.current.setRightChild(node);
                    break;
                }
                this.current=this.current.getRightChild();
            }else{
                return;
            }
        }
//        this.current= node;
//        if(flag){
//        this.previous.setLeftChild(this.current);}else{
//            this.previous.setRightChild(this.current);
//        }
    }
    private boolean find(int element){
        this.current=this.root;
        while(this.current!=null){
            if(this.current.getValue()==element){
                return true;
            }
            if(this.current.getValue()>element){
                this.current=this.current.getLeftChild();
            }else{
                this.current=this.current.getRightChild();
            }
        }
        return false;
    }

    public void preOrderTraversal(){
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.getValue());
        preOrderTraversal(root.getLeftChild());
        preOrderTraversal(root.getRightChild());
    }

    public void inOrderTraversal(){
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node root){
        if(root==null){
            return;
        }
        inOrderTraversal(root.getLeftChild());
        System.out.println(root.getValue());
        inOrderTraversal(root.getRightChild());
    }
    public void postOrderTraversal(){
        postOrderTraversal(root);
    }
    private void postOrderTraversal(Node root){
        if(root==null){
            return;
        }
        postOrderTraversal(root.getLeftChild());
        postOrderTraversal(root.getRightChild());
        System.out.println(root.getValue());
    }

    public void height(){
        System.out.println("height of a tree: "+height(root));
    }

    private int height(Node root) {
        if(root==null){
            return -1;
        }
        if(root.getLeftChild()==null&&root.getRightChild()==null){
            return 0;
        }
        return 1+ Math.max(height(root.getLeftChild()),height(root.getRightChild()));
    }
    public int min(){
        return min(root);
    }


    private int min(Node root){
        if(root== null){
            throw new IllegalArgumentException("Expects a valid params");
        }
        Node current =root;
        Node last=current;
        while(current!=null){
            last=current;
            current=current.getLeftChild();
        }
        return last.getValue();
    }

    public boolean equals(Node other){
        return equals(root,other);
    }

    private boolean equals(Node treeRoot1, Node treeRoot2){
        if(treeRoot1==null||treeRoot2==null){
            return true;
        }
        if(treeRoot1.getValue()==treeRoot2.getValue()&&equals(treeRoot1.getLeftChild(),treeRoot2.getLeftChild())
        &&equals(treeRoot1.getRightChild(),treeRoot2.getRightChild())){
             return true;
        }
        return false;
    }

    public Node getRoot() {
        return root;
    }

    public boolean isBinarySearchTree(){

        return validateBinaryTree(root, Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean validateBinaryTree(Node root, int min, int max){
        if(root==null)
            return true;

        if(root.getValue()<min || root.getValue()>max)
        return false;

         return validateBinaryTree(root.getLeftChild(),Integer.MIN_VALUE, root.value-1)&&
                 validateBinaryTree(root.getRightChild(), root.value+1,Integer.MAX_VALUE);
    }

    public void kthNode(int distance){
        kthNode(root, distance);
    }

    private void kthNode(Node root, int distance){
        if(root==null){
            return;
        }
        if(distance==0)
        {
            System.out.println(root.getValue());
        }
        int temp=--distance;
        kthNode(root.getLeftChild(), temp);
        kthNode(root.getRightChild(), temp);
    }

    public static void main(String[] args) {
         TreeImpl tree = new TreeImpl();
         tree.insert(7);
         tree.insert(4);
         tree.insert(8);
         tree.insert(3);
        tree.insert(6);
        tree.insert(10);
        TreeImpl tree1 = new TreeImpl();
        tree1.insert(7);
        tree1.insert(4);
        tree1.insert(8);
        tree1.insert(3);
        tree1.insert(6);
        tree1.insert(10);
        System.out.println(tree.find(7));
        tree.preOrderTraversal();
        System.out.println("inorder traversal");
        tree.inOrderTraversal();
        System.out.println("post traversal");
        tree.postOrderTraversal();
        tree.height();
        System.out.println("min value in a tree: "+tree.min());
        System.out.println(tree.equals(tree1.getRoot()));
        System.out.println(tree.isBinarySearchTree());
        tree.kthNode(2);
    }
}

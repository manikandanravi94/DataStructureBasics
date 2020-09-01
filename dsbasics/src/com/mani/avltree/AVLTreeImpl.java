package com.mani.avltree;

public class AVLTreeImpl {

    private AVLTreeNode root;

    public void insert(int element){
       root= insert(root, element);
        System.out.println("value of root" +root);
    }

    private AVLTreeNode insert(AVLTreeNode root, int element){
        if(root==null){
            return new AVLTreeNode(element);
        }
        if(root.getValue()>element){
           root.leftChild= insert(root.getLeftChild(),element);
        }else{
            root.rightChild=insert(root.getRightChild(),element);
        }
        System.out.println("height of left child:" +height(root.getLeftChild()));
        System.out.println("height of right child:" +height(root.getRightChild()));
        System.out.println("height to be set on the field :"+(Math.max(height(root.getLeftChild()),height(root.getRightChild()))+1));
        setRootHeight(root);
        root=balance(root);
        return root;
    }

    private void setRootHeight(AVLTreeNode node){
        node.setHeight(Math.max(height(node.getLeftChild()),height(node.getRightChild()))+1);
    }

    private AVLTreeNode balance(AVLTreeNode root){
        AVLTreeNode newRoot = root;
        if(isLeftHeavy(root)){
            System.out.println(root.getValue()+" is left heavy");
              if(balanceFactor(root.getLeftChild())<0){
                System.out.println(root.getLeftChild().getValue()+" needs a left rotation");
                System.out.println(root.getValue()+" needs a right rotation");
                newRoot.setLeftChild(leftRotate(root.getLeftChild()));
            }
              newRoot=rightRotate(root);
        }
        else if(isRightHeavy(root)){
            System.out.println(root.getValue()+" is right heavy");
            if(balanceFactor(root.getRightChild())>0){
                System.out.println(root.getRightChild().getValue()+" needs a right rotation");
                System.out.println(root.getValue()+" needs left rotation");
               newRoot.setRightChild(rightRotate(root.getRightChild()));
                System.out.println(root);
            }
            newRoot=leftRotate(root);
        }
        return newRoot;
    }

    private int balanceFactor(AVLTreeNode root) {
        int h=height(root.getLeftChild())-height(root.getRightChild());
        System.out.println("calculated balance factor: "+root+"value"+h);
        return h;
    }
    private boolean isRightHeavy(AVLTreeNode root){
         return balanceFactor(root)<-1;
    }
    private boolean isLeftHeavy(AVLTreeNode root){
        return balanceFactor(root)>1;
    }

    private int height(AVLTreeNode node){
        return (node==null)? -1:node.getHeight();
    }

    private AVLTreeNode leftRotate(AVLTreeNode root){
        AVLTreeNode newRoot = root.getRightChild();
        root.setRightChild(newRoot.getLeftChild());
        newRoot.setLeftChild(root);
        setRootHeight(root);
        setRootHeight(newRoot);
        return newRoot;
    }

    private AVLTreeNode rightRotate(AVLTreeNode root){
        AVLTreeNode newRoot = root.getLeftChild();
        root.setLeftChild(newRoot.getRightChild());
        newRoot.setRightChild(root);
        setRootHeight(root);
        setRootHeight(newRoot);
        return newRoot;
    }

    private class AVLTreeNode{
        private int value;
        private AVLTreeNode leftChild;
        private AVLTreeNode rightChild;
        private int height;

        public AVLTreeNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public AVLTreeNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(AVLTreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public AVLTreeNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(AVLTreeNode rightChild) {
            this.rightChild = rightChild;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        @Override
        public String toString() {
            return "AVLTreeNode{" +
                    "value=" + value +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    ", height=" + height +
                    '}';
        }
    }
}

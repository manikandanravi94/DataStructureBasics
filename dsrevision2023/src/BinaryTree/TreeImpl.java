package BinaryTree;

/*
hints.. always while condition to check current!=null
current.leftchild!=null assign the value vice versa for bigger value
 */
public class TreeImpl {

    private Node root;

    public void insert(int value){
        if(root==null){
            this.root = new Node(value,null,null);
        }else{
            Node current = root;
            while (current!=null){
                if(value<current.value){
                    if(current.leftChild==null){
                        current.leftChild= new Node(value,null,null);
                        break;
                    }
                    current=current.leftChild;
                }else{
                    if(current.rightChild==null){
                        current.rightChild= new Node(value,null,null);
                        break;
                    }
                    current=current.rightChild;
                }
            }

        }

    }

    public boolean find(int value){
        Node current=this.root;
        while(current!=null){
            if(current.value==value)
                return true;
            if(current.value>value){
                current=current.leftChild;
            }else{
                current=current.rightChild;
            }
        }
        return false;
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
    }
}


import java.util.*;


 class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

 public class BinaryTree{
    static Node root;
    void insert(int data){
        Node newNode = new Node(data);
        if(root==null){
            root = newNode;
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.left==null){
                temp.left = newNode;
                return;
            }
            else{
                queue.add(temp.left);
            }
            if(temp.right==null){
                temp.right = newNode;
                return;
            }
            else{
                queue.add(temp.right);
            }
        }
    }
    void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    void postorder(Node root){
        if(root==null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    void preorder(Node root){
        if(root==null) return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    void levelorder(Node root){
        if (root==null){
            System.err.println("Tree empty");
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print(temp.data+ " ");
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }
    }
    void deleteNode(int Key){
        if(root.left==null && root.right==null){
            if(root.data==Key){
                root = null;
                return;
            }
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node temp = null;
        Node keyNode = null;
        while(!queue.isEmpty()){
            temp = queue.poll();
            if(temp.data==Key){
                keyNode = temp;
            }
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }
        if(keyNode!=null){
            keyNode.data = temp.data;
            deleteLeafNode(temp);
        }
    }
    void deleteLeafNode(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.left==node){
                temp.left = null;
                return;
            }
            if(temp.right==node){
                temp.right = null;
                return;
            }
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }

    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        System.out.println("Inorder Traversal:");
        tree.inorder(root);
        System.out.println("\nPostorder Traversal:");
        tree.postorder(root);
        System.out.println("\nPreorder Traversal:");
        tree.preorder(root);
        System.out.println("\nLevel Order Traversal");
        tree.levelorder(root);
    }
}
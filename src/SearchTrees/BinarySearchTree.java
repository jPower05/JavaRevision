package SearchTrees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public class BinarySearchTree {
//    Node root;
//
//    public void insert(Node node){
//        root = insertHelperNode(root, node);
//    }
//    private Node insertHelperNode(Node root, Node node){
//        Object data = node.getData();
//
//        if(root == null){
//            root = node;
//            return root;
//        }
//        else if(data < root.getData()){
//            root.setLeft(insertHelperNode(root.getLeft(), node));
//        }
//        else{
//            root.setRight(insertHelperNode(root.getRight(), node));
//        }
//        return root;
//    }
//
//    public void display(){
//        displayHelper(root);
//    }
//
//    private void displayHelper(Node root){
//        if(root != null){
//            displayHelper(root.getLeft());
//            System.out.println(root.getData());
//            displayHelper(root.getRight());
//        }
//    }
//
//    public boolean search(int data){
//        return searchHelper(root, data);
//    }
//    private boolean searchHelper(Node root, int data){
//        if(root == null){
//            return false;
//        }
//        else if(root.getData() == data){
//            return true;
//        }
//        else if(root.getData() > data){
//            return searchHelper(root.getLeft(), data);
//        }
//        else{
//            return searchHelper(root.getRight(), data);
//        }
//    }
//
//    public void remove(int data){
//
//    }
//
//    private Node removeHelper(Node root, int data){
//        return null;
//    }
//
//    private int successor(Node root){
//        return 0;
//    }
//    private int predecessor(Node root){
//        return 0;
//    }
}

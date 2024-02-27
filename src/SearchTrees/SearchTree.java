package SearchTrees;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SearchTree<T> {
    Node root;

    public void traversal(){
        dFSInorderHelper(root);
        //dFSPreOrderHelper(root);
        //dFSPostOrderHelper(root);
    }
    private void dFSInorderHelper(Node root){
        if(root  != null){
            dFSInorderHelper(root.getLeft());
            System.out.println(root.getData());
            dFSInorderHelper(root.getRight());
        }
    }
    private void dFSPreOrderHelper(Node root){
        if(root  != null){
            System.out.println(root.getData());
            dFSInorderHelper(root.getLeft());
            dFSInorderHelper(root.getRight());
        }
    }
    private void dFSPostOrderHelper(Node root){
        if(root  != null){
            dFSInorderHelper(root.getLeft());
            dFSInorderHelper(root.getRight());
            System.out.println(root.getData());
        }
    }

    public void insert(Node node){
        root = insertHelperNode(root, node);
    }
    private Node insertHelperNode(Node root, Node node){
        if(root == null){
            root = node;
            return root;
        }
        else if(dataComparison(root, node)){
            root.setLeft(insertHelperNode(root.getLeft(), node));
        }
        else{
            root.setRight(insertHelperNode(root.getRight(), node));
        }
        return root;
    }

    public boolean dataComparison(Node n1, Node n2){
        if(n1.getData() instanceof Integer && n2.getData() instanceof Integer){
            int n1Data = (int) n1.getData();
            int n2Data = (int) n2.getData();
            if(n1Data > n2Data){
                return true;
            }
        }
        if(n1.getData() instanceof Character && n2.getData() instanceof Character){
            char n1Data = (char) n1.getData();
            char n2Data = (char) n2.getData();
            if(n1Data > n2Data){
                return true;
            }
        }
        return false;
    }
}

package SearchTrees;

public class TreeDriver {
    public static void main(String[] args){
        //Node<Integer> n = new Node<>(5);
        Node<Character> root = new Node<>('F');
        Node<Character> d = new Node<>('D');
        Node<Character> j = new Node<>('J');
        Node<Character> b = new Node<>('B');
        Node<Character> e = new Node<>('E');
        Node<Character> g = new Node<>('G');
        Node<Character> k = new Node<>('K');
        Node<Character> a = new Node<>('A');
        Node<Character> c = new Node<>('C');
        Node<Character> i = new Node<>('I');
        Node<Character> h = new Node<>('H');
        Node<Character> l = new Node<>('L');


        root.setLeft(d);
        root.setRight(j);
        d.setLeft(b);
        d.setRight(e);
        b.setLeft(a);
        b.setRight(c);
        j.setLeft(g);
        j.setRight(k);
        g.setRight(i);
        i.setLeft(h);


        SearchTree<Character> tree = new SearchTree<>(root);
        tree.traversal();
        System.out.println("///////////////");
        tree.insert(l);
        tree.traversal();


//        BinarySearchTree bst = new BinarySearchTree(new Node(4));
//        bst.insert(new Node(6));
//        bst.insert(new Node(2));
//        bst.insert(new Node(1));
//        bst.insert(new Node(3));
//        bst.insert(new Node(5));
//        bst.insert(new Node(7));
//
//        bst.display();
//        System.out.println(bst.search(33));
    }
}

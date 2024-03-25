
import java.util.concurrent.ThreadLocalRandom;

public class Graphs {
    public static void main(String[] args){
        //int[][] array = create2DArray(4);
        //print(array);
        AdjacencyGraph2 ag = new AdjacencyGraph2(6);

        ag.addNode(new AdjacencyGraph2.Node('A'));   // 0
        ag.addNode(new AdjacencyGraph2.Node('B'));   // 1
        ag.addNode(new AdjacencyGraph2.Node('C'));   // 2
        ag.addNode(new AdjacencyGraph2.Node('D'));   // 3
        ag.addNode(new AdjacencyGraph2.Node('E'));   // 4
        ag.addNode(new AdjacencyGraph2.Node('F'));   // 5

        ag.addEdge(0,1);// A -> B
        ag.addEdge(1,4);// B -> E
        ag.addEdge(1,2);// B -> C
        ag.addEdge(4,0);// E -> A
        ag.addEdge(4,2);// E -> C
        ag.addEdge(2,4);// C -> E
        ag.addEdge(2,3);// C -> D
        ag.addEdge(0, 5);// A -> F
        ag.addEdge(5,1); // F -> B

        //ag.print();

        System.out.println('\n');

        //ag.depthFirstSearch(0);
        ag.dfsAllPaths(0, 1);


    }

    public static int[][] create2DArray(int size){
        int[][] array = new int[size][size];

        // populate
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                array[i][j] = ThreadLocalRandom.current().nextInt(1, 100);
            }
        }
        return array;
    }

    public static void print(int[][] array){
        for (int[] ints : array) {
            System.out.println();
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
        }
    }
}

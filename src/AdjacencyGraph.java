import java.util.ArrayList;

public class AdjacencyGraph {

    public static class Node{
        char data;
        Node(char data){
            this.data = data;
        }
    }

    int[][] matrix;
    ArrayList<Node> nodes;
    public AdjacencyGraph(int size){
        nodes = new ArrayList<Node>();
        matrix = new int[size][size];
    }

    public void addNode(Node node){
        nodes.add(node);
    }

    public void addEdge(int row, int column){
        matrix[row][column] = 1;
    }

    public boolean checkEdge(int row, int column){
        return matrix[row][column] == 1;
    }

    public void print(){
        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
}

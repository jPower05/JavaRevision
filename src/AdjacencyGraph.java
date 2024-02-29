import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

    public void depthFirstSearch(int startIndex){
        boolean[] visited = new boolean[matrix.length];
        depthFirstSearchHelper(startIndex, visited);
    }

    private void depthFirstSearchHelper(int startIndex, boolean[] visited){
        // if we have already visted this node
        if(visited[startIndex] == true){
            return;
        }
        else{
            visited[startIndex] = true;     // mark as visited
            System.out.println(nodes.get(startIndex).data + " = visited");
        }
        // loop through the row
        for(int i = 0; i < matrix[startIndex].length; i++){
            if(matrix[startIndex][i] == 1){
                depthFirstSearchHelper(i, visited);
            }
        }
        return;
    }

    public void breadthFirstSearch(int startIndex){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[matrix.length];

        queue.add(startIndex);
        visited[startIndex] = true;

        while(queue.size() != 0){
            startIndex = queue.poll();
            System.out.println(nodes.get(startIndex).data + " = visited");

            for(int i = 0; i < matrix[startIndex].length; i++){
                if(matrix[startIndex][i] == 1 && visited[i] != true){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

}

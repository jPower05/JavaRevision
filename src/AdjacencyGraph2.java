import java.util.ArrayList;

public class AdjacencyGraph2 {

    public static class Node{
        char data;
        public Node(char data){
            this.data = data;
        }
    }
    public ArrayList<Node> nodes;
    public int[][] matrix;

    public AdjacencyGraph2(int size){
        nodes = new ArrayList<Node>();
        matrix = new int[size][size];
    }

    public void addNode(Node node){
        nodes.add(node);
    }

    public void addEdge(int row, int col){
        matrix[row][col] = 1;
    }

    public boolean checkEdge(int row, int col){
        return matrix[row][col] == 1;
    }

    public void print(){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
        }
    }

    public void dfs(int src){
        boolean[] visited = new boolean[matrix.length];
        dfsHelper(src, visited);
    }

    private void dfsHelper(int src, boolean[] visited) {
        if (visited[src] == true)
            return;
        else{
            visited[src] = true;
            System.out.println("Visited " + nodes.get(src).data);
        }

        for(int i = 0; i < matrix[src].length; i++){
            if(matrix[src][i] == 1){
                dfsHelper(i, visited);
            }
        }
    }

    public void dfsAllPaths(int src, int dest){
        boolean[] visited = new boolean[matrix.length];
        ArrayList<Character> path = new ArrayList<Character>();
        path.add(nodes.get(src).data);

        dfsAllPathsHelper(src, dest, visited, path);
    }

    private void dfsAllPathsHelper(int src, int dest, boolean[] visited, ArrayList<Character> path) {

        if(src == dest ){
            printPath(path);
            return;
        }
        else{
            visited[src] = true;
        }

        for(int i = 0; i < matrix[src].length; i++){
            if(visited[i] == false && matrix[src][i] == 1){
                path.add(nodes.get(i).data);
                dfsAllPathsHelper(i, dest, visited, path);
                path.removeLast();
            }
        }
    }

    private void printPath(ArrayList<Character> path){
        for(Character c : path){
            System.out.print(c + " ");
        }
        System.out.println();
    }


}

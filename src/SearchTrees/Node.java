package SearchTrees;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Node<T> {
    private T data;
    private Node<T> left;
    private Node<T> right;

    public Node(T data){
        this.data = data;
    }


}

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public abstract class Animal {
    private String name;

    public Animal(){}

    public Animal(String name){
        this.name = name;
    }

    public void introduce(){
        System.out.println("AM ANIMAL");
    }
}

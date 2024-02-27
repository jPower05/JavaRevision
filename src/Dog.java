import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Dog extends Animal{
    private int regNum;

    public Dog(String name, int regNum){
        super(name);
        this.regNum = regNum;
    }

    @Override
    public void introduce(){
        System.out.println("AM DOG");
    }
}

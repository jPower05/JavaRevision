import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)

public class Cat extends Animal implements Movement {
    private String breed;

    public static class Collar {
        public String colour;

        Collar(String colour) {
            this.colour = colour;
        }
    }

    public Cat(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    @Override
    public void introduce() {
        System.out.println("AM CAT");
    }

    public void aboutMe() {
        System.out.println("i AM AN " + breed + " cat");
    }

    @Override
    public void howIMove() {
        System.out.println("I LIKE TO RUN");
    }
}

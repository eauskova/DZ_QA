public class Pet extends AbstractAnimal {
    public Pet(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " делает дружелюбные звуки/жесты.");
    }
}

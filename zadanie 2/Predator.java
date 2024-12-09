public class Predator extends AbstractAnimal {
    public Predator(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " издаёт угрожающие звуки.");
    }
}

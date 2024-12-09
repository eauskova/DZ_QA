public class Wolf extends Predator {
    public Wolf(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " скалит зубы");
    }
}
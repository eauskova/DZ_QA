public class Shark extends Predator {
    public Shark(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " молчалива, но зубы остренькие");
    }
}



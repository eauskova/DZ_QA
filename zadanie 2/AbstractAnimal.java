public abstract class AbstractAnimal implements Animal {
    String name; // Имя животного

    public AbstractAnimal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

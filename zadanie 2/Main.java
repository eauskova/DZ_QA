public class Main {
    public static void main(String[] args) {
        // Создаём объекты животных
        Animal wolf = new Wolf("Волк");
        Animal shark = new Shark("Акула");
        Animal dog = new Dog("Собака");
        Animal cat = new Cat("Кошка");

        // Вызываем метод makeSound() для каждого животного
        wolf.makeSound();
        shark.makeSound();
        dog.makeSound();
        cat.makeSound();
    }
}

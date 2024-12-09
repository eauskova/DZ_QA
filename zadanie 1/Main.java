public class Main {
    public static void main(String[] args) {
        //создание объектов
        Product product1 = new Product(10, 100, 0.75);
        Product product2 = new Product(5, 200, 42.575);
        Product product3 = new Product(3, 300, 59.1);

        //вызов метода для каждого товара
        System.out.println("Товар 1:");
        product1.calculateTotal();

        System.out.println("\nТовар 2:");
        product2.calculateTotal();

        System.out.println("\nТовар 3:");
        product3.calculateTotal();
    }
}

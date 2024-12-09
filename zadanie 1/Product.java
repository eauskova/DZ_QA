public class Product {
    int quantity;      //количество товаров
    double price;      //цена товара
    double discount;   //скидка на товар в процентах
    
    //конструктор
    public Product(int quantity, double price, double discount) {
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
    }
    
    //метод для подсчета общей суммы без скидки и со скидкой
    public void calculateTotal() {
        double totalWithoutDiscount = quantity * price;
        double totalWithDiscount = totalWithoutDiscount * (1 - discount / 100);
    //вывод округленных значений
        System.out.println("Без скидки: " + String.format("%.2f", totalWithoutDiscount));
        System.out.println("Со скидкой: " + String.format("%.2f", totalWithDiscount));
    }
}
    


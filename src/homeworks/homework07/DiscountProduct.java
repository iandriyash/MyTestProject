package homeworks.homework07;

public class DiscountProduct extends Product {
    private int discountPercentage;
    private boolean discountActive;

    public DiscountProduct(String name, double price, int discountPercentage) {
        super(name, price); // Инициализируем name и price через конструктор Product (проверки внутри него)
        if (discountPercentage <= 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Недопустимый размер скидки!");
        }
        this.discountPercentage = discountPercentage;
        this.discountActive = true; // скидка действует по умолчанию
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public boolean isDiscountActive() {
        return discountActive;
    }

    public void setDiscountActive(boolean active) {
        this.discountActive = active;
    }

    @Override
    public double getPrice() {
        if (discountActive) {
            // Цена со скидкой: уменьшаем исходную цену на процент скидки
            return super.getPrice() * (100 - discountPercentage) / 100.0;
        } else {
            // Если скидка не активна, возвращаем полную цену
            return super.getPrice();
        }
    }

    @Override
    public String toString() {
        // Формат вывода: Название = цена, XX%
        // Здесь выводим исходную цену и процент скидки
        return getName() + " = " + super.getPrice() + ", " + discountPercentage + "%";
    }

    // equals() и hashCode() можно переопределить, учитывая поля суперкласса + новые поля, если нужно
}

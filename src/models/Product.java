package models;


public class Product {

    private String name;
    private int quantity;
    private float price;

    public float getTax() {
        return 0.05f;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public static float calculateIncome(int quantity, float price) {
        return quantity * price;
    }

    public static float calculateTaxExpense(float tax, float income) {
        return tax * income;
    }

    public static float calculateNetIncome(float income, float taxExpense) {
        return income - taxExpense;
    }

}
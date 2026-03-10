package model;
import java.time.LocalDate;

public class Expense {
    LocalDate date;
    String description;
    String category;
    private double amount;

    public Expense(LocalDate date, String description, String category, double amount) {
        this.date = date;
        this.description = description;
        this.category = category;
        setAmount(amount);


    }
    public void setAmount(double amount) {
        if (amount >= 0) {
            this.amount = amount;
        } else {
            System.out.println("Amount cannot be negative. Setting to 0.");
            this.amount = 0;

        }
    }

    public double getAmount() { return amount; }

    public void display() {
        System.out.println("Date: " + date + " |"+" Description: " + description + " |" + " Category: " + category + " |" + " Amount: " + amount);
    }
    public LocalDate getDate() {
        return date;
    }
    public String getDescription() {   // ✅ ADD
        return description;
    }

    public String getCategory() {
        return category;
    }




}

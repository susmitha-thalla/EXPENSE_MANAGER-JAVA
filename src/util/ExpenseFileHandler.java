package util;
import model.Expense;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExpenseFileHandler {

    private static final String FILE_NAME = "expenses.txt";

    // Save all expenses to file
    public static void saveExpenses(List<Expense> expenses) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Expense e : expenses) {
                writer.write(
                        e.getDate() + "| " + e.getDescription() + "| " +
                                e.getCategory() + "| " +
                                e.getAmount());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving expenses to file.");
        }
    }

    // Load expenses from file
    public static List<Expense> loadExpenses() {
        List<Expense> expenses = new ArrayList<>();

        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return expenses; // first run, no file yet
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                LocalDate date = LocalDate.parse(parts[0]);
                String description = parts[1];
                String category = parts[2];
                double amount = Double.parseDouble(parts[3]);

                expenses.add(new Expense(date, description, category, amount));
            }
        } catch (IOException e) {
            System.out.println("Error loading expenses from file.");
        }

        return expenses;
    }
}


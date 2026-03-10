package service;
import model.Expense;
import model.MonthlyReport;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportGenerator {
    public MonthlyReport generateMonthlyReport(List<Expense> expenses, int year, int month) {

        double totalAmount = 0;
        Map<String, Double> categoryTotals = new HashMap<>(); // store totals per category

        // Loop through all expenses
        for (Expense e : expenses) {
            // Filter expenses belonging to the given year & month
            if (e.getDate().getYear() == year && e.getDate().getMonthValue() == month) {
                //totalAmount += e.getAmount(); // add to monthly total

                // Handle category-wise totals
                double amt = e.getAmount();

                if (amt > 0) {
                    totalAmount += amt;

                    String category = e.getCategory();
                    categoryTotals.put(
                            category,
                            categoryTotals.getOrDefault(category, 0.0) + amt
                    );
                }

            }
        }

        // Create and return MonthlyReport object
        return new MonthlyReport(year, month, totalAmount, categoryTotals);
    }

}

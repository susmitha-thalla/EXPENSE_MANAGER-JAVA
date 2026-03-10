package model;
import java.util.Map;

public class MonthlyReport {
        private int year;
        private int month;
        private double totalAmount;
        private Map<String, Double> categoryTotals;
        public MonthlyReport(int year, int month, double totalAmount, Map<String, Double> categoryTotals) {
            this.year = year;
            this.month = month;
            this.totalAmount = totalAmount;
            this.categoryTotals = categoryTotals;
        }

        public int getYear() {
            return year;
        }
        public int getMonth() {
            return month;
        }
        public double getTotalAmount() {
            return totalAmount;
        }
        public Map<String, Double> getCategoryTotals() {
            return categoryTotals;
        }
    }



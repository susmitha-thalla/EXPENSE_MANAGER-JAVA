package app;
import model.Expense;
import service.ExpenseService;
import java.time.LocalDate;
import java.util.Scanner;
import model.MonthlyReport;
import service.ReportGenerator;
import java.util.Map;
import util.ExpenseFileHandler;


public class ExpenseApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseService ex = new ExpenseService();
        ReportGenerator rg = new ReportGenerator();
        ex.setExpenses(ExpenseFileHandler.loadExpenses());


        int choice;
        do {
            System.out.println("1.Add Expense");
            System.out.println("2.Show All Expenses");
            System.out.println("3.Total Expenses");
            System.out.println("4. Monthly Report");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            //2025sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    if(amount <=0){
                        System.out.println("Amount cannot be negative or zero. Please try again.");
                        break;
                    }
                    sc.nextLine();
                    System.out.print("Enter category: ");
                    String category = sc.nextLine();
                    System.out.print("Enter description: ");
                    String description = sc.nextLine();
                    LocalDate date = LocalDate.now();

                    Expense expense = new Expense(date, description, category, amount);
                    ex.addExpense(expense);

                    ExpenseFileHandler.saveExpenses(ex.getAllExpenses());
                    System.out.println("Expense added successfully.");
                    break;
                case 2:
                    ex.showAllExpenses();
                    break;
                case 3:
                    System.out.println("Total Expenses: " + ex.totalExpenses());
                    break;
                case 4:
                    System.out.print("Enter year: ");
                    int year = sc.nextInt();
                    System.out.print("Enter month (1-12): ");
                    int month = sc.nextInt();
                    MonthlyReport report = rg.generateMonthlyReport(ex.getAllExpenses(), year, month);
                    System.out.println("\n===== Monthly Report =====");
                    System.out.println("Year: " + year + " Month: " + month);
                    if (report.getCategoryTotals().isEmpty()) {
                        System.out.println("No expenses recorded for this month.");
                        System.out.println("==========================");
                        break;
                    }
                    System.out.println("Total Spent: " + report.getTotalAmount());

                    for (Map.Entry<String, Double> entry :
                            report.getCategoryTotals().entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                    System.out.println("==========================");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        while (choice != 5);
    }

}
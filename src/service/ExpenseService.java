package service;
import model.Expense;
import java.util.List;
import java.util.ArrayList;


public class ExpenseService {
   private List<Expense> expenses=new ArrayList<>();
    public void addExpense(Expense e){
        expenses.add(e);
    }
    public void showAllExpenses(){
        for(Expense e:expenses){
            e.display();
        }
    }
    public double totalExpenses(){
        double total=0;
        for(Expense e:expenses){
            total+=e.getAmount();
        }
        return total;
    }
    public List<Expense> getAllExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }



}

package strategy;

import model.ExpenseType;
import model.User;

import java.util.List;

public interface ExpenseSplitStrategy {

    void split(Double amount, User paidBy, ExpenseType expenseType, List<User> paidTo);

}

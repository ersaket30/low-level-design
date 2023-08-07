package model;

import java.util.List;

public class Expense {

    ExpenseType expenseType;
    User paidBy;
    List<User> paidToUsers;
    Double amountPaid;
}

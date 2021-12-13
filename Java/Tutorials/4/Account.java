import java.util.*;

public class Account implements Comparable<Account>, Cloneable {
    private String number;
    private double credit;
    public List<Action> history;

    // Getters And Setters
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public List<Action> getHistory() {
        return history;
    }

    public void setHistory(List<Action> history) {
        this.history = history;
    }

    // Constructors
    public Account() {
        this.number = null;
        this.credit = 0;
        this.history = new LinkedList<>();
    }

    public Account(String number, double credit) {
        this.number = number;
        this.credit = credit;
        this.history = new LinkedList<>();
    }

    // Overriding
    @Override
    public int compareTo(Account account) { // Compare the account credits
        return this.number.compareTo(account.number);
    }

    @Override
    public String toString() {
        return this.number + " " + this.credit + " " + this.history.toString();
    }

    @Override
    public Account clone() throws CloneNotSupportedException {
        Account c = new Account();

        try {
            c = (Account) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Error");
        }
        c.history = new LinkedList<Action>(this.history);
        for (int i = 0; i < this.history.size(); i++) {
            c.history.set(i, (Action) this.history.get(i).clone());
        }
        return c;
    }

    // Class Action
    class Action implements Cloneable{
        private double amount;

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public Action(double amount) {
            this.amount = amount;
        }

        class Deposit extends Action {
            public Deposit() {
                super(amount);
                credit += amount;
            }

            @Override
            public String toString() {
                return "+" + amount;
            }
        }

        class Withdrawal extends Action {
            public Withdrawal() {
                super(amount);
                credit -= amount;
            }

            @Override
            public String toString() {
                return "-" + amount;
            }
        }

        public Action clone() {
            Action c = new Action(0);
            try {
                c = (Action) super.clone();
            } catch (CloneNotSupportedException ignored){ }
            return c;
        }
    }

    // Methods
    public void addDeposit(double amount) {
        history.add(new Action(amount).new Deposit());
    }

    public void addWithdrawal(double amount) {
        if (amount > this.credit) return;
        history.add(new Action(amount).new Withdrawal());
    }

    public double sumDeposit() {
        double sum = 0;
        for (Action i : (List<Action>)(LinkedList<Action>) this.history) {
            if (i instanceof Action.Deposit) {
                sum += i.amount;
            }
        }
        return sum;
    }

    public double sumWithdrawal() {
        double sum = 0;
        for (Action i : (List<Action>)(LinkedList<Action>) this.history) {
            if (i instanceof Action.Withdrawal) {
                sum += i.amount;
            }
        }
        return sum;
    }


}

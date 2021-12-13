import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.Function;
import java.util.function.Predicate;

public class Agency extends LinkedList<Account>{

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Agency clone() {
        return (Agency) super.clone();
    }

        public void sortByNumber() {
        sort(Comparator.comparing(Account::getNumber));
    }

    public void sortByCredit() {
        sort(Comparator.comparing(Account::getCredit));
    }

    public Agency filter(Predicate<Account> c) {
        Agency temp = new Agency();
        for (int i = 0; i < this.size(); i++) {
            if (c.test(this.get(i))) {
                temp.add(this.get(i));
            }
        }
        return temp;
    }

    public Agency map(Function<Account, Account> f) {
        Agency temp = new Agency();
        for (int i = 0; i < this.size(); i++) {
            temp.add(f.apply(this.get(i)));
        }
        return temp;
    }

    public Agency loyalClients(double m) {
        return this.filter((account -> account.getCredit() > m)).map(account -> new Account(account.getNumber(), account.getCredit() * 1.02));
    }
}
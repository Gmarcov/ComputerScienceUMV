import java.util.SortedMap;
import java.util.function.Predicate;

public class td4 {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("Welcome to your Program Marcos");
        Account marcos = new Account("MARCOS2700", 1000);
        Account sam = new Account("SAM2001", 13000);
        Account jonas = new Account("JONAS0303", 9000);

        Agency agencyLosAngeles = new Agency();
        agencyLosAngeles.add(marcos);
        agencyLosAngeles.add(sam);
        agencyLosAngeles.add(jonas);

        marcos.addDeposit(1000);
        marcos.addDeposit(900);
        marcos.addWithdrawal(300);
        marcos.addWithdrawal(800);

        System.out.println("Los Angeles Agency \n" + agencyLosAngeles);
        Agency loyalClientsLA = agencyLosAngeles.loyalClients(8000);
            System.out.println("After the promotion \n" + loyalClientsLA);
    }
}

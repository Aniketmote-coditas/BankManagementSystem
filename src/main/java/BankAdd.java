import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BankAdd {
    public static void main(String[] args) throws IOException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        EntityManager manager = factory.createEntityManager();

        System.out.println("--------------------- we are adding Bank by ADMIN---------------");
        Bank bank = new Bank();
        System.out.println("Enter the bank name");
        String bname = bufferedReader.readLine();

        bank.setBname(bname);
        manager.getTransaction().begin();
        manager.persist(bank);
        manager.getTransaction().commit();

    }
}

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
//import java.sql.Date;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

interface Dao{
    void openAccount() throws SQLException, IOException;
    void showUser();
    void deleteUserAccount() throws SQLException, IOException;
    void updateUserInfo() throws SQLException, IOException;
    void query1();
    void query2();
    void query3() throws IOException;

}
public class DaoImpl implements Dao{
    BufferedReader bufferedReader;
    public void openAccount() throws SQLException, IOException {
       /* EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        System.out.println("enter name of zoo");
        String libraryName = bufferedReader.readLine();
        Zoo zoo = new Zoo();
        zoo.setName(libraryName);
        entityManager.persist(zoo);
        int choice;
        do {
            System.out.println("enter 1 to enter animal\n0 to exit");
            choice = Integer.parseInt(bufferedReader.readLine());
            if (choice == 1) {
                System.out.println("enter name of animal");
                String animalName = bufferedReader.readLine();
                System.out.println("enter the type of animal");
                String type = bufferedReader.readLine();
                System.out.println("enter age of animal");
                int age = Integer.parseInt(bufferedReader.readLine());
                System.out.println("enter Date of book");

                Animal animal = new Animal(animalName,age,type,zoo);
                entityManager.persist(animal);

            }
        }while(choice!=0);
        entityManager.getTransaction().commit();
        entityManager.close();*/

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa");
        EntityManager entityManager = factory.createEntityManager();
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("In which bank you have to open account\npress 1 for ICICI Bank\npress 2 for HDFC Bank");
        int choice = Integer.parseInt(bufferedReader.readLine());
        int bid=0;
        if(choice==1){
            bid=1;
        }else{
            bid=2;
        }
        System.out.println("Enter your Name");
        String uname = bufferedReader.readLine();

        User user = new User();
        user.setUname(uname);

        Bank bank = new Bank();
        bank.setBid(bid);

        List<Bank> bankList = new ArrayList<>();
        bankList.add(bank);
        user.setBankList(bankList);

        System.out.println("Which typr of account you want to open\nPress 1 for Saving Account\nPress 2 for Current Account");
        int choice1 = Integer.parseInt(bufferedReader.readLine());

        String str1 = "S";
        String str2 = "C";
        String str3;
        String info="";
        if(choice1==1){
            str3=str1;
            System.out.println("Enter the name of your company/where you work");
            info = bufferedReader.readLine();
        }else {
            str3=str2;
        }
        System.out.println("Enter the money you want to add in this account");
        int money = Integer.parseInt(bufferedReader.readLine());
        Account account = new Account();
        account.setTypeOfAccount(str3);
        account.setUserInfo(info);
        account.setBalance(money);
        account.setBank(bank);
        List<User> userList = new ArrayList<>();
        userList.add(user);

        List<Account> accountList = new ArrayList<>();
        accountList.add(account);

        user.setAccountList(accountList);
        account.setUserList(userList);


        //bank.setAccountList(accountList);



        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.persist(account);
        entityManager.getTransaction().commit();

        entityManager.close();

    }

    public void showUser() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Query q = entityManager.createQuery("from Product");

        List<User> list = q.getResultList();

        for(User product:list){
            System.out.println(product.getUid()+"  "+product.getUname());
        }

        entityManager.close();
        entityManagerFactory.close();
    }

    public void deleteUserAccount() throws SQLException, IOException {
        System.out.println("enter Account id ");
        int choice = Integer.parseInt(bufferedReader.readLine());
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Account account = entityManager.find(Account.class,choice);
        entityManager.getTransaction().begin();
        entityManager.remove(account);
        entityManager.getTransaction().commit();
       /* if(choice==1){
            Zoo zoo = entityManager.find(Zoo.class,id);
            entityManager.remove(zoo);
            entityManager.getTransaction().commit();
        }else if(choice==2){
            Animal animal = entityManager.find(Animal.class,id);
            entityManager.remove(animal);
            entityManager.getTransaction().commit();
        }*/
        entityManager.close();
    }

    public void updateUserInfo() throws SQLException, IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");

        System.out.println("enter user id ");
        int choice = Integer.parseInt(bufferedReader.readLine());
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        System.out.println("Enter the new name");
        String newName = bufferedReader.readLine();
        User user = entityManager.find(User.class,choice);
        user.setUname(newName);
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();

        entityManager.close();

    }

    public void query1() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa");
        //like
        EntityManager manager = factory.createEntityManager();
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<String> query = cb.createQuery(String.class);
        Root<User> root = query.from(User.class);
        Join<User, Account> join = root.join("accounts");
        query.select(root.<String>get("uname")).distinct(true)
                .where(cb.equal(join.get("openDate"), LocalDate.of(2023, 4, 27)));
        List<String> usernames = manager.createQuery(query).getResultList();

        for(Object a:usernames){
            System.out.println(a);
        }

    }

    public void query2() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa");
        //like
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaUpdate<Account> update = cb.createCriteriaUpdate(Account.class);
        Root<Account> root = update.from(Account.class);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -3);
        Date threeMonthsAgo = calendar.getTime();

        update.set(root.get("accountStatus"), "prime")
                .where(cb.and(cb.greaterThan(root.get("balance"),100000)));

        int i = manager.createQuery(update).executeUpdate();
        manager.getTransaction().commit();
        manager.close();

    }

    public void query3() throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        EntityManager em2 = emf.createEntityManager() ;
        System.out.println("Enter the account id");

        int aid = Integer.parseInt(br.readLine());

        em2.getTransaction().begin();
        Account account = em2.find(Account.class,aid);
        String accountName =  account.getTypeOfAccount();
        System.out.println("Enter The number of months you have not been activated");
        int actid = Integer.parseInt(br.readLine());
        if(accountName.equalsIgnoreCase("C")){
            int balance = (account.getBalance());
            if(balance<100000){
                System.out.println("Insufficient Balance");
                int bal = actid * 250;
                balance = balance-bal;
                account.setBalance((balance));
                em2.merge(account);
            }
        }
        else if(accountName.equalsIgnoreCase("S")){
            int balance = (account.getBalance());
            if(balance<10000){
                System.out.println("Insufficient Balance");
                int bal = actid * 150;
                balance = balance-bal;
                account.setBalance((balance));
                em2.merge(account);
            }
        }
        em2.getTransaction().commit();
        em2.close();
    }


}

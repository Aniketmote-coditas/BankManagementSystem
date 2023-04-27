import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Controller {
    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int choice ;
        Dao dao = new DaoImpl();
        do{
            System.out.println("1. Open Account");
            System.out.println("2. update");
            System.out.println("3. delete");
            System.out.println("4. display");
            System.out.println("5. query 1");
            System.out.println("6. query 2");
            System.out.println("7. query 3");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(bufferedReader.readLine());

            switch (choice) {
                case 1:
                    dao.openAccount();
                    break;
                case 2:
                    dao.updateUserInfo();
                    // Code for option 2
                    break;
                case 3:
                    dao.deleteUserAccount();
                    // Code for option 3
                    break;
                case 4:
                    dao.showUser();
                    // Code for option 3
                    break;
                case 5:
                    dao.query1();
                    // Code for option 3
                    break;
                case 6:
                    dao.query2();
                    // Code for option 3
                    break;
                case 7:
                    dao.query3();
                    // Code for option 3
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();

        }while(choice!=0);
    }
}

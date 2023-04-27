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
/*
1. Open Account
2. update
3. delete
4. display
5. query 1
6. query 2
7. query 3
0. Exit
Enter your choice: 6
Apr 27, 2023 3:36:44 PM org.hibernate.jpa.internal.util.LogHelper logPersistenceUnitInformation
INFO: HHH000204: Processing PersistenceUnitInfo [name: jpa]
Apr 27, 2023 3:36:44 PM org.hibernate.Version logVersion
INFO: HHH000412: Hibernate ORM core version 5.6.5.Final
Apr 27, 2023 3:36:45 PM org.hibernate.annotations.common.reflection.java.JavaReflectionManager <clinit>
INFO: HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
Apr 27, 2023 3:36:47 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
WARN: HHH10001002: Using Hibernate built-in connection pool (not for production use!)
Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
Apr 27, 2023 3:36:47 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001005: using driver [com.mysql.jdbc.Driver] at URL [jdbc:mysql://localhost:3306/Ban?createDatabaseIfNotExist=true]
Apr 27, 2023 3:36:47 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001001: Connection properties: {user=root, password=****}
Apr 27, 2023 3:36:47 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001003: Autocommit mode: false
Apr 27, 2023 3:36:47 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PooledConnections <init>
INFO: HHH000115: Hibernate connection pool size: 20 (min=1)
Apr 27, 2023 3:36:49 PM org.hibernate.dialect.Dialect <init>
INFO: HHH000400: Using dialect: org.hibernate.dialect.MySQL5Dialect
Apr 27, 2023 3:36:54 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@303a5119] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Hibernate:

    alter table Account
       add constraint FKjwfdfl9uqwb107crow9lbya0g
       foreign key (bank_bid)
       references Bank (bid)
Hibernate:

    alter table Account_User
       add constraint FKopbw8wkhb7qpxvxe7rakjfy8h
       foreign key (userList_uid)
       references User (uid)
Hibernate:

    alter table Account_User
       add constraint FKkbj21lbo88vpdydjkufyfj8yw
       foreign key (Account_aid)
       references Account (aid)
Hibernate:

    alter table bank_user
       add constraint FK4f1w9s9r195wa9wpupfio4705
       foreign key (uid)
       references Account (aid)
Hibernate:

    alter table bank_user
       add constraint FKrbgbyd5inkya9pk4vxt1j80wh
       foreign key (bank_id)
       references Bank (bid)
Hibernate:

    alter table User_Account
       add constraint FKl2vlju75axy2kbfphg59tlunc
       foreign key (accountList_aid)
       references Account (aid)
Hibernate:

    alter table User_Account
       add constraint FKsfb2i20bkl4pq8dgnhjdaqhwx
       foreign key (User_uid)
       references User (uid)
Apr 27, 2023 3:36:59 PM org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
Hibernate:
    update
        Account
    set
        accountStatus=?
    where
        balance>100000

1. Open Account
2. update
3. delete
4. display
5. query 1
6. query 2
7. query 3
0. Exit
Enter your choice: 7
Apr 27, 2023 3:37:24 PM org.hibernate.jpa.internal.util.LogHelper logPersistenceUnitInformation
INFO: HHH000204: Processing PersistenceUnitInfo [name: jpa]
Apr 27, 2023 3:37:24 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
WARN: HHH10001002: Using Hibernate built-in connection pool (not for production use!)
Apr 27, 2023 3:37:24 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001005: using driver [com.mysql.jdbc.Driver] at URL [jdbc:mysql://localhost:3306/Ban?createDatabaseIfNotExist=true]
Apr 27, 2023 3:37:24 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001001: Connection properties: {user=root, password=****}
Apr 27, 2023 3:37:24 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001003: Autocommit mode: false
Apr 27, 2023 3:37:24 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PooledConnections <init>
INFO: HHH000115: Hibernate connection pool size: 20 (min=1)
Apr 27, 2023 3:37:24 PM org.hibernate.dialect.Dialect <init>
INFO: HHH000400: Using dialect: org.hibernate.dialect.MySQL5Dialect
Apr 27, 2023 3:37:25 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@6ab4ba9f] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Hibernate:

    alter table Account
       add constraint FKjwfdfl9uqwb107crow9lbya0g
       foreign key (bank_bid)
       references Bank (bid)
Hibernate:

    alter table Account_User
       add constraint FKopbw8wkhb7qpxvxe7rakjfy8h
       foreign key (userList_uid)
       references User (uid)
Hibernate:

    alter table Account_User
       add constraint FKkbj21lbo88vpdydjkufyfj8yw
       foreign key (Account_aid)
       references Account (aid)
Hibernate:

    alter table bank_user
       add constraint FK4f1w9s9r195wa9wpupfio4705
       foreign key (uid)
       references Account (aid)
Hibernate:

    alter table bank_user
       add constraint FKrbgbyd5inkya9pk4vxt1j80wh
       foreign key (bank_id)
       references Bank (bid)
Hibernate:

    alter table User_Account
       add constraint FKl2vlju75axy2kbfphg59tlunc
       foreign key (accountList_aid)
       references Account (aid)
Hibernate:

    alter table User_Account
       add constraint FKsfb2i20bkl4pq8dgnhjdaqhwx
       foreign key (User_uid)
       references User (uid)
Apr 27, 2023 3:37:28 PM org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
Enter the account id
2
Hibernate:
    select
        account0_.aid as aid1_0_0_,
        account0_.accountOpeningDate as accounto2_0_0_,
        account0_.accountStatus as accounts3_0_0_,
        account0_.balance as balance4_0_0_,
        account0_.bank_bid as bank_bid7_0_0_,
        account0_.typeOfAccount as typeofac5_0_0_,
        account0_.userInfo as userinfo6_0_0_,
        bank1_.bid as bid1_2_1_,
        bank1_.bname as bname2_2_1_
    from
        Account account0_
    left outer join
        Bank bank1_
            on account0_.bank_bid=bank1_.bid
    where
        account0_.aid=?
Enter The number of months you have not been activated
4
Insufficient Balance
Hibernate:
    update
        Account
    set
        accountOpeningDate=?,
        accountStatus=?,
        balance=?,
        bank_bid=?,
        typeOfAccount=?,
        userInfo=?
    where
        aid=?

1. Open Account
2. update
3. delete
4. display
5. query 1
6. query 2
7. query 3
0. Exit
Enter your choice: 1
Apr 27, 2023 3:38:09 PM org.hibernate.jpa.internal.util.LogHelper logPersistenceUnitInformation
INFO: HHH000204: Processing PersistenceUnitInfo [name: jpa]
Apr 27, 2023 3:38:09 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
WARN: HHH10001002: Using Hibernate built-in connection pool (not for production use!)
Apr 27, 2023 3:38:09 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001005: using driver [com.mysql.jdbc.Driver] at URL [jdbc:mysql://localhost:3306/Ban?createDatabaseIfNotExist=true]
Apr 27, 2023 3:38:09 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001001: Connection properties: {user=root, password=****}
Apr 27, 2023 3:38:09 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001003: Autocommit mode: false
Apr 27, 2023 3:38:09 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PooledConnections <init>
INFO: HHH000115: Hibernate connection pool size: 20 (min=1)
Apr 27, 2023 3:38:09 PM org.hibernate.dialect.Dialect <init>
INFO: HHH000400: Using dialect: org.hibernate.dialect.MySQL5Dialect
Apr 27, 2023 3:38:10 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@481e91b6] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Hibernate:

    alter table Account
       add constraint FKjwfdfl9uqwb107crow9lbya0g
       foreign key (bank_bid)
       references Bank (bid)
Hibernate:

    alter table Account_User
       add constraint FKopbw8wkhb7qpxvxe7rakjfy8h
       foreign key (userList_uid)
       references User (uid)
Hibernate:

    alter table Account_User
       add constraint FKkbj21lbo88vpdydjkufyfj8yw
       foreign key (Account_aid)
       references Account (aid)
Hibernate:

    alter table bank_user
       add constraint FK4f1w9s9r195wa9wpupfio4705
       foreign key (uid)
       references Account (aid)
Hibernate:

    alter table bank_user
       add constraint FKrbgbyd5inkya9pk4vxt1j80wh
       foreign key (bank_id)
       references Bank (bid)
Hibernate:

    alter table User_Account
       add constraint FKl2vlju75axy2kbfphg59tlunc
       foreign key (accountList_aid)
       references Account (aid)
Hibernate:

    alter table User_Account
       add constraint FKsfb2i20bkl4pq8dgnhjdaqhwx
       foreign key (User_uid)
       references User (uid)
Apr 27, 2023 3:38:14 PM org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
In which bank you have to open account
press 1 for ICICI Bank
press 2 for HDFC Bank
2
Enter your Name
k
Which typr of account you want to open
Press 1 for Saving Account
Press 2 for Current Account
1
Enter the name of your company/where you work
coditas
Enter the money you want to add in this account
100000
Hibernate:
    insert
    into
        User
        (uname)
    values
        (?)
Hibernate:
    insert
    into
        Account
        (accountOpeningDate, accountStatus, balance, bank_bid, typeOfAccount, userInfo)
    values
        (?, ?, ?, ?, ?, ?)
Hibernate:
    insert
    into
        User_Account
        (User_uid, accountList_aid)
    values
        (?, ?)
Hibernate:
    insert
    into
        Account_User
        (Account_aid, userList_uid)
    values
        (?, ?)

1. Open Account
2. update
3. delete
4. display
5. query 1
6. query 2
7. query 3
0. Exit

 */
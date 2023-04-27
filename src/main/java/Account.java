import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;
    private String typeOfAccount;
    @Temporal(TemporalType.DATE)
    private Date accountOpeningDate;
    public Account() {
        this.accountOpeningDate=new Date();
    }

    private int balance;
    private String userInfo;

    private String accountStatus;
    @ManyToMany//(mappedBy = "account")
    private List<User> userList;

    @ManyToOne
    private Bank bank;

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public Date getAccountOpeningDate() {
        return accountOpeningDate;
    }

    public void setAccountOpeningDate(Date accountOpeningDate) {
        this.accountOpeningDate = accountOpeningDate;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getTypeOfAccount() {
        return typeOfAccount;
    }

    public void setTypeOfAccount(String typeOfAccount) {
        this.typeOfAccount = typeOfAccount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

   /* public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
*/
    @Override
    public String toString() {
        return "Account{" +
                "aid=" + aid +
                ", typeOfAccount='" + typeOfAccount + '\'' +
                ", accountOpeningDate=" + accountOpeningDate +
                ", balance=" + balance +
                ", userInfo='" + userInfo + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                ", userList=" + userList +
                ", bank=" + bank +
                '}';
    }
}

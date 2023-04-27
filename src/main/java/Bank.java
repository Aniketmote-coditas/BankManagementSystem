import javax.persistence.*;
import java.util.List;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bid;
    private String bname;
    @ManyToMany
    @JoinTable(
            name = "bank_user",
            joinColumns = @JoinColumn(name = "bank_id"),
            inverseJoinColumns = @JoinColumn(name = "uid")
    )
    private List<Account> userList;
   /* @ManyToMany(mappedBy = "user")
    private List<User> userList;*/

    @OneToMany(mappedBy = "bank")
    private List<Account> accountList;

    public List<Account> getUserList() {
        return userList;
    }

    public void setUserList(List<Account> userList) {
        this.userList = userList;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    /*public List<User> getList() {
        return userList;
    }

    public void setList(List<User> userList) {
        this.userList = userList;
    }
*/

    @Override
    public String toString() {
        return "Bank{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", userList=" + userList +
                ", accountList=" + accountList +
                '}';
    }

    public Bank() {
    }
}

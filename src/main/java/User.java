import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String uname;
    @ManyToMany(mappedBy = "userList")
    private List<Bank> bankList;
   /* @ManyToMany(mappedBy = "bank")
    private List<Bank> bankList;*/

    @ManyToMany//(mappedBy = "account")//dfgfgf
    private List<Account> accountList;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public List<Bank> getBankList() {
        return bankList;
    }

    public void setBankList(List<Bank> bankList) {
        this.bankList = bankList;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", bankList=" + bankList +
                ", accountList=" + accountList +
                '}';
    }
}

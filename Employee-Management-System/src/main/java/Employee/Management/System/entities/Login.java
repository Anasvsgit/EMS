package Employee.Management.System.entities;

import jakarta.persistence.*;

@Entity
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int loginid;
    @Column(length = 50)
    String email;
    @Column(length = 50)
    String password;

    public int getLoginid() {
        return loginid;
    }

    public void setLoginid(int loginid) {
        this.loginid = loginid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Login(int loginid, String email, String password) {
        this.loginid = loginid;
        this.email = email;
        this.password = password;
    }
}





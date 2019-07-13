package example.demo.Model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "username")
    private String username;

   @Column(name = "pass")
    private String pass;



   @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    private Set<Repository> listRepositories = new HashSet<>();


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users1")
    private Set<ResGroup> resGroups = new HashSet<>();

    public Users() {
    }

    public Users(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }

    public Users(String username, String pass, Set<Repository> listRepositories) {
        this.username = username;
        this.pass = pass;
        this.listRepositories = listRepositories;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}

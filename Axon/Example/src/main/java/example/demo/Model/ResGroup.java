package example.demo.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "resgroup")
public class ResGroup implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private Users users1;


    @ManyToOne
    @JoinColumn(name = "idR", nullable = false)
    private Repository repository;

    public ResGroup() {
    }

    public ResGroup(Users users1, Repository repository) {
        this.users1 = users1;
        this.repository = repository;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Users getUsers1() {
        return users1;
    }

    public void setUsers1(Users users1) {
        this.users1 = users1;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }
}

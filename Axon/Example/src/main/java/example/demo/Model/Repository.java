package example.demo.Model;

import com.google.api.client.util.DateTime;
import org.springframework.stereotype.Service;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "repository")
public class Repository implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    @Column(name = "name")
    private String name;



    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private Users users;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "repository")
    private Set<ResGroup> listResGroup = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "repository1")
    private Set<Item> items = new HashSet<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Set<ResGroup> getListResGroup() {
        return listResGroup;
    }

    public void setListResGroup(Set<ResGroup> listResGroup) {
        this.listResGroup = listResGroup;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}

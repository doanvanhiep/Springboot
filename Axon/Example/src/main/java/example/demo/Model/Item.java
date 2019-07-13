package example.demo.Model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "item")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "idR", nullable = false)
    private Repository repository1;

    @Column(name = "state")
    private String state;

    @Column(name = "content")
    private String content;


    public Item() {
    }

    public Item(Repository repository1, String state, String content) {
        this.repository1 = repository1;
        this.state = state;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Repository getRepository1() {
        return repository1;
    }

    public void setRepository1(Repository repository1) {
        this.repository1 = repository1;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

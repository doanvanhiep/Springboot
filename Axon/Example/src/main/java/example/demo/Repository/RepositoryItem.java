package example.demo.Repository;

import example.demo.Model.Item;
import example.demo.Model.Repository;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryItem extends CrudRepository<Item,Integer> {

    public Item findById(int id);
    public void deleteByRepository1(Repository repository);
    public Iterable<Item> findByRepository1(Repository repository);
}

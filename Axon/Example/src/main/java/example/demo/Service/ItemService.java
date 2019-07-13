package example.demo.Service;

import example.demo.Model.Item;
import example.demo.Model.Repository;

import java.util.Optional;

public interface ItemService {
    public Iterable<Item> findByRepository1(Repository repository);

    void save(Item item);

    void delete(int id);

    Item findById(int id);
    public void deleteByRepository1(Repository repository);
}

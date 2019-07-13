package example.demo.Service;

import example.demo.Model.Item;
import example.demo.Model.Repository;
import example.demo.Repository.RepositoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private RepositoryItem repositoryItem;
    @Override
    public Iterable<Item> findByRepository1(Repository repository) {
        return repositoryItem.findByRepository1(repository);
    }

    @Override
    public void save(Item item) {
        repositoryItem.save(item);
    }

    @Override
    public void delete(int id) {
        repositoryItem.deleteById(id);
    }

    @Override
    public Item findById(int id) {
        return repositoryItem.findById(id);
    }

    @Override
    public void deleteByRepository1(Repository repository) {
        repositoryItem.deleteByRepository1(repository);
    }


}

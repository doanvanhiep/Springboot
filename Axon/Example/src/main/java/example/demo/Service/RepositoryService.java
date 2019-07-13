package example.demo.Service;

import example.demo.Model.Repository;
import example.demo.Model.Users;

import java.util.List;

public interface RepositoryService {
    Iterable<Repository> findAll();
    Repository findOne(int id);

    void save(Repository repository);

    void delete(int id);

    public Iterable<Repository> findByUsers(Users user);

    public Repository findById(int id);

}

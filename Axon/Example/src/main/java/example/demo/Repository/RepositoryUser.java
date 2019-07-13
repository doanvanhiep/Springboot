package example.demo.Repository;

import example.demo.Model.Repository;
import example.demo.Model.Users;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryUser extends CrudRepository<Users,String> {
    public Users findByUsername(String user);
}

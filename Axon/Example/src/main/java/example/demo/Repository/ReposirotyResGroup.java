package example.demo.Repository;

import example.demo.Model.Repository;
import example.demo.Model.ResGroup;
import example.demo.Model.Users;
import jnr.ffi.annotations.In;
import org.springframework.data.repository.CrudRepository;

public interface ReposirotyResGroup extends CrudRepository<ResGroup, Integer> {
    public Iterable<ResGroup> findByUsers1(Users users);


}

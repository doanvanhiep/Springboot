package example.demo.Service;

import example.demo.Model.Repository;
import example.demo.Model.ResGroup;
import example.demo.Model.Users;

public interface ResGroupService {
    Iterable<ResGroup> findAll();
    ResGroup findOne(int id);

    void save(ResGroup resGroup);

    void delete(int id);

    public Iterable<ResGroup> findByUsers1(Users user);
}

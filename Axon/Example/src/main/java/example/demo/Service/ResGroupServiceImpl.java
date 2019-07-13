package example.demo.Service;

import example.demo.Model.Repository;
import example.demo.Model.ResGroup;
import example.demo.Model.Users;
import example.demo.Repository.ReposirotyResGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResGroupServiceImpl implements ResGroupService{

    @Autowired
    private ReposirotyResGroup reposirotyResGroup;
    public Iterable<ResGroup> findAll() {
        return reposirotyResGroup.findAll();
    }

    @Override
    public ResGroup findOne(int id) {
        return null;
    }

    @Override
    public void save(ResGroup resGroup) {
        reposirotyResGroup.save(resGroup);
    }

    @Override
    public void delete(int id) {
        reposirotyResGroup.deleteById(id);
    }

    @Override
    public Iterable<ResGroup> findByUsers1(Users user) {
        return reposirotyResGroup.findByUsers1(user);
    }
}

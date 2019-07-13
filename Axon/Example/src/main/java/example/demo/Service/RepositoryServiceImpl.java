package example.demo.Service;


import example.demo.Model.Repository;
import example.demo.Model.Users;
import example.demo.Repository.RepositoryHome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class RepositoryServiceImpl implements RepositoryService{

    @Autowired
    RepositoryHome repositoryHome;


    @Override
    public Iterable<Repository> findAll() {
       return repositoryHome.findAll();
    }

    @Override
    public Repository findOne(int id) {
        return null;
    }

    @Override
    public void save(Repository employee) {
        repositoryHome.save(employee);
    }

    @Override
    public void delete(int id) {
            repositoryHome.deleteById(id);
    }

    @Override
    public Iterable<Repository> findByUsers(Users user) {
        return repositoryHome.findByUsers(user);
    }

    @Override
    public Repository findById(int id) {
        return repositoryHome.findById(id);
    }
}

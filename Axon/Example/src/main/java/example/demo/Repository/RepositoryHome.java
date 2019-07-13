package example.demo.Repository;

import example.demo.Model.Repository;
import example.demo.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public interface RepositoryHome extends CrudRepository<Repository,Integer>{

    public Iterable<Repository> findByUsers(Users user);

    public Repository findById(int id);
    public Repository findByName(String name);
}


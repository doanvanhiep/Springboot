package example.demo.Service;


import example.demo.Model.Users;
import example.demo.Repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService{
    @Autowired

    private RepositoryUser repositoryUser;
    @Override
    public Users findByUserName(String user) {
        return repositoryUser.findByUsername(user);
    }
}

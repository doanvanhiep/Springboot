package example.demo.Service;

import example.demo.Model.User;
import example.demo.Repository.UserRepo;
import org.springframework.stereotype.Service;


@Service
public class Userimpl {
    private  final UserRepo userRepo;

    public Userimpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    public User findUser(int id)
    {
        return userRepo.findById(id).orElse(null);
    }
    public int findOneUser(String name)
    {

        for(User user: userRepo.findAll())
        {
            if(user.getUsername().equals(name))
                return 0;
        }
        return 1;
    }
    public User save(User user){
        return userRepo.save(user);
    }

    public int findUser(String tendangnhap,String pass){
        for(User employee : userRepo.findAll()){
            if(employee.getUsername().equals(tendangnhap) && employee.getPass().equals(pass))
            {
                return 1;
            }
        }
        return 0;
    }



}

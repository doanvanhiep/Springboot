package example.demo.Controller;

import example.demo.Model.Repository;
import example.demo.Model.ResGroup;
import example.demo.Model.User;
import example.demo.Model.Users;
import example.demo.Repository.RepositoryUser;
import example.demo.Service.RepositoryService;
import example.demo.Service.ResGroupService;
import example.demo.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class Home {

    @Autowired
    RepositoryService repositoryService;

    @Autowired
    UsersService usersService;

    @Autowired
    ResGroupService resGroupService;


    String UserName="";

    @GetMapping("/home")
    public String home(Model m,String userName,HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        UserName = (String) session.getAttribute("user");
        if(UserName==null)
        {
            UserName="";
        }

        userName=UserName;
        m.addAttribute("resgroup",resGroupService.findByUsers1(usersService.findByUserName(userName)));
      //  m.addAttribute("repository",repositoryService.findAll());
        m.addAttribute("User",userName);
        return "home";
    }


    @GetMapping("/home/{id}/delete")
    public String DeleteRepository(@PathVariable int id, RedirectAttributes redirect ) {

      repositoryService.delete(id);
      return "redirect:/home";

    }

    @GetMapping("/home/create")
    public String create(Model model) {
        model.addAttribute("repository", new Repository());
        return "addRepository";
    }


    @RequestMapping( value = {"/home/save"})
    public String SaveRepository(@ModelAttribute("repository") Repository repository, RedirectAttributes redirect) {
        try {
           repository.setUsers(usersService.findByUserName(UserName));
            repositoryService.save(repository);

            ResGroup r=new ResGroup();
            r.setUsers1(usersService.findByUserName(UserName));
            r.setRepository(repository);
            resGroupService.save(r);

            return "redirect:/home";
        }catch (Exception e) {
            return "redirect:/home";
        }
    }




}

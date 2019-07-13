package example.demo.Controller;

import example.demo.Model.Item;
import example.demo.Model.Repository;
import example.demo.Model.ResGroup;
import example.demo.Service.ItemService;
import example.demo.Service.RepositoryService;
import example.demo.Service.ResGroupService;
import example.demo.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Kanban {

    @Autowired
    private ItemService itemService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private ResGroupService resGroupService;


    @Autowired
    private RepositoryService repositoryService;
    @RequestMapping("/home/{id}/kanban")
    public String Kanban(@PathVariable int id, Model m,String UserName) {
        m.addAttribute("item",itemService.findByRepository1(repositoryService.findById(id)));
        m.addAttribute("id",id);
        m.addAttribute("username",UserName);
        return "kanban";
    }



    @RequestMapping( value = {"/home/kanban/save"})
    public String Save(@RequestParam("username")  String username,
                       @ModelAttribute("id")String id) {
        try {
            ResGroup r=new ResGroup();
            r.setUsers1(usersService.findByUserName(username));
            r.setRepository(repositoryService.findById(Integer.parseInt(id)));
            resGroupService.save(r);
            return "kanban";
        }catch (Exception e) {

            return "kanban";
        }

    }

    @GetMapping("/home/{id}/kanban/chageStateToDo/{id1}")
    public String changeTodo(RedirectAttributes redirect,@PathVariable int id1) {
        Item i=itemService.findById(id1);
        i.setState("ToDo");
        itemService.save(i);

        return "redirect:/home/{id}/kanban";
    }

    @GetMapping("/home/{id}/kanban/chageStateDoing/{id1}")
    public String changeDoing(RedirectAttributes redirect,@PathVariable int id1) {

        Item i=itemService.findById(id1);
        i.setState("Doing");
        itemService.save(i);

        return "redirect:/home/{id}/kanban";
    }

    @GetMapping("/home/{id}/kanban/chageStateTest/{id1}")
    public String changetest(RedirectAttributes redirect,@PathVariable int id1) {

        Item i=itemService.findById(id1);
        i.setState("Test");
        itemService.save(i);

        return "redirect:/home/{id}/kanban";
    }

    @GetMapping("/home/{id}/kanban/chageStateDone/{id1}")
    public String change(RedirectAttributes redirect,@PathVariable int id1) {
        Item i=itemService.findById(id1);
        i.setState("Done");
        itemService.save(i);


        return "redirect:/home/{id}/kanban";
    }

}

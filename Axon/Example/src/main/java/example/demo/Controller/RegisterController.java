package example.demo.Controller;

import example.demo.Model.User;
import example.demo.Service.Userimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController {
    @Autowired
    private Userimpl useriml;


    @GetMapping("/")
    public String newemployee(HttpServletRequest request)
    {
        return "register";
    }

    @PostMapping("/save-user")
    public ModelAndView saveBinhLuan(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
        String name = request.getParameter("username");
        if (useriml.findOneUser(name) == 1) {
            user.setPass((String) request.getParameter("password"));
            useriml.save(user);
            return new ModelAndView("redirect:/list");
        } else {
            return new ModelAndView("redirect:/");
        }
    }
}

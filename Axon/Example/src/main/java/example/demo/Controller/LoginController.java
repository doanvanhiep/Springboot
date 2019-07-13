package example.demo.Controller;


import example.demo.Model.User;

import example.demo.Service.Userimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

//    @Autowired
//    LoginService loginService;


    @GetMapping(value = "/list")
    public ModelAndView loginPage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        ModelAndView model = new ModelAndView();
        User login = new User();
        model.addObject("loginForm", login);
        model.setViewName("login");
        return model;
    }


    @Autowired
    Userimpl userimpl;
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute User logins, HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        User login = new User();
        logins.setUsername(request.getParameter("username"));
        logins.setPass(request.getParameter("password"));
        //      List<User> login = loginService.getAccount2(logins.getUser(), logins.getPass());
        if ( userimpl.findUser(logins.getUsername(),logins.getPass())==1) {
            HttpSession session = request.getSession();
            session.setAttribute("user", logins.getUsername());
            //setting session to expiry in 30 mins
            model.addObject("hihi",logins.getUsername());

            return new ModelAndView("redirect:/home");
        } else {

            model.setViewName("login");
            return model;
        }
    }


//    @RequestMapping(value = "/home", method = RequestMethod.GET)
//    public ModelAndView Home()
//    {
//        ModelAndView model = new ModelAndView();
//        model.setViewName("Home");
//        return model;
//    }


}

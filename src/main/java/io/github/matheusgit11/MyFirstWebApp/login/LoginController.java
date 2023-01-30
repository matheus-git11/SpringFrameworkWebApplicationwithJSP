package io.github.matheusgit11.MyFirstWebApp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    // login => LoginController => loginJsp Method => return "login"=> calling login.jsp
    //http://localhost:8080/login-jsp?name=matheus
    @RequestMapping("login-jsp")
    public String loginJsp(@RequestParam String name , ModelMap model) {
        //if you want to make anything available to the view(jsp) ,you can put it into ModelMap Class
        model.put("name",name);
        logger.debug("Request Param is {}",name);
        logger.info("i want this printed at info level");
        logger.warn("i want this printed at warn level");
        return "login";
    }
}

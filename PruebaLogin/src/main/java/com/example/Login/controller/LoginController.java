
package com.example.Login.controller;


import com.example.Login.form.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author Lupe
 */
@Controller
public class LoginController {
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String getLoginForm() {

        return "login";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(@ModelAttribute(name="loginForm") LoginForm loginForm, Model model) {

        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        if ("admin".equals(username) && "1234".equals(password)) {

            return "home";
        }
        
        model.addAttribute("invalidCredentials", true);
        return "login";
    }
    
    
}
